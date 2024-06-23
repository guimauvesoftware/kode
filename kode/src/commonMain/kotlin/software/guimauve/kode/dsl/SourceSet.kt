package software.guimauve.kode.dsl

@KodeDsl
class SourceSet internal constructor(
    val name: String,
) : FileOrDirectory {

    val directorySets = mutableListOf<SourceDirectorySet>()

    fun directorySet(name: String, block: SourceDirectorySet.() -> Unit = {}) {
        directorySets.add(SourceDirectorySet(name).apply(block))
    }

}
