package com.moberan.t02

import org.junit.Test

enum class ESHAPE {
    CIRCLE, TRIANGLE, RECT, POLYGON
}

val initDataList = listOf(ESHAPE.TRIANGLE, ESHAPE.CIRCLE, ESHAPE.POLYGON, ESHAPE.RECT, ESHAPE.POLYGON)

interface IShape {
    fun draw()
    fun printInfo()
}

data class Circle private constructor(val x:Int, val y:Int, val w:Int, val h:Int) : IShape {

    companion object {
        fun create(x:Int, y:Int, w:Int, h:Int): IShape {
            return Circle(x, y, w, h)
        }
    }
    override fun draw() {
        println("Circle.draw")
    }

    override fun printInfo() {
        println("Circle.printInfo : $this")
    }
}

data class Triangle private constructor(val x:Int, val y:Int, val w:Int, val h:Int) : IShape {

    companion object {
        fun create(x:Int, y:Int, w:Int, h:Int): IShape {
            return Triangle(x, y, w, h)
        }
    }

    override fun draw() {
        println("Triangle.draw")
    }

    override fun printInfo() {
        println("Triangle.printInfo : $this")
    }
}

data class Rect private constructor(val x:Int, val y:Int, val w:Int, val h:Int) : IShape {

    companion object {
        fun create(x:Int, y:Int, w:Int, h:Int): IShape {
            return Rect(x, y, w, h)
        }
    }

    override fun draw() {
        println("Rect.draw")
    }

    override fun printInfo() {
        println("Rect.printInfo : $this")
    }
}

data class Polygon private constructor(val x:Int, val y:Int, val w:Int, val h:Int) : IShape {

    companion object {
        fun create(x:Int, y:Int, w:Int, h:Int): IShape {
            return Polygon(x, y, w, h)
        }
    }

    override fun draw() {
        println("Polygon.draw")
    }

    override fun printInfo() {
        println("Polygon.printInfo : $this")
    }
}

class T02Ex {

    @Test
    fun T02() {
        var shapeList = mutableListOf<IShape>()

        for(t in initDataList) {
            shapeList.add( when(t) {
                            ESHAPE.CIRCLE -> Circle.create(1,2,3,4)
                            ESHAPE.TRIANGLE -> Triangle.create(1,2,3,4)
                            ESHAPE.RECT -> Rect.create(1,2,3,4)
                            ESHAPE.POLYGON -> Polygon.create(1,2,3,4)
                            })
        }

        shapeList.forEach({it.draw(); it.printInfo()})
    }

}