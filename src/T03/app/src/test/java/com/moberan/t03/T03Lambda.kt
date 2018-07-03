package com.moberan.t03

import org.junit.Test

typealias mytype = (Int, Int)->Int

class T03Lambda {
    @Test
    fun T03() {

        fun f1(a:Int, b:Int): Int {
            return a + b
        }
        println("일반 함수 : ${f1(1,2)}")

        fun f2(a:Int, b:Int) = a + b
        println("표현식 함수 : ${f2(1,2)}")

        val f3 : (Int, Int) -> Int = fun(x, y) = x + y
        println("익명 함수 : ${f3(1,2)}, ${f3}")

        val f4 = fun(x: Int, y: Int) = x + y
        println("익명 함수2 : ${f4(1,2)}, ${f4}")
        val f4_1:mytype = fun(x, y) = x + y
        println("익명 함수2 : ${f4_1(1,2)}, ${f4_1}")

        var l1 = { a:Int, b:Int -> println("l1");a+b }
        var l1_1 = { a:Int, b:Int -> a+b; println("l1_1") }
        println("람다1 : ${l1(1,2)}")
        println("람다1 마지막 식의 값 : ${l1_1(1,2)}")

        var l2: (Int)->Boolean = { it > 0 }
        println("람다2 : ${l2(2)}, ${l2.invoke(2)}")

        var l3 = { println("l3") }
        println("람다3 : $l3 : ${l3()}")

        val tmp = 10
        var l4 = { println("$tmp") }
        println("람다4 : $l4 : ${l4()}")

        // Int 하나를 인자로 받고 Boolean 을 리턴하는 함수 타입
        var l5: ((Int) -> Boolean)? = null
        l5 = { it > 0 }
        println("람다5 : ${l5(2)}, ${l5.invoke(2)}")

        // 인자 없고 String 을 리턴하는 함수 타입
        var l6: (() -> String)? = null
        l6 = { "인자없고 String리턴" }
        println("람다6 : ${l6()}, ${l6.invoke()}")

        var l7: (Int, Int) -> Int = { x, y -> x*y }
        println("람다7 : ${l7(1,2)}, ${l7.invoke(3,4)}")

        var l8: (Int, Int) -> Unit = { x, y -> println("l8 : $x, $y") }
        println("람다8 : ${l8(1,2)}, ${l8.invoke(3,4)}")

        var l9: ( (Int, Int) -> Int, Int, Int, Int) -> Int = { x, y, z, k -> x(x(y, z), k)  }
        println("람다9 : ${l9({x, y -> println("$this : $x, $y"); if(x > y) x else y }, 1, 3, 2)}")

        var l10: ( () -> (Int, Int) -> Int, Int, Int, Int) -> Int = { x, y, z, k -> x()(x()(y, z), k)  }
        println("람다10 : ${l10( {{x, y -> println("$this : $x, $y"); if(x > y) x else y }}, 1, 3, 2)}")
        println("람다10 : ${l10( {{x, y -> println("$this : $x, $y"); if(x > y) y else x }}, 1, 3, 2)}")

        fun f5(a:Int, b:(Int, Int)->Int) : Int = b(a, a)

        var f5r = f5(3) { x, y -> x*y }
        println("람다11: $f5r")

        fun f6(b:(Int, Int)->Int) : Int = b(5, 5)

        var f6r = f6 { x, y -> x*y }
        println("람다12: $f6r")
    }
}