package com.orgry.analysis.oom;

import java.util.concurrent.TimeUnit;

/**
 * 栈溢出-java.lang.StackOverFlowError。
 *
 * @author 葛飞
 */
public class StackOOM {
    /*
     * 调整帧栈的大小-Xss512k，默认帧栈大小为1M
     * 以上这种情况是帧栈不够用了，如果出现了这种情况，需要了解什么地方创建了很多线程，线上程序需要用jstack命令，将当前线程的状态导出来放到文件里边，然后将文件上传到fastthread.io网站上进行分析。
     * 0x02: 看一下栈溢出的情况，下面的代码就是无限的创建线程，直到没法再创建线程。
     */
    public static void infiniteRun() {
        while (true) {
            Thread thread = new Thread(() -> {
                while (true) {
                    try {
                        TimeUnit.HOURS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        infiniteRun();
    }

}
