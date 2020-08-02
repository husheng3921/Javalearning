package com.hs.algorithm.heap.BigFileTopN;

import com.hs.algorithm.heap.BigFileTopN.pojo.PartitionBusi;

import java.io.*;

/**
 * TODO
 * 进行分区操作
 * @author hushe
 * @date 2020/4/30/0030 19:59
 * @email husheng3921@163.com
 */
public class PartitionFile {
    public static final PartitionFile INSTANCE = new PartitionFile();
    /** 分割成64文件*/
    private static final int MAX_PARTITION_SIZE = 64;
    /** 分区的文件夹名称**/
    private static final String PARTITION_DIR_NAME = "partition";

    /** 中间临时分割文件**/
    private static final String SUFFIX_NAME = ".buffer";

    public PartitionBusi[] getPartition(String basePath) {
        PartitionBusi[] result = new PartitionBusi[MAX_PARTITION_SIZE];

        File baseFiel = new File(basePath + File.separator + PARTITION_DIR_NAME);

        if (baseFiel.exists()){
            File[] rsp = baseFiel.listFiles();
            for (File fins : rsp){
                fins.exists();
            }
            System.out.println("删除结果"+rsp);
        }
        baseFiel.mkdir();

        for (int i = 0; i < MAX_PARTITION_SIZE; i++){
            result[i] = new PartitionBusi();
            result[i].setIndex(i);
            String path = baseFiel.getPath() + File.separator + i+SUFFIX_NAME;
            result[i].setPath(path);
            try {
                result[i].setOutWriter(new FileWriter(path));
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        return result;
    }

    /**
     *
     * @param busi
     * @param data
     */
    public void writeData(PartitionBusi busi, String data) {
        try{
            busi.getBufferedWriter().write(data);
            busi.getBufferedWriter().newLine();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     *
     * @param partitionBusis
     */
    public void closeOutput(PartitionBusi[] partitionBusis){
        for (int i = 0; i < partitionBusis.length; i++){
            //关闭输出
        }
    }

    /**
     * 进行文件读取操作
     * @param file
     */
    public void openReader(PartitionBusi file){
        try{
            file.setFileReader(new FileReader(file.getPath()));
            file.setBufferedReader(new BufferedReader(file.getFileReader()));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void closeReader(PartitionBusi file){
        //关闭流
    }
}
