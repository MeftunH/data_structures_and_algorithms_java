package leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    //Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    //
    //You may assume that each input would have exactly one solution, and you may not use the same element twice.
    //
    //You can return the answer in any order.
    //
    //
    //
    //Example 1:
    //
    //Input: nums = [2,7,11,15], target = 9
    //Output: [0,1]
    //Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
    //Example 2:
    //
    //Input: nums = [3,2,4], target = 6
    //Output: [1,2]
    //Example 3:
    //
    //Input: nums = [3,3], target = 6
    //Output: [0,1]
    //
    //
    //Constraints:
    //
    //2 <= nums.length <= 104
    //-109 <= nums[i] <= 109
    //-109 <= target <= 109
    //Only one valid answer exists.
    //
    //
    //Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
    public static void main(String[] args) {
        int[] numbers = new int[] {2,3,7,4,8};
        int target =7;
        int[] result = getTwoSum(numbers,target);
        System.out.println(result[0] + " " + result[1]);
    }
    public static int[] getTwoSum(int[] numbers,int target){
        Map<Integer,Integer> iteratedNumbers = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int delta = target -numbers[i];
            if(iteratedNumbers.containsKey(delta)){
              return new int[] {i,iteratedNumbers.get(delta)};
            }
            iteratedNumbers.put(numbers[i],i);
        }
        //when it gives nothing
         return new int[] {-1,-1};
    }
}
