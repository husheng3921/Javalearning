package com.hs.algorithm.traceback.$17;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/5/7/0007 8:59
 * @email husheng3921@163.com
 */
public class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<>();
        map.put('1',"");
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        List<String> res = new LinkedList<>();
        search("", digits,0,res,map);
        return res;
    }

    /**
     *
     * @param s 当前层次结果
     * @param digits
     * @param i level
     * @param res
     * @param map
     */
    public void search(String s, String digits, int i,List<String> res, Map<Character, String> map){
        //终止条件
        if (i == digits.length()){
            res.add(s);
            return;
        }

        //
        String letters = map.get(digits.charAt(i));
        for (int j = 0; j < letters.length(); j++){
            //drilldown
            search(s + letters.charAt(j), digits, i + 1,res,map);
        }
    }
}
