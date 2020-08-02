package com.hs.thread.unsafeThread;

import java.text.SimpleDateFormat;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/16/0016 15:16
 * @email husheng3921@163.com
 */
public class RunTest {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String[] dateStrArray = new String[]{"2000-01-05", "2010-01-02", "2012-02-03","2007-01-05", "2017-01-02", "2018-02-03","2020-01-05", "2012-01-02", "2014-02-03"};
        SimpleDateFormateTest1[] threadArray= new SimpleDateFormateTest1[9];
        for (int i = 0; i < 9; i++){
            threadArray[i] = new SimpleDateFormateTest1(sdf,dateStrArray[i]);
        }
        for (int i = 0; i < 9; i++){
            threadArray[i].start();
        }
    }
}
