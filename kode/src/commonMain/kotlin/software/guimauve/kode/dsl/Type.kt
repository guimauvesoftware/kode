package software.guimauve.kode.dsl

@KodeDsl
class Type internal constructor(
    val name: String,
) : KodeGenerator {

    val parameters = mutableListOf<Type>()

    fun parameter(type: Type) = parameters.add(type)
    fun parameters(vararg types: Type) = this.parameters.addAll(types)

}
