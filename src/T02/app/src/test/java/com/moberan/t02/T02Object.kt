package com.moberan.t02

import org.junit.Test

interface TListener {
    fun onEvent()
}

object Person {
    var name: String = ""
    var age: Int = 0
}

data class Person2 private constructor(val name: String, val age: Int)
{
    object Shared {
        fun makePerson(name: String, age: Int): Person2 {
            return Person2(name, age)
        }
    }
}

data class Person3 private constructor(val name: String, val age: Int, var litener: TListener? = null)
{
    fun doFire() = litener?.onEvent()

    companion object {
        fun makePerson(name: String, age: Int): Person3
        {
            var tmp = age
            return Person3(name, age, object: TListener {
                override fun onEvent() {
                    println("evt2 : $tmp")
                }
            })
        }
    }
}

class T02Object {
    @Test
    fun T02() {
        var p3 = Person3.makePerson("zoops3", 43);
        println("Person3.makePerson : ${p3}")
        p3.doFire()
    }
}