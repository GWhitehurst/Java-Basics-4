package com.gw.sse;

public class Main {
    static Object ObjectLock1 = new Object();
    static Object ObjectLock2 = new Object();

    private static class Thread1 extends Thread{
        public void run(){
            synchronized(ObjectLock1){
                System.out.println("Thread1: Has ObjectLock1");
                try{
                    Thread.sleep(100);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("Thread1: Waiting for ObjectLock2");
                synchronized(ObjectLock2){
                    System.out.println("Thread1: Deadlock avoided");
                }
            }
        }
    }

    private static class Thread2 extends Thread{
        public void run(){
            synchronized(ObjectLock2){
                System.out.println("Thread2: Has ObjectLock2");
                try{
                    Thread.sleep(100);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("Thread2: Waiting for ObjectLock1");
                synchronized(ObjectLock1){
                    System.out.println("Thread2: Deadlock avoided");
                }
            }
        }
    }


    public static void main(String[] args) {
	    Thread1 thr1 = new Thread1();
        Thread2 thr2 = new Thread2();
        thr1.start();
        thr2.start();
    }
}
