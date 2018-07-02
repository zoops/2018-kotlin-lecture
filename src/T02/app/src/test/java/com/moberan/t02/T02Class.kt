package com.moberan.t02

import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class MyClass1 {}

class MyClass2

class MyClass3 {
    val v1 = 10
    var v2 = ""
}

class MyClass4 constructor(val v1: Int = 10, val v2: String = "")

class MyClass5 (val v1: Int = 10, val v2: String = "")

class MyClass6 private constructor(val v1: Int = 10, val v2: String = "")

class MyClass7  (pv1: Int = 10, pv2: String = "") {
    var v1 = pv1
    var v2 = pv2
}

class MyClass8  (v1: Int = 10, v2: String = "") {
    var v1: Int
    var v2: String

    init {  // Initialization block
        this.v1 = v1
        this.v2 = v2
    }
}

class MyClass10 {
    val v1: Int
    var v2: String

    constructor() : this(0) {}
    constructor(v1: Int, v2: String = "none") {
        this.v1 = v1
        this.v2 = v2
    }
}

class MyClass11 {
    class MyClass6Sub1(var v1: Int = 0, var v2: String = "none")

    var sub1: MyClass6Sub1 = MyClass6Sub1(1, "a")
    var sub2: MyClass6Sub1 = MyClass6Sub1()
    var sub3: MyClass6Sub1 = MyClass6Sub1(v2 = "a")

    fun print() {
        var ls = listOf(sub1, sub2, sub3)
        for((idx, l) in ls.withIndex())
            println("$idx : ${l.v1} , ${l.v2}")
    }
}

class MyClass12 {
    var count = 100
        get() {
            println("myclass12 count get")
            return field
        }
        set(value: Int) {
            println("myclass12 count set")
            field = value
        }
    val rocount = 1
}

fun Int.addex(a: Int) = this + a

class ExampleUnitTest {
    @Test
    fun T02() {
        println("Start T02")

        val mc = MyClass11()
        mc.print()

        val mc12 = MyClass12()
        println("${mc12.count}")
        mc12.count = 111
        println("${mc12.count}")

        println("${1.addex(2)}")
    }
}
