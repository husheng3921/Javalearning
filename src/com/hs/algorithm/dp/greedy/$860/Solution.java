package com.hs.algorithm.dp.greedy.$860;

/**
 * TODO
 * LC860 柠檬水找零 简单
 * @author hushe
 * @date 2020/5/2/0002 18:32
 * @email husheng3921@163.com
 */
public class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0; //标记5 美元，10美元的个数
        for (int bill : bills){
            if (bill == 5){
                five++;
            }else if (bill == 10){
                if (five == 0) return false;//无法找0
                five--;
                ten++;//找零
            }else{
                if (five > 0 && ten > 0){
                    five--;
                    ten--;
                }else if (five >=3){
                    five -= 3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] bills = {5,5,5,10,20};
        Solution solution = new Solution();
        boolean res = solution.lemonadeChange(bills);
        System.out.println(res);
    }
}
