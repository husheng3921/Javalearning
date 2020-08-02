package com.hs.algorithm.dp.greedy.case4;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/5/2/0002 10:23
 * @email husheng3921@163.com
 */
public class ScopeBusi {
    /** 起点 */
    private int start;

    /** 终点 */
    private int end;

    public ScopeBusi(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ScopeBusi{");
        sb.append("start=").append(start);
        sb.append(", end=").append(end);
        sb.append('}');
        return sb.toString();
    }
}
