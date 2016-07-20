package com.sunchenglong.thread.thinking;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/7/20.
 */
public class ThreadVariations {
    public static void main(String[] args) {
        new InnerThread1("Inner Thread 1");
        new InnerThread2("Inner Thread 2");
        new InnerRunnable1("Inner Runnable 1");
        new InnerRunnable2("Inner Runnable 2");
        new ThreadMethod("Thread Method1").runTask();
        new ThreadMethod("Thread Method2").runTask();
    }
}

class InnerThread1 {
    private int countDown = 5;
    private Inner inner;

    private class Inner extends Thread {
        Inner(String name) {
            super(name);
            start();
        }

        public void run() {
            try {
                while (true) {
                    System.out.println(this);
                    if (--countDown == 0) return;
                    sleep(10);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public String toString() {
            return getName() + ":" + countDown;
        }
    }

    public InnerThread1(String name) {
        inner = new Inner(name);
    }
}


class InnerThread2 {
    private int countDown = 5;
    private Thread thread;

    public InnerThread2(final String name) {
        thread = new Thread(name) {
            public void run() {
                try {
                    while (true) {
                        System.out.println(this);
                        if (--countDown == 0) return;
                        sleep(10);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            public String toString() {
                return getName() + ":" + countDown;
            }
        };
        thread.start();
    }
}


class InnerRunnable1 {
    private int countDown = 5;
    private Inner inner;

    private class Inner implements Runnable {
        Thread thread;

        Inner(String name) {
            thread = new Thread(this, name);
            thread.start();
        }

        public void run() {
            try {
                while (true) {
                    System.out.println(this);
                    if (--countDown == 0) return;
                    TimeUnit.MILLISECONDS.sleep(10);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public String toString() {
            return thread.getName() + ":" + countDown;
        }
    }

    public InnerRunnable1(String name) {
        inner = new Inner(name);
    }
}

class InnerRunnable2 {
    private int countDown = 5;
    Thread thread;

    public InnerRunnable2(String name) {
        thread = new Thread(new Runnable() {
            public void run() {
                try {
                    while (true) {
                        System.out.println(this);
                        if (--countDown == 0) return;
                        TimeUnit.MILLISECONDS.sleep(10);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            public String toString() {
                return Thread.currentThread().getName() + ":" + countDown;
            }
        }, name);
        thread.start();
    }
}

class ThreadMethod {
    private int countDown = 5;
    private Thread thread;
    private String name;

    public ThreadMethod(String name) {
        this.name = name;
    }
    public void runTask() {
        if(thread == null) {
            thread = new Thread(name) {
                public void run() {
                    try{
                        while (true) {
                            System.out.println(this);
                            if(--countDown == 0) return;
                            sleep(10);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                public String toString() {
                    return getName() + ":" + countDown;
                }
            };
        }
        thread.start();
    }
}