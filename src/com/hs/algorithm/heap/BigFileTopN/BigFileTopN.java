package com.hs.algorithm.heap.BigFileTopN;

import com.hs.algorithm.heap.BigFileTopN.pojo.KeyBusi;
import com.hs.algorithm.heap.BigFileTopN.pojo.PartitionBusi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/4/30/0030 20:38
 * @email husheng3921@163.com
 */
public class BigFileTopN {
    private static final String SPIT_FLAG =" ";

    public KeyBusi[] topN(String file, int n){
        //提取目录信息
        File cuFile = new File(file);

        //1.将当前一个文件切分成多个文件中，按关键字的hash进行分片操作
        PartitionBusi[] parts = PartitionFile.INSTANCE.getPartition(cuFile.getParent());
        this.fileToPartition(file,parts);
        //关闭所有分片文件
        PartitionFile.INSTANCE.closeOutput(parts);
        //2.针对每个文件求解TopK
        List<KeyBusi[]> topklist = this.countTopN(parts,n);

        //3.针对求得TopK再进行求总的TopN，
        KeyBusi[] topBusi = CountTopN.INSTANCE.getTopN(topklist, n);
        return topBusi;
    }

    public List<KeyBusi[]> countTopN(PartitionBusi[] partis, int n){
        List<KeyBusi[]> list = new ArrayList<>();
        for (int i = 0; i < partis.length; i++){
            PartitionFile.INSTANCE.openReader(partis[i]);
            //进行数据读取
            try{
                String line = null;
                while ((line = partis[i].getBufferedReader().readLine()) !=null){
                   CountTopN.INSTANCE.putData(line);
                }
                //完成一个文件读取进行一次topK的求解
                list.add(CountTopN.INSTANCE.getTopN(n));
                CountTopN.INSTANCE.dataClear();
            }catch (IOException e){
                e.printStackTrace();
            }finally {
                PartitionFile.INSTANCE.closeReader(partis[i]);
            }
        }
        return list;
    }
    public void fileToPartition(String file, PartitionBusi[] partitions){
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        String line = null;
        try{
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null){
                this.lineToPartition(line, partitions);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {

        }
    }

    public void lineToPartition(String line, PartitionBusi[] partitions){
        //分割字符串
        int index = 0;
        int findIndex = 0;
        line = line.trim();

        while (index < line.length()){
            // 切分字符串
            if ((findIndex = line.indexOf(SPIT_FLAG, index)) != -1) {
                String key = line.substring(index, findIndex);

                // 按关键证书进行分片操作
                this.keyToPartition(key, partitions);

                index = findIndex + 1;
            } else {
                String key = line.substring(index);

                // 按关键证书进行分片操作
                this.keyToPartition(key, partitions);

                index += line.length();
            }
        }
    }
    private void keyToPartition(String key, PartitionBusi[] partitions) {
        int partLength = partitions.length;
        // 计算hash值
        int hashCode = 0;//HashCode.getHash(key);
        // 计算得到分片
        int modeVal = hashCode % partLength;
        // 将数据输出到分处文件中
        PartitionFile.INSTANCE.writeData(partitions[modeVal], key);
    }
}
