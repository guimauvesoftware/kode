package software.guimauve.kode.usecases

import dev.kaccelero.usecases.IUseCase
import software.guimauve.kode.dsl.KodeGenerator

interface IGenerateCodeUseCase : IUseCase<KodeGenerator, String>
