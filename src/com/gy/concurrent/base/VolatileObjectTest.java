package com.gy.concurrent.base;

/**
 * @Description: java并发-死循环问题
 * <p>
 * 死循环发生在代码段：
 * while (objectA.isFlag()) {
 * i++;
 * }
 * 这是由于编译器对其进行了优化，因为while循环内部没有修改objectA变量且没有用volatile修饰，JVM会把判断提前，类似于优化成如下：
 * if(objectA.isFlag()){
 * while(true){
 * i++;
 * }
 * }
 * @Author: 郭宇
 * @CreateDate: 2019/3/14 20:19
 */
public class VolatileObjectTest implements Runnable {

    //添加volatile不会死循环
    private ObjectA objectA; // 加上volatile 就可以正常结束While循环了

    public VolatileObjectTest(ObjectA a) {
        this.objectA = a;
    }

    public ObjectA getA() {
        return objectA;
    }

    public void setA(ObjectA a) {
        this.objectA = a;
    }

    @Override
    public void run() {
        long i = 0;
        while (objectA.isFlag()) {
            i++;
            System.out.println(Thread.currentThread().getName() + "线程中，i的值为：" + i);
            if (i == 10) objectA.setFlag(false);
        }
        System.out.println("stop My Thread " + i);
    }

    public void stop() {
        objectA.setFlag(false);
    }

    public static void main(String[] args) throws InterruptedException {
        // 如果启动的时候加上-server 参数则会 输出 Java HotSpot(TM) Server VM
        System.out.println(System.getProperty("java.vm.name"));

        VolatileObjectTest test = new VolatileObjectTest(new ObjectA());
        new Thread(test).start();

        Thread.sleep(3000);
        test.stop();
        System.out.println("Main Thread " + test.getA().isFlag());
    }

    static class ObjectA {
        private boolean flag = true;

        public boolean isFlag() {
            return flag;
        }

        public void setFlag(boolean flag) {
            this.flag = flag;
        }

    }
}