package com.gy.interview.zfxx;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * <p>Title:YSF.java</p >
 * <p>Description:約瑟夫环问题-中孚信息 </p >
 * <p>Copyright: 公共服务与应急管理战略业务本部 Copyright(c)2019</p >
 * <p>Date:2020/3/12 20:11</p >
 *
 * @author guoyu (guoyu@mail.taiji.com.cn)
 * @version 1.0
 */
public class YSF {
    public static void main(String[] args) {
        int num = 5;
        Link link = initLinks(num);
//        printList(link);
        System.out.println(ysf(link, num, 2));
    }

    private static Link initLinks(int num) {
        if (num <= 0) return null;
        List<Link> list = new ArrayList<>(num);
        for (int i = 1; i <= num; i++) {
            Link link = new Link(i);
            list.add(link);
        }
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                list.get(i).setPre(list.get(list.size() - 1));
                list.get(i).setNext(list.get(i + 1));
                continue;
            }
            if (i == list.size() - 1) {
                list.get(i).setPre(list.get(i - 1));
                list.get(i).setNext(list.get(0));
                continue;
            }
            list.get(i).setNext(list.get(i + 1));
            list.get(i).setPre(list.get(i - 1));
        }
        return list.get(0);
    }

    public static void printList(Link link) {
        Link head = link;
        while (link.next != head) {
            System.out.println(link.getData() + "->");
            link = link.getNext();
        }
        System.out.println(link.getData());
    }

    private static int ysf(Link link, int total, int n) {
        //定义当前数数的数量
        int current = 1;
        while (total > 1) {
            if (current % n == 0) {
                remove(link);
                total--;
            }
            current++;
            link = link.getNext();
        }
        return link.getData();
    }

    private static void remove(Link link) {
        Link pre = link.getPre();
        Link next = link.getNext();
        pre.setNext(next);
        next.setPre(pre);
    }

}

class Link {
    int data;
    Link pre;
    Link next;

    public Link(int data) {
        this.data = data;
    }

    public Link(int data, Link pre, Link next) {
        this.data = data;
        this.pre = pre;
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Link getPre() {
        return pre;
    }

    public void setPre(Link pre) {
        this.pre = pre;
    }

    public Link getNext() {
        return next;
    }

    public void setNext(Link next) {
        this.next = next;
    }
}
