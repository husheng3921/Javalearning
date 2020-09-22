package com.hs.algorithm.stack.$394;

import java.util.LinkedList;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/09/19 15:53
 */
public class Solution {
    public String decodeString(String s){
        StringBuilder res = new StringBuilder();
        int multi = 0;
        LinkedList<Integer> stackMul = new LinkedList<>();
        LinkedList<String> stackRes = new LinkedList<>();
        for (char c : s.toCharArray()){
            if (c == '['){
                stackMul.addLast(multi);
                stackRes.addLast(res.toString());
                multi = 0;
                res = new StringBuilder();
            }else if(c == ']'){
                StringBuilder tmp = new StringBuilder();
                //获取数字栈
                int curMult = stackMul.removeLast();
                //循环复制
                for (int i = 0; i < curMult; i++){
                    tmp.append(res);
                }
                res = new StringBuilder(stackRes.removeLast() + tmp);
            }else if( c >= '0' && c <= '9'){
                //数字连续，获取
                multi = multi*10 + Integer.parseInt(c + "");
            }else{
                res.append(c);
            }
        }
        return res.toString();
    }
}
