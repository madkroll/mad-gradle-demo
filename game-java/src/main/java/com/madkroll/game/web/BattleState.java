package com.madkroll.game.web;

import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Getter
@Service
public class BattleState {

    private final LinkedList<BattleRound> battleLog = new LinkedList<>();

    public BattleRound reset() {
        battleLog.clear();
        battleLog.add(new BattleRound(BattlePhase.IN_PROGRESS, 10, 10));
        return battleLog.getLast();
    }

    public BattleRound doTurn() {
        validateTurn();

        final BattleRound lastRound = battleLog.getLast();

        final int playerLifePoints = lastRound.getPlayerLifePoints();
        final int opponentLifePoints = lastRound.getOpponentLifePoints() - 1;
        final BattlePhase phase =
                Math.min(playerLifePoints, opponentLifePoints) > 0 ? BattlePhase.IN_PROGRESS : BattlePhase.COMPLETE;

        battleLog.add(new BattleRound(phase, playerLifePoints, opponentLifePoints));
        return battleLog.getLast();
    }

    private void validateTurn() {
        if (battleLog.isEmpty()) {
            throw new IllegalStateException("Game is Over. Start a new game.");
        }

        final BattleRound lastRound = battleLog.getLast();

        if (lastRound.getPhase() == BattlePhase.COMPLETE) {
            throw new IllegalStateException("Game is Over. Start a new game.");
        }
    }
}