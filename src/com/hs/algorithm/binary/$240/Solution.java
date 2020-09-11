package com.hs.algorithm.binary.$240;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/09/11 9:20
 */
public class Solution {
    /**
     * O(logmn)
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
       if(matrix == null || matrix.length == 0){
           return false;
       }
       int left = 0;
       int right = matrix.length * matrix[0].length - 1;
       int col = matrix[0].length;
       while (left <= right){
           int mid = (left + right)/2;
           int value = matrix[mid/col][mid % col];
           if(value == target){
               return true;
           }else if(value > target){
               right = mid - 1;
           }else{
               left = mid + 1;
           }
       }
       return false;
    }
    public boolean find(int[][] matrix, int target){
        if(matrix == null || matrix.length == 0){
            return false;
        }
        int row = 0;
        int column = matrix[0].length - 1;
        while (row < matrix.length && column >= 0){
            if(matrix[row][column] == target){
                return true;
            }else if (matrix[row][column] < target){
                row++;
            }else{
                column--;
            }
        }
        return false;
    }
}
