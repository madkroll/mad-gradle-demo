package com.madkroll.game.web;

import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Getter
@Service
public class BattleState {

    private final LinkedList<BattleTurn> battleLog = new LinkedList<>();

    public BattleTurn reset() {
        battleLog.clear();
        battleLog.add(new BattleTurn(BattlePhase.IN_PROGRESS, 10, 10));
        return battleLog.getLast();
    }

    public BattleTurn doTurn() {
        final BattleTurn lastCommittedTurn = battleLog.getLast();

        if (lastCommittedTurn.getPhase() == BattlePhase.COMPLETE) {
            throw new IllegalStateException("Game is Over. Start a new game.");
        }

        final int playerLifePoints = lastCommittedTurn.getPlayerLifePoints();
        final int opponentLifePoints = lastCommittedTurn.getOpponentLifePoints() - 1;
        final BattlePhase phase =
                Math.min(playerLifePoints, opponentLifePoints) > 0 ? BattlePhase.IN_PROGRESS : BattlePhase.COMPLETE;

        battleLog.add(new BattleTurn(phase, playerLifePoints, opponentLifePoints));
        return battleLog.getLast();
    }
}