package com.hs.clone;

/**
 * TODO
 * 深拷贝，必须实现 Cloneable 接口
 * @author hushe
 * @date 2020/4/18/0018 9:17
 * @email husheng3921@163.com
 */
public class Address implements Cloneable{

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

    public Address(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Address() {
    }

    @Override
    protected Address clone() throws CloneNotSupportedException {
        return (Address) super.clone();
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
