package software.guimauve.kode.dsl

interface InstructionContainer : DeclarationContainer {

    fun instruction(instruction: Instruction)

    override fun declaration(declaration: Declaration) =
        instruction(declaration)

    fun call(name: String, init: Call.() -> Unit = {}) =
        instruction(Call(name).apply(init))

}
