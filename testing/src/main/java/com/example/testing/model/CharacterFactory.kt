package com.example.testing.model

import com.example.core.domain.model.Character

class CharacterFactory {
    fun create(hero: Hero) = when (hero) {
        Hero.ThreeDMan -> Character(
            "3-D Man",
            "https://i.annihil.us/u/prod/marvel/i/mg/3/20/535fecbbb9784.jpg"
        )

        Hero.Abomb -> Character(
            "A-Bomb (HAS)",
            "https://i.annihil.us/u/prod/marvel/i/mg/3/20/5232158de5b16.lpg"
        )
    }

    sealed class Hero {
        object ThreeDMan : Hero()
        object Abomb : Hero()
    }
}