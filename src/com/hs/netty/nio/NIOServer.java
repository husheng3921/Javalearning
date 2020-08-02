package com.hs.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/17/0017 11:20
 * @email husheng3921@163.com
 */
public class NIOServer {
    public static void startServer() throws IOException{
        //1.获取选择器
        Selector selector = Selector.open();
        //2.获取通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //3.设置非阻塞
        serverSocketChannel.configureBlocking(false);
        //4.绑定连接
        serverSocketChannel.bind(new InetSocketAddress(8181));
        System.out.println("服务启动！");
        //5.将通道注册的接收新连接IO事件 注册到选择器上
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        //6 轮询感兴趣的IO就绪事件
        while (selector.select()>0){
            //7.选择键集合
            Iterator<SelectionKey> selectedKeys = selector.selectedKeys().iterator();

            while (selectedKeys.hasNext()){
                // 8 获取单个选择键，并处理
                SelectionKey selectedKey = selectedKeys.next();
                //9. 判断key是具体的什么事件
                if (selectedKey.isAcceptable()){
                    //10.选择键的IO事件是连接就绪，就获取客户端连接
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    //11.切换为非阻塞模式
                    socketChannel.configureBlocking(false);
                    //12.将该新连接的通道可读事件注册到选择器上
                    socketChannel.register(selector, SelectionKey.OP_READ);
                }else if(selectedKey.isReadable()){
                    //13 若选择键的IO事件是可读事件，读取数据
                    SocketChannel socketChannel = (SocketChannel) selectedKey.channel();
                    //14 读取数据，然后丢弃
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    int length = 0;
                    while ((length = socketChannel.read(byteBuffer)) > 0){
                        byteBuffer.flip();
                        System.out.println(new String(byteBuffer.array(), 0, length));
                        byteBuffer.clear();
                    }
                    //socketChannel.close();
                }
                // 15 移除选择键
                selectedKeys.remove();
            }
        }
        // 16 关闭连接
        serverSocketChannel.close();
    }

    public static void startServer1() throws IOException {

        // 1、获取Selector选择器
        Selector selector = Selector.open();

        // 2、获取通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 3.设置为非阻塞
        serverSocketChannel.configureBlocking(false);
        // 4、绑定连接
        serverSocketChannel.bind(new InetSocketAddress(8181));
        System.out.println("服务器启动成功");

        // 5、将通道注册到选择器上,并注册的IO事件为：“接收新连接”
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        // 6、轮询感兴趣的I/O就绪事件（选择键集合）
        while (selector.select() > 0) {
            // 7、获取选择键集合
            Iterator<SelectionKey> selectedKeys = selector.selectedKeys().iterator();
            while (selectedKeys.hasNext()) {
                // 8、获取单个的选择键，并处理
                SelectionKey selectedKey = selectedKeys.next();

                // 9、判断key是具体的什么事件
                if (selectedKey.isAcceptable()) {
                    // 10、若选择键的IO事件是“连接就绪”事件,就获取客户端连接
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    // 11、切换为非阻塞模式
                    socketChannel.configureBlocking(false);
                    // 12、将该通道注册到selector选择器上
                    socketChannel.register(selector, SelectionKey.OP_READ);
                } else if (selectedKey.isReadable()) {
                    // 13、若选择键的IO事件是“可读”事件,读取数据
                    SocketChannel socketChannel = (SocketChannel) selectedKey.channel();

                    // 14、读取数据
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    int length = 0;
                    while ((length = socketChannel.read(byteBuffer)) >0) {
                        byteBuffer.flip();
                        System.out.println(new String(byteBuffer.array(), 0, length));
                        byteBuffer.clear();
                    }
                    //socketChannel.close();
                }
                // 15、移除选择键
                selectedKeys.remove();
            }
        }

        // 7、关闭连接
        serverSocketChannel.close();
    }
    public static void main(String[] args) throws Exception {
        startServer();
    }
}
