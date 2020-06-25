package com.vinci7.lc.lc0007;

class Solution {
    public int reverse(int x) {
        boolean isNegative = false;
        long num = x;
        if (x < 0) {
            isNegative = true;
            num *= -1;
        }
        long res = num % 10;
        num /= 10;
        while (num > 0) {
            res = res * 10 + num % 10;
            num /= 10;
            if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) return 0;
        }
        if (isNegative) res = res * -1;
        return (int) res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse(123));
        System.out.println(solution.reverse(-123));
        System.out.println(solution.reverse(120));
        System.out.println(solution.reverse(1000000));
        System.out.println(solution.reverse(1534236469));
        System.out.println(solution.reverse(-2147483648));
    }
}
