package com.madkroll.game.web;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/game")
@RestController
@Log4j2
public class GameController {

    private final BattleState battleState;

    public GameController(final BattleState battleState) {
        this.battleState = battleState;
    }

    @RequestMapping("/start")
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public BattleRound startGame() {
        return battleState.reset();
    }

    @RequestMapping("/turn")
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public BattleRound handleTurn() {
        return battleState.doTurn();
    }
}