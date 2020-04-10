package com.dnp.test.io;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.comparator.NameFileComparator;
import org.apache.commons.io.filefilter.FileFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.junit.Test;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/**
 * @author huazai
 * @description I/O实用程序集合
 * @date 2020/4/9
 */
public class IoTest {

    /**
     * description: 测试一下文件比较
     */
    @Test
    public void fileComparator() {
        //get the current directory
        File currentDirectory = new File("g:\\");
        System.out.println("file = " + currentDirectory.isFile());

        NameFileComparator comparator = new NameFileComparator();
        File[] sortedFiles = comparator.sort(currentDirectory.listFiles((FileFilter) FileFileFilter.FILE));

        System.out.println("Sorted By Name: ");
        for (File file : sortedFiles) {
            System.out.println(file.getName());
        }
        File currentDirectory1 = new File("g:\\dnplicense");
        File currentDirectory2 = new File("g:\\用户excel模板.xls");
        LastModifiedFileComparator lastModifiedFileComparator = new LastModifiedFileComparator();
        int xx = lastModifiedFileComparator.compare(currentDirectory1, currentDirectory2);
        System.out.println("xx = " + xx);
    }

    /**
     * description: 测试文件过滤，我参考的地址：https://blog.csdn.net/kjfcpua/article/details/8548137
     */
    @Test
    public void fileFilterTest() {

        File file = new File("G:\\java学习资料\\java学习书籍");
//        String[] files = file.list();
//        for (int i = 0; i < files.length; i++) {
//            System.out.println("i = " + files[i]);
//        }

//        File[] files1 = file.listFiles((FileFilter) FileFileFilter.FILE);
//        for (int i = 0; i < files1.length; i++) {
//            System.out.println("files1 = " + files1[i].getAbsolutePath());
//        }

//        File[] files2 = file.listFiles((FileFilter) FileFilterUtils.directoryFileFilter());
//        for (int i = 0; i < files2.length; i++) {
//            System.out.println("files2 = " + files2[i].getAbsolutePath());
//        }

        File[] files3 = file.listFiles((FileFilter) FileFilterUtils.suffixFileFilter("pdf"));
        for (int i = 0; i < files3.length; i++) {
            System.out.println("files2 = " + files3[i].getAbsolutePath());
        }


    }

    /**
     * description: 测试文件修改监控，注意@junit测试不了线程，参考地址：https://www.cnblogs.com/yanphet/p/5774291.html，
     * 直接用thread.sleep来测试线程
     */
    @Test
    public void fileAlterationMonitorTest() {
        File file = new File("H:\\000");

        FileAlterationMonitor monitor = new FileAlterationMonitor(1000L);// 每隔1000毫秒扫描一次
        FileAlterationObserver observer = new FileAlterationObserver(file, FileFilterUtils.suffixFileFilter("txt"));
        FileListerAdapter listener = new FileListerAdapter();
        observer.addListener(listener);
        monitor.addObserver(observer);

        try {
            monitor.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(TimeUnit.HOURS.toMillis(1));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void fileUtilsTest() throws IOException {
//        File xx = FileUtils.getFile("H:\\000", "ddd.txt");
//        System.out.println("xx = " + xx.exists());
//
//        FileUtils.touch(xx);

//        Iterator<File> fileIter  = FileUtils.iterateFiles(new File("\\\\192.168.0.37\\document\\虚拟移动应用系统\\德宁普\\共享\\2019"), new String[]{"txt", "xml"}, true);
//        while (fileIter.hasNext()) {
//            System.out.println("fileIter = " + fileIter.next().getAbsoluteFile());
//        }

//        boolean contentEqual = FileUtils.contentEquals(new File("H:\\000\\ddd - 副本.txt")
//                , new File("H:\\000\\ddd.txt"));
//        System.out.println("contentEqual = " + contentEqual);


//        File file = FileUtils.toFile(new URL("https://github.com/379924269/my-debug/blob/master/commom/MARKDOWN_LEARNING.md"));
//        System.out.println("file = " + file.getAbsoluteFile());

        boolean contains = FileUtils.directoryContains(new File("G:\\00"), new File("G:\\00\\cas-3.5.2\\.gitignore1"));
        System.out.println("contains = " + contains);
    }

    @Test
    public void ioutilTest() {

    }
}
