class UserV1 (var name: String, var surname: String)

class UserV2 (name: String, surname: String) {
    val name = name
    val surname = surname
}

class UserV3 (name: String, surname: String) {
    var name = name
        get() = name.decapitalize()
        set
    var surname = surname
        get() = surname.decapitalize()
        set
}

val u1 = UserV1("Java", "Leader")
val u2 = UserV2("Java", "Leader")
val u3 = UserV3("Java", "Leader")

fun main(args: Array<String>) {
    println(u1.name)
    println(u1.surname)

    println(u2.name)
    println(u2.surname)

    println(u3.name)
    println(u3.name)
}