package com.moberan.t03

import org.junit.Test

class T03Stream {
    @Test
    fun T03() {
        var list = listOf(1,2,3,4,5,6,7,8,9,0)
        var list2 = list.filter { println("filter"); (it % 2 ) == 0 }.map { println("map"); it * 100 }
        list2.forEach { println(it) }

        var list3 = list.stream().filter { println("filter"); (it % 2 ) == 0 }.map { println("map"); it * 100 }
        list3.forEach { println(it) }
        // list3.forEach { println(it) }

        var avg = list.asSequence().filter { println("filter"); (it % 2 ) == 0 }.map { println("map"); it * 100 }
        println(avg.reduce { acc, i -> acc + i })
    }
}