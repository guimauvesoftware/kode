package software.guimauve.kode.usecases

import dev.kaccelero.usecases.IUseCase
import software.guimauve.kode.dsl.FileOrDirectory
import software.guimauve.kode.dsl.FolderContent

interface IGenerateFolderUseCase : IUseCase<FileOrDirectory, FolderContent>
