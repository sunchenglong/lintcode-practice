package com.sunchenglong.thread.pro;

/**
 * Created by Administrator on 2016/7/19.
 */
public class Player implements Runnable {
    private Movie movie;

    public Player(Movie movie) {
        this.movie = movie;
    }

    public void run() {
        for (int i = 0; i < 20; i++) {
            if(i%2 ==0){
                movie.play("左青龙");
            }else{
                movie.play("右白虎");
            }
        }
    }
}
