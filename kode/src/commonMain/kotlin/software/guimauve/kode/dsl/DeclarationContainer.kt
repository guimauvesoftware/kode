package software.guimauve.kode.dsl

interface DeclarationContainer {

    val declarations: MutableList<Declaration>

    fun declaration(declaration: Declaration) = declarations.add(declaration)

}
