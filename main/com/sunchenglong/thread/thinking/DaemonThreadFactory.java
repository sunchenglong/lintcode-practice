package com.sunchenglong.thread.thinking;

import java.util.concurrent.ThreadFactory;

/**
 * Created by Administrator on 2016/7/20.
 */
public class DaemonThreadFactory implements ThreadFactory {
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
}
