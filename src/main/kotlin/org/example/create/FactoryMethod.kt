package org.example.create

sealed class Doll(
    val color: String
) {
    class Teddy(
        color: String
    ) : Doll(color) {
        companion object {
            fun from(color: String) = Teddy(color)
        }
    }

    class Pooh(
        color: String
    ) : Doll(color)
}

enum class Disney {
    YES, NO
}

object Factory {
    val makeDoll = fun(color: String, disney: Disney): Doll {
        // factory 생성 함수는 전처리나 후처리가 자유롭게 가능하다.
        if (color == "red") {
            throw IllegalArgumentException("red is not allowed")
        }
        return when (disney) {
            Disney.YES -> Doll.Teddy(color)
            Disney.NO -> Doll.Pooh(color)
        }
    }
}

fun main() {
    //별도 factory object나 companion object에 factory 함수 정의 가능
    Factory.makeDoll("red", Disney.YES)
    Factory.makeDoll("brown", Disney.NO)

    Doll.Teddy.from("red")
}
