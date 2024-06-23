package software.guimauve.kode.dsl

@KodeDsl
class Call internal constructor(
    val name: String,
) : Instruction {

    val parameters = mutableListOf<Instruction>()

    fun parameter(instruction: Instruction) = parameters.add(instruction)
    fun parameters(vararg instructions: Instruction) = this.parameters.addAll(instructions)

}
