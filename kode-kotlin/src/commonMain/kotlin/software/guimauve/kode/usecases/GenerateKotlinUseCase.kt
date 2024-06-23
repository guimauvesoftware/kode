package software.guimauve.kode.usecases

import software.guimauve.kode.dsl.KodeGenerator
import software.guimauve.kode.visitors.KotlinVisitor

class GenerateKotlinUseCase : IGenerateCodeUseCase {

    override fun invoke(input: KodeGenerator): String = KotlinVisitor.visit(input)

}
