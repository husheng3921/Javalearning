package com.hs.thread.unsafeThread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * TODO
 * SimpleDateFormat 不安全，每次使用时创建多个SimpleDateFormat实例
 * @author hushe
 * @date 2020/7/16/0016 15:12
 * @email husheng3921@163.com
 */
public class SimpleDateFormateTest1  extends Thread{
    private SimpleDateFormat sdf;
    private String dateString;

    public SimpleDateFormateTest1(SimpleDateFormat sdf, String dateString) {
        super();
        this.sdf = sdf;
        this.dateString = dateString;
    }

    @Override
    public void run() {
        try{
            Date dateRef = sdf.parse(dateString);
            String newDateStr = sdf.format(dateRef).toString();
            if (!newDateStr.equals(dateString)){
                System.out.println("ThreadName"+ this.getName()+"报错了日期字符串"+dateString+"转换成的日期"+newDateStr);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
