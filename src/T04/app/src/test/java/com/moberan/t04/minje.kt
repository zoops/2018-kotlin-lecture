package com.moberan.t04

import org.junit.Test
import java.util.*

fun <T> TimeLogCheck(tag : String, f:(String) -> T): T {
    val startTime = GregorianCalendar()
    println("${startTime.toZonedDateTime()} : $tag 시작")
    val result = f(tag)
    val endTime = GregorianCalendar()
    val elapsed = endTime.timeInMillis - startTime.timeInMillis
    println("${endTime.toZonedDateTime()} : $tag -> 종료(elapsed time : $elapsed")
    return result
}

val workList = MutableList(1000){it + 1}

class TestClass{
    @Test
    fun run(){
//        workList.forEach { print(it) }
        TimeLogCheck("collection"){
            workList.filter{ num -> num%2==0 }.map{num -> num.toString()}
        }
        TimeLogCheck("stream"){
            workList.asSequence().filter { num -> num % 2==0 }.map { num -> num.toString() }.toList()
        }
    }
}