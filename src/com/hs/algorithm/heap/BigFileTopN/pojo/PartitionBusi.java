package com.hs.algorithm.heap.BigFileTopN.pojo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * TODO
 * 分区bean
 * @author hushe
 * @date 2020/4/30/0030 19:54
 * @email husheng3921@163.com
 */
public class PartitionBusi {
    /** 当前切分后的文件编号*/
    private int index;
    /** 文件路径*/
    private String path;

    /** 文件流输出对象*/
    private FileWriter outWriter;

    /** 缓冲输出流对象*/
    private BufferedWriter bufferedWriter;

    /** 文件读取*/
    private FileReader fileReader;

    /** 缓冲读取*/
    private BufferedReader bufferedReader;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public FileWriter getOutWriter() {
        return outWriter;
    }

    public void setOutWriter(FileWriter outWriter) {
        this.outWriter = outWriter;
    }

    public BufferedWriter getBufferedWriter() {
        return bufferedWriter;
    }

    public void setBufferedWriter(BufferedWriter bufferedWriter) {
        this.bufferedWriter = bufferedWriter;
    }

    public FileReader getFileReader() {
        return fileReader;
    }

    public void setFileReader(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    public BufferedReader getBufferedReader() {
        return bufferedReader;
    }

    public void setBufferedReader(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }
}
