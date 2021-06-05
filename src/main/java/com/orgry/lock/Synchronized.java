package com.orgry.lock;

/**
 * synchronized关键字
 *
 * @author orgry
 */
public class Synchronized {

    public synchronized static void methodStatic() {
        System.out.println("methodStatic 1 start");
    }

    public synchronized void methodObject() {
        System.out.println("methodObject start");
    }

    public void methodCode() {
        synchronized (this) {
            System.out.println("methodCode start");
        }
    }

}
