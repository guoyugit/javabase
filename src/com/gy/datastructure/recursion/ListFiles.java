package com.gy.datastructure.recursion;

import java.io.File;

/**
 * ClassName: ListFiles
 * Description:
 * date: 2019/3/19 15:16
 *
 * @author 郭宇
 * @since JDK 1.8
 */
public class ListFiles {
    private static int count = 0;

    private static void print(int count,String value){
        for(int i= 0;i<count;i++){
            System.out.print("-");
        }
        System.out.println(value);
    }

    public static void listFile(String path,int count) {
        if (path == null) {
            return;// 因为下面的new File如果path为空，回报异常
        }
        File[] files = new File(path).listFiles();
        if (files == null) {
            return;
        }
        for(File file : files) {
            if (file.isFile()) {
                print(++count,file.getName());
            } else if (file.isDirectory()) {
                print(count,file.getName());
                listFile(file.getPath(),++count);//每进入一层需要加深层次
            } else {
                System.out.println("Error");
            }
            count--;
        }
    }

    public static void main(String[] args) {
        listFile("D:\\workutils\\tomcat",count);
    }
}