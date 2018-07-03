package com.moberan.t03

import org.junit.Test

class T03Sam {
    @Test
    fun T03() {
        JavaSAMSample.setSAM { println("sam-onclick : $it") }
        JavaSAMSample.doFire(100)
    }
}