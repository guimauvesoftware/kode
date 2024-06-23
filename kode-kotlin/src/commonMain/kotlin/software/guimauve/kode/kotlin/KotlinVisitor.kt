package software.guimauve.kode.kotlin

import software.guimauve.kode.dsl.*

object KotlinVisitor {

    fun visit(generator: KodeGenerator): String = when (generator) {
        is Text -> generator.text
        is File -> visitFile(generator)
        is Class -> visitClass(generator)
        is software.guimauve.kode.dsl.Function -> visitFunction(generator)
        is Variable -> visitVariable(generator)
        is Type -> visitType(generator)
        is Call -> visitCall(generator)
    }

    private fun visitFile(file: File): String = listOf(
        "package ${file.`package`}\n",
        file.imports.joinToString("\n") { "import $it" }.takeIf { it.isNotEmpty() }?.let { "\n$it\n" } ?: "",
        file.declarations.joinToString("\n\n") { visit(it) }.takeIf { it.isNotEmpty() }?.let { "\n$it\n" } ?: ""
    ).joinToString("")

    private fun visitClass(`class`: Class): String = """
        |${if (`class`.data) "data " else ""}class ${`class`.name} {
        |${`class`.declarations.joinToString("\n") { visit(it) }.shift(4)}
        |}
    """.trimMargin()

    private fun visitFunction(function: software.guimauve.kode.dsl.Function): String = """
        |fun ${function.name}(${function.arguments.joinToString(", ") { "${it.name}: ${visit(it.type)}" }}) {
        |${function.instructions.joinToString("\n") { visit(it) }.shift(4)}
        |}
    """.trimMargin()

    private fun visitVariable(variable: Variable): String = """
        |val ${variable.name}: ${visit(variable.type)}
    """.trimMargin()

    private fun visitType(type: Type): String = """
        |${type.name}${if (type.parameters.isNotEmpty()) "<${type.parameters.joinToString(", ") { visit(it) }}>" else ""}
    """.trimMargin()

    private fun visitCall(call: Call): String = """
        |${call.name}(${call.parameters.joinToString(", ") { visit(it) }})
    """.trimMargin()

}
