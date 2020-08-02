package com.hs.clone;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/6/30/0030 9:07
 * @email husheng3921@163.com
 */
public class AddressNoClone {
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

    public AddressNoClone(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public AddressNoClone() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AddressNoClone{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
