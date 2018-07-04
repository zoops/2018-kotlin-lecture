package com.moberan.t04

import org.junit.Test

class E04Projection {

    @Test
    fun E04() {
        class Star<T>
        val st1:Star<Any> = Star<Any>()
        // val st2:Star<Any> = Star<Int>()

        val st5:Star<out Any> = Star<Int>()

        val st6:Star<*> = Star<Any>()
        val st7:Star<*> = Star<Int>()

        fun printListItem(list : List<*>) {
            println("갯수 : ${list.size}")
            println("내역 : $list")
            // list.add(100)
        }

        val ls1 = listOf(1,2,3)
        val ls2 = listOf("a", "b", "c")
        printListItem(ls1)
        printListItem(ls2)
    }
}