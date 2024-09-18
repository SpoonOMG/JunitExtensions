package framework.qa.test;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import framework.qa.jupiter.callbacks.RestExtension;
import framework.qa.jupiter.callbacks.TestSaver;
import framework.qa.jupiter.annotations.Init;
import framework.qa.jupiter.parameters.InitResolver;
import framework.qa.models.init.InitRoot;
import framework.qa.models.init.ValuesItem;
import framework.qa.values.Params;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
//import thread.qa.parameters.RandomUserResolver;

import java.util.LinkedList;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith({TestSaver.class, InitResolver.class, RestExtension.class})
//@WireMockTest(httpPort = 8080)


public class ExtensionTestWiremockInMemory extends BaseTest {


    private static WireMockServer wireMockServer = new WireMockServer(
            wireMockConfig()
                    .port(8080)
                    .globalTemplating(true)
                    .stubCorsEnabled(true)
    );

    @BeforeAll
    static void start() {
        wireMockServer.start();

    }

    @AfterAll
    static void stop() {
        wireMockServer.stop();
    }

    @BeforeEach
    void configure() {
        new WireMock(8080).register((post(urlPathEqualTo("/omni-oks-cards/api/v1/metadata/init"))
                .willReturn(
                        okJson(
                                """
                                        {
                                          "status" : "success",
                                          "actualTimestamp" : 1725880843264,
                                          "data" : {
                                            "arbitrary" : { },
                                            "operation" : {
                                              "values" : [ {
                                                "id" : "##clientPhone",
                                                "value" : "79645524477"
                                              }, {
                                                "id" : "##areEmbossedCardsAvailable",
                                                "value" : "true"
                                              }, {
                                                "id" : "##sourceChannel",
                                                "value" : "ufo"
                                              }, {
                                                "id" : "##full_name",
                                                "value" : "Казаков Иван Васильевич"
                                              }, {
                                                "id" : "##paySystemCode",
                                                "value" : "visa"
                                              }, {
                                                "id" : "##cardIdCategoryName",
                                                "value" : "Зарп Visa Gold Кэшбэк Газпром"
                                              }, {
                                                "id" : "##signMode",
                                                "value" : "omniDigitalSign"
                                              }, {
                                                "id" : "cardCategoryCode",
                                                "value" : "0"
                                              }, {
                                                "id" : "subProgramCode",
                                                "value" : "000"
                                              }, {
                                                "id" : "##cardIdProductNameForPrintScreen",
                                                "value" : "Заявление на выпуск карты Зарп Visa Gold Кэшбэк Газпром"
                                              }, {
                                                "id" : "##print_obpo",
                                                "value" : "1199"
                                              }, {
                                                "id" : "##OTPChannel",
                                                "value" : "web"
                                              }, {
                                                "id" : "##virtualNum",
                                                "value" : "DRTL10074435954"
                                              }, {
                                                "id" : "##clientPhoneOTP",
                                                "value" : "79645524477"
                                              }, {
                                                "id" : "##loyaltyProgram",
                                                "value" : "Умный кэшбэк"
                                              }, {
                                                "id" : "##organizationName",
                                                "value" : "Общество с ограниченной ответственностью \\"Газпромбанк-Инвест Девелопмент\\""
                                              }, {
                                                "id" : "paymentSystemCode",
                                                "value" : "1"
                                              }, {
                                                "id" : "##isSecretWord",
                                                "value" : "true"
                                              }, {
                                                "id" : "##dashboardBranchCode",
                                                "value" : "047"
                                              }, {
                                                "id" : "##dashboardBranchUnitCode",
                                                "value" : "047/1013"
                                              }, {
                                                "id" : "##cardIdProductName",
                                                "value" : "Зарп Visa Gold Кэшбэк Газпром"
                                              }, {
                                                "id" : "##systemId",
                                                "value" : "DRTL"
                                              }, {
                                                "id" : "##orderOwner",
                                                "value" : "Ефимов Андрей Васильевич"
                                              }, {
                                                "id" : "##registration_address",
                                                "value" : "г Москва,  , корп. 1, кв 225"
                                              }, {
                                                "id" : "##obpo",
                                                "value" : "1199"
                                              }, {
                                                "id" : "userFullName",
                                                "value" : "Никишин Максим Юрьевич"
                                              }, {
                                                "id" : "CardID",
                                                "value" : "10074435954"
                                              }, {
                                                "id" : "##isSalary",
                                                "value" : "true"
                                              }, {
                                                "id" : "branchCode",
                                                "value" : "000"
                                              }, {
                                                "id" : "##CELLPHONE",
                                                "value" : "+7 964 552-44-77"
                                              }, {
                                                "id" : "##secondName",
                                                "value" : "Васильевич"
                                              }, {
                                                "id" : "##tessaMetaEcmAgrAccountsNumber",
                                                "value" : "40817810300602456538"
                                              }, {
                                                "id" : "##expiredPassport",
                                                "value" : "false"
                                              }, {
                                                "id" : "ClientID",
                                                "value" : "12345"
                                              }, {
                                                "id" : "##document",
                                                "value" : "45 09 987654, выдан 10.03.2015"
                                              }, {
                                                "id" : "##birth_date",
                                                "value" : "17.10.1985"
                                              }, {
                                                "id" : "##OTPAvailableChannels",
                                                "value" : "web|mb"
                                              }, {
                                                "id" : "branchUnitCode",
                                                "value" : "047/1013"
                                              }, {
                                                "id" : "##fact_address",
                                                "value" : "г Москва,  , д 35, корп 1, кв 225"
                                              }, {
                                                "id" : "##embossing_client_name",
                                                "value" : "IVAN KAZAKOV"
                                              }, {
                                                "id" : "##isOTPAvailable",
                                                "value" : "true"
                                              }, {
                                                "id" : "##print_organizationName",
                                                "value" : "Общество с ограниченной ответственностью \\"Газпромбанк-Инвест Девелопмент\\""
                                              }, {
                                                "id" : "##firstName",
                                                "value" : "Иван"
                                              }, {
                                                "id" : "##lastName",
                                                "value" : "Казаков"
                                              }, {
                                                "id" : "##delivery.dsa",
                                                "value" : "false"
                                              }, {
                                                "id" : "##email",
                                                "value" : "ivan.kazak@mail.ru"
                                              }, {
                                                "id" : "title",
                                                "value" : "Ведущий инженер по тестированию"
                                              }, {
                                                "id" : "login",
                                                "value" : "gpbu14775"
                                              }, {
                                                "id" : "##phoneNumberSmsPush",
                                                "value" : "Отправьте клиенту SMS на номер +7 964 552 44 77 со ссылкой на web-страницу для подписания документов"
                                              }, {
                                                "id" : "##saleChannelName",
                                                "value" : "Дашборд ФО"
                                              }, {
                                                "id" : "PDL",
                                                "value" : "1"
                                              }, {
                                                "id" : "##depositProductAvailable",
                                                "value" : "false"
                                              }, {
                                                "id" : "##isCardAccountReserved",
                                                "value" : "false"
                                              }, {
                                                "id" : "branchCode5NT",
                                                "value" : "049"
                                              }, {
                                                "id" : "IsUnembossed",
                                                "value" : "0"
                                              }, {
                                                "id" : "##scenarioId",
                                                "value" : "sc_dff09e0c2f36177"
                                              }, {
                                                "id" : "##isTeenager",
                                                "value" : "0"
                                              }, {
                                                "id" : "isDkbo",
                                                "value" : "true"
                                              } ]
                                            }
                                          },
                                          "screen" : {
                                            "stage" : "initial",
                                            "success" : true,
                                            "load" : {
                                              "component" : "OPERATION",
                                              "id" : "MASS_ISSUANCE_CARDS_PERSONAL_INFO",
                                              "header" : "Выдача карт немедленного предоставления",
                                              "defCommandId" : "confirmPersonalInfo",
                                              "cacheable" : true,
                                              "groups" : [ {
                                                "component" : "NONE",
                                                "alias" : "stepInfo",
                                                "visible" : true,
                                                "disabled" : false,
                                                "style" : {
                                                  "width" : "1"
                                                },
                                                "elements" : [ {
                                                  "component" : "baseEntry",
                                                  "type" : "default",
                                                  "id" : "##chanelType",
                                                  "alias" : "##channel",
                                                  "required" : true,
                                                  "visible" : false,
                                                  "placeholder" : "Канал",
                                                  "value" : "",
                                                  "errors" : [ {
                                                    "type" : "required",
                                                    "message" : "Обязательное поле"
                                                  } ],
                                                  "serverFeature" : {
                                                    "dependencies" : [ {
                                                      "property" : "value",
                                                      "rules" : [ {
                                                        "if" : {
                                                          "type" : "reference",
                                                          "id" : "#EMPTY#",
                                                          "property" : "meta/channel",
                                                          "compare" : "<>",
                                                          "value" : "null"
                                                        },
                                                        "then" : {
                                                          "externalPropertyValue" : {
                                                            "type" : "reference",
                                                            "id" : "#EMPTY#",
                                                            "property" : "meta/channel"
                                                          }
                                                        }
                                                      } ]
                                                    } ]
                                                  }
                                                }, {
                                                  "component" : "static",
                                                  "type" : "text|greyMouse",
                                                  "visible" : true,
                                                  "value" : "Шаг 1 из 2"
                                                } ],
                                                "excluded" : false
                                              }, {
                                                "component" : "NONE",
                                                "alias" : "cardParamInfo",
                                                "visible" : true,
                                                "disabled" : false,
                                                "elements" : [ {
                                                  "component" : "static",
                                                  "type" : "heading2",
                                                  "alias" : "header_group",
                                                  "visible" : true,
                                                  "value" : "Параметры карты"
                                                }, {
                                                  "component" : "baseValue",
                                                  "alias" : "ProductName",
                                                  "visible" : true,
                                                  "disabled" : false,
                                                  "label" : "Наименование карты",
                                                  "value" : "",
                                                  "serverFeature" : {
                                                    "dependencies" : [ {
                                                      "property" : "value",
                                                      "rules" : [ {
                                                        "if" : {
                                                          "type" : "operation",
                                                          "id" : "##cardIdProductName",
                                                          "property" : "value",
                                                          "compare" : "ISNOTNULL"
                                                        },
                                                        "then" : {
                                                          "externalPropertyValue" : {
                                                            "type" : "operation",
                                                            "id" : "##cardIdProductName",
                                                            "property" : "value"
                                                          }
                                                        }
                                                      } ]
                                                    } ]
                                                  }
                                                } ],
                                                "excluded" : false,
                                                "serverFeature" : {
                                                  "dependencies" : [ {
                                                    "property" : "excluded",
                                                    "rules" : [ {
                                                      "if" : {
                                                        "type" : "operation",
                                                        "id" : "##cardIdProductName",
                                                        "property" : "value",
                                                        "compare" : "ISNULL"
                                                      },
                                                      "then" : {
                                                        "value" : "true"
                                                      }
                                                    } ]
                                                  } ]
                                                }
                                              }, {
                                                "component" : "NONE",
                                                "alias" : "personalInfo",
                                                "visible" : true,
                                                "disabled" : false,
                                                "style" : {
                                                  "width" : "1"
                                                },
                                                "elements" : [ {
                                                  "component" : "static",
                                                  "type" : "heading2",
                                                  "alias" : "header_group",
                                                  "visible" : true,
                                                  "value" : "Подтвердите персональные данные"
                                                }, {
                                                  "component" : "baseValue",
                                                  "type" : "default",
                                                  "alias" : "fio",
                                                  "logInfo" : "ФИО для подтверждения",
                                                  "visible" : true,
                                                  "label" : "ФИО",
                                                  "value" : "",
                                                  "serverFeature" : {
                                                    "dependencies" : [ {
                                                      "property" : "value",
                                                      "rules" : [ {
                                                        "if" : {
                                                          "type" : "operation",
                                                          "id" : "##full_name",
                                                          "property" : "value",
                                                          "compare" : "<>",
                                                          "value" : "null"
                                                        },
                                                        "then" : {
                                                          "externalPropertyValue" : {
                                                            "type" : "operation",
                                                            "id" : "##full_name",
                                                            "property" : "value"
                                                          }
                                                        }
                                                      } ]
                                                    } ]
                                                  }
                                                }, {
                                                  "component" : "baseValue",
                                                  "type" : "default",
                                                  "alias" : "birthPlace",
                                                  "logInfo" : "Место рождения для подтверждения",
                                                  "visible" : true,
                                                  "label" : "Дата рождения",
                                                  "value" : "",
                                                  "serverFeature" : {
                                                    "dependencies" : [ {
                                                      "property" : "value",
                                                      "rules" : [ {
                                                        "if" : {
                                                          "type" : "operation",
                                                          "id" : "##birth_date",
                                                          "property" : "value",
                                                          "compare" : "<>",
                                                          "value" : "null"
                                                        },
                                                        "then" : {
                                                          "externalPropertyValue" : {
                                                            "type" : "operation",
                                                            "id" : "##birth_date",
                                                            "property" : "value"
                                                          }
                                                        }
                                                      } ]
                                                    } ]
                                                  }
                                                }, {
                                                  "component" : "baseValue",
                                                  "type" : "default",
                                                  "alias" : "passport",
                                                  "logInfo" : "Паспортные данные для подтверждения",
                                                  "visible" : true,
                                                  "label" : "Паспорт",
                                                  "value" : "",
                                                  "serverFeature" : {
                                                    "dependencies" : [ {
                                                      "property" : "value",
                                                      "rules" : [ {
                                                        "if" : {
                                                          "type" : "operation",
                                                          "id" : "##document",
                                                          "property" : "value",
                                                          "compare" : "<>",
                                                          "value" : "null"
                                                        },
                                                        "then" : {
                                                          "externalPropertyValue" : {
                                                            "type" : "operation",
                                                            "id" : "##document",
                                                            "property" : "value"
                                                          }
                                                        }
                                                      } ]
                                                    } ]
                                                  }
                                                }, {
                                                  "component" : "baseValue",
                                                  "type" : "default",
                                                  "alias" : "addressReg",
                                                  "logInfo" : "Адрес регистрации для подтверждения",
                                                  "visible" : true,
                                                  "label" : "Адрес регистрации",
                                                  "value" : "",
                                                  "serverFeature" : {
                                                    "dependencies" : [ {
                                                      "property" : "value",
                                                      "rules" : [ {
                                                        "if" : {
                                                          "type" : "operation",
                                                          "id" : "##registration_address",
                                                          "property" : "value",
                                                          "compare" : "<>",
                                                          "value" : "null"
                                                        },
                                                        "then" : {
                                                          "externalPropertyValue" : {
                                                            "type" : "operation",
                                                            "id" : "##registration_address",
                                                            "property" : "value"
                                                          }
                                                        }
                                                      } ]
                                                    } ]
                                                  }
                                                }, {
                                                  "component" : "baseValue",
                                                  "type" : "default",
                                                  "alias" : "addressFact",
                                                  "logInfo" : "Фактический адрес для подтверждения",
                                                  "visible" : true,
                                                  "label" : "Фактический адрес",
                                                  "value" : "",
                                                  "serverFeature" : {
                                                    "dependencies" : [ {
                                                      "property" : "value",
                                                      "rules" : [ {
                                                        "if" : {
                                                          "type" : "operation",
                                                          "id" : "##fact_address",
                                                          "property" : "value",
                                                          "compare" : "<>",
                                                          "value" : "null"
                                                        },
                                                        "then" : {
                                                          "externalPropertyValue" : {
                                                            "type" : "operation",
                                                            "id" : "##fact_address",
                                                            "property" : "value"
                                                          }
                                                        }
                                                      } ]
                                                    } ]
                                                  }
                                                }, {
                                                  "component" : "baseValue",
                                                  "type" : "default",
                                                  "alias" : "phone",
                                                  "logInfo" : "Мобильный телефон для подтверждения",
                                                  "visible" : true,
                                                  "label" : "Мобильный телефон",
                                                  "value" : "",
                                                  "serverFeature" : {
                                                    "dependencies" : [ {
                                                      "property" : "value",
                                                      "rules" : [ {
                                                        "if" : {
                                                          "type" : "operation",
                                                          "id" : "##CELLPHONE",
                                                          "property" : "value",
                                                          "compare" : "<>",
                                                          "value" : "null"
                                                        },
                                                        "then" : {
                                                          "externalPropertyValue" : {
                                                            "type" : "operation",
                                                            "id" : "##CELLPHONE",
                                                            "property" : "value"
                                                          }
                                                        }
                                                      } ]
                                                    } ]
                                                  }
                                                } ],
                                                "excluded" : false
                                              }, {
                                                "component" : "NONE",
                                                "alias" : "personalInfochange",
                                                "elements" : [ {
                                                  "component" : "static",
                                                  "type" : "p",
                                                  "id" : "##popUp",
                                                  "alias" : "header_group",
                                                  "visible" : true,
                                                  "markup" : "bbcode",
                                                  "value" : "[oks_click]Персональные данные изменились?[/oks_click]"
                                                }, {
                                                  "component" : "popupValue",
                                                  "id" : "popupId2",
                                                  "visible" : false,
                                                  "specific" : {
                                                    "header" : "",
                                                    "body" : {
                                                      "component" : "NOTIFICATION",
                                                      "id" : "",
                                                      "groups" : [ {
                                                        "elements" : [ {
                                                          "component" : "static",
                                                          "type" : "text",
                                                          "value" : "Для изменения персональных данных необходимо вернуться в профиль клиента, внести изменения и повторно выполнить оформление заявки"
                                                        } ]
                                                      } ]
                                                    }
                                                  },
                                                  "dependencies" : [ {
                                                    "property" : "visible",
                                                    "rules" : [ {
                                                      "if" : {
                                                        "type" : "element",
                                                        "id" : "##popUp",
                                                        "property" : "oks_click",
                                                        "compare" : "=",
                                                        "value" : "true",
                                                        "logInfo" : "Если клиент кликнул по ссылке"
                                                      },
                                                      "then" : {
                                                        "value" : "true"
                                                      }
                                                    }, {
                                                      "if" : {
                                                        "type" : "element",
                                                        "id" : "##popUp",
                                                        "property" : "oks_click",
                                                        "compare" : "=",
                                                        "value" : "false",
                                                        "logInfo" : "Если клиент не трогал ссылку"
                                                      },
                                                      "then" : {
                                                        "value" : "false"
                                                      }
                                                    } ]
                                                  } ]
                                                } ],
                                                "dependencies" : [ ],
                                                "excluded" : false
                                              }, {
                                                "component" : "NONE",
                                                "alias" : "personalConsent",
                                                "logInfo" : "Согласия клиента",
                                                "visible" : true,
                                                "disabled" : false,
                                                "elements" : [ {
                                                  "component" : "checkboxEntry",
                                                  "type" : "default",
                                                  "id" : "##consent_all",
                                                  "logInfo" : "Все согласия, связанные с продуктом",
                                                  "required" : true,
                                                  "visible" : true,
                                                  "disabled" : false,
                                                  "label" : "Согласие на [oks_click=oks_click_id1]условия обработки персональных данных[/oks_click]",
                                                  "markup" : "bbcode",
                                                  "value" : "false",
                                                  "dependencies" : [ ],
                                                  "errors" : [ {
                                                    "type" : "required",
                                                    "message" : "Обязательное поле"
                                                  } ]
                                                }, {
                                                  "component" : "popupPdfViewer",
                                                  "id" : "popupId1",
                                                  "visible" : false,
                                                  "disabled" : false,
                                                  "specific" : {
                                                    "fileName" : "Consent_to_the_processing_of_personal_data_20_07_19.pdf",
                                                    "url" : "${pdf-directory}Consent_to_the_processing_of_personal_data_20_07_19.pdf"
                                                  },
                                                  "dependencies" : [ {
                                                    "property" : "visible",
                                                    "rules" : [ {
                                                      "ands" : [ ],
                                                      "if" : {
                                                        "type" : "element",
                                                        "id" : "##consent_all",
                                                        "property" : "oks_click_id1",
                                                        "compare" : "=",
                                                        "value" : "true"
                                                      },
                                                      "then" : {
                                                        "value" : "true"
                                                      }
                                                    }, {
                                                      "ands" : [ ],
                                                      "if" : {
                                                        "type" : "element",
                                                        "id" : "##consent_all",
                                                        "property" : "oks_click_id1",
                                                        "compare" : "=",
                                                        "value" : "false"
                                                      },
                                                      "then" : {
                                                        "value" : "false"
                                                      }
                                                    } ]
                                                  } ],
                                                  "errors" : [ ]
                                                } ],
                                                "excluded" : false,
                                                "serverFeature" : {
                                                  "dependencies" : [ {
                                                    "property" : "excluded",
                                                    "rules" : [ {
                                                      "if" : {
                                                        "type" : "reference",
                                                        "id" : "#EMPTY#",
                                                        "property" : "meta/channel",
                                                        "compare" : "IN",
                                                        "value" : "ufo-dsa",
                                                        "logInfo" : "Для канала ufo-dsa"
                                                      },
                                                      "then" : {
                                                        "value" : "true"
                                                      }
                                                    } ]
                                                  } ]
                                                }
                                              }, {
                                                "component" : "NONE",
                                                "alias" : "savingsAccountSelection",
                                                "visible" : true,
                                                "disabled" : false,
                                                "elements" : [ {
                                                  "component" : "static",
                                                  "type" : "heading3",
                                                  "alias" : "savingsAccounts",
                                                  "visible" : true,
                                                  "disabled" : false,
                                                  "markup" : "html",
                                                  "value" : "Выберите накопительный счет",
                                                  "dependencies" : [ ],
                                                  "serverFeature" : {
                                                    "dependencies" : [ ]
                                                  }
                                                }, {
                                                  "component" : "radioEntry",
                                                  "type" : "compact",
                                                  "id" : "##depositProductCode",
                                                  "alias" : "##depositProductCode",
                                                  "logInfo" : "Выбор типа накопительного счета",
                                                  "required" : true,
                                                  "visible" : true,
                                                  "disabled" : false,
                                                  "markup" : "bbcode",
                                                  "value" : "",
                                                  "specific" : {
                                                    "dictionaryEntries" : [ {
                                                      "value" : "Без_НС",
                                                      "label" : "Без накопительного счета",
                                                      "help" : "Накопительный[br]счет не будет[br]оформлен"
                                                    } ]
                                                  },
                                                  "style" : {
                                                    "help" : {
                                                      "typography" : "text:regular_3"
                                                    }
                                                  },
                                                  "dependencies" : [ ],
                                                  "serverFeature" : {
                                                    "dependencies" : [ ]
                                                  }
                                                } ],
                                                "excluded" : false,
                                                "serverFeature" : {
                                                  "dependencies" : [ {
                                                    "property" : "excluded",
                                                    "rules" : [ {
                                                      "if" : {
                                                        "type" : "operation",
                                                        "id" : "##depositProductAvailable",
                                                        "property" : "value",
                                                        "compare" : "<>",
                                                        "value" : "true"
                                                      },
                                                      "then" : {
                                                        "value" : "true"
                                                      }
                                                    }, {
                                                      "if" : {
                                                        "type" : "operation",
                                                        "id" : "##isSalary",
                                                        "property" : "value",
                                                        "compare" : "=",
                                                        "value" : "false"
                                                      },
                                                      "then" : {
                                                        "value" : "true"
                                                      }
                                                    }, {
                                                      "ands" : [ ],
                                                      "if" : {
                                                        "type" : "operation",
                                                        "id" : "##isTeenager",
                                                        "property" : "value",
                                                        "compare" : "=",
                                                        "value" : "1"
                                                      },
                                                      "then" : {
                                                        "value" : "true"
                                                      }
                                                    }, {
                                                      "set" : {
                                                        "value" : "false"
                                                      }
                                                    } ]
                                                  } ]
                                                }
                                              }, {
                                                "component" : "COMMAND",
                                                "logInfo" : "Группа с командами",
                                                "elements" : [ {
                                                  "component" : "command",
                                                  "type" : "primary",
                                                  "id" : "confirmPersonalInfo",
                                                  "visible" : true,
                                                  "disabled" : false,
                                                  "label" : "Далее",
                                                  "dependencies" : [ ]
                                                } ],
                                                "excluded" : false
                                              } ],
                                              "commands" : [ {
                                                "type" : "check",
                                                "id" : "confirmPersonalInfo"
                                              } ],
                                              "serverFeature" : { }
                                            }
                                          }
                                        }
                                        """))));
    }
    ;

