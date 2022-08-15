package org.example.create

//singleton
class JavaSingleton private constructor() {

    fun statelessMethod() {
        println("stateless method")
    }

    companion object {
        private var _instance: JavaSingleton? = null
        val instance = fun(): JavaSingleton {
            if (_instance == null) {
                _instance = JavaSingleton()
            }
            return _instance!!
        }
    }
}

object KotlinSingleton {
    fun statelessMethod() {
        println("stateless method")
    }
}

fun main() {
    println(JavaSingleton.instance() == JavaSingleton.instance())
    println(KotlinSingleton == KotlinSingleton)
}