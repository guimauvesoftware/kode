package software.guimauve.kode.dsl

@KodeDsl
class Project : FileOrDirectory {

    val modules = mutableListOf<Module>()
    val textFiles = mutableMapOf<String, TextFile>()

    fun module(name: String, block: Module.() -> Unit = {}) {
        modules.add(Module(name).apply(block))
    }

    fun textFile(name: String, content: String) {
        textFiles[name] = TextFile(content)
    }

}
