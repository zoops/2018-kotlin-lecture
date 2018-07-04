package com.moberan.t03

import org.junit.Test


enum class ShapeType{
    CIRCLE, TRIANGLE, RECT, POLYGON;
}

val initDataList = listOf(ShapeType.CIRCLE,ShapeType.RECT, ShapeType.CIRCLE, ShapeType.POLYGON, ShapeType.TRIANGLE )
interface IShape{
    fun draw(){
        println("draw ")
    }
    fun printInfo()
}
data class Circle private constructor(var x : Int, var y : Int, var w : Int, var h : Int): IShape{
    companion object {
        fun makeShape(x : Int, y : Int, w : Int, h : Int) : Circle{
            return Circle(x,y,w,h)
        }
    }

    override fun draw(){
        println("Draw Circle")
    }

    override fun printInfo() {
        println(this.toString())
    }
}
data class Polygon private constructor(var x : Int, var y : Int, var w : Int, var h : Int): IShape{
    companion object {
        fun makeShape(x : Int, y : Int, w : Int, h : Int) : Polygon{
            return Polygon(x,y,w,h)
        }
    }

    override fun draw(){
        println("Draw Polygon")
    }

    override fun printInfo() {
        println(this.toString())
    }
}
data class Triangle private constructor(var x : Int, var y : Int, var w : Int, var h : Int): IShape{
    companion object {
        fun makeShape(x : Int, y : Int, w : Int, h : Int) : Triangle{
            return Triangle(x,y,w,h)
        }
    }

    override fun draw(){
        println("Draw Triangle")
    }

    override fun printInfo() {
        println(this.toString())
    }
}
data class Rect private constructor(var x : Int, var y : Int, var w : Int, var h : Int): IShape{
    companion object {
        fun makeShape(x : Int, y : Int, w : Int, h : Int) : Rect{
            return Rect(x,y,w,h)
        }
    }

    override fun draw(){
        println("Draw Rect")
    }

    override fun printInfo() {
        println(this.toString())
    }
}
class MinjaeTest {

    @Test
    fun testRun(){
        for(i in initDataList){
            var shape : IShape?
            when(i){
                ShapeType.TRIANGLE->
                    shape = Triangle.makeShape(1,2,3,4)
                ShapeType.CIRCLE->
                    shape = Circle.makeShape(4,3,2,2)
                ShapeType.RECT->
                    shape = Rect.makeShape(9,7,5,3)
                ShapeType.POLYGON->
                    shape = Polygon.makeShape(3,4,6,6)
            }
            shape.draw()
            shape.printInfo()
        }
    }
}