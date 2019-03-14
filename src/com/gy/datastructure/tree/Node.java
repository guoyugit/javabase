package com.gy.datastructure.tree;

/**
 * 节点类
 */
class Node {
    public int data;    //节点数据项
    public Node leftChild;    //指向左孩子的引用
    public Node rightChild;    //指向右孩子的引用

    public Node(int data) {
        this.data = data;
    }
}