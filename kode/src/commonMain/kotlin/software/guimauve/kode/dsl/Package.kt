package software.guimauve.kode.dsl

@KodeDsl
class Package internal constructor(
    val name: String,
) {

    val packages = mutableListOf<Package>()
    val files = mutableMapOf<String, File>()

    fun `package`(name: String, init: Package.() -> Unit = {}) =
        packages.add(Package("${this.name}.$name").apply(init))

    fun file(name: String, init: File.() -> Unit = {}) =
        files.put(name, File().apply(init).apply { `package`(this@Package.name) })

}
