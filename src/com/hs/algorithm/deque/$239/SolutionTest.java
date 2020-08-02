package com.hs.algorithm.deque.$239;

public class SolutionTest {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums ={1,3,-1,5,2,3,1,7};
        System.out.println(solution.maxSlidingWindow(nums, 3));
        int[] res = solution.maxSlidingWindow2(nums, 3);
        for(int i = 0;i<res.length; i++){
            System.out.println(res[i]);
        }
        System.out.println("************************");
        solution.maxSlidingWindow1(nums, 3);
    }
}
