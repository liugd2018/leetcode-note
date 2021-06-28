package com.liugd;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author <a href="mailto:liugd2020@gmail.com">liuguodong</a>
 * @since 1.0
 */
public class Leetcode01TwoSum {
    /**
     *
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     *
     * 你可以按任意顺序返回答案。
     *
     * 示例 1：
     *
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
     * 示例 2：
     *
     * 输入：nums = [3,2,4], target = 6
     * 输出：[1,2]
     * 示例 3：
     *
     * 输入：nums = [3,3], target = 6
     * 输出：[0,1]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/two-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] resultIndices01 = twoSum01(new int[]{2,7,11,15}, 9);
        System.out.println(Arrays.toString(resultIndices01));

        int[] resultIndices02 = twoSum02(new int[]{2,7,11,15}, 9);
        System.out.println(Arrays.toString(resultIndices02));

    }

    /**
     * 暴力循环
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum01(int[] nums, int target) {

        int[] resultIndices = new int[]{};

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target){
                    resultIndices = new int[]{i,j};
                }
            }

        }
        return resultIndices;
    }

    /**
     * hash 表的方式
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum02(int[] nums, int target) {

        int[] resultIndices = new int[]{};
        Map<Integer,Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            numMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {

            int diff = target - nums[i];
            if (numMap.containsKey(diff)){
                return new int[]{i,numMap.get(diff)};
            }

        }
        return resultIndices;
    }
}
