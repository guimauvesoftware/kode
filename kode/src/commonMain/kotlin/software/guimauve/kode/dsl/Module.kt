package software.guimauve.kode.dsl

@KodeDsl
class Module internal constructor(
    val name: String,
) : FileOrDirectory {

    val sourceSets = mutableListOf<SourceSet>()

    fun sourceSet(name: String, block: SourceSet.() -> Unit = {}) {
        sourceSets.add(SourceSet(name).apply(block))
    }

}
