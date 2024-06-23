package software.guimauve.kode.dsl

interface DeclarationContainer {

    fun declaration(declaration: Declaration)

    fun `class`(name: String, init: Class.() -> Unit = {}) =
        declaration(Class(name).apply(init))

    fun dataClass(name: String, init: Class.() -> Unit = {}) =
        declaration(Class(name, data = true).apply(init))

    fun function(name: String, init: Function.() -> Unit = {}) =
        declaration(Function(name).apply(init))

    fun variable(name: String, type: Type) =
        declaration(Variable(name, type))

}
