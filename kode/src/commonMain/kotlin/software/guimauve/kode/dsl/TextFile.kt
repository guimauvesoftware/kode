package software.guimauve.kode.dsl

@KodeDsl
data class TextFile internal constructor(
    val content: String,
) : FolderContent, FileOrDirectory
