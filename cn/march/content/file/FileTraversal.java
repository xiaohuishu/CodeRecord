package cn.march.guava.test.io.temp_001;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

/**
 * 查找项目目录下所有的源文件
 */
public class FileTraversal {

    //存储结构
    private static Set<File> sourceFiles = null;

    static {
        sourceFiles = new HashSet<File>();
    }

    public static void traversqlFile(File projectFile) {

        File[] files = projectFile.listFiles(new SourceFileFilter());
        for(File file : files) {
            if(file.isDirectory())
                traversqlFile(file);
            else if(file.isFile())
                sourceFiles.add(file);
        }
    }

    public static Set<File> getSourceFiles() {
        return sourceFiles;
    }
}
