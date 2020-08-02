package com.hs.algorithm.binary.$410;

/** hard
 * LeetCode410 https://leetcode-cn.com/problems/split-array-largest-sum/submissions/
 * 给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。
 * 设计一个算法使得这 m 个子数组各自和的最大值最小。
 * 思想：既然是子数组和sum，肯定小于等于整个数组和SUM；我们可以发现m越大，sum越小，也就是
 * m个桶分装子数组，拆的越散，显然子和越小。现在我们从探索最小值出发，
 */
public class LC410 {

    /**
     * 判断目前的最小值和m是否搭配。相当于我们给定了子和的最大值，判断m
     * 个桶是否能满足
     * @param mid
     * @param nums
     * @param m
     * @return
     */
    public static boolean guess(long mid, int[] nums, int m){
        long sum = 0;
        long mm = 1;//箱子个数,初始值最少一个桶，既一个子数组本身 目标值m
        for(int i = 0; i < nums.length; i++){
            if(sum + nums[i] > mid){
                mm++;//如果大于最小值，则不能加进去，加到另一个箱子
                //sum = 0; //此时初始化sum,将该值加入这个箱子，sum从该元素开始计算
                // sum += nums[i];
                sum = nums[i];//
                if(nums[i] > mid){
                    return false;//大于最小值直接舍弃
                }
            }else{
                sum += nums[i];
            }
        }
        return mm <= m;
    }

    /**
     * 拆分数组求子和,满足拆分条件的子和最大值开始试探，二分法找到最小的那个子和
     * @param nums
     * @param m
     * @return
     */
    public static int splitArray(int[] nums, int m) {
        int n = nums.length;
        long R = 0;// 非负整数数组，和肯定大于0，
        //求出最大和SUM，[1,R)
        for(int i = 0; i < n; i++) {
            R += nums[i];
        }
        long L = 0;
        long ans = R;//初始和等于数组整和
        while(L <= R){
            long mid = (L + R)>>1;//(L+R)/2
            if(guess(mid, nums, m)){
                ans = mid;
                // L = mid + 1;
                R = mid - 1;
            }else{
                L = mid + 1;
                // R = mid;
            }
        }
        return (int) ans;
    }

    public static void main(String[] args) {
            int nums[]={7, 2, 5, 10, 8};
            int result = splitArray(nums, 2);
            System.out.println(result);
        System.out.println(splitArray2(nums, 2));
    }

    /**
     * 动态规划解，找出状态方程
     *
     * @param nums
     * @param m
     * @return
     */
    public static int splitArray2(int[] nums, int m){
        int n = nums.length;
        int[][] f = new int[n+1][m+1];
        int[] sub = new int[n+1];//数组子和
        //初始化子数组和的最大值
        for(int i = 0; i <= n; i++) {
            for( int j = 0; j <=m; j++) {
                f[i][j] = Integer.MAX_VALUE;
            }
        }

        //计算第1个到第x=(i+1)个数组的和
        for(int i = 0; i < n; i++){
            sub[i+1]=sub[i] + nums[i];
        }
        f[0][0] = 0;
        for(int i  = 1; i <= n; i++){
            for(int j = 1; j <=m; j++){
                for(int k = 0; k<i; k++){
                    f[i][j] = Math.min(f[i][j], Math.max(f[k][j-1], sub[i] - sub[k]));
                }
            }
        }
        return f[n][m];
    }

    /**
     * LeetCode解答 二分法精髓：x -f(x)单调性，正相关或负相关
     * 这里的ans值与m呈现负相关，m越大，ans越小
     * @param nums
     * @param m
     * @return
     */
    public int splitArrayLC(int[] nums, int m) {
        long l = 0;
        long r = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            r += nums[i];//右边界整个数组和
            if (l < nums[i]) {
                l = nums[i];//左边界是数组中最小的元素
            }
        }
        long ans = r;
        //子数组和最大值在l<=r区间，我们用二分法找
        while (l <= r) {
            long mid = (l + r) >> 1;
            long sum = 0;
            int cnt = 1;//统计分组个数，至少为一个
            for (int i = 0; i < n; i++) {
                if (sum + nums[i] > mid) {
                    cnt ++;
                    sum = nums[i];
                } else {
                    sum += nums[i];
                }
            }
            //分组完，个数cnt<=m则暂存mid，同时比较ans，保留最小值，继续缩小r右边界
            if (cnt <= m) {
                ans = Math.min(ans, mid);
                r = mid - 1;
            } else {//不满足说明，实际m过大，mid过小，我们则扩大左边界
                l = mid + 1;
            }
        }
        return (int)ans;
    }

}
