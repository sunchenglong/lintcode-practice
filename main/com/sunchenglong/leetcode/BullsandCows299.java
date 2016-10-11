package com.sunchenglong.leetcode;

import java.util.HashMap;

/**
 * Created by Chenglong Sun on 2016/10/12.
 */
public class BullsandCows299 {
    public String getHint(String secret, String guess) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int length = secret.length();
        int bull = 0;
        int cows = 0;
        for (int i = 0; i < length; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bull++;
            } else {
                if (hashMap.containsKey(secret.charAt(i))) {
                    hashMap.put(secret.charAt(i), hashMap.get(secret.charAt(i)) + 1);
                } else {
                    hashMap.put(secret.charAt(i), 1);
                }
            }
        }
        for (int i = 0; i < length; i++) {
            if (secret.charAt(i) != guess.charAt(i)) {
                if (hashMap.containsKey(guess.charAt(i)) && hashMap.get(guess.charAt(i)) > 0) {
                    cows++;
                    hashMap.put(guess.charAt(i), hashMap.get(guess.charAt(i)) - 1);
                }
            }
        }
        return String.valueOf(bull) + "A" + String.valueOf(cows) + "B";
    }
}
