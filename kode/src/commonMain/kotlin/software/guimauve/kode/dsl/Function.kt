package software.guimauve.kode.dsl

@KodeDsl
class Function(val name: String) : Declaration, DeclarationContainer {

    override val declarations = mutableListOf<Declaration>()

}
