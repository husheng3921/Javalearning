package com.hs.interview;

/**
 * Created by husheng02.
 * 异常
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/09/17 9:31
 */
public class Question5 {
    public static void main(String[] args) {
        try{
            throwNPE();
        }catch ( NullPointerException e){
            System.out.println(e.getMessage());
        }catch (RuntimeException e){

        }
    }

    private static void throwNPE() {
        //RuntimeException, 非checked异常，不需要throws声明
        throw new RuntimeException("Throw");
    }
}
