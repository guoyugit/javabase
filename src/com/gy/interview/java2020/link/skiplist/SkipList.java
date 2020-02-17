package com.gy.interview.java2020.link.skiplist;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.Random;

/**
 * 跳跃表
 * 在查找目标元素时，从顶层列表、头元素起步。算法沿着每层链表搜索，直至找到一个大于或等于目标的元素，或者到达当前层列表末尾。如果该元素等于目标元素，
 * 则表明该元素已被找到；如果该元素大于目标元素或已到达链表末尾，则退回到当前层的上一个元素，然后转入下一层进行搜索。
 */
public class SkipList<K extends Comparable<K>, V> {

    @Getter
    @Setter
    static final class Node<K extends Comparable<K>, V> {
        private K key;

        private V value;

        private Node<K, V> up, down, pre, next;

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    ", hashcode=" + hashCode() +
                    ", up=" + (up == null ? "null" : up.hashCode()) +
                    ", down=" + (down == null ? "null" : down.hashCode()) +
                    ", pre=" + (pre == null ? "null" : pre.hashCode()) +
                    ", next=" + (next == null ? "null" : next.hashCode()) +
                    '}';
        }

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    //头节点引用变量
    private Node<K, V> head;//k,v 都是 NULL

    //层级
    private Integer levels = 0;

    //横向链表的最大长度
    private Integer length = 0;

    //随机数
    private Random random = new Random(System.currentTimeMillis());

    public SkipList() {
        createNewLevel();
    }

    public void put(K key, V value) {
        if (key == null || value == null) {
            return;
        }

        Node<K, V> newNode = new Node<>(key, value);
        insertNode(newNode);
    }

    private void insertNode(Node<K, V> newNode) {
        //最底层需要插入节点的前一节点
        Node<K, V> curNode = findNode(newNode.getKey());

        if (curNode.getKey() == null) {
            //从头部开始插入新元素
            insertNext(curNode, newNode);
        } else if (curNode.getKey().compareTo(newNode.getKey()) == 0) {
            //update
            curNode.setValue(newNode.getValue());
            return;
        } else {
            insertNext(curNode, newNode);
        }

        int currentLevel = 1;
        Node<K, V> oldTop = newNode;
        //二分之一的概率添加一层
        while (random.nextInt(100) < 50) {
            Node<K, V> newTop = new Node<>(newNode.getKey(), null);

            if (currentLevel >= levels) {
                createNewLevel();
            }
            //当前节点的pre不为空，up为空，此时curnode向前移动一位
            while (curNode.getPre() != null && curNode.getUp() == null) {
                    curNode = curNode.getPre();
            }

            if (curNode.getUp() == null) {
                continue;
            }

            curNode = curNode.getUp();
            Node<K, V> curNodeNext = curNode.getNext();

            curNode.setNext(newTop);
            newTop.setPre(curNode);
            newTop.setDown(oldTop);
            oldTop.setUp(newTop);

            newTop.setNext(curNodeNext);
            oldTop = newTop;
            currentLevel++;
        }
    }

    private void createNewLevel() {
        Node<K, V> newHead = new Node<>(null, null);
        if (this.head == null) {
            this.head = newHead;
            this.levels++;
            return;
        }

        //头节点添加向上的指向，指向新的一层
        this.head.setUp(newHead);
        //新加层的头节点设置向下的指向，为当前头节点
        newHead.setDown(this.head);
        //设置当前的头指向为新加层的头节点
        this.head = newHead;
        //层级+1
        this.levels++;
    }

    private void insertNext(Node<K, V> curNode, Node<K, V> newNode) {
        Node<K, V> curNodeNext = curNode.getNext();
        //新节点设置next
        newNode.setNext(curNodeNext);
        if (curNodeNext != null) {
            //当前节点的next设置pre为新节点
            curNodeNext.setPre(newNode);
        }
        //当前节点的next为新节点
        curNode.setNext(newNode);
        //新节点的pre设置为当前节点
        newNode.setPre(curNode);
        //链表长度加一
        this.length++;
    }

    public V get(K key) {
        Node<K, V> node = findNode(key);
        if (key.equals(node.getKey())) {
            return node.getValue();
        }

        return null;
    }

    private Node<K, V> findNode(K key) {
        Node<K, V> curNode = this.head;

        for (; ; ) {
            //当前节点存在下一节点，且下一节点的key小于传入的key
            while (curNode.getNext() != null && curNode.getNext().getKey().compareTo(key) <= 0) {
                curNode = curNode.getNext();
            }

            if (curNode.getDown() != null) {
                curNode = curNode.getDown();
            } else {
                break;
            }
        }

        return curNode;
    }

    public void print() {
        Node<K, V> curI = this.head;

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
            Node<K, V> curJ = curI;
            int j = levels - 1;
            while (curJ != null) {
                strings[j][i] = String.valueOf(curJ.getKey());

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

    public static void main(String[] args) {

        SkipList<Integer, String> skipList = new SkipList<>();

        skipList.put(2, "B");
        skipList.put(1, "A");
        skipList.put(3, "C");
        skipList.put(4, "D");
        skipList.put(5, "E");

        skipList.print();

        System.out.println(skipList.get(4));

    }
//    public static void main(String[] args) {
//        Random random = new Random(System.currentTimeMillis());
//        System.out.println(System.currentTimeMillis());
//        for (int i = 0; i < 100 ; i++) {
//            System.out.println(random.nextInt(100));
//        }
//
//    }
}

