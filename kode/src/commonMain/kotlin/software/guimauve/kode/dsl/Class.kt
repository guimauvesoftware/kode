package software.guimauve.kode.dsl

@KodeDsl
class Class internal constructor(
    val name: String,
    val data: Boolean = false,
) : Declaration, DeclarationContainer {

    val declarations = mutableListOf<Declaration>()

    override fun declaration(declaration: Declaration) {
        declarations.add(declaration)
    }

}
