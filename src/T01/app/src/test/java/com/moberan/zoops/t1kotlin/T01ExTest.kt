package com.moberan.zoops.t1kotlin

import org.junit.Test

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

class T01ExTest {
    @Test
    fun T01ExText01() {
        println("start T01ExText01")

        olist = makeMaxList(list1, list2) ?: mutableListOf()
        for((idx, v) in olist.withIndex()) println("$idx : $v")
    }
}