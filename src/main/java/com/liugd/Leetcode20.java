package com.liugd;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 *
 * @author <a href="mailto:liugd2020@gmail.com">liuguodong</a>
 * @since 1.0
 */
public class Leetcode20 {


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("()[]{}"));;

    }

    static class Solution {
        public boolean isValid(String s) {
            if (s == null || s.length() == 0 || s.length() % 2 != 0) return false;


            for (int i = 0; i < s.length() - 2; i++) {
                char charAt = s.charAt(i);
                char charAt1 = s.charAt(i + 1);
                if (charAt != charAt1){
                    return false;
                }
            }

            int midLength = s.length() / 2;
            String start = s.substring(0, midLength);
            String end = s.substring(midLength);
            if (start.equals(end)){
                return true;
            }
            return false;


        }
    }
}
