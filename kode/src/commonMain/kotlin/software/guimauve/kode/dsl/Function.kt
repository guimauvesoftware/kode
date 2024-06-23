package software.guimauve.kode.dsl

@KodeDsl
class Function internal constructor(val name: String) : Declaration, InstructionContainer {

    val arguments = mutableListOf<Variable>()
    val instructions = mutableListOf<Instruction>()

    override fun instruction(instruction: Instruction) {
        instructions.add(instruction)
    }

    fun argument(name: String, type: Type) = arguments.add(Variable(name, type))

}
