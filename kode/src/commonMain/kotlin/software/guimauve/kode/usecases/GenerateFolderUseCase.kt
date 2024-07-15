package software.guimauve.kode.usecases

import software.guimauve.kode.dsl.*

class GenerateFolderUseCase(
    private val generateCodeUseCase: IGenerateCodeUseCase,
) : IGenerateFolderUseCase {

    override fun invoke(input: FileOrDirectory): FolderContent = invoke(input, "")

    private fun invoke(input: FileOrDirectory, parentPackage: String): FolderContent = when (input) {
        is Project -> Folder(input.modules.associate { it.name to invoke(it) } +
                input.textFiles.map { it.key to invoke(it.value) }.associate { it })

        is Module -> Folder(input.sourceSets.associate { it.name to invoke(it) })
        is SourceSet -> Folder(input.directorySets.associate { it.name to invoke(it) })
        is SourceDirectorySet -> folderFor(input.packages, parentPackage, input.files, input.textFiles)
        is Package -> folderFor(input.packages, parentPackage, input.files, input.textFiles)
        is File -> TextFile(generateCodeUseCase(input))
        is TextFile -> input
    }

    private fun folderFor(
        packages: List<Package>,
        parentPackage: String,
        files: Map<String, File>,
        textFiles: Map<String, TextFile>,
    ) = Folder(
        packages.associate { it.associate(parentPackage) }
                + files.map { it.key to invoke(it.value) }.associate { it }
                + textFiles.map { it.key to it.value }.associate { it }
    )

    private fun Package.associate(parentPackage: String) =
        name.removePrefix(parentPackage).replace('.', '/').trim('/') to invoke(this, name)

}
