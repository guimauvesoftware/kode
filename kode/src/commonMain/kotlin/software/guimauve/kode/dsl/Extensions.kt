package software.guimauve.kode.dsl

fun String.shift(spaces: Int) =
    split("\n").joinToString("\n") { " ".repeat(spaces) + it }

fun file(init: File.() -> Unit) =
    File().apply(init)

fun DeclarationContainer.`class`(name: String, init: Class.() -> Unit) =
    declaration(Class(name).apply(init))

fun DeclarationContainer.dataClass(name: String, init: Class.() -> Unit) =
    declaration(Class(name, data = true).apply(init))

fun DeclarationContainer.function(name: String, init: Function.() -> Unit) =
    declaration(Function(name).apply(init))
