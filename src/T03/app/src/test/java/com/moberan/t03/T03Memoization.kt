package com.moberan.t03

import org.junit.Test
import kotlin.system.measureNanoTime

// region Factors
fun isFactor(number: Int, potential: Int) = number % potential == 0
fun factorsOf(number: Int) = (1..number).filter { isFactor(number, it) }.toList()
fun sumFactors(number: Int) = factorsOf(number).sum()
/**
 * formatting methods for showing measureNanoTimes effectively
 */
fun Long.format() = String.format("%.5f", (this.toDouble() / 1000000.toDouble()))
// endregion

// region Memoize implement part
class MemoizeHelper<in T, out R>(private val function: (T) -> R) : (T) -> R {
    private val valuesMap = mutableMapOf<T, R>()
    override fun invoke(key: T): R = valuesMap.getOrPut(key, { function(key) })
}
fun <T, R> ((T) -> R).memoize(): (T) -> R = MemoizeHelper(this)
val memoizeSumFactors = { number: Int -> sumFactors(number) }.memoize()
// endregion

// region Cache implement part
val sumMap = mutableMapOf<Int, Int>()
private fun cachedSumFactors(number: Int): Int {
    val value = sumMap[number]
    return if (value == null) {
        val answer = sumFactors(number)
        sumMap.put(number, answer)
        answer
    } else {
        value
    }
}
// endregion
fun Boolean.toInt() = if (this) 1 else 0
val isMemoize = true
val isApply = true
val examplenumber = 2016
val loopCount = 10


class T03Memoization {
    @Test
    fun main() {
        val value = isApply.toInt() + isMemoize.toInt()
        println("Measuring start, methods is $value")

        val applyMethod = {
            when (value) {
                2 -> {
                    memoizeSumFactors(examplenumber)
                }
                1 -> {
                    cachedSumFactors(examplenumber)
                }
                else -> {
                    sumFactors(examplenumber)
                }
            }
        }
        for (i in 1..loopCount) {
            println("Step $i, Measured Time is ${(measureNanoTime { applyMethod() }).format()}ms")
        }
    }
}