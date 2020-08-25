package com.hs.algorithm.string.$242;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/08/14 15:42
 */
public class Solution {
    public boolean isAnagram(String s, String t){
        int[] numChars = new int[26];
        for (int i = 0; i < s.length(); i++){
            numChars[s.charAt(i) - 'a'] +=1;
        }
        for (int i = 0; i < t.length(); i++){
            numChars[t.charAt(i) - 'a'] -= 1;
        }
        for (int i = 0; i < 26; i++){
            if (numChars[i] != 0){
                return false;
            }
        }
        return true;
    }
}
