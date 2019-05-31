package com.madkroll.game.battle;

import com.madkroll.game.utils.TargetParser;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Getter
@Service
public class BattleState {

    private final LinkedList<BattleRound> battleLog = new LinkedList<>();

    private final DamageCalculator damageCalculator;
    private final TargetParser targetParser;

    public BattleState(final DamageCalculator damageCalculator, final TargetParser targetParser) {
        this.damageCalculator = damageCalculator;
        this.targetParser = targetParser;
    }

    public BattleRound reset() {
        battleLog.clear();
        battleLog.add(new BattleRound(BattlePhase.IN_PROGRESS, 10, 10));
        return battleLog.getLast();
    }

    public BattleRound doTurn(final BattleTurn playerTurn) {
        validateTurn();

        final BattleTurn opponentTurn = opponentDoesTurn();
        final int damageToPlayer = damageCalculator.calculate(opponentTurn, playerTurn);
        final int damageToOpponent = damageCalculator.calculate(playerTurn, opponentTurn);

        final BattleRound lastRound = battleLog.getLast();

        final int playerLifePoints = lastRound.getPlayerLifePoints() - damageToPlayer;
        final int opponentLifePoints = lastRound.getOpponentLifePoints() - damageToOpponent;
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

    private BattleTurn opponentDoesTurn() {
        return new BattleTurn(targetParser.parse("1100"), targetParser.parse("0011"));
    }
}