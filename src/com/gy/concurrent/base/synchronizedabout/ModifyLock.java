package com.gy.concurrent.base.synchronizedabout;
/**
 * @Description: 锁对象的属性发生改变时，不影响锁对于代码的锁定：
 * @Author:         郭宇
 * @CreateDate:     2019/3/14 20:37
 */
public class ModifyLock {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void changeAttribute(String name, int age) {
        synchronized (this) {
            try {
                System.out.println("当前线程：" + Thread.currentThread().getName() + "开始");
                this.setName(name);
                this.setAge(age);
                System.out.println(
                        "当前线程：" + Thread.currentThread().getName() + " 修改对象内容为： " + this.getName() + ", " + this.getAge());
                Thread.sleep(5000);
                System.out.println("当前线程：" + Thread.currentThread().getName() + "结束");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        final ModifyLock ml = new ModifyLock();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                ml.changeAttribute("张三", 20);
            }
        }, "t1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                ml.changeAttribute("李四", 30);
            }
        }, "t2");
        t1.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }
}