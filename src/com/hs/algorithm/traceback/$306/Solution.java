package com.hs.algorithm.traceback.$306;

/**
 * TODO
 * LC 306
 *
 * @author hushe
 * @date 2020/4/24/0024 14:29
 * @email husheng3921@163.com
 */
public class Solution {

    public boolean isAdditiveNumber(String num) {
        if (num == null || num.length() < 3){
            return false;
        }
        char[] nums = num.toCharArray();
        long pre1,pre2;
        //起始数字要满足
        //1.开头不为0，长度不超过总长一半
        for (int i = 0; i < num.length()/2; i++){
          /*  if (nums[0] == '0' && i > 0){
                break;
            }*/
            pre1 = getNum(nums,0,i);
            for (int j = i+1; j < num.length(); j++) {
                if (nums[i+1] == '0' && j > i + 1) {
                    break;
                }
                pre2 = getNum(nums, i+1, j);
                if (backtrack(nums,j+1,pre1,pre2)){
                    return true;
                }
            }
        }
        return false;
    }
    long getNum(char[] nums, int start, int end) {
        if (end >= nums.length){
            return -1;
        }
        long ans = 0;
        for (int i = start; i <= end; i++) {
            ans *= 10;
            ans += (nums[i]-'0');
        }
        return ans;
        //
    }
    boolean backtrack(char[] nums, int start, long pre1, long pre2){
        long target = pre1 + pre2;
        int length = String.valueOf(target).length();
        if (getNum(nums,start,start+length -1) != target) {
            return false;
        }
        start = start + length;
        return start == nums.length || backtrack(nums,start,pre2,target);

    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isAdditiveNumber("112358"));
    }
}
