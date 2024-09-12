package thread.qa;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import io.restassured.response.Response;
import org.apache.http.impl.conn.Wire;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import thread.qa.callbacks.RestExtension;
import thread.qa.callbacks.TestSaver;
import thread.qa.models.clientSearch.Base;
import thread.qa.models.init.InitRoot;
import thread.qa.models.init.ValuesItem;
import thread.qa.parameters.Init;
import thread.qa.parameters.InitResolver;
import thread.qa.parameters.Mock;
import thread.qa.parameters.WiremockResolver;
import thread.qa.utils.FileContentReader;
import thread.qa.utils.JsonAttChanger;
import thread.qa.utils.Wiremock;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static thread.qa.utils.FileContentReader.jsonBody;


//@WireMockTest(httpPort = 8080)


public class ExtensionTest extends BaseTest {


    @BeforeEach
    public void setUp() {
        System.out.println("first");
    }

    @DisplayName("меняю логин")
    @Test
    public void initTestWithWiremockExtension(@Mock Wiremock wiremock) {
        wiremock.wiremockSend("/Users/andrey/IdeaProjects/stadalone/JunitExtensions/src/test/resources/wiremock/client-search/default.json",
                "base.guid",
                "4321",
                "1234",
                "1234");

        //достаю json из ресурсов
        // метод("путь к файлу", "jsonpath", "значение переменной")
        //отправляю джейсон в вайрмок
//        FileContentReader fr = new FileContentReader();
//        JsonAttChanger js = new JsonAttChanger();
//        fr.jsonFile("/Users/andrey/IdeaProjects/stadalone/JunitExtensions/src/test/resources/wiremock/client-search/default.json");
//        js.apply(jsonBody, "base.guid", "1234");
////        System.out.println(jsonBody);
//        Response response = given().body(jsonBody).post("api/v1/metadata/init")
//                .then().extract().response();

//
//        List<ValuesItem> values = new LinkedList<>();
//        values.add(userFullNameValue);
//        values.add(titleValue);
//        values.add(branchCodeValue);
//        values.add(branchUnitCodeValue);
//        values.add(new ValuesItem(Values.LOGIN, "1234"));
//
//        initRootBody.getData().getVerifyData().setValues(values);
//        Response response = given().body(initRootBody).post("api/v1/metadata/init")
//                .then().extract().response();
//
//        assertAll(
//                () -> assertEquals(200, response.getStatusCode()));
    }

