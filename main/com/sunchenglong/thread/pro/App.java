package com.sunchenglong.thread.pro;

/**
 * Created by Administrator on 2016/7/19.
 */
public class App {
    public static void main(String[] args) {
        Movie movie = new Movie();
        Player player = new Player(movie);
        Watcher watcher = new Watcher(movie);
        Thread playerThread = new Thread(player);
        Thread watcherThread = new Thread(watcher);
        playerThread.start();
        watcherThread.start();
    }
}
