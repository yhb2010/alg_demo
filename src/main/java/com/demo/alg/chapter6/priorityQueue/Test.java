package com.demo.alg.chapter6.priorityQueue;

public class Test {

	public static void main(String[] args) {
		PriorityQueue q = new PriorityQueue(16);
		q.insert(2);
		q.insert(6);
		q.insert(3);
		q.insert(8);
		q.insert(7);
		q.insert(9);
		q.insert(1);
		q.insert(10);
		q.insert(9);
		System.out.println(q.extractMax());
		System.out.println(q.extractMax());
		q.insert(9);
		q.insert(1);
		q.insert(10);
		System.out.println(q.extractMax());
		System.out.println(q.extractMax());
		System.out.println(q.extractMax());
		System.out.println(q.extractMax());
		System.out.println(q.extractMax());
		System.out.println(q.extractMax());
		System.out.println(q.extractMax());
	}

}
