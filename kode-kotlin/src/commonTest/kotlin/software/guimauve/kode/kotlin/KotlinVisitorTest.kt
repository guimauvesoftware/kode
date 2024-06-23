package software.guimauve.kode.kotlin

import software.guimauve.kode.dsl.`class`
import software.guimauve.kode.dsl.dataClass
import software.guimauve.kode.dsl.file
import software.guimauve.kode.dsl.function
import kotlin.test.Test

class KotlinVisitorTest {

    @Test
    fun main() {
        file {
            `package`("com.example")
            imports("java.util.*", "kotlin.*")
            `class`("MyClass") {
                function("myFunction") {

                }
            }
            dataClass("MyDataClass") {
                function("myDataFunction") {

                }
            }
            function("main") {

            }
        }.let {
            println(KotlinVisitor.visit(it))
        }
    }

}
