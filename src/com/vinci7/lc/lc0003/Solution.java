package com.vinci7.lc.lc0003;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Boolean> bucket = new HashMap<>();
        int head = 0, res = 0;
        for (int tail = 0; tail < s.length(); tail++) {
            while (bucket.getOrDefault(s.charAt(tail), false)) {
                bucket.put(s.charAt(head), false);
                head = head + 1 < s.length() ? head + 1 : head;
            }
            bucket.put(s.charAt(tail), true);
            res = tail - head + 1 > res ? tail - head + 1 : res;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
        System.out.println(solution.lengthOfLongestSubstring("a"));
        System.out.println(solution.lengthOfLongestSubstring(""));
    }
}
