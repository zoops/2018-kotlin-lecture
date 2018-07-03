package com.moberan.t03

import org.junit.Test

data class Person(val name: String, val age: Int)

val people = listOf(Person("Alice", 29), Person("Bob", 31))

fun lookForAlice(people: List<Person>) {
    people.forEach {
        if (it.name == "Alice") {
            println("Found!")
            return
        }
    }
    println("Alice is not found")
}

fun lookForAlice2(people: List<Person>) {
    people.forEach {
        if (it.name == "Alice") {
            println("Found!")
            return@forEach
        }
    }
    println("Alice is not found")
}

fun lookForAlice3(people: List<Person>) {
    people.forEach(fun (person) {
        if (person.name == "Alice") {
            println("Found!")
            return
        }
    })
    println("Alice is not found")
}


class T03NonLocalReture {
    @Test
    fun T03() {
        lookForAlice(people)
        lookForAlice2(people)
        lookForAlice3(people)
    }
}