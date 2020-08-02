package com.hs.netty.udp;

import com.hs.netty.util.Dateutil;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.Scanner;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/17/0017 8:26
 * @email husheng3921@163.com
 */
public class UDPClient {
    public void send() throws Exception{
        //操作一：获取DatagramChannel数据报通道
        DatagramChannel dChannel = DatagramChannel.open();
        dChannel.configureBlocking(false);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        Scanner scanner = new Scanner(System.in);
        System.out.println( "UDP 客户端启动成功！");
        System.out.println( "请输入发送内容:");
        while (scanner.hasNext()) {
            String next = scanner.next();
            buffer.put((Dateutil.getNow() + " >>" + next).getBytes());
            buffer.flip();
            // 操作三：通过DatagramChannel数据报通道发送数据
            dChannel.send(buffer,
                    new InetSocketAddress("125.220.153.16"
                            , 8181));
            buffer.clear();
        }
        //操作四：关闭DatagramChannel数据报通道
        dChannel.close();
    }

    public static void main(String[] args) throws Exception {
        new UDPClient().send();
    }
}
