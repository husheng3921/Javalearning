package com.hs.thread.communication.wait;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/16/0016 16:05
 * @email husheng3921@163.com
 */
public class MyList {
    private List list = new ArrayList();
    public void add(){
        list.add("husheng");
    }
    public int size(){
        return list.size();
    }
}
