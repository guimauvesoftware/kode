package software.guimauve.kode.visitors

import software.guimauve.kode.dsl.project
import software.guimauve.kode.dsl.type
import software.guimauve.kode.dsl.unaryPlus
import software.guimauve.kode.usecases.GenerateFolderUseCase
import software.guimauve.kode.usecases.GenerateKotlinUseCase
import kotlin.test.Test

class KotlinVisitorTest {

    @Test
    fun testModule() {
        val basePackage = "com.example"

        val proj = project {
            module("shared") {
                sourceSet("commonMain") {
                    directorySet("kotlin") {
                        `package`(basePackage) {
                            file("Application.kt") {
                                import("$basePackage.plugins")
                                import("io.ktor.server.application.*")
                                import("io.ktor.server.netty.*")

                                function("main") {
                                    argument("args", type("Array") {
                                        parameter(type("String"))
                                    })
                                    call("EngineMain.main") {
                                        parameters(+"args")
                                    }
                                }

                                function("Application.module") {
                                    call("configureI18n")
                                    // ...
                                }
                            }
                            `package`("plugins") {
                                file("I18n.kt") {
                                    import("dev.kaccelero.plugins.I18n")
                                    import("io.ktor.server.application.*")
                                    import("java.util.*")

                                    function("Application.configureI18n") {
                                        call("install") {
                                            parameter(+"I18n")
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        val folder = GenerateFolderUseCase(GenerateKotlinUseCase()).invoke(proj)
        println(folder)
    }

}
