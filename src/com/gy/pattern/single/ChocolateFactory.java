package com.gy.pattern.single;

/**
 * ClassName: ChocolateFactory
 * Description:
 * 1.添加volatile保证实例改变后，所有线程能够获取该实例的最新状态。
 * 2.同步代码块中加入null实例判断原因：如果两个线程共同进入单实例的创建过程中，都进入了同步代码阶段，
 *  只会有一个线程进行后面的创建操作，当实例化实例后，另一个线程进入时，再做一次判断发现，已经创建则不会进行再次创建的过程：
 * date: 2019/3/10 22:50
 * @author 郭宇
 * @since JDK 1.8
 */
public class ChocolateFactory {
    public volatile static ChocolateFactory uniqueInstance = null;

    public static ChocolateFactory getInstance() {

        if (uniqueInstance == null) {
            synchronized (ChocolateFactory.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new ChocolateFactory();
                }
            }
        }
        return uniqueInstance;
    }
}
