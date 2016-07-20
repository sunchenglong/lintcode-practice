package com.sunchenglong.thread.thinking;

import java.util.concurrent.*;

/**
 * Created by Administrator on 2016/7/20.
 */
public class DaemonThreadPoolExecutor extends ThreadPoolExecutor {
    public DaemonThreadPoolExecutor() {
        super(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), new DaemonThreadFactory());
    }
}
