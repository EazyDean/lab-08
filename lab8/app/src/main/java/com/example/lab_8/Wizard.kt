package com.example.lab_8

class Wizard(val name: String, var mana: Int, var spellPower: Int) {
    /*
     * Replication prompt 3: Implement restoreMana
     * Source: OpenAI Codex conversation; retrospective instructions for recreating the lab.
     * The preceding skeleton and tests are covered by prompt 2 in WizardTest.kt.
     *
     * Now implement restoreMana() using mana = minOf(100, mana + amount). Run the full
     * Gradle build, commit and push the implementation, and confirm GitHub Actions passes.
     */
    fun restoreMana(amount: Int) {
        mana = minOf(100, mana + amount)
    }

    /*
     * Replication prompt 5: Implement train
     * Source: OpenAI Codex conversation; retrospective instructions for recreating the lab.
     * The preceding skeleton and tests are covered by prompt 4 in WizardTest.kt.
     *
     * Implement train(): when mana is at least 5, increase spellPower by 1 and decrease
     * mana by 5; otherwise leave both unchanged. Run ./gradlew build --configuration-cache
     * from lab8. Verify all 7 unit tests, both APK builds, and lint pass. Commit and push,
     * then confirm GitHub Actions passes.
     */
    fun train() {
        if (mana >= 5) {
            spellPower += 1
            mana -= 5
        }
    }

    fun castSpell(spell: String): Int {
        when (spell) {
            "Explosion" -> {
                if (mana >= 10) {
                    mana -= 10
                    return spellPower * 3
                } else return 0 // not enough mana
            }
            "Frostbite" -> {
                if (mana >= 5) {
                    mana -= 5
                    return spellPower * 2
                } else return 0 // not enough mana
            }
            else -> {
                return 0 // invalid spell
            }
        }
    }
}
