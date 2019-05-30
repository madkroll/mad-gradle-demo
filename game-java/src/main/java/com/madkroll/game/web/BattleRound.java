package com.madkroll.game.web;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class BattleRound {

    private final String turnId = UUID.randomUUID().toString();
    private final BattlePhase phase;
    private final int playerLifePoints;
    private final int opponentLifePoints;

}