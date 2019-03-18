package com.gy.concurrent.gupao.pay;

/**
 * ClassName: PaymentRequest
 * Description:
 * date: 2019/3/17 21:12
 *
 * @author 郭宇
 * @since JDK 1.8
 */
public class PaymentRequest {

    private int payMethod;
    private int totalFee;
    private String returnRul;//回调地址

    public int getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(int payMethod) {
        this.payMethod = payMethod;
    }

    public int getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(int totalFee) {
        this.totalFee = totalFee;
    }

    public String getReturnRul() {
        return returnRul;
    }

    public void setReturnRul(String returnRul) {
        this.returnRul = returnRul;
    }

    @Override
    public String toString() {
        return "PaymentRequest{" +
                "payMethod=" + payMethod +
                ", totalFee=" + totalFee +
                ", returnRul='" + returnRul + '\'' +
                '}';
    }
}