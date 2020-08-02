package com.hs.clone;

import java.io.*;

/**
 * TODO
 * 通过字节流实现深拷贝
 * @author hushe
 * @date 2020/4/18/0018 9:34
 * @email husheng3921@163.com
 */
public class ByteClone {

    public static void main(String[] args) {
        //创建对象
        Address address = new Address(110,"bj");
        People p1 = new People(1,"Java",address);
        //通过字节流拷贝
        People p2 = (People) StreamClone.clone(p1);
        //修改原型对象
        p1.getAddress().setCity("jl");
        //输出p1,p2
        System.out.println("p1:"+p1.getAddress().getCity()+"p2:"+p2.getAddress().getCity());
    }
    static class StreamClone {
        public static <T extends Serializable> T clone(People obj){
            T cloneObj = null;
            try {
                //写入字节流
                ByteArrayOutputStream bo = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(bo);
                oos.writeObject(obj);
                oos.close();
                //分配内存，写入原始对象，生成新对象
                ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
                ObjectInputStream oi= new ObjectInputStream(bi);
                //返回生成的新对象
                cloneObj = (T) oi.readObject();
                oi.close();
            }catch (Exception e){
                e.printStackTrace();
            }
            return cloneObj;
        }
    }
    static class People implements Serializable{
        private Integer id;
        private String name;
        private Address address;

        public People(Integer id, String name, Address address) {
            this.id = id;
            this.name = name;
            this.address = address;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Address getAddress() {
            return address;
        }

        public void setAddress(Address address) {
            this.address = address;
        }
    }
    static class Address implements Serializable{
        private Integer id;
        private String city;

        public Address(Integer id, String city) {
            this.id = id;
            this.city = city;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }
    }
}
