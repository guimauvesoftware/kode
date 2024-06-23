package software.guimauve.kode.dsl

@KodeDsl
class File : KodeGenerator, DeclarationContainer {

    var `package` = ""
    val imports = mutableListOf<String>()
    override val declarations = mutableListOf<Declaration>()

    fun `package`(name: String) {
        `package` = name
    }

    fun import(import: String) = imports.add(import)
    fun imports(vararg imports: String) = this.imports.addAll(imports)

}
