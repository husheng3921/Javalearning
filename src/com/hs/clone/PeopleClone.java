package com.hs.clone;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/4/18/0018 9:13
 * @email husheng3921@163.com
 */
public class PeopleClone implements Cloneable{

    private Integer id;
    private String name;
    private Address address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PeopleNoClone{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }

    public PeopleClone(Integer id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public PeopleClone() {
    }

    @Override
    protected PeopleClone clone() throws CloneNotSupportedException {
        PeopleClone peopleClone = (PeopleClone) super.clone();
        peopleClone.setAddress(this.address.clone());
        return peopleClone;
    }
}
