package com.hs.rpc;

import com.hs.rpc.demo.server.CalculatorService;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/26/0026 11:16
 * @email husheng3921@163.com
 */
public class ServerThread implements Runnable{

    private Socket socket = null;
    private Object service;
    public ServerThread(Socket s, Object service){
        this.socket = s;
        this.service = service;
    }
    @Override
    public void run() {
        try{
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            //Thread.sleep(2000);
            try{
                String methodName = input.readUTF();
                Class<?>[] parameterTypes = (Class<?>[]) input.readObject();
                Object[] arguments = (Object[]) input.readObject();
                Method method = service.getClass().getMethod(methodName, parameterTypes);
                Object result = method.invoke(service, arguments);
                output.writeObject(result);
            }catch (Throwable t){
                output.writeObject(t);
            }finally {
                output.close();
                input.close();
                socket.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
