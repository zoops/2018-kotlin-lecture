package com.moberan.t03

import org.junit.Test
import java.io.File

data class User(var name: String , var email: String? = null, var profile: String? = null)

class T03SL {
    @Test
    fun T03() {
        val user = User("importre").run {
            email = "importre@example.com"
            profile = "http://path/to"
            this
        }

        println("run : $user")

        val user2 = User("importre").let {
            it.email = "importre@example.com"
            it.profile = "http://path/to"
            this
        }
        println("let : $user2")

        val user3 = User("importre").apply {
            email = "importre@example.com"
            profile = "http://path/to"
        }

        println("apply : $user3")

        var list = File("c:\\").list()?.let {
            // `it`은 File("/usr/local").list()
            // println(size)
            println(it.size)
            this
        }

        println("$list")
    }
}