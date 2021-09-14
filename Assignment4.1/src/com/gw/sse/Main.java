package com.gw.sse;

class Singleton{
    private volatile static Singleton instance;

    private Singleton(){

    }

    public static Singleton getInstance(){
        synchronized(Singleton.class){
            if(instance == null)
                instance = new Singleton();
            return instance;
        }
    }
}

public class Main {

    public static void main(String[] args) {

    }
}
