package com.sunchenglong.net;

import java.net.*;

/**
 * Created by Administrator on 2016/7/21.
 */
public class InetDemo01 {
    public static void main(String[] args) throws UnknownHostException, MalformedURLException {
        InetAddress addr;
        addr = InetAddress.getLocalHost();
        System.out.println(addr);
        System.out.println(InetAddress.getByName("127.0.0.1").getHostName());
        System.out.println(InetAddress.getByName("localhost").getHostName());
        System.out.println(new InetSocketAddress("localhost",9999).getPort());
        URL url = new URL("http://www.baidu.com");
        System.out.println(url.getProtocol());
    }
}
