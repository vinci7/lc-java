package com.vinci7.lc.lc0005;

class Solution {
    public String longestPalindrome(String s) {
        int len = s.length(), maxLen = 0,startPoint = 0, j;
        boolean[][] dp = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
            if (i + 1 < len){
                if (s.charAt(i) == s.charAt(i + 1)){
                    dp[i][i + 1] = true;
                }
            }
        }

        for (int range = 0; range < len; range++) {
            for (int i = 0; i + range < len; i++) {
                j = i + range;
                if (s.charAt(i) != s.charAt(j)) continue;

                if (i + 1 < len && j - 1 >= 0){
                    dp[i][j] = dp[i + 1][j - 1] ? true : dp[i][j];
                }

                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    startPoint = i;
                }
            }
        }
        return s.substring(startPoint, startPoint+maxLen);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("cbbc"));
        System.out.println(solution.longestPalindrome("babad"));
        System.out.println(solution.longestPalindrome("aaabaaaa"));
    }

}