    @BeforeEach
    public void setUp() {
        System.out.println("first");
    }

    @DisplayName("меняю логин")
    @Test
    public void initTest(@Init InitRoot initRootBody) {

        System.out.println("выполняю тест 1");
        List<ValuesItem> values = new LinkedList<>();
        values.add(userFullNameValue);
        values.add(titleValue);
        values.add(branchCodeValue);
        values.add(branchUnitCodeValue);
        values.add(new ValuesItem(Params.LOGIN, "ufo"));

        initRootBody.getData().getVerifyData().setValues(values);
        System.out.println(initRootBody);

        Response response = given().body(initRootBody).post("api/v1/metadata/init")
                .then().extract().response();
//        assertAll(
//                () -> assertEquals(200, response.getStatusCode()));
    }

    @DisplayName("меняю канал")
    @Test
    public void initTestUfoDsa(@Init InitRoot initRootBody) {
        System.out.println("выполняю тест 2");

        initRootBody.getMeta().setChannel("выполняю тест 2");
        System.out.println(initRootBody);
        Response response = given().body(initRootBody).post("api/v1/metadata/init")
                .then().log().all().extract().response();
//
//        assertAll(
//                () -> assertEquals(200, response.getStatusCode()));
    }

    @DisplayName("меняю логин")
    @Test
    public void initTest1(@Init InitRoot initRootBody) {
        System.out.println("выполняю тест 3");
        List<ValuesItem> values = new LinkedList<>();
        values.add(userFullNameValue);
        values.add(titleValue);
        values.add(branchCodeValue);
        values.add(branchUnitCodeValue);
        values.add(new ValuesItem(Params.LOGIN, "выполняю тест 3"));

        initRootBody.getData().getVerifyData().setValues(values);
        System.out.println(initRootBody);

        Response response = given().body(initRootBody).post("api/v1/metadata/init")
                .then().extract().response();
//        assertAll(
//                () -> assertEquals(200, response.getStatusCode()));
    }

