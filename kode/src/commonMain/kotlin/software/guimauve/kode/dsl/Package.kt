package software.guimauve.kode.dsl

@KodeDsl
class Package internal constructor(
    val name: String,
) : FileOrDirectory {

    val packages = mutableListOf<Package>()
    val files = mutableMapOf<String, File>()
    val textFiles = mutableMapOf<String, TextFile>()

    fun `package`(name: String, init: Package.() -> Unit = {}) {
        packages.add(Package("${this.name}.$name").apply(init))
    }

    fun file(name: String, init: File.() -> Unit = {}) {
        files[name] = File().apply(init).apply { `package`(this@Package.name) }
    }

    fun textFile(name: String, content: String) {
        textFiles[name] = TextFile(content)
    }

}
