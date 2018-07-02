package com.moberan.t02

import org.junit.Test

class Account(val age: Int) {
    operator fun plus(account: Account): Account {
        return Account(age + account.age)
    }

    operator fun minus(account: Account): Account {
        return Account(age - account.age)
    }

    operator fun invoke() = println("hello world")

    override fun toString(): String {
        return "$age years old"
    }
}

class T02OperatorOverloading {

    @Test
    fun T02OpO() {
        println(Account(10) + Account(20))
        println(Account(20) - Account(10))
        println(Account(10).plus(Account(20)))

        // println(Account(1)())
    }
}