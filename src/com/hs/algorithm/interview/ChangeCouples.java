package com.hs.algorithm.interview;

import java.util.Arrays;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/4/29/0029 9:46
 * @email husheng3921@163.com
 */
public class ChangeCouples {
    public static void main(String[] args){
        int[] arr={3,2,0,1};
       // int count = changedemo(arr,0,0);
        int count = (new ChangeCouples()).minSwapsCouples(arr);
        System.out.println(count);
        int[] nums = {1,2,2,4,2,3};
        int nm = (new ChangeCouples()).minMoves2(nums,3);
        System.out.println(nm);
    }
    public static int changedemo(int[] arr,int a,int num){
        if(a>=arr.length){
            return num;
        }
        if(arr[a]%2==0){     //第一位为新郎情况	
            int y=a+1;
            if(arr[a]+1==arr[y]){//新郎的隔壁为其新娘，符合
                a=a+2;               //跳过新娘，继续循环
                num=changedemo(arr,a,num);//继续
            }else{
                while(arr[a]+1!=arr[y]){  //如果新郎的隔壁不是其新娘，不符合，遍历剩下的人，直到找到为止
                    y++;
                }
                //show(arr[a+1],arr[y]);//显示交换
                changetemp(a+1,y,arr);    //交换函数
                a=a+2;					//跳过新娘，继续循环
                num++;           //交换次数加1
                num=changedemo(arr,a,num);
            }
        }
        else{
            int y=a+1;
            if(arr[a]-1==arr[y]){//新娘的隔壁为其新郎，符合
                a=a+2;               //跳过新郎，继续循环
                num=changedemo(arr,a,num);//继续
            }else{
                while(arr[a]-1!=arr[y]){  //如果新娘的隔壁不是其新郎，不符合，遍历剩下的人，直到找到为止
                    y++;
                }
                //show(arr[a+1],arr[y]);//显示交换
                changetemp(a+1,y,arr);            //找到新娘对应的新郎，交换位置
                a=a+2;						//跳过新娘，继续循环
                num++;            //交换次数加1
                num =changedemo(arr,a,num);
            }
        }
        return num;
    }
    public static void show(int a,int b){
        System.out.println(a+"<------------->"+b);
    }
    public static void changetemp(int a,int b,int[] arr){
        int temp=0;//中间值，作为交换
        temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;              //找到新郎对应的新娘，交换位置
    }
    public int minSwapsCouples(int[] row) {
        int ans = 0;
        for (int i = 0; i < row.length; i += 2) {
            int x = row[i];
            if (row[i+1] == (x ^ 1)) continue;
            ans++;
            for (int j = i+1; j < row.length; ++j) {
                if (row[j] == (x^1)) {
                    row[j] = row[i+1];
                    row[i+1] = x^1;
                    break;
                }
            }
        }
        return ans;
    }
    public int minMoves2(int[] nums,int k) {
        Arrays.sort(nums);
        int sum = 0;
        int i = 0, j= nums.length - 1;
        int m = 1;
        while (i < j ){
            sum  += nums[j--] - nums[i++];
        }
        return sum;
    }

}
