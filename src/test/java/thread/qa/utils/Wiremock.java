package thread.qa.utils;

import io.restassured.response.Response;
import thread.qa.config.Config;

import static io.restassured.RestAssured.given;
import static thread.qa.utils.FileContentReader.jsonBody;

public class Wiremock {
    protected static final Config CFG = Config.getInstance();


    public void wiremockSend(String mockPath, String att, String value, String enpointMapping, String gpbRequestIdMapping) {
        FileContentReader fr = new FileContentReader();
        JsonAttChanger js = new JsonAttChanger();
        fr.jsonFile(mockPath);
        js.apply(jsonBody, att, value);
        //здесь нужно продумать как сделать преобразование jsonBody в запрос на генерацию мока
        /*
 ___________________
{
    "request": {
        "method": "POST",
        "url": "/omni-information/api/v2/client/search",
        "headers": {
          "gpb-requestId": {
            "equalTo": "gpbRequestIdMapping"
          }
        }
    },
    "response": {
        "status": 200,
        "headers": {
            "Content-Type": "application/json"
        },
        "body": "{\n  \"status\": \"success\",\n  \"actualTimestamp\": 1607342013827,\n  \"data\": {\n    \"clients\": [\n      {\n        \"base\": {\n          \"guid\": \"6F57A2C3507C4D6AA1A70E9C8C8CF919\",\n          \"hid\": \"195942247\",\n          \"identityType\": \"3\",\n          \"actualDate\": \"2020-11-27\",\n          \"fullName\": \"Казаков Иван Васильевич\",\n          \"surname\": \"Казаков\",\n          \"name\": \"Иван\",\n          \"patronymic\": \"Васильевич\",\n          \"gender\": \"MALE\",\n          \"birthPlace\": \"Москва\",\n          \"birthSettlement\": \"г Москва\",\n          \"birthRayon\": \"г Москва\",\n          \"birthRegion\": \"г Москва\",\n          \"birthCountry\": \"РОССИЙСКАЯ ФЕДЕРАЦИЯ\",\n          \"categories\": [\n            {\n              \"type\": \"REGULAR\"\n            }\n          ],\n          \"residents\": [\n            {\n              \"type\": \"base\",\n              \"state\": {\n                \"terminalFlag\": true\n              }\n            },\n            {\n              \"type\": \"tax\",\n              \"state\": {}\n            }\n          ],\n          \"citizenships\": [\n            {\n              \"countryName\": \"РОССИЙСКАЯ ФЕДЕРАЦИЯ\"\n            }\n          ],\n          \"birthdate\": \"1985-10-17\"\n        },\n        \"addresses\": [\n          {\n            \"hid\": \"87678847\",\n            \"type\": \"CONSTANT_REGISTRATION\",\n            \"primary\": false,\n            \"actualDate\": \"2020-11-18\",\n            \"postalCode\": \"117041\",\n            \"kladrPostalCode\": \"117041\",\n            \"countryCode\": \"643\",\n            \"countryName\": \"Россия\",\n            \"district\": \"Центральный\",\n            \"regionType\": \"г\",\n            \"regionCode\": \"77\",\n            \"regionName\": \"Москва\",\n            \"cityType\": \"г\",\n            \"city\": \"Москва\",\n            \"streetType\": \"\",\n            \"street\": \"\",\n            \"houseNumber\": \"\",\n            \"building\": \"1\",\n            \"flat\": \"225\",\n            \"okatoCode\": \"45293594000\",\n            \"kladrCode\": \"7700000000042730039\",\n            \"fiasCode\": \"28cb6660-de62-4c4a-9fe1-e409c30f0874\",\n            \"fullAddress\": \"\",\n            \"registrationDate\": \"2010-10-10\",\n            \"validationCode\": \"VALIDATED\",\n            \"qualityCode\": \"GOOD\",\n            \"isForeign\": false\n          },\n          {\n            \"hid\": \"87678848\",\n            \"type\": \"HOME\",\n            \"primary\": false,\n            \"actualDate\": \"2020-11-18\",\n            \"postalCode\": \"117041\",\n            \"kladrPostalCode\": \"117041\",\n            \"countryCode\": \"643\",\n            \"countryName\": \"Россия\",\n            \"district\": \"Центральный\",\n            \"regionType\": \"г\",\n            \"regionCode\": \"77\",\n            \"regionName\": \"Москва\",\n            \"cityType\": \"г\",\n            \"city\": \"Москва\",\n            \"streetType\": \"\",\n            \"street\": \"\",\n            \"houseNumber\": \"35\",\n            \"building\": \"1\",\n            \"flat\": \"225\",\n            \"okatoCode\": \"45293594000\",\n            \"kladrCode\": \"7700000000042730039\",\n            \"fiasCode\": \"28cb6660-de62-4c4a-9fe1-e409c30f0874\",\n            \"fullAddress\": \"\",\n            \"validationCode\": \"VALIDATED\",\n            \"qualityCode\": \"GOOD\",\n            \"isForeign\": false\n          }\n        ],\n        \"documents\": [\n          {\n            \"hid\": \"100957263\",\n            \"type\": \"PASSPORT_RU\",\n            \"primary\": true,\n            \"actualDate\": \"2020-11-27\",\n            \"series\": \"45 09\",\n            \"number\": \"987654\",\n            \"fullValue\": \"45 09987654\",\n            \"issueDate\": \"2015-03-10\",\n            \"issueAuthority\": \"о-нием по р-ну Южное Бутово ОУФМС России по гор.Москве\",\n            \"departmentCode\": \"077-089\",\n            \"state\": {\n              \"code\": \"ACTUAL\"\n            }\n          }\n        ],\n        \"phones\": [\n          {\n            \"hid\": \"77200806\",\n            \"type\": \"MOBILE\",\n            \"primary\": false,\n            \"actualDate\": \"2020-11-18\",\n            \"countryCode\": \"7\",\n            \"cityCode\": \"964\",\n            \"number\": \"5524477\",\n            \"fullNumber\": \"79645524477\",\n            \"timezone\": \"UTC+3\",\n            \"numberProfile\": \"MOBILE\",\n            \"rawSource\": \"79645524477\",\n            \"state\": {\n              \"code\": \"ACTUAL\"\n            },\n            \"isForeign\": false\n          },\n          {\n            \"hid\": \"77200940\",\n            \"type\": \"PC\",\n            \"primary\": false,\n            \"actualDate\": \"2020-11-19\",\n            \"countryCode\": \"7\",\n            \"cityCode\": \"964\",\n            \"number\": \"5524477\",\n            \"fullNumber\": \"79645524477\",\n            \"timezone\": \"UTC+3\",\n            \"numberProfile\": \"MOBILE\",\n            \"state\": {\n              \"code\": \"ACTUAL\"\n            },\n            \"isForeign\": false\n          }\n        ],\n        \"mails\": [\n          {\n            \"hid\": \"4363744\",\n            \"type\": \"HOME\",\n            \"primary\": false,\n            \"actualDate\": \"2020-11-19\",\n            \"value\": \"ivan.kazak@mail.ru\",\n            \"state\": {}\n          }\n        ],\n        \"detail\": {\n          \"foreignSurname\": \"Kazakov\",\n          \"foreignName\": \"Ivan\",\n          \"dignitaryFlag\": false,\n          \"lastFio\": [],\n          \"biometrics\": {\n            \"isAgreement\": false\n          },\n          \"consents\": [\n            {\n              \"type\": \"GOODS_SERVICES_ADVERTISING\",\n              \"consentValue\": \"COMMON_GRANTED\",\n              \"actualDate\": \"2020-11-17\",\n              \"startDate\": \"2020-11-17\"\n            },\n            {\n              \"type\": \"VOICE_BIOMETRICS\",\n              \"consentValue\": \"COMMON_DENIED\",\n              \"actualDate\": \"2020-11-17\",\n              \"startDate\": \"2020-11-17\"\n            },\n            {\n              \"type\": \"CREDIT_BUREAU_REQUEST\",\n              \"consentValue\": \"COMMON_GRANTED\",\n              \"actualDate\": \"2020-11-17\"\n            }\n          ],\n          \"isDkbo\": true\n        },\n        \"crs\": {\n          \"status\": \"NON_REPORTABLE_PERSON\",\n          \"employeeFullName\": \"Ерохин Сергей Сергеевич\",\n          \"approveDate\": \"2020-11-17\",\n          \"countries\": [\n            {\n              \"reasonNoTin\": \"UNKNOWN\",\n              \"code\": \"RUS\"\n            }\n          ]\n        },\n        \"fatca\": {\n          \"status\": \"NON_US\",\n          \"employeeFullName\": \"Ерохин Сергей Сергеевич\",\n          \"approveDate\": \"2020-11-17\"\n        },\n        \"entityStoplist\": [\n          {\n            \"totalMatches\": \"1\",\n            \"internalNumber\": \"1\",\n            \"suspectChecks\": [\n              {\n                \"name\": \"Сведения о недействительных российских паспортах\",\n                \"inclusionReasonCode\": \"1.01.01\",\n                \"categories\": [\n                  {\n                    \"code\": \"UNKNOWN\"\n                  }\n                ],\n                \"message\": \"Паспорт Клиента недействителен. Необходимо затребовать у Клиента действующий документ, удостоверяющий личность\"\n              }\n            ]\n          }\n        ]\n      }\n    ]\n  }\n}\n"
    }
}
_____________________
         */
        String wiremockRequest;
        given().baseUri(CFG.wiremockUrl()).body(
                        jsonBody).post("/__admin/mappings")
                .then().extract().response();
    }

}
