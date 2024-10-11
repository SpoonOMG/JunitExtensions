
<code><img width="65%" title="ElbrusLogog" src="images/logo/2024-10-12 00.40.27.jpg"></code>
## **Технологии, использованные в ElbrusTestFramework**

- [JUnit 5 (Extensions, Resolvers, etc)](https://junit.org/junit5/docs/current/user-guide/)
- [Retrofit 2](https://square.github.io/retrofit/)
- [Allure](https://docs.qameta.io/allure/)
- [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Wiremock](https://wiremock.org)
- [IBM MQ](https://developer.ibm.com/tutorials/mq-develop-mq-jms/)

**Минимальные предусловия для работы с проектом ElbrusTestFramework**

#### 1. Установить JDK 17+

- [Инструкция по установке Java](https://github.com/qa-guru/getting-started-java/wiki/1.-Установка-JDK)

#### 2. Подтянуть все зависимости с помощью Gradle

- [Инструкция по установке Gradle](https://github.com/qa-guru/getting-started-java/wiki/2.-Установка-Gradle)



### *Структура проекта*

###### - api

* В абстрактном классе ApiClient описана реализация rest-api взаимодействия с использованием **retrofit** и **okHttpClient**
  Реализованный апи-клиент уже настроен на отправку запросов, в том числе с использованием интерсептера логирования.
* Интерфейc **OmniApi** описывает методы взаимодействие с тестируемым rest-api приложением посредством спецификации
  retrofit. Перед реализацией интерфейса **retrofit** необходимо заранее иметь модели запросов/ответов тестируемого сервиса.
  [Подробнее о том, как работает библиотека retrofit](https://rutube.ru/video/f09c90281d0aa1134d9dc78c566fbda3/)
* **WiremockApi** описывает методы взаимодействия с инстансом **Wiremock** для создания и удаления маппинга заглушек.
* **OmniApiClient** является имплементацией абстрактного класа **ApiClient**, реализуя методы описанные в **OmniApi**

###### - config

* Интерфейс **Config** позволяет описывать различные environment (local/openshift). Перед стартом необходимо убедиться, что
  baseUrl/wiremockUrl, а также настройки подключения к IBM MQ указаны корректно(в соответствии с тестируемым сервисом)

###### - jupiter

* Представлены аннотации Junit.
    * Аннотация Wmock позволяет конфигурировать заглушку из ресурсов(mockFile()) и отправлять ее в Wiremock с маппингом
      соотвествующего endpoint (**enpointMapping()**). Методы **pathToField()** и **value()** позволяют, проходя по jsonPath менять
      атрибуты сконфигурированной заглушки.
  ```java
    @Wmock(
                    enpointMapping = "/omni-information-card/api/v3/client/product/card/issue/check",
                    mockFile = "wiremock/issue-check/card-issue-check-isMobilePinTrue.json",
                    pathToField = "actualTimestamp",
                    value = "1234"
          )
* Аннотация Wmocks - является контейнером, позволяющим собирать несколько заглушек в одном тесте
    ```java
    @Wmocks({
              @Wmock(...),
              @Wmock(...)
              @Wmock(...)
    })
* Аннотации @xRequest используются в качестве аннотаций к десериализованным Java-объектам запросов, применяемые к
  соответствующим **ParameterResolver**
    ```java
    public void someTest(
    @CheckRequest OmniRequestItem check
    ) check.getData().setOperation()
  }
* Представлены Callback Junit
  * WmockExtension - позволяет генерировать заглушку перед тестом, помеченным аннотацией Wmock. Уникальным
           идентификатором заглушки является gpbrequestId. При обращении в ручку с таким gpbrequestId сервис будет получать
           ожидаемую заглушку. Для этого в аргументах теста нужно создать экземпляр класса RootWiremockResponse, забрать
           gpbrequestid и поместить в запрос в сервис
    ```java
             @Test
         @Wmocks({
                 @Wmock(
                         enpointMapping = "/omni-information/api/v2/client/search",
                         mockFile = "wiremock/client-search/default.json",
                         pathToField = "data.clients.[?(@.base.guid==\"6F57A2C3507C4D6AA1A70E9C8C8CF919\")].base.hid",
                         value = ""
                 )})
         public void someTest(
                 RootWiremockResponse rwr,
                 @InitRequest OmniRequestItem init
         ) {
             String gpbrequestId = rwr.getRequest().getHeaders().getGpbrequestId().getEqualTo(); 
             ResponseItem response = initApi.initRequest(gpbrequestId, init);
         }
    
   По окончании теста все сгенерированные заглушки самостоятельно удаляются.
  * TestSaver сохраняет методы и классы упавших тестов в ресурсы в файл "failedTests.txt" после каждого прогона.
* Parameters под собой представляют parameterResolver заранее десириализованных запросов в соответствии с методами сервисов

### **Напишем тест RestApi с конфигурацией заглушки** 



```java
                      @Test
                      @Tag("Task")
                      @DisplayName("GetScreenName")
                      @Wmocks({
                              @Wmock(
                                      enpointMapping = "/omni-information/api/v2/client/search",
                                      mockFile = "wiremock/client-search/default.json",
                                      pathToField = "data.clients.[?(@.base.guid==\"6F57A2C3507C4D6AA1A70E9C8C8CF919\")].base.hid",
                                      value = ""
                              ),
                              @Wmock(
                                      enpointMapping = "/omni-information-card/api/v3/client/product/cards",
                                      mockFile = "wiremock/product-cards/default.json",
                                      pathToField = "actualTimestamp",
                                      value = "1234"
                              )})
                      public void exampleTest(
                              RootWiremockResponse rwr,
                              @InitRequest OmniRequestItem init
                      ) throws IOException {
                          String gpbrequestId = rwr.getRequest().getHeaders().getGpbrequestId().getEqualTo();
                          ResponseItem response = initApi.initRequest(gpbrequestId, init);
                          assertAll(
                                  () -> assertEquals("ScreenName", response.getScreen().getLoad().getId()),
                          );
                         }   
  ```                  
                    
### **Напишем тест на MQ-клиент**

```java
    @DisplayName("Получение успешного экрана при запросе на init с проверкой заполнения параметров из client-search")
    @Test
    public void initMQTest(@InitRequest OmniRequestItem init) throws JMSException, JsonProcessingException {
        String gpbRequestId = UUID.randomUUID().toString();
        OmniMqClient mqClient = new OmniMqClient();
        mqClient.sendMqMessage("IN.RQ.CARDACPTACTVISTDR11_01.00.00",init,gpbRequestId);
        OmniRequestItem result = om.readValue(mqClient.readMqMessage("IN.RQ.CARDACPTACTVISTDR11_01.00.00","X_TransactionID",gpbRequestId),OmniRequestItem.class);
     Assertions.assertEquals(ChannelEnum.UFO.getName(), result.getMeta().getChannel());
    }
}
  ```  