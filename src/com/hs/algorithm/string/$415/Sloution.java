package com.hs.algorithm.string.$415;

/**
 * TODO
 * 简单
 * @author hushe
 * @date 2020/7/18/0018 21:14
 * @email husheng3921@163.com
 */
public class Sloution {
    public String addString(String num1, String num2){
        StringBuilder res = new StringBuilder("");
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        while (i >= 0 || j >= 0){
            int n1 = i >= 0 ? num1.charAt(i)-'0' :0;
            int n2 = j >= 0 ? num2.charAt(j)-'0':0;
            int temp = n1 + n2 + carry;
            carry = temp / 10;
            res.append(temp % 10);
            i--;
            j--;
        }
        //最后进位
        if (carry == 1){
            res.append(1);
        }
        return res.reverse().toString();
    }
}
