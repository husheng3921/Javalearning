package com.hs.algorithm.heap.MergeSmallFile.pojo;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/4/30/0030 21:08
 * @email husheng3921@163.com
 */
public class ByteHeadInfo {
    /** 当前存储的byte值信息 */
    private byte value;

    /** 文件所有的索引信息 */
    private int index;

    public ByteHeadInfo(byte value, int index) {
        this.value = value;
        this.index = index;
    }

    public byte getValue() {
        return value;
    }

    public void setValue(byte value) {
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ByteHeadInfo{");
        sb.append("value=").append(value);
        sb.append(", index=").append(index);
        sb.append('}');
        return sb.toString();
    }
}
