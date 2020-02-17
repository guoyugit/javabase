package com.gy.test;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * <p>
 * <p>Title:SkipTest.java</p >
 * <p>Description: </p >
 * <p>Copyright: 公共服务与应急管理战略业务本部 Copyright(c)2019</p >
 * <p>Date:2020/2/17 21:52</p >
 *
 * @author guoyu (guoyu@mail.taiji.com.cn)
 * @version 1.0
 */
public class SkipTest<k extends Comparable<k>, v> {

    @Getter
    @Setter
    static final class Node<k extends Comparable<k>, v> {

        private k k;
        private v v;
        private Node<k, v> pre, next, up, down;

        Node(k k, v v) {
            this.k = k;
            this.v = v;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "k=" + k +
                    ", v=" + v +
                    ", pre=" + pre +
                    ", next=" + next +
                    ", up=" + up +
                    ", down=" + down +
                    '}';
        }
    }

    private Node<k, v> head;
    private Integer levels = 0;
    private Integer length = 0;
    private Random random = new Random(System.currentTimeMillis());

    SkipTest() {
        createNewLevel();
    }

    private void createNewLevel() {
        Node<k, v> newNode = new Node<>(null, null);
        if (null == head) {
            this.head = newNode;
            this.levels++;
            return;
        }
        this.head.setUp(newNode);
        newNode.setDown(this.head);
        this.head = newNode;
        this.levels++;
    }


    public static void main(String[] args) {
        SkipTest<Integer, String> skip = new SkipTest<Integer, String>();

        skip.put(2, "B");
        skip.put(1, "A");
        skip.put(3, "C");

        skip.print();

        System.out.println(skip.get(4));
    }

    private void put(k key, v value) {
        //key value必须都有值
        if (key == null || value == null) {
            return;
        }
        Node<k, v> newNode = new Node<>(key, value);
        insertNode(newNode);
    }

    private void insertNode(Node<k, v> newNode) {
        //findNode总是找到位于最底层的node节点。
        Node<k, v> curNode = findNode(newNode.getK());
        if (curNode.getK() == null) {
            insertNext(curNode, newNode);
        } else if (curNode.getK().compareTo(newNode.getK()) == 0) {
            //update 只有最底层的节点存储key对应的value值。
            curNode.setV(newNode.getV());
            return;
        } else {
            insertNext(curNode, newNode);
        }
        int currentLevel = 1;
        Node<k, v> oldTop = newNode;
        while (random.nextInt(100) < 50) {
            Node<k, v> newTop = new Node<k, v>(newNode.getK(), null);
            if (currentLevel >= levels) {
                createNewLevel();
            }

            while (curNode.getPre() != null && curNode.getUp() == null) {
                curNode = curNode.getPre();
            }
            if (curNode.getUp() == null) {
                continue;
            }
            curNode = curNode.getUp();
            Node<k, v> curNextNode = curNode.getNext();

            curNode.setNext(newTop);
            newTop.setPre(curNode);
            newTop.setDown(oldTop);
            oldTop.setUp(newTop);
            newTop.setNext(curNextNode);
            if (curNextNode != null) {
                curNextNode.setPre(newTop);
            }
            oldTop = newTop;
            currentLevel++;
        }
    }

    //普通链表的插入规则
    private void insertNext(Node<k, v> curNode, Node<k, v> newNode) {
        Node<k, v> curNextNode = curNode.getNext();
        newNode.setNext(curNextNode);
        if (null != curNextNode) {
            curNextNode.setPre(newNode);
        }
        curNode.setNext(newNode);
        newNode.setPre(curNode);
        this.length++;
    }

    private Node<k, v> findNode(k key) {
        Node<k, v> curNode = this.head;
        for (; ; ) {
            while (curNode.next != null && curNode.getNext().getK().compareTo(key) < 0) {
                curNode = curNode.next;
            }
            if (curNode.getDown() != null) {
                curNode = curNode.getDown();
            } else {
                break;
            }
        }
        return curNode;
    }

    public v get(k key) {
        Node<k, v> node = findNode(key);
        if (key.equals(node.getK())) {
            return node.getV();
        }
        return null;
    }

    public void print() {
        Node<k, v> curI = this.head;

        String[][] strings = new String[levels][length + 1];
        for (String[] string : strings) {
            Arrays.fill(string, "0");
        }

        while (curI.getDown() != null) {
            curI = curI.getDown();
        }

        System.out.println("levels:" + levels + "_" + "length:" + length);

        int i = 0;
        while (curI != null) {
            Node<k, v> curJ = curI;
            int j = levels - 1;
            while (curJ != null) {
                strings[j][i] = String.valueOf(curJ.getK());

                if (curJ.getUp() == null) {
                    break;
                }
                curJ = curJ.getUp();
                j--;
            }

            if (curI.getNext() == null) {
                break;
            }
            curI = curI.getNext();
            i++;
        }

        for (String[] string : strings) {
            System.out.println(Arrays.toString(string));
        }
    }
}
