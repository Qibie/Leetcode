package com.leetcode.zbf;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class RenameFile {
    public static final String FILE_INPUT_PATH = "G:\\入党材料\\入党材料电子版";
    public static final String FILE_OUTPUT_PATH = "G:\\入党材料\\张炳斐_入党材料_电子版";

    public static void main(String[] args) {
        File file_source = new File(FILE_INPUT_PATH);
        File[] files = file_source.listFiles();
        for (int i = 0; i < files.length; ++i) {
            String filename = files[i].getName();
            System.out.println(filename.substring(8, filename.length()));
            files[i].renameTo(new File(FILE_OUTPUT_PATH + "\\" + filename.substring(8, filename.length())));
        }
    }
}
