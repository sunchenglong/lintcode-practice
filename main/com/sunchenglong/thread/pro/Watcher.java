package com.sunchenglong.thread.pro;

/**
 * Created by Administrator on 2016/7/19.
 */
public class Watcher implements Runnable {
    private Movie movie;

    public Watcher(Movie movie) {
        this.movie = movie;
    }

    public void run() {
        for (int i = 0; i < 20; i++) {
            movie.watch();
        }
    }
}
