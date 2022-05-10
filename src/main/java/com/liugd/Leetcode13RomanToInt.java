package com.liugd;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author <a href="mailto:liugd2020@gmail.com">liuguodong</a>
 * @since 1.0
 */
public class Leetcode13RomanToInt {
    public static void main(String[] args) {

        System.out.println(romanToInt("XLIX"));
    }

//    private static Map<String, Integer> romanMap = new HashMap<>();
//
//
//    static {
//        romanMap.put("I",1);
//        romanMap.put("V",5);
//        romanMap.put("X",10);
//        romanMap.put("L",50);
//        romanMap.put("C",100);
//        romanMap.put("D",500);
//        romanMap.put("M",1000);
//    }

    private static  Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    // 49 999
    // XLIX



    public static int romanToInt(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            int value = symbolValues.get(s.charAt(i));
            if (i < n - 1 && value < symbolValues.get(s.charAt(i + 1))) {
                ans -= value;
            } else {
                ans += value;
            }
        }
        return ans;
    }


}
