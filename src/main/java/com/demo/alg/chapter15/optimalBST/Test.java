package com.demo.alg.chapter15.optimalBST;

/**
 * 最优二叉查找树：
 * 给定n个互异的关键字组成的序列K=<k1,k2,...,kn>，且关键字有序（k1<k2<...<kn），我们想从这些关键字中构造一棵二叉查找树
 * 。对每个关键字ki，一次搜索搜索到的概率为pi。可能有一些搜索的值不在K内，因此还有n+1个“虚拟键”d0,d1,...,dn，他们代表不在K内的值。具体：
 * d0代表所有小于k1的值，dn代表所有大于kn的值。而对于i =
 * 1,2,...,n-1,虚拟键di代表所有位于ki和ki+1之间的值。对于每个虚拟键，一次搜索对应于di的概率为qi
 * 。要使得查找一个节点的期望代价（代价可以定义为：比如从根节点到目标节点的路径上节点数目）最小，就需要建立一棵最优二叉查找树。
 * 
 * @author Administrator
 *
 */
public class Test {

	public static void main(String[] args) {
		int n = 5;
		// 搜索到根节点和虚拟键的概率
		double[] p = { -1, 0.15, 0.1, 0.05, 0.1, 0.2 };
		double[] q = { 0.05, 0.1, 0.05, 0.05, 0.05, 0.1 };

		OptimalBST bst = new OptimalBST();
		bst.optimalBST(p, q, n);
		bst.printRoot(n);
		System.out.println("最优二叉树结构：");
		bst.printOptimalBST(n, 1, n, -1);

		System.out.println("该最优二叉查找树的期望代价为：" + bst.gete(n));
	}
}
