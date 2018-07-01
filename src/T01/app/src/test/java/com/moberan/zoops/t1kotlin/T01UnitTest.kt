package com.moberan.zoops.t1kotlin

import org.junit.Test
import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

val data1 : Int = 10
var data2 : Int = 20
var data3 = 30
const val data4 = 40

var str: String = "aaa" // ok
var str2 = "bbb"        // ok
// var str3: String = null // error
var str4: String? = null // ok
var str5 = """abcd
                .efg
                .high""".trimMargin(".") //trimIndent()

var kotlinLogo = """| //
                   .|//
                   .|/ \"""


class T01UnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    fun max(a: Int, b: Int): Int {
        return if (a > b) a else b
    }

    fun max2(a: Int, b: Int): Int = if (a > b) a else b

    fun max3(a: Int, b: Int) = if (a > b) a else b

    fun some(a: Int, b: Int): Int {
        return a + b
    }
    fun some2(a: Int, b: Int): Int = a + b
    fun some3(a: Int, b: Int) = a + b

    fun sayHello(name: String = "kkang", no: Int){
        println("Hello!!"+name)
    }

    fun <T> varargfunc(vararg args : T) {
        for(v in args) {
            println("$v")
        }
    }

    tailrec fun tailrecPrint(no: Int = 1, count: Int = 1){
        println("tailrecPrint...")
        return if(no==count) return else tailrecPrint(no -1, count)
    }

    infix fun Int.addex(v:Int) = this+v

    @Test
    fun T01() {
        println("hello kotlin T01")

        val ct01: CT01 = CT01 ()
        ct01.T01_01()

        println(max(1,2))
        println(max2(2,3))
        println(max3(3,4))

        println("$data1, $data2, $data3")
        // data1 += 20
        data2 += 30
        println("$data1, $data2, $data3")

        println("$str2, $str4, $str5")

        // sayHello(10)//error
        sayHello("lee", 20)
        sayHello(no=10)
        sayHello(name="kim", no=10)

        varargfunc("a", "b", "c", 10, 20)

        tailrecPrint(10, 1)

        println(10.addex(20))

        println("\$abc")

        println(kotlinLogo.trimMargin("."))
    }

    @Test
    fun T01_1() {
        println("hello kotlin T01_1")

        var d01 : D01 = D01("init", 0)
        println("d01 : ${d01.i1}, ${d01.s1}")

        d01.s1 = "s"
        d01.i1 = 10
        println("d01 : ${d01.i1}, ${d01.s1}")
        println("d01 : ${d01.component1()}, ${d01.component2()}")
    }
}



