package software.guimauve.kode.kotlin

import software.guimauve.kode.dsl.Package
import software.guimauve.kode.dsl.`package`
import software.guimauve.kode.dsl.type
import software.guimauve.kode.dsl.unaryPlus
import kotlin.test.Test

class KotlinVisitorTest {

    @Test
    fun testPackage() {
        fun printPackage(pkg: Package) {
            println(pkg.name)
            println("files: " + pkg.files.map { it.key + " -> " + KotlinVisitor.visit(it.value) })
            pkg.packages.forEach { printPackage(it) }
        }

        val basePackage = "com.example"
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

        }.let(::printPackage)
    }

}
