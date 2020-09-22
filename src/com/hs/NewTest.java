package com.hs;

/**
 * TODO
 *
 * @author husheng
 * @date 2020/8/2 下午3:10
 * @email husheng3921@gmail.com
 */
public class NewTest {
    /**
     * 
     * @param args
     */
    public static void main(String args[]) {
       /* System.out.println(1<<3|3);
        NewTest newTest = new NewTest();
        newTest.add(5);*/
        /*String s = "祝你考出好成绩! ";
        System.out.println(s.length());*/
        int[] a = {1,2,2,3,4,4,5,5,6};
        System.out.println(solution(a, 7));
    }
    private void add(int a){
        System.out.println(a +2);
    }

    private static int solution(int[] a, int k){
        int res = 0;
        int i = 0, j = a.length - 1;
        while (i < j){
            if (a[i] + a[j] < k){
                i++;
            }else if (a[i] + a[j] > k){
                j--;
            }else{
                res++;
                System.out.println("<"+i+","+j+">"+"----"+"<"+a[i]+","+a[j]+">");
                if(a[i] == a[i+1]){
                    i++;
                }else{
                    j--;
                }
               /* if(a[j] != a[j-1]){
                    j--;
                }else {
                    i++;
                }*/


            }
        }
        return res;
    }
}
