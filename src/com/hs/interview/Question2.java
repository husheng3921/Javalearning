package com.hs.interview;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/09/17 9:14
 */
public class Question2 {
    public static void main(String[] args) {

        tryWithResource();
    }

    private static void tryWithResource() {
        try(FileInputStream inputStream = new FileInputStream("/temp")){

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
