package com.hs.rpc.demo.client;

import com.hs.rpc.RpcClient;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/26/0026 11:00
 * @email husheng3921@163.com
 */
public class ClientDemo {
    public static void main(String[] args) throws Exception {
        RpcClient client = new RpcClient();
        CalculatorService service = client.refer(CalculatorService.class, "127.0.0.1",1234);
        int result = service.add(3, 6);
        System.out.println(result);
    }
}
