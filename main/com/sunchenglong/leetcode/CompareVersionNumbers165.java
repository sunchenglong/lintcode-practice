package com.sunchenglong.leetcode;

/**
 * Created by Administrator on 2016/8/7.
 */
public class CompareVersionNumbers165 {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int v1Length = v1.length - 1;
        int v2Length = v2.length - 1;
        int length = Math.max(v1Length, v2Length);
        int v1Int, v2Int;
        for (int i = 0; i <= length; i++) {
            v1Int = v1Length < i ? 0 : Integer.parseInt(v1[i]);
            v2Int = v2Length < i ? 0 : Integer.parseInt(v2[i]);
            if(v1Int == v2Int){
                continue;
            }else if(v1Int < v2Int){
                return -1;
            } else {
                return 1;
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        System.out.println(new CompareVersionNumbers165().compareVersion("1.0", "1"));
    }
}
