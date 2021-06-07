package com.orgry.analysis.map;

import java.util.HashMap;
import java.util.UUID;

/**
 * HashMap
 *
 * @author 葛飞
 */
public class HashMapLoop {


    private HashMap map = new HashMap();

    public void infiniteRun() {
        for (int i = 1; i <= 30; i++) {
            Thread thread = new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 8));
                System.out.println(map.size());
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        new HashMapLoop().infiniteRun();
    }
}
