package com.example.lab_8


import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class WizardTest {
    private lateinit var evilWizard: Wizard

    // Set up a new wizard before every single test
    @Before
    fun setUp() {
        evilWizard = Wizard("Evil Wizard", 30, 10)
    }

    @Test
    fun castSpell_explosion_successful() {
        val damageDealt = evilWizard.castSpell("Explosion")

        assertEquals(30, damageDealt) // spellPower of 10 * 3 = 30

        assertEquals(20, evilWizard.mana) // mana of 30 - 10 = 20
    }

    @Test
    fun castSpell_explosion_unsuccessful() {
        evilWizard.mana = 5 // Evil Wizard does not have enough mana to cast "Explosion"
        val damageDealt = evilWizard.castSpell("Explosion")

        assertEquals(0, damageDealt)

        assertEquals(5, evilWizard.mana) // mana still is 5
    }

    /*
     * Replication prompt 2: Write the restoreMana tests first
     * Source: OpenAI Codex conversation; retrospective instructions for recreating the lab.
     * Applies to both restoreMana tests below and the initial skeleton in Wizard.kt.
     *
     * Add an empty restoreMana(amount: Int) method to Wizard. Add two JUnit tests:
     * restoring 80 mana from 30 must cap mana at 100; restoring 40 from 30 must produce 70.
     * Run the tests and verify both fail. Commit and push this tests-first version, then
     * confirm GitHub Actions fails on those assertions. Leave the method empty.
     */
    @Test
    fun restoreMana_amountAddedExceedsOneHundred_manaSetToOneHundred() {
        evilWizard.restoreMana(80)

        assertEquals(100, evilWizard.mana)
    }

    @Test
    fun restoreMana_amountAddedDoesNotExceedOneHundred_manaIncreasesCorrectly() {
        evilWizard.restoreMana(40)

        assertEquals(70, evilWizard.mana)
    }

    /*
     * Replication prompt 4: Write the train tests first
     * Source: OpenAI Codex conversation; retrospective instructions for recreating the lab.
     * Applies to both train tests below and the initial skeleton in Wizard.kt.
     *
     * Add an empty train() method with no parameters. Write two JUnit tests: with exactly
     * 5 mana and spellPower 10, training must produce mana 0 and spellPower 11; with 4 mana,
     * both values must remain unchanged. Verify the sufficient-mana test fails locally.
     * Commit and push the skeleton and tests, then confirm GitHub Actions fails on that
     * test before implementing train().
     */
    @Test
    fun train_exactlyFiveMana_spellPowerIncreasesAndManaDecreases() {
        evilWizard.mana = 5

        evilWizard.train()

        assertEquals(11, evilWizard.spellPower)
        assertEquals(0, evilWizard.mana)
    }

    @Test
    fun train_lessThanFiveMana_spellPowerAndManaRemainUnchanged() {
        evilWizard.mana = 4

        evilWizard.train()

        assertEquals(10, evilWizard.spellPower)
        assertEquals(4, evilWizard.mana)
    }
}
