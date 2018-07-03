package com.moberan.t03

import org.junit.Test

fun addMaker(a:Int): (Int) -> Int { return { a + it } }


class T03Currying {
    @Test
    fun T03() {
        println("addMaker(1)(2) : ${addMaker(1)(2)}")

        var a1 = addMaker(1)
        println("a1(2) : ${a1(2)}")
        println("a1(3) : ${a1(3)}")
        println("a1(4) : ${a1(4)}")
        println("a1(5) : ${a1(5)}")
    }
}