package com.hs.algorithm.heap.MergeSmallFile;

import com.hs.algorithm.heap.MergeSmallFile.pojo.FileMergeBusi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/4/30/0030 21:07
 * @email husheng3921@163.com
 */
public class FileMergeProc {
    /** 实例信息 */
    public static final FileMergeProc INSTANCE = new FileMergeProc();

    /** 缓冲区的大小 */
    private static final int MAX_BUFF_SIZE = 10;

    /**
     * 打开文件
     *
     * @param path 路径信息
     * @return 返回
     */
    public FileMergeBusi openFile(File path) {
        FileMergeBusi margeBean = new FileMergeBusi();

        if (path.exists()) {
            try {
                margeBean.setInput(new FileInputStream(path));
                margeBean.setReadPath(path.getPath());
                margeBean.setBuffer(new byte[MAX_BUFF_SIZE]);
                margeBean.setFileReadIndex(0);
                margeBean.setBufferReadIndex(0);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        return margeBean;
    }

    /**
     * 读取文件中的byte字节信息
     *
     * @param bean
     */
    public void readFile(FileMergeBusi bean) {
        if (!bean.isFinish()) {
            try {
                int readLength = bean.getInput().read(bean.getBuffer());
                bean.setFileReadIndex(readLength);
                bean.setBufferReadIndex(0);

                if (readLength == -1) {
                    bean.setFinish(true);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void close(FileMergeBusi[] bean) {
        for (int i = 0; i < bean.length; i++) {
            if (null != bean[i]) {
                try {
                    bean[i].getInput().close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
