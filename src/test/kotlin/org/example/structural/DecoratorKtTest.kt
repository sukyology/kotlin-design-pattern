package org.example.structural

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class DecoratorKtTest{

    @Test
    fun a(){
        val a = listOf(1000, 2, 3)
        println(a.first().javaClass)
    }
}