package com.liugd;

/**
 * TODO
 *
 * @author <a href="mailto:liugd2020@gmail.com">liuguodong</a>
 * @since 1.0
 */
public class Leetcode14LongestCommonPrefix {

    public static void main(String[] args) {
//        Solution solution = new Solution();
//        String commonPrefix = solution.longestCommonPrefix(new String[]{"flower",  "flight", "flow"});
//        System.out.println(commonPrefix);

        Solution1 solution1 = new Solution1();
        String commonPrefix1 = solution1.longestCommonPrefix(new String[]{"flower",  "flight", "flow"});
        System.out.println(commonPrefix1);
    }




}


class Solution1 {
    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0){
            return "";
        }
        int length = strs.length;
        String prefix = strs[0];
        // 遍历数组，数组每个比较
        for (int i= 1; i< length; i++){
            prefix = comparePrefix(prefix, strs[i]);
            // 如果任意一个比较是空,说明没有相同的数据直接返回空
            if (prefix.length() == 0) {
                break;
            }
        }

        return prefix;
    }

    /**
     *
     * @param str1
     * @param str2
     * @return
     */
    String comparePrefix(String str1, String str2){
        // 为了防止出现下标越界,取最小的长度
        int length = Math.min(str1.length(), str2.length());
        int i = 0;
        // 比较最小
        while (length > i && str1.charAt(i) == str2.charAt(i)){
            i++;
        }
        return str1.substring(0, i);
    }

}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    public String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }
}

