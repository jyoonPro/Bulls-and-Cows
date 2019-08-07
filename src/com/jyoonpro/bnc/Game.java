package com.jyoonpro.bnc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {

    private int[] digit;
    int turn;

    public Game() {
        List<Integer> num = new ArrayList<>(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        Collections.shuffle(num);

        digit = new int[4];

        digit[0] = num.get(0);
        digit[1] = num.get(1);
        digit[2] = num.get(2);
        digit[3] = num.get(3);

        turn = 0;
    }

    public String checkAns(String a1, String a2, String a3, String a4) {

        int[] ans = new int[4];
        ans[0] = Integer.parseInt(a1);
        ans[1] = Integer.parseInt(a2);
        ans[2] = Integer.parseInt(a3);
        ans[3] = Integer.parseInt(a4);

        if (ans[0] == ans[1] || ans[0] == ans[2] || ans[0] == ans[3] ||
        ans[1] == ans[2] || ans[1] == ans[3] || ans[2] == ans[3]) {
            return "Duplicate";
        }

        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (digit[i] == ans[j]) {
                    if (i == j) {
                        strike++;
                    } else {
                        ball++;
                    }
                }
            }
        }

        turn++;

        if (strike == 4) {
            return "Correct!";
        } else {
            return String.format("%d Strike %d Ball", strike, ball);
        }
    }
}
