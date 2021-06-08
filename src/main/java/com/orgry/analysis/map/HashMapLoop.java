package com.orgry.analysis.map;

import java.util.HashMap;

/**
 * HashMap
 *
 * @author 葛飞
 */
public class HashMapLoop {
    private HashMap<String, String> map = new HashMap();

    public void hashMapLoop() {
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    map.put(Thread.currentThread().getName() + "-" + j, String.valueOf(j));
                }
            }).start();
        }
        System.out.println(map.size());
    }

    public static void main(String[] args) {
        new HashMapLoop().hashMapLoop();
    }
}
