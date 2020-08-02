package com.hs.algorithm.traceback.permute;

/**
 * TODO
 * L31 下一个排列 中等
 * @author hushe
 * @date 2020/5/5/0005 15:18
 * @email husheng3921@163.com
 */
public class $31 {
    public void nextPermutation(int[] nums) {
        int length = nums.length;
        if (length <= 1){
            return;
        }
        int i = length -2, j = length -1, k = length -1;
        while (i >=0 && nums[i] >= nums[j]){
            i--;
            j--;
        }

        if (i >=0 ){
            while (nums[i] >= nums[k]){
                k--;
            }
            swap(nums,i,k);
        }
        for (i =j, j = length -1; i < j; i++, j--){
            swap(nums,i,j);
        }

    }
    private void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,8,5,7,6,4};
        $31 so = new $31();
        so.nextPermutation(nums);
        for (int item : nums){
            System.out.print(item+" ");
        }
    }
}
