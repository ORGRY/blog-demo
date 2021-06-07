package com.orgry.analysis.oom;

/**
 * 栈溢出-java.lang.StackOverFlowError
 *
 * @author 葛飞
 */
public class StackOFE {

    /**
     * -Xss2m
     * 0x03：看一下栈溢出的另一种情况，这就是栈的StackOverFlow的情况。下面就是一个死循环递归调用。
     * 运行之后出现的错误如下，程序每次递归的时候，程序会把数据结果压入栈，包括里边的指针等，这个时候就需要帧栈大一些才能承受住更多的递归调用。通过-Xss进行设置，上边的例子需要设置小一些，以分配更多的帧栈，这次是一个帧栈需要记录程序数据，所以需要更大的值。
     */
    public static void stackOverFlowErrorMethod() {
        stackOverFlowErrorMethod();
    }

    public static void main(String[] args) {
        stackOverFlowErrorMethod();
    }

}
