package com.madkroll.game.web;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.BitSet;

@Getter
@AllArgsConstructor
public class BattleTurn {

    private final BitSet attackTargets;
    private final BitSet defenseTargets;
}