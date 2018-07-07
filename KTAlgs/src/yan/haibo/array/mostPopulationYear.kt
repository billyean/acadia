package yan.haibo.array

import kotlin.math.max

class Person {
    var name: String = ""

    var birthYear: Int = 0

    var deathYear: Int = 0
}

fun mostPopulationYear(people: Array<Person>): Int {
    var mi = Int.MAX_VALUE
    var mx = Int.MIN_VALUE

    for (p in people) {
        mi = max(mi, p.birthYear)
        mx = max(mx, p.deathYear)
    }

    var years: Array<Int> = Array(mx - mi, {i -> 0})
    for (p in people) {
        years[p.birthYear - mi]++
        years[p.deathYear - mi]--
    }

    var c: Int = 0
    var m: Int = 0
    var y: Int = 0
    for (i in years.indices) {
        c += years[i]
        y = if (c > m)  y else i
        m = if (c > m)  c else m
    }

    return mi + y
}