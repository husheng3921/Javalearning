package com.hs.algorithm.bit.APowB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by husheng02.
 * https://mp.weixin.qq.com/s/TdvRLCr6bzGT_k0D8Fv4Sg
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/11/19 20:32
 * a^b
 */
public class Solution {
    public int pow(int a, int b) {
        int base = a, ans = 1;
        while (b != 0) {
            //b为奇数时，先乘以一个base，右移后，必出现1，ans*base返回结果
            if((b & 1) == 1) {
                ans *= base;
            }
            base *= base;
            b >>= 1;
        }
        return ans;
    }

    /**
     * 任意 a,b属于N,b!=0,gcd(a,b)=gcd(b,a % b);b=0,gcd(a,b) = a ;欧里几德算法
     * 最大公约数gcd(a, b),当a,b互质，gcd(a, b)=1
     * @param a
     * @param b
     * @return
     */
    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(a, a % b);
    }

    private static int[] vis ;
    private static List<Integer> primes = new ArrayList<>();

    /**
     * 质数筛选
     * (1)将2-N中所有数标记0
     * (2)从质数2开始遍历，2-N的所有自然数
     * (3)如果遍历到一个标记位0的数x,则将其2—N中X的所有倍数标记为1
     * @param n
     * @return
     */
    public static void getPrimes(int n) {
        vis = new int[n + 1];
        Arrays.fill(vis, 0);
        for (int i = 2; i <= n; i++){
            if (vis[i] == 0){
                primes.add(i);
                for (int j = i; j <= n; j +=i){
                    vis[j] = 1;
                }
            }
        }
    }

    public static void divide(int n) {
        List<Integer> p = new ArrayList<>();
        List<Integer> c = new ArrayList<>();
        for(int i = 2; i * i <= n; i++) {
            if(n % i == 0) {
                p.add(i);
                int num = 0;
                while (n % i == 0){
                    num++;
                    n /= i;
                }
                c.add(num);
            }
        }
        if(n > 1) {
            p.add(n);
            c.add(1);
        }
        System.out.println(p.toString());
        System.out.println(c.toString());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.pow(2, 14));
        System.out.println(solution.gcd(5, 15));
        getPrimes(9);
        System.out.println(primes.toString());
        divide(80);
    }
}
