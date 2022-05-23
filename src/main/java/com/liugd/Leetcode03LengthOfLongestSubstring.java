package com.liugd;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *  
 *
 * 提示：
 *
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author <a href="mailto:liugd2020@gmail.com">liuguodong</a>
 * @since 1.0
 */
public class Leetcode03LengthOfLongestSubstring {
    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring(" "));
        System.out.println(lengthOfLongestSubstring(""));
        System.out.println(lengthOfLongestSubstring("abba"));
    }

    public static int lengthOfLongestSubstring(String s) {

        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        int length = s.length();
        int currIndex = -1;
        for (int i = 0; i < length; i++) {
            char charAt = s.charAt(i);
            // 如果存在就去取当前字符串的下标地址, 需要比较一下当前字符串下标和已经重复的字符串下标
            if (map.containsKey(charAt)){
                currIndex = Math.max(map.get(charAt), currIndex);
            }
            // 当前循环的坐标地址-重复字符串的坐标地址= 重复字符串最大长度
            // 比较当前坐标地址是否 > 最大坐标地址
            maxLength = Math.max(i - currIndex, maxLength);
            // 把重复的最新坐标地址保存
            map.put(charAt, i);
        }
        return maxLength;

    }
}















