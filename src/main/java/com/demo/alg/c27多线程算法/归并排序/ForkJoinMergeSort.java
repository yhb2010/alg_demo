package com.demo.alg.c27多线程算法.归并排序;

import java.util.concurrent.CountDownLatch;

public class ForkJoinMergeSort {
	
    public static void sort(int []arr){
        int []temp = new int[arr.length];//在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        sort(arr, 0, arr.length-1, temp, 3, 1);
    }

    public static void sort(int[] arr, int low, int high, int []temp, final int parallelDepth, final int depth) {
    	if(low < high){
            //同步工具，等待其两个子线程完成任务后归并
            final CountDownLatch mergeSignal = new CountDownLatch(2);
            int mid = (low+high)/2;
            new SortThread(depth, parallelDepth, arr, low, mid, temp, mergeSignal).start();
            new SortThread(depth, parallelDepth, arr, mid+1, high, temp, mergeSignal).start();
            //等待两个子线程完成其工作
            try {
                mergeSignal.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            MergeSort.merge(arr, low, mid, high, temp);
        }
    }

    static class SortThread extends Thread {
    	
    	private int depth;
        private int parallelDepth;
        private int[] arr;
        private int start;
        private int end;
        private int []temp;
        private CountDownLatch mergeSignal;

        public SortThread(int depth, int parallelDepth, int[] arr, int start, int end, int []temp, CountDownLatch mergeSignal) {
            super();
            this.depth = depth;
            this.parallelDepth = parallelDepth;
            this.arr = arr;
            this.start = start;
            this.end = end;
            this.temp = temp;
            this.mergeSignal = mergeSignal;
        }

        @Override
        public void run() {
        	if (depth < parallelDepth) {
                sort(arr, start, end, temp, parallelDepth, (depth + 1));
            } else {
                MergeSort.sort(arr, start, end, temp);
            }
            mergeSignal.countDown();
        }

    }

}
