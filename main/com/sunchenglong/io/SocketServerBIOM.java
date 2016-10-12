package com.sunchenglong.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Chenglong Sun on 2016/10/12.
 */
public class SocketServerBIOM {
    public static void main(String[] args) throws IOException {
        int port = 7000;
        ExecutorService executorService = Executors.newCachedThreadPool();
        int id = 1;
        ServerSocket serverSocket = new ServerSocket(port);
        while (true) {
            try {
                //serverSocket是阻塞式方法
                Socket socket = serverSocket.accept();
                executorService.execute(new SingleServer(id++, socket));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

class SingleServer implements Runnable {

    private int id;
    private Socket socket;

    SingleServer(int id, Socket socket) {
        this.id = id;
        this.socket = socket;
    }

    @Override
    public void run() {
        boolean flag = true;
        try {
            System.out.println("与客户端开始通信 id: " + String.valueOf(id));
            DataInputStream dataInputStream = new DataInputStream(
                    new BufferedInputStream(socket.getInputStream()));
            DataOutputStream dataOutputStream = new DataOutputStream(
                    new BufferedOutputStream(socket.getOutputStream()));
            do {
                double result = dataInputStream.readDouble();
                result *= result;
                Thread.sleep(5000);
                dataOutputStream.writeDouble(result);
                dataOutputStream.flush();
                while (true) {
                    char judge = dataInputStream.readChar();
                    if (judge == 'Y' || judge == 'y') {
                        flag = true;
                        break;
                    } else if (judge == 'N' || judge == 'n') {
                        flag = false;
                        break;
                    }
                }
            } while (flag);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("与客户端通信结束：" + String.valueOf(id));
        }
    }
}
