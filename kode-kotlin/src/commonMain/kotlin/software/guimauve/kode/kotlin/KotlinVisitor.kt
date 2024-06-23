package software.guimauve.kode.kotlin

import software.guimauve.kode.dsl.Class
import software.guimauve.kode.dsl.File
import software.guimauve.kode.dsl.KodeGenerator
import software.guimauve.kode.dsl.shift

object KotlinVisitor {

    fun visit(generator: KodeGenerator): String = when (generator) {
        is File -> visitFile(generator)
        is Class -> visitClass(generator)
        is software.guimauve.kode.dsl.Function -> visitFunction(generator)
    }

    private fun visitFile(file: File): String = """
        |package ${file.`package`}
        |
        |${file.imports.joinToString("\n") { "import $it" }}
        |
        |${file.declarations.joinToString("\n\n") { visit(it) }}
    """.trimMargin()

    private fun visitClass(`class`: Class): String = """
        |${if (`class`.data) "data " else ""}class ${`class`.name} {
        |${`class`.declarations.joinToString("\n") { visit(it) }.shift(4)}
        |}
    """.trimMargin()

    private fun visitFunction(function: software.guimauve.kode.dsl.Function): String = """
        |fun ${function.name}() {
        |${function.declarations.joinToString("\n") { visit(it) }.shift(4)}
        |}
    """.trimMargin()

}
