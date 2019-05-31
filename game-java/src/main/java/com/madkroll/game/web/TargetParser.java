package com.madkroll.game.web;

import org.springframework.stereotype.Service;

import java.util.BitSet;

@Service
public class TargetParser {

    public BitSet parse(final String targets) {
        return BitSet.valueOf(new long[]{Long.parseLong(targets, 2)});
    }
}