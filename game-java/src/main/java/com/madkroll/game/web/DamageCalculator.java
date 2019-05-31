package com.madkroll.game.web;

import org.springframework.stereotype.Component;

import java.util.BitSet;

@Component
public class DamageCalculator {

    public int calculate(final BattleTurn attackTurn, final BattleTurn defenseTurn) {
        final BitSet damageMatrix = new BitSet();
        damageMatrix.or(defenseTurn.getDefenseTargets());
        damageMatrix.flip(0, damageMatrix.size());
        damageMatrix.and(attackTurn.getAttackTargets());

        return damageMatrix.cardinality();
    }
}