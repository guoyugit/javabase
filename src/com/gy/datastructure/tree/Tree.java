package com.gy.datastructure.tree;


/**
 * 求一颗二叉树中的最大距离
 * 二叉树最大距离其实就是左子树最长距离+右子树最长距离，所以可以通过递归来做，递归的求左子树最大距离和右子树最大距离，然后判断，更新结果。
 * @author 郭宇
 *
 */
class TreeNode {
	TreeNode pLeft;		//左孩子
	TreeNode pRight;	//右孩子
	int nMaxLeft;	//左子树中的最长距离
	int nMaxRight;	//右子树中的最长距离
	char chValue;	//该节点的值
}

public class Tree {
	
	public static int nMaxLen;
	
	//寻找树中的最长距离
	public static void findMaxLen(TreeNode pRoot) {
		//如果遍历到叶子节点 返回
		if(pRoot == null) return;
		//如果左子树空 那么该节点的左边最长距离为0
		if(pRoot.pLeft == null) {
			pRoot.nMaxLeft = 0;
		}
		//如果右子树是空 那么该节点的右边最常距离为0
		if(pRoot.pRight == null) {
			pRoot.nMaxRight = 0;
		}
		
		//左子树不为空 递归寻找左子树的最长距离
		if(pRoot.pLeft != null) {
			findMaxLen(pRoot.pLeft);
		}
		
		
		//计算左子树最长节点距离
		if(pRoot.pLeft != null) {
			int nTempMax = 0;
			if(pRoot.pLeft.nMaxLeft > pRoot.pLeft.nMaxRight) {
				nTempMax = pRoot.pLeft.nMaxLeft;
			}else {
				nTempMax = pRoot.pLeft.nMaxRight;
			}
			pRoot.nMaxLeft = nTempMax+1;
		}
		//计算右子树
		if(pRoot.pRight != null) {
			findMaxLen(pRoot.pRight);
		}
		
		//计算you子树最长节点距离
		if(pRoot.pRight != null) {
			int nTempMax = 0;
			if(pRoot.pRight.nMaxLeft > pRoot.pRight.nMaxRight) {
				nTempMax = pRoot.pRight.nMaxLeft;
			}else {
				nTempMax = pRoot.pRight.nMaxRight;
			}
			pRoot.nMaxRight = nTempMax+1;
		}
		
		//返回最长距离
		if(pRoot.nMaxLeft+pRoot.nMaxRight > nMaxLen) {
			nMaxLen = pRoot.nMaxLeft + pRoot.nMaxRight;
		}
	} 

}