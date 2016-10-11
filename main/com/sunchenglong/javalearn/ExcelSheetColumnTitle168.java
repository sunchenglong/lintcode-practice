package com.sunchenglong.javalearn;

/**
 * Created by Chenglong Sun on 2016/10/11.
 */
public class ExcelSheetColumnTitle168 {
    public String convertToTitle(int n) {
        if (n <= 0) return "";
        StringBuilder stringBuilder = new StringBuilder("");
        do {
            n -= 1;
            char tmp = (char) ('A' + n % 26);
            stringBuilder.append(tmp);
            n /= 26;
        }while (n>0);
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new ExcelSheetColumnTitle168().convertToTitle(28));
    }
}
