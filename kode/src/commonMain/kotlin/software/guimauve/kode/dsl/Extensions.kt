package software.guimauve.kode.dsl

fun String.shift(spaces: Int) =
    split("\n").joinToString("\n") { " ".repeat(spaces) + it }

operator fun String.unaryPlus() = Text(this)

fun type(name: String, init: Type.() -> Unit = {}) =
    Type(name).apply(init)

fun `package`(name: String, init: Package.() -> Unit = {}) =
    Package(name).apply(init)

fun file(init: File.() -> Unit) =
    File().apply(init)
