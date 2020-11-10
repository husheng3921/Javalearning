package com.hs;

import java.util.Scanner;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/09/13 18:51
 */
public class MainTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int j = 0; j < T; j++){
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            int countJ = 0;
            for (int i = 1; i <= N; i++){
                if((i & 1) == 0){
                    countJ++;
                }
            }
            int countJ2 = 0;
            for (int k = 1; k <= M; k++){
                if((k & 1) == 0){
                    countJ2++;
                }
            }
            int b = M*N;
            int a = b - (countJ*countJ2+ (N-countJ)*(M-countJ2));
            System.out.println(a/gcd(a,b) +"/"+b/gcd(a,b));
        }

    }

    private static int gcd(int x, int y){
        if(y == 0){
            return x;
        }else{
            return gcd(y, x % y);
        }
    }
}
