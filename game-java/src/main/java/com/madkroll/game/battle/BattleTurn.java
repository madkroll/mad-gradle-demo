package com.madkroll.game.battle;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.BitSet;

@Getter
@AllArgsConstructor
public class BattleTurn {

    private final BitSet attackTargets;
    private final BitSet defenseTargets;
}