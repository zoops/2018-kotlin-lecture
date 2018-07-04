package com.moberan.t04

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

data class TData<T, S> (var v1: T?  = null, var v2: S? = null)

class ExampleUnitTest {

    @Test
    fun T04() {
        val d1 = TData<String, Int>("zoops", 43)
        println("d1 : $d1")

        val d2 = TData("zoops2", 43+2)
        println("d2 : $d2")

        val d3 = TData(20, d2)
        println("d3 : $d3")
    }

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}
