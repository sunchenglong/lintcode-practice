package com.sunchenglong.javalearn;

import java.io.File;
import java.lang.management.ClassLoadingMXBean;
import java.lang.management.ManagementFactory;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chenglong Sun on 2016/10/27.
 */
public class GCtest {
    public static final int _1MB = 1024 * 1024;

    /**
     * -verbose:gc  -Xms20m -Xmx20m -XX:PermSize=10M -XX:MaxPermSize=10M
     */
    public static void testOOM() {
        List<GCtest> list = new ArrayList<>();
        while (true) {
            list.add(new GCtest());
        }
    }

    public static void testRuntimeOOM() {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }

    public static void testIntern() {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }

    /**
     * -verbose:gc  -Xms20m -Xmx20m -Xmn10m -XX:+PrintGCDetails -XX:SurvivorRatio=8
     */
    public static void testAllocation() {
        byte[] a1, a2, a3, a4;
        a1 = new byte[2 * _1MB];
        a1 = new byte[2 * _1MB];
        a2 = new byte[2 * _1MB];
        a3 = new byte[2 * _1MB];
        a3 = new byte[2 * _1MB];
        a3 = new byte[2 * _1MB];
        a3 = new byte[2 * _1MB];
        a4 = new byte[4 * _1MB];
        a4 = new byte[4 * _1MB];
    }

    /**
     * -verbose:gc  -Xms20m -Xmx20m -XX:PermSize=10M -XX:MaxPermSize=10M -XX:+PrintGCDetails
     */
    public static void testPretenureSizeThreshold() {
        byte[] allocation;
        allocation = new byte[4 * _1MB];
    }

    /**
     *-verbose:gc  -Xms20m -Xmx20m -XX:MaxMetaspaceSize=10M -XX:+PrintGCDetails
     */
    public static void testMetaSpaceOOM() {

        try {
            //准备url
            URL url = new File("D:\\workspace\\lintcode-practice\\target\\classes\\com\\sunchenglong\\javalearn").toURI().toURL();
            URL[] urls = {url};
            //获取有关类型加载的JMX接口
            ClassLoadingMXBean loadingBean = ManagementFactory.getClassLoadingMXBean();
            //用于缓存类加载器
            List<ClassLoader> classLoaders = new ArrayList<ClassLoader>();
            while (true) {
                //加载类型并缓存类加载器实例
                ClassLoader classLoader = new URLClassLoader(urls);
                classLoaders.add(classLoader);
                classLoader.loadClass("ClassTest");
                //显示数量信息（共加载过的类型数目，当前还有效的类型数目，已经被卸载的类型数目）
                System.out.println("total: " + loadingBean.getTotalLoadedClassCount());
                System.out.println("active: " + loadingBean.getLoadedClassCount());
                System.out.println("unloaded: " + loadingBean.getUnloadedClassCount());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        testAllocation();
    }
}
