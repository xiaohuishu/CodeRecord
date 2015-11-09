package cn.march.guava.test.io.temp_001;

import java.io.File;
import java.io.FileFilter;

/**
 * 文件过滤器
 *   过滤项目目录下所有非java源文件
 */
public class SourceFileFilter implements FileFilter{
    public boolean accept(File pathname) {
        //System.out.println(pathname.getPath());
        if(pathname.isDirectory())
            return true;
        else if(pathname.getPath().endsWith(".java"))
            return true;
        return false;
    }
}
