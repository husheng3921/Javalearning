package com.hs.algorithm.tree.$589;

import java.util.List;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/5/4/0004 16:43
 * @email husheng3921@163.com
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node(){}

    public Node(int val){
        this.val = val;
    }

    public Node(int val, List<Node> children){
        this.val = val;
        this.children = children;
    }
}
