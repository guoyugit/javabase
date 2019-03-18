package com.gy.concurrent.gupao.pay;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * ClassName: AsynPaymentService
 * Description:
 * date: 2019/3/17 21:21
 *
 * @author 郭宇
 * @since JDK 1.8
 */
public class AsynPaymentService {
    private ExecutorService single = Executors.newSingleThreadExecutor();
    LinkedBlockingQueue<PaymentRequest> taskQueue = new LinkedBlockingQueue<>();
    private volatile boolean isRunning = true;

    /*在启动的时候初始化*/ {
        init();
    }

    private void init() {
        single.execute(() -> {
            while (isRunning) {
                try {
                    System.out.println("当前队列中任务总数为:" + taskQueue.size());
                    PaymentRequest paymentRequest = taskQueue.take();
                    System.out.println("队列任务执行完毕！");
                    doPay(paymentRequest);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            single.shutdown();
        });
    }

    public String submitPay(PaymentRequest request) {
        System.out.println("开始校验支付请求参数");
        taskQueue.add(request);
        return "支付处理中";
//        return doPay(request);
    }

    //第三方服务无法改变
    private String doPay(PaymentRequest request) {
        System.out.println("开始处理支付请求" + request);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "sucess";
    }

    //数据的最终一致性结果（柔性事务）
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        AsynPaymentService service = new AsynPaymentService();
        PaymentRequest request = new PaymentRequest();
        request.setPayMethod(1);
        request.setTotalFee(10000);
        request.setReturnRul("http://www.gy.com");
        service.submitPay(request);
        long end = System.currentTimeMillis();
        System.out.println("请求处理结束,用时为：" + (end - start));
        Thread.sleep(3000);
        service.isRunning = false;
    }
}