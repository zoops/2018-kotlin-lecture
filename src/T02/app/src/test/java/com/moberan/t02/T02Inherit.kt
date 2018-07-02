package com.moberan.t02

import org.junit.Test


open class Parent(var a: Int) {
    fun funB() {
        println("ParentA funB()")
    }
    open fun funA() {
        println("Parent funA()")
    }
}

interface IParent {
    fun funA() {
        println("IParent funIA()")
    }
}

data class Example(var age: Int) : Parent(age), IParent {
    constructor(name: String, age: Int) : this(age) {
        println("$name $age")
    }

    override fun funA() {
        println("Child FunA()")
        super<IParent>.funA()
        super<Parent>.funA()

        funB()
    }
}

interface MyInterface {
    val prop: Int // abstract

    val propertyWithImplementation: String
        get() = "foo"

    fun foo() {
        print(prop)
    }
}

data class Child (override val prop: Int = 29): MyInterface

class T02Inherit {
    @Test
    fun T02() {
        println("Start T02Inherit")

        var ex = Example("zoops", 1)
        println("$ex")
        ex.funA()

        var ch = Child()
        println("$ch : ${ch.propertyWithImplementation}")
        ch.foo()

    }
}