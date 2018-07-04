package com.moberan.t03

import org.junit.Test
import java.util.*

fun timeLogCheck(tag: String, f: (tag:String) -> List<String>): List<String> {
    var startTime = GregorianCalendar()
    println("${startTime.toZonedDateTime()} : $tag -> Start")

    var l = f(tag)

    var endTime = GregorianCalendar()
    println("${endTime.toZonedDateTime()} : $tag -> End (elapsed time : ${endTime.timeInMillis - startTime.timeInMillis})")

    return l
}

class T03Ex {
    @Test
    fun T03() {

        val initList = mutableListOf<Int>()
        for(i in 1..1000) {
            initList.add(i)
        }


        var outList2 = timeLogCheck("collection") {
            println("$it lambda start")
            initList.filter { (it%2) > 0 }.map{ it.toString() }
        }

        var outList3 = timeLogCheck("stream") {
            println("$it lambda start")
            initList.asSequence().filter { (it%2) > 0 }.map{ it.toString() }.toList()
        }
    }
}