    @DisplayName("меняю канал")
    @Test
    public void initTestUfoDsa1(@Init InitRoot initRootBody) {
        System.out.println("выполняю тест 4");

        initRootBody.getMeta().setChannel("ufo-cc");
        System.out.println(initRootBody);
        Response response = given().body(initRootBody).post("api/v1/metadata/init")
                .then().log().all().extract().response();
//
//        assertAll(
//                () -> assertEquals(200, response.getStatusCode()));
    }

    @DisplayName("меняю логин")
    @Test
    public void initTest2(@Init InitRoot initRootBody) {
        System.out.println("выполняю тест 5");
        List<ValuesItem> values = new LinkedList<>();
        values.add(userFullNameValue);
        values.add(titleValue);
        values.add(branchCodeValue);
        values.add(branchUnitCodeValue);
        values.add(new ValuesItem(Params.LOGIN, "выполняю тест 5"));

        initRootBody.getData().getVerifyData().setValues(values);
        System.out.println(initRootBody);

        Response response = given().body(initRootBody).post("api/v1/metadata/init")
                .then().extract().response();
//        assertAll(
//                () -> assertEquals(200, response.getStatusCode()));
    }

    @DisplayName("меняю канал")
    @Test
    public void initTestUfoDsa2(@Init InitRoot initRootBody) {
        System.out.println("выполняю тест 6");

        initRootBody.getMeta().setChannel("ib");
        System.out.println(initRootBody);
        Response response = given().body(initRootBody).post("api/v1/metadata/init")
                .then().log().all().extract().response();
//
//        assertAll(
//                () -> assertEquals(200, response.getStatusCode()));
    }

