package com.hs.clone;

import java.util.Arrays;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/4/18/0018 9:08
 * @email husheng3921@163.com
 */
public class CloneExample {
    public static void main(String[] args) throws CloneNotSupportedException {

        People p1 = new People();
        p1.setId(1);
        p1.setName("hh");
        //克隆对象,深拷贝
        People p2 = (People)p1.clone();
        p2.setName("hh2");
        System.out.println(p1.toString());//1,hh
        System.out.println(p2.toString());//1,hh2

        People[] o1 = {p1};
        People[] o2 = Arrays.copyOf(o1,o1.length);
        o1[0].setName("harr");
        System.out.println(o1[0].toString());// 1,harr
        System.out.println(o2[0].toString());// 1,harr
        //浅拷贝与深拷贝对比
        PeopleClone pc1 = new PeopleClone();
        pc1.setId(2);
        pc1.setName("hc1");
        pc1.setAddress(new Address(11,"jl"));
        //拷贝
        PeopleClone pc2 = (PeopleClone)pc1.clone();
        pc2.setName("hc2");
        pc2.getAddress().setName("jz");
        /**
         * 1. Address 未实现 clone id=2, name='hc1', address=Address{id=11, name='jz'
         *                         id=2, name='hc2', address=Address{id=11, name='jz'
         * 2. Address 重写 clone   id=2, name='hc1', address=Address{id=11, name='jl'
         *                          id=2, name='hc2', address=Address{id=11, name='jz'
         */
        System.out.println(pc1.toString());//
        System.out.println(pc2.toString());//
        System.out.println("**********");
        PeopleClone2 pc21 = new PeopleClone2();
        pc21.setId(1);
        pc21.setName("husheng");
        pc21.setAddress(new AddressNoClone(1,"bh"));

        PeopleClone2 pc22 = pc21.clone();
        pc22.setId(2);
        pc22.setName("husheng2");
        pc22.getAddress().setId(2);
        pc22.getAddress().setName("hw");
        System.out.println("浅拷贝"+pc21.toString());
        System.out.println("浅拷贝"+pc22.toString());
        System.out.println("***********");
        PeopleClone2 pc23 = new PeopleClone2(1, "hh", new AddressNoClone(33, "jz"));
        PeopleClone2 pc24 = pc23;
        pc24.setName("hh24");
        pc24.setId(3);
        System.out.println("="+pc23.toString());
        System.out.println("="+pc24.toString());
        //基础类型变量
        PeopleTest pt1 = new PeopleTest(33,0);
        PeopleTest pt2 = pt1.clone();
        pt2.setId(32);
        pt2.setSex(1);
        System.out.println(pt1.toString());
        System.out.println(pt2.toString());

        //

    }

    static class People implements Cloneable{
        private Integer id;
        private String name;

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

        @Override
        protected People clone() throws CloneNotSupportedException {
            return (People) super.clone();
        }

        @Override
        public String toString() {
            return "People{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
    static class PeopleTest implements Cloneable {
        private int id;
        private int sex;

        public PeopleTest(int id, int sex) {
            this.id = id;
            this.sex = sex;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        @Override
        public String toString() {
            return "PeopleTest{" +
                    "id=" + id +
                    ", sex=" + sex +
                    '}';
        }

        @Override
        protected PeopleTest clone() throws CloneNotSupportedException {
            return (PeopleTest)super.clone();
        }

    }
}
