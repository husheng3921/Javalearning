package com.hs.algorithm.unifind.$547;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/09/13 22:32
 */
public class Solution {
    public int findCircleNum(int[][] M) {
        int n = M.length;
        int m = M[0].length;
        UnionFind unionFind = new UnionFind(n);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(M[i][j] == 1){
                    unionFind.union(i, j);
                }

            }
        }
        return unionFind.getCount();
    }
    class UnionFind{
        int count;
        int[] parent;

        public UnionFind(int n){
            this.count = n;
            parent = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
            }
        }
        public int find(int p){
            while(p != parent[p]){
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }
        public void union(int p, int q){
            int rootP = find(p);
            int rootQ = find(q);
            if(rootP ==  rootQ){
                return;
            }
            parent[rootP] = rootQ;
            count--;
        }
        public int getCount(){
            return count;
        }
    }
}
