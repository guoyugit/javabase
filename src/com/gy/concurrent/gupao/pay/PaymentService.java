package com.gy.concurrent.gupao.pay;

import javax.print.attribute.standard.RequestingUserName;

/**
 * ClassName: PaymentService
 * Description:
 * date: 2019/3/17 21:14
 *
 * @author 郭宇
 * @since JDK 1.8
 */
public class PaymentService {

    public String submitPay(PaymentRequest request) {
        System.out.println("开始校验支付请求参数");
        return doPay(request);
    }

    private String doPay(PaymentRequest request) {
        System.out.println("开始处理支付请求" + request);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "sucess";
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        PaymentService service = new PaymentService();
        PaymentRequest request = new PaymentRequest();
        request.setPayMethod(1);
        request.setTotalFee(10000);
        request.setReturnRul("http://www.gy.com");
        service.submitPay(request);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}