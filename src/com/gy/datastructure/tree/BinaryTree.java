package com.gy.datastructure.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Java实现二叉树的常见操作
 *
 * @author 郭宇
 */
public class BinaryTree {
    private Node root;    //根节点

    public boolean isEmpty() {
        return root == null;
    }

    //插入操作
    public void insert(int data) {
        Node node = new Node(data);
        if (isEmpty()) root = node;
        //更改链节点顺序，需要两个指针
        Node current = root;
        Node parent = null;
        //循环查找插入的位置
        while (true) {
            parent = current;
            if (data < current.data) {
                current = current.leftChild;
                if (current == null) {
                    parent.leftChild = node;
                    return;
                }
            } else {
                current = current.rightChild;
                if (current == null) {
                    parent.rightChild = node;
                    return;
                }
            }
        }
    }

    //查找操作
    public Node find(int key) {
        if (isEmpty()) return null;
        Node current = root;
        while (current != null) {
            if (key < current.data) {
                current = current.leftChild;
            } else if (key > current.data) {
                current = current.rightChild;
            } else {
                return current;
            }
        }
        return null;
    }

    //查找某个节点的中序后继节点并完成一些处理(难点，后继节点是比当前节点大的节点中最小的那个) 找到后继节点并进行处理后代替删除位置的节点
    private Node getSuccessor(Node delNode) {
        if (delNode == null) return null;
        Node successParent = delNode;
        Node parent = delNode;
        Node current = delNode.rightChild;
        while (current != null) {
            successParent = parent;
            parent = current;
            current = current.leftChild;
        }
        if (parent != successParent.rightChild) {//最终遍历的结果包括三层，其中第二层为第一层的左节点时，才是我们寻找的目标，如果是右节点，则无意义，当为左节点时，我们需要调整这最后三层的层级关系。
            successParent.leftChild = parent.rightChild;//第一级的左节点变为删除节点的位置，改变其左节点为parent的右节点，仍然保证第一级节点的值大于第二季节点
            parent.rightChild = delNode.rightChild;//将删除节点的右子树挂到上移节点的右子树上。
        }
        return parent;
    }

    //删除操作（关键变量parent，current，isLeftChild是否为左孩子）
    public boolean delete(int key) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;
        while (current.data != key) {
            parent = current;
            if (key < current.data) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null) return false;
        }//上述步骤是找到要删除的节点
        //下面将分情况来进行删除操作
        //1.无孩子
        if (current.leftChild == null && current.rightChild == null) {
            if (root == current) {
                root = null;
            } else if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        } else if (current.rightChild == null) {//2.有左孩子
            if (current == root) {
                root = current.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {//遍历过程中始终在右子树上
                parent.rightChild = current.leftChild;
            }
        } else if (current.leftChild == null) {
            //3.有右孩子
            if (current == root) {
                root = current.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        } else {
            //4.有两个孩子
            Node successor = getSuccessor(current);

            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;//返回的后继节点的左子树为删除节点的左子树的父节点
        }
        return true;
    }

    /**
     * 求二叉树宽度
     * 什么是二叉树的宽度？二叉树的宽度定义为具有最多结点数的层中包含的结点数。
         那么我们怎么来求解呢？
         我们可以考虑使用队列来实现，队列是一种先进先出的数据结构，具体步骤如下：
         1．一开始让根节点入队，此时队列长度为1，最大宽度也就是1
         2．让队列中的元素一一出队，出队时看一下他们是否有子节点，如果有的话入队
         3．查看队列长度，跟最大宽度比较，重复第二个过程，直到队列长度为0。
     *
     * @return
     */
    public int getMaxWidth() {
        if (root == null) return 0;
        Queue<Node> queue = new ArrayDeque<Node>();
        int maxWidth = 1;    //最大宽度
        queue.add(root);    //入队

        while (true) {
            int len = queue.size();
            if (len == 0) break;
            while (len > 0) {    //当前层还有节点
                Node n = queue.poll();
                len--;
                if (n.leftChild != null)
                    queue.add(n.leftChild);
                ;
                if (n.rightChild != null)
                    queue.add(n.rightChild);
            }
            maxWidth = Math.max(maxWidth, queue.size());
        }

        return maxWidth;
    }

}