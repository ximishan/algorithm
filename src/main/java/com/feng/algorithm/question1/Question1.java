package com.feng.algorithm.question1;

import java.util.HashMap;

/**
 * @author zhangfeng
 * @date 2020/5/26 1:25 下午
 *
 * 给定一个整数数组 nums 和一个目标值 target，
 * 请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question1 {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] resultArr = twoSum_(nums, target);
        System.out.println("第一个下标="+resultArr[0]);
        System.out.println("第二个下标="+resultArr[1]);
    }

    // 暴力循环
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i=0; i<nums.length; i ++) {
            int ans = target - nums[i];
            for (int j=i+1 ;j <nums.length; j++) {
                if (ans == nums[j]) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    // 官方答案
    public static int[] twoSum_(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i=0; i<nums.length; i ++) {
            if (hashMap.containsKey(target - nums[i])) {
                result[0] = i;
                result[1] = hashMap.get(target - nums[i]);
            }
            hashMap.put(nums[i], i);
        }
        return result;
    }
}
