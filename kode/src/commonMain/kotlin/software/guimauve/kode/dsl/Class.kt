package software.guimauve.kode.dsl

@KodeDsl
class Class(
    val name: String,
    val data: Boolean = false,
) : Declaration, DeclarationContainer {

    override val declarations = mutableListOf<Declaration>()

}
