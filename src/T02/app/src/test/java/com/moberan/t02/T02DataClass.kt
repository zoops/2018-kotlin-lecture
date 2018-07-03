package com.moberan.t02

import org.junit.Test

data class User(val id: Long, val name: String)

enum class EClazz(var str:String = "") {

    E1("nameE1"), E2("nameE2"), E3, E4, E5;
}


val list1 = listOf(8,3,4,2,6,8,2,3,8,4)
val list2 = listOf(1,2,3,4,5,6,7,8,9,0)
lateinit var olist:List<Int>

fun max(a:Int, b:Int) = if (a > b) a else b

fun makeMaxList(l1: List<Int>, l2: List<Int>): List<Int>? {
    if (l1.size != l2.size) return null

    var ol = mutableListOf<Int>()
    for(i in l1.indices) ol.add(max(l1[i], l2[i]))

    return ol
}

class T02DataClass {

    @Test
    fun T02Data() {
        println("Start T02Data")

        var u = User(0, "name")
        println("$u")
        println("${u.id}, ${u.name}")
        println("${u.component1()}, ${u.component2()}")

        val (id, name) = u
        println("id : $id name : $name")

        println("${EClazz.E1.ordinal}, ${EClazz.E1.name}, ${EClazz.E1.str}")
    }

    @Test
    fun T01ExText01() {
        println("start T01ExText01")

        olist = makeMaxList(list1, list2) ?: mutableListOf()
        for((idx, v) in olist.withIndex()) println("$idx : $v")
    }

}