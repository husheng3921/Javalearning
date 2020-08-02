package com.hs.rpc.demo.server;

import com.hs.rpc.RpcServer;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/26/0026 11:05
 * @email husheng3921@163.com
 */
public class CalculatorServer {
    public static void main(String[] args) throws Exception {
        CalculatorService service = new CalculatorServiceImpl();
        RpcServer server = new RpcServer();
        server.exportPool(service,1234);
    }
}