    @DisplayName("меняю логин")
    @Test
    public void initTest3(@Init InitRoot initRootBody) {
        System.out.println("выполняю тест 7");
        List<ValuesItem> values = new LinkedList<>();
        values.add(userFullNameValue);
        values.add(titleValue);
        values.add(branchCodeValue);
        values.add(branchUnitCodeValue);
        values.add(new ValuesItem(Params.LOGIN, "выполняю тест 7"));

        initRootBody.getData().getVerifyData().setValues(values);
        System.out.println(initRootBody);

        Response response = given().body(initRootBody).post("api/v1/metadata/init")
                .then().extract().response();
//        assertAll(
//                () -> assertEquals(200, response.getStatusCode()));
    }

    @DisplayName("меняю канал")
    @Test
    public void initTestUfoDsa3(@Init InitRoot initRootBody) {
        System.out.println("выполняю тест 8");

        initRootBody.getMeta().setChannel("mb");
        System.out.println(initRootBody);
        Response response = given().body(initRootBody).post("api/v1/metadata/init")
                .then().log().all().extract().response();
//
//        assertAll(
//                () -> assertEquals(200, response.getStatusCode()));
    }



//
//    @DisplayName("перебираю канал")
//    @ParameterizedTest
//    @MethodSource("provideForTestInitTestChannel")
//    public void initTestChannel(String channel, @Init InitRoot initRootBody) {
//        initRootBody.getMeta().setChannel(channel);
//        String actual = given().body(initRootBody).log().all().post("api/v1/metadata/init")
//                .then().extract().response().path("123124");
//
//        assertAll(
//                () -> assertEquals("200", actual));
//    }
//
//
//    private static Stream<Arguments> provideForTestInitTestChannel() {
//        return Stream.of(
//                Arguments.of("ufo")
//                Arguments.of("ufo-dsa"),
//                Arguments.of("ufo-cc"),
//                Arguments.of("ib"),
//                Arguments.of("mobile"),
//                Arguments.of("mb"),
//                Arguments.of("web")
//        );
//    }
}
