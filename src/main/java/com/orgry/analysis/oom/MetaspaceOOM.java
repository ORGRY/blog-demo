package com.orgry.analysis.oom;

import org.mockito.cglib.proxy.Enhancer;
import org.mockito.cglib.proxy.MethodInterceptor;

/**
 * 元信息溢出-java.lang.OutOfMemoryError: Metaspace。
 *
 * @author 葛飞
 */
public class MetaspaceOOM {

    static class OOMObject {
    }

    /**
     * 0x04: 元数据区域溢出，元数据区域也成为方法区，存储着类的相关信息，常量池，方法描述符，字段描述符，运行时产生大量的类就会造成这个区域的溢出。我们运行的时候指定一下元数据区域的大小，设置到idea的VM options里边：-XX:MetaspaceSize=10M -XX:MaxMetaspaceSize=30M
     *
     * 运行的结果如下，元数据信息溢出了。这种情况产生的原因有：通过CBLIG大量生成类，导致Meta信息满了；JDK7的时候使用String.intern()不当，会产生大量常量数据；加载大量的jsp以及动态生成jsp文件。需要调整元数据空间的大小，如果调大了之后还出现了这种异常，我们需要分析哪里出现的溢出并fix掉。
     *
     */
    public static void main(String[] args) {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback((MethodInterceptor) (obj, method, args1, proxy) -> proxy.invokeSuper(obj, args1));
            enhancer.create();
        }
    }

}
