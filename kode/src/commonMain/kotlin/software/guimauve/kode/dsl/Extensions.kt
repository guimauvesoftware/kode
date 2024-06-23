package software.guimauve.kode.dsl

fun String.shift(spaces: Int) =
    split("\n").joinToString("\n") { " ".repeat(spaces) + it }

operator fun String.unaryPlus() = Text(this)

fun project(init: Project.() -> Unit = {}) =
    Project().apply(init)

fun type(name: String, init: Type.() -> Unit = {}) =
    Type(name).apply(init)
