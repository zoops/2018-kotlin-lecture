package com.moberan.t04

import org.junit.Test


interface ISuper<T2> {
    fun printInfo(v: T2)
}

data class SubClass<T, T2>(var v1:T) : ISuper<T2> {
    override fun printInfo(v: T2) {
        println("subclass printInfo : $v")
    }
}

data class TData<T, S> (var v1: T?  = null, var v2: S? = null)

fun <T> add(a:T, b:T):String {
    return a.toString() + b.toString()
}

fun <T : Comparable<T> > max(a:T, b:T) : T {
    return if (a > b) a else b
}

inline fun <reified T> checkType(s: Any) {
    if (s is T)
        println("같은 타입")
    else
        println("다른 타입")
}

class Ex03Class {

    @Test
    fun T04() {
        val d1 = TData<String, Int>("zoops", 43)
        println("d1 : $d1")

        val d2 = TData("zoops2", 43+2)
        println("d2 : $d2")

        val d3 = TData(20, d2)
        println("d3 : $d3")

        var sub:ISuper<String> = SubClass<Int, String>(3)
        println("sub : $sub")
        sub.printInfo("hoho")


        println(add(1, 2))
        println(add("zoop", "s"))

        println(max(1,2))
        println(max("z", "a"))

        checkType<String>(1)
        checkType<String>("a")
    }
}