package com.DesignPattern;

import com.sun.org.apache.regexp.internal.RE;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.List;

public class ComponentDesign {
    public abstract class File {
        String name = "";

        public File(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        /**
         * 统一操作接口
         */
        public abstract void display();

    }

    /**
     * 文件夹类
     */
    public class Folder extends File {

        public Folder(String name) {
            super(name);
        }

        /**
         * 文件夹存储一系列文件
         */
        private List<File> files;

        /**
         * 下面是files集合的操作
         */

        public void addFile(File file) {
            files.add(file);
        }

        public void removeFile(File file) {
            files.remove(file);
        }

        /**
         * 对文件夹的display操作
         */
        @Override
        public void display() {
            System.out.println(files);
        }
    }


    /**
     * 各种文件的实现
     */

    public class ImageFile extends File {

        public ImageFile(String name) {
            super(name);
        }


        @Override
        public void display() {
            System.out.println("display imagefile");
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public class TextFile extends File {
        public TextFile(String name) {
            super(name);
        }

        @Override
        public void display() {
            System.out.println("display textfile");
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public class VideoFile extends File {
        public VideoFile(String name) {
            super(name);
        }

        @Override
        public void display() {
            System.out.println("display videofile");
        }

        @Override
        public String toString() {
            return name;
        }
    }


}
