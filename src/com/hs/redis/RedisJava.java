package com.hs.redis;

import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/09/07 22:02
 */
public class RedisJava {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1",6379);
        jedis.auth("hs3921");
        System.out.println("连接成功！");
        System.out.println("服务正在运行"+ jedis.ping());
        /*jedis.set("husheng","whu---");
        System.out.println(jedis.get("husheng"));*/
        jedis.lpush("site-list","hhh");
        jedis.lpush("site-list","hhh1");
        jedis.lpush("site-list","hhh2");
        jedis.lpush("site-list","hhh3");
        List<String > list = jedis.lrange("site-list",0,3);
        for (String item : list){
            System.out.println("列表项为"+item);
        }
        jedis.sadd("hu","s12");
        jedis.sadd("hu","s13");
        jedis.sadd("hu","s14");
        jedis.sadd("hu","s15");
        jedis.sadd("hu","s16");
        jedis.srem("hu","s15");
        Set<String> set = jedis.smembers("hu");
        for (String item:set){
            System.out.println(item+"--");
        }
        jedis.zadd("sortSet",1,"5th");
        jedis.zadd("sortSet",2,"4th");
        jedis.zadd("sortSet",3,"3th");
        jedis.zadd("sortSet",4,"2th");
        jedis.zadd("sortSet",5,"1th");
        jedis.zadd("sortSet",6,"0th");
        Set<String> set1 = jedis.zrange("sortSet",2,4);
        for (String item:set1){
            System.out.println(item+"--");
        }
        Set<String> set2 = jedis.zrevrange("sortSet",2,4);
        for (String item:set2){
            System.out.println(item+"--");
        }

    }
}
