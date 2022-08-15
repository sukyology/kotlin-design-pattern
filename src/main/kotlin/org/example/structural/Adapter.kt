package org.example.structural

class Magician {
    fun castFireball() = println("Fireball!")
}

class Knight {
    fun swingSword() = println("Sword!")
}

class Ninja {
    fun throwShuriken() = println("Shuriken!")
}

interface Attacker {
    fun attack()
}


class Player(
    private val attacker: Attacker
) {
    fun commandAttack() = attacker.attack()
}

// in java

class NinjaAdapter(private val ninja: Ninja) : Attacker {
    override fun attack() = ninja.throwShuriken()
}

// in kotlin

fun Knight.toAttacker() = object : Attacker {
    override fun attack() = swingSword()
}

fun main() {
    val player = Player(NinjaAdapter(Ninja()))
    player.commandAttack()

    val kotlinPlayer = Player(Knight().toAttacker())
    kotlinPlayer.commandAttack()
}