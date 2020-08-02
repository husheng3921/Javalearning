package com.hs.rpc;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/26/0026 10:49
 * @email husheng3921@163.com
 */
public class RpcServer {
    public void export(Object service, int port) throws Exception{
        if (service == null){
            throw new IllegalArgumentException("service instance == null");
        }
        if (port <=0 || port >= 65535){
            throw new IllegalArgumentException("Invalid port"+ port);
        }
        ServerSocket server = new ServerSocket(port);
        while (true){
            final Socket socket= server.accept();
           new Thread(new ServerThread(socket,service)).start();
        }
    }

    /**
     * 线程池
     * @param service
     * @param port
     * @throws Exception
     */
    public void exportPool(Object service, int port) throws Exception{
        if (service == null){
            throw new IllegalArgumentException("service instance == null");
        }
        if (port <=0 || port >= 65535){
            throw new IllegalArgumentException("Invalid port"+ port);
        }
        ServerSocket server = new ServerSocket(port);
        ExecutorService executorService = Executors.newCachedThreadPool();
        while (true){
            final Socket socket= server.accept();
            executorService.execute(new ServerThread(socket, service));
        }
    }
}
