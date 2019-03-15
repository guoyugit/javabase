package com.gy.datastructure.tree;

import java.util.ArrayList;
/**
 * @Description:
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前,
 * 根据二叉搜索树的概念，先加入list的数组集合必然是最长的一只)
 * @Author:         郭宇
 * @CreateDate:     2019/3/15 10:36
 */
public class DeepSearch {

	private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
	private ArrayList<Integer> list = new ArrayList<Integer>();

	public ArrayList<ArrayList<Integer>> FindPath(TreeNode1 root, int target) {
		if (null == root)
			return listAll;
		list.add(root.val);
		target -= root.val;
		if (target == 0 && root.left == null && root.right == null)// 如果此时节点为叶子节点，且满足目标值即当前list为满足条件的其中一条路径
			listAll.add(new ArrayList<Integer>(list));
		FindPath(root.left, target);
		FindPath(root.right, target);
		list.remove(list.size() - 1);// 移除list数组中最后一个值，继续寻找符合条件的值
		return listAll;
	}

	public static void main(String[] args) {
		TreeNode1 root = new TreeNode1(10);
		TreeNode1 a = new TreeNode1(4);
		TreeNode1 b = new TreeNode1(5);
		TreeNode1 c = new TreeNode1(7);
		TreeNode1 d = new TreeNode1(12);
		root.left = b;
		root.right = d;
		b.left = a;
		b.right = c;
		DeepSearch test = new DeepSearch();
		ArrayList<ArrayList<Integer>> findPath = test.FindPath(root, 22);
		for (ArrayList<Integer> arrayList : findPath) {
			for (Integer integer : arrayList) {
				System.out.print(integer + " ");
			}
			System.out.println();
		}
	}
}

class TreeNode1 {
	int val = 0;
	TreeNode1 left = null;
	TreeNode1 right = null;

	public TreeNode1(int val) {
		this.val = val;

	}

}