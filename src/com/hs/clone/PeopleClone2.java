package com.hs.clone;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/6/30/0030 9:16
 * @email husheng3921@163.com
 */
public class PeopleClone2 implements Cloneable {
    private Integer id;
    private String name;
    private AddressNoClone address;

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

    public AddressNoClone getAddress() {
        return address;
    }

    public void setAddress(AddressNoClone address) {
        this.address = address;
    }

    public PeopleClone2(Integer id, String name, AddressNoClone address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public PeopleClone2() {
    }

    public PeopleClone2 clone() throws CloneNotSupportedException{
        return (PeopleClone2) super.clone();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PeopleClone2{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", address=").append(address);
        sb.append('}');
        return sb.toString();
    }
}
