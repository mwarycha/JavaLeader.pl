fun sum(i: Int, j: Int) = i + j

val arg1 = try {
    sum(10,15)
}
catch (e: Exception) {
    -1
}

var arg2: Int? = null
try {
    arg2 = sum(10,15)
} catch (e: Exception) {
    arg2 = -1
}

val result = arg2!!

fun checkType(a: Any?) = when(a) {
    null   -> "null"
    is Int -> "number"
    else   -> "?"
}

println(checkType(5))
println(checkType(null))

fun String.startWithUpperCaseCustom() = this[0].isUpperCase()
println("JavaLeader.pl".startWithUpperCaseCustom())

val u1     = UserV1("JavaLeader", "pl")
u1.name    = "JavaLeader"
u1.surname = "pl"

u1.apply {
    name    = "JavaLeader"
    surname = "pl"
}
