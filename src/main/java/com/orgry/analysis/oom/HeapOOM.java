package com.orgry.analysis.oom;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 堆溢出-java.lang.OutOfMemoryError: Java heap space。
 *
 * @author 葛飞
 */
public class HeapOOM {

    /*
     * VM Options: -Xmx100m
     *  0x01: 堆溢出异常，相信大家很常见。即堆内对象不能进行回收了，堆内存持续增大，这样达到了堆内存的最大值，数据满了，所以就出来了。我们直接放溢出的代码样例。需要设置好idea的VM Options: -Xmx100m，这样设置为最大堆内存，这样运行起来就很快就出来错误了。
     */
    @SneakyThrows
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();

        while (true) {
//            TimeUnit.MILLISECONDS.sleep(1);
            list.add(new OOMObject());
        }
    }

    static class OOMObject {
    }

}
