package com.moberan.t04

import org.junit.Test

interface IMyClazz<T>

class E04Variance {
    @Test
    fun E04() {

        open class MyClazzImpl<T>(val v:T) : IMyClazz<T>
        data class MySubClazzImpl<T>(val w:T) : MyClazzImpl<T>(w)

        fun printMyClazz(my: MyClazzImpl<Number>) {
            println(my)
        }

        fun printInt(ls: List<Number>) {
            ls.forEach {print("$it ")}
            println("")
        }

        val m1 = MyClazzImpl<Int>(1)
        val m2 = MyClazzImpl<String>("aaa")
        val m3 : IMyClazz<String> = MyClazzImpl<String>("aaa")
        val m4 = MyClazzImpl<Number>(222)
        val m5 = MySubClazzImpl<Number>(222)
        println(m1)
        println(m2)
        println(m3)
        printMyClazz(m4)
        //printMyClazz(m1)
        printMyClazz(m5)

        val lt1:List<Number> = listOf(1,2)
        val lt2 = listOf<Number>(3,4)
        val lt3 = listOf<Number?>(5,6)
        val lt4:List<Number?> = listOf(7,8)
        val lt5:List<Int> = listOf(9,0)
        val lt6: ArrayList<Int> = arrayListOf(9,0)

        printInt(lt1)
        printInt(lt2)
        // printInt(lt3)
        // printInt(lt4)
        printInt(lt5)
        printInt(lt5)
        printInt(lt6)

        class InVariance<T>
        class CoVariance<out T>
        class ContraVariance<in T>

        val in1 = InVariance<Int>()
        // val in2:InVariance<Number> = in1
        val in3:InVariance<out Number> = in1 // 사용지점변성

        val co1 = CoVariance<Int>()
        val co2: CoVariance<Number> = co1

        val ct1 = ContraVariance<Int>()
        // val ct2 : ContraVariance<Number> = ct1
        val ct3 = ContraVariance<Number>()
        val ct4:ContraVariance<Int> = ct3



    }
}