    @DisplayName("меняю логин")
    @Test
    public void initTestWithWiremockExtension2(@Mock Wiremock wiremock) {
        wiremock.wiremockSend("/Users/andrey/IdeaProjects/stadalone/JunitExtensions/src/test/resources/wiremock/client-search/default.json",
                "base.guid",
                "1234",
                "1234",
                "1234");

        //достаю json из ресурсов
        // метод("путь к файлу", "jsonpath", "значение переменной")
        //отправляю джейсон в вайрмок
//        FileContentReader fr = new FileContentReader();
//        JsonAttChanger js = new JsonAttChanger();
//        fr.jsonFile("/Users/andrey/IdeaProjects/stadalone/JunitExtensions/src/test/resources/wiremock/client-search/default.json");
//        js.apply(jsonBody, "base.guid", "1234");
////        System.out.println(jsonBody);
//        Response response = given().body(jsonBody).post("api/v1/metadata/init")
//                .then().extract().response();

//
//        List<ValuesItem> values = new LinkedList<>();
//        values.add(userFullNameValue);
//        values.add(titleValue);
//        values.add(branchCodeValue);
//        values.add(branchUnitCodeValue);
//        values.add(new ValuesItem(Values.LOGIN, "1234"));
//
//        initRootBody.getData().getVerifyData().setValues(values);
//        Response response = given().body(initRootBody).post("api/v1/metadata/init")
//                .then().extract().response();
//
//        assertAll(
//                () -> assertEquals(200, response.getStatusCode()));
    }
//    @DisplayName("меняю логин")
//    @Test
//    public void initTest(@Init InitRoot initRootBody) {
//    //достаю json из ресурсов
//        // метод("путь к файлу", "jsonpath", "значение переменной")
//    //отправляю джейсон в вайрмок
//FileContentReader fr = new FileContentReader();
//        JsonAttChanger js = new JsonAttChanger();
//fr.jsonFile("/Users/andrey/IdeaProjects/stadalone/JunitExtensions/src/test/resources/wiremock/client-search/default.json");
//js.apply(jsonBody, "base.guid", "1234");
////        System.out.println(jsonBody);
//        Response response = given().body(jsonBody).post("api/v1/metadata/init")
//                .then().extract().response();

//
//        List<ValuesItem> values = new LinkedList<>();
//        values.add(userFullNameValue);
//        values.add(titleValue);
//        values.add(branchCodeValue);
//        values.add(branchUnitCodeValue);
//        values.add(new ValuesItem(Values.LOGIN, "1234"));
//
//        initRootBody.getData().getVerifyData().setValues(values);
//        Response response = given().body(initRootBody).post("api/v1/metadata/init")
//                .then().extract().response();
//
//        assertAll(
//                () -> assertEquals(200, response.getStatusCode()));
//    }

//    @DisplayName("меняю логин")
//    @Test
//    public void initTest1(@Init InitRoot initRootBody) {
//        //достаю json из ресурсов
//        // метод("путь к файлу", "jsonpath", "значение переменной")
//        //отправляю джейсон в вайрмок
//        FileContentReader fr = new FileContentReader();
//        JsonAttChanger js = new JsonAttChanger();
//        fr.jsonFile("/Users/andrey/IdeaProjects/stadalone/JunitExtensions/src/test/resources/wiremock/client-search/default.json");
//        js.apply(jsonBody, "base.guid", "4321");
////        System.out.println(jsonBody);
//
//        Response response = given().body(jsonBody).post("api/v1/metadata/init")
//                .then().extract().response();
////
////        List<ValuesItem> values = new LinkedList<>();
////        values.add(userFullNameValue);
////        values.add(titleValue);
////        values.add(branchCodeValue);
////        values.add(branchUnitCodeValue);
////        values.add(new ValuesItem(Values.LOGIN, "1234"));
////
////        initRootBody.getData().getVerifyData().setValues(values);
////        Response response = given().body(initRootBody).post("api/v1/metadata/init")
////                .then().extract().response();
////
////        assertAll(
////                () -> assertEquals(200, response.getStatusCode()));
//    }

//    @DisplayName("меняю канал")
//    @Test
//    public void initTestUfoDsa(@Init InitRoot initRootBody) {
//        initRootBody.getMeta().setChannel("ufo-dsa");
//        Response response = given().body(initRootBody).post("api/v1/metadata/init")
//                .then().log().all().extract().response();
//
//        assertAll(
//                () -> assertEquals("unexpectedException", response.path("error.code")));
//    }
//
//
//    @DisplayName("перебираю канал")
//    @ParameterizedTest
//    @MethodSource("provideForTestInitTestChannel")
//    public void initTestChannel(String channel, @Init InitRoot initRootBody) {
//        initRootBody.getMeta().setChannel(channel);
//        String actual = given().body(initRootBody).contentType("application/json").log().all().post("http://localhost:8082")
//                .then().extract().response().path("123124");
//
//        assertAll(
//                () -> assertEquals("400", actual));
//    }
//
//
//    private static Stream<Arguments> provideForTestInitTestChannel() {
//        return Stream.of(
//                Arguments.of("ufo"),
//                Arguments.of("ufo-dsa"),
//                Arguments.of("ufo-cc"),
//                Arguments.of("ib"),
//                Arguments.of("mobile"),
//                Arguments.of("mb"),
//                Arguments.of("web")
//        );
//    }
}
