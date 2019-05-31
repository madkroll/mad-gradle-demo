package com.madkroll.game.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class DamageCalculatorTest {

    private final TargetParser targetParser = new TargetParser();

    @Parameters
    public static List<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"11", "11", 0},
                {"11", "00", 2},
                {"10", "01", 1},
                {"01", "10", 1},
                {"00", "00", 0},
                {"00", "11", 0}
        });
    }

    private final String attack;
    private final String defense;
    private final int expectedDamage;

    public DamageCalculatorTest(final String attack, final String defense, final int expectedDamage) {
        this.attack = attack;
        this.defense = defense;
        this.expectedDamage = expectedDamage;
    }

    @Test
    public void shouldCalculateCorrectDamage() {
        final int damage =
                new DamageCalculator().calculate(
                        new BattleTurn(targetParser.parse(attack), null),
                        new BattleTurn(null, targetParser.parse(defense))
                );

        assertThat(damage).isEqualTo(expectedDamage);
    }
}