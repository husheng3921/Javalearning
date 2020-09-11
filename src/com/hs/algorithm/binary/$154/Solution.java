package com.hs.algorithm.binary.$154;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/09/11 13:42
 */
public class Solution {
    public int minArray(int[] numbers){
        int low = 0;
        int high = numbers.length - 1;
        while (low < high){
            int mid = (low + high)/2;
            if(numbers[mid] < numbers[high]){
                high = mid;
            }else if(numbers[mid] > numbers[high]){
                low = mid + 1;
            }else{
                high -= 1;
            }
        }
        return numbers[low];
    }
}
