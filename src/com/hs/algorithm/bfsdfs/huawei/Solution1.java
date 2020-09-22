package com.hs.algorithm.bfsdfs.huawei;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/09/18 10:23
 */
public class Solution1 {

   static boolean[][] vis;
    public static void main(String[] args) {
        int[][] nums = new int[4][4];
        vis = new boolean[4][4];
        nums[0][1] = 4;
        nums[3][3] = 3;
       dfs(nums,0,1,4);
        dfs(nums,3,3,3);
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                System.out.print(nums[i][j]+" ");
            }
            System.out.println();
        }
    }


    private static void dfs(int[][] nums, int i, int j, int num){
        if(i < 0 || j < 0 || i >= 4 || j >= 4 || vis[i][j]){
            return;
        }
        vis[i][j]= true;
        nums[i][j] = Math.max(nums[i][j], num);
        dfs(nums, i+1, j, num-1);
        dfs(nums, i-1, j, num-1);
        dfs(nums, i, j+1, num-1);
        dfs(nums, i, j-1, num-1);
        dfs(nums,i+1,j-1,num - 1);
        dfs(nums,i+1,j+1,num - 1);
        dfs(nums,i-1,j-1,num - 1);
        dfs(nums,i-1,j+1,num - 1);
        vis[i][j]= false;
    }
}
