package com.moberan.t02

import org.junit.Test

data class User(val id: Long, val name: String)

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
    }
}