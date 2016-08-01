package com.sunchenglong.thread.thinking;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/7/30.
 */
public class CloseResource {
    public static void main(String[] args) throws IOException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ServerSocket serverSocket = new ServerSocket(8088);
        InputStream socketInput =
                new Socket("localhost", 8088).getInputStream();
        executorService.execute(new IOBlocked(socketInput));
        executorService.execute(new IOBlocked(System.in));
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("Shutting down all threads");
        executorService.shutdown();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Closing " + socketInput.getClass().getName());
        socketInput.close();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Closing " + System.in.getClass().getName());
        System.in.close();
    }
}
