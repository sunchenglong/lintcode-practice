package com.sunchenglong.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chenglong Sun on 2016/10/30.
 */
public class RestoreIPAddresses93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        dfsRestore(result, path, s, 0, 0);
        return result;
    }

    private void dfsRestore(List<String> result, StringBuilder path, String s, int start, int level) {
        if (level == 4 && start == s.length()) {
            result.add(path.toString().substring(0, path.length() - 1));
        } else if (level < 4) {
            for (int i = 1; i <= 3; i++) {
                if ((start + i <= s.length() && i <= 2) || (i == 3 && start + 3 <= s.length() && Integer.valueOf(s.substring(start, start + 3)) < 256)) {
                    if (!s.substring(start, start + i).matches("0{1,}\\d{1,}")) {
                        path.append(s.substring(start, start + i));
                        path.append(".");
                        dfsRestore(result, path, s, start + i, level + 1);
                        int pathl = path.length();
                        path.replace(pathl - i - 1, pathl, "");
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        String s = "12345";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(s.substring(1, 2));
        System.out.println(stringBuilder.toString());
        System.out.println(Integer.valueOf(s.substring(0, 3)));
        System.out.println(new RestoreIPAddresses93().restoreIpAddresses("0000"));
        System.out.println("0".matches("0{1,}\\d{1,}"));
    }
}
