package software.guimauve.kode.dsl

@KodeDsl
class Variable internal constructor(
    val name: String,
    val type: Type,
) : Declaration
