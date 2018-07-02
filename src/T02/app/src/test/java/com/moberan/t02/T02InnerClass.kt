package com.moberan.t02

import org.junit.Test

class Outter {
    var v1 = 0;
    var s1 = "outter"
    var o1 = "outter o1"

    fun print() = println("$s1, $v1, $o1")
    inner class Inner {
        var v1 = 1;
        var s1 = "Inner"

        fun print() {
            this@Outter.print();
            println("$s1, $v1, $o1")
        }
    }
}
class T02InnerClass {

    @Test
    fun T02() {
        println("Start T02InnerClass")

        var o = Outter().Inner();
        o.print()
    }
}