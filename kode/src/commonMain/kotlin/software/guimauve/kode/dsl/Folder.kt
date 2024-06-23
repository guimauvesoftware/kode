package software.guimauve.kode.dsl

data class Folder(
    val content: Map<String, FolderContent>,
) : FolderContent
