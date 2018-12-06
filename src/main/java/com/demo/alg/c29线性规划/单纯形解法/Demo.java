package com.demo.alg.c29线性规划.单纯形解法;

import java.io.PrintStream;

public class Demo {

	private static PrintStream StdOut = System.out;

	// test client
	public static void main(String[] args) {
		try {
			test0();
		} catch (Exception e) {
			e.printStackTrace();
		}
		StdOut.println("--------------------------------");

		try {
			//test1();
		} catch (Exception e) {
			e.printStackTrace();
		}
		StdOut.println("--------------------------------");

		try {
			//test2();
		} catch (Exception e) {
			e.printStackTrace();
		}
		StdOut.println("--------------------------------");

		try {
			//test3();
		} catch (Exception e) {
			e.printStackTrace();
		}
		StdOut.println("--------------------------------");

		try {
			//test4();
		} catch (Exception e) {
			e.printStackTrace();
		}
		StdOut.println("--------------------------------");
	}
	
    /**
     *  model:
		max=13*A+ 23*B;
		
		5*A + 15*B <480 ;
		4*A + 4 *B <160 ;
		35* A + 20 *B <1190 ;
		
		end
		
		
		Variable Value Reduced Cost
		A 12.00000 0.000000
		B 28.00000 0.000000
     */
    public static void test0() {
        double[][] A = {
                { 5,  15 },
                {  4, 4 },
                {  35,  20  }

        };
        double[] c = { 13, 23 };
        double[] b = { 480,160,1190};
        test(A, b, c);
    }
    
    public static void test1() {
        double[][] A = {
                { -1,  1,  0 },
                {  1,  4,  0 },
                {  2,  1,  0 },
                {  3, -4,  0 },
                {  0,  0,  1 },
        };
        double[] c = { 1, 1, 1 };
        double[] b = { 5, 45, 27, 24, 4 };
        test(A, b, c);
    }

    // x0 = 12, x1 = 28, opt = 800
    public static void test2() {
        double[] c = {  13.0,  23.0 };
        double[] b = { 480.0, 160.0, 1190.0 };
        double[][] A = {
                {  5.0, 15.0 },
                {  4.0,  4.0 },
                { 35.0, 20.0 },
        };
        test(A, b, c);
    }

    // unbounded
    public static void test3() {
        double[] c = { 2.0, 3.0, -1.0, -12.0 };
        double[] b = {  3.0,   2.0 };
        double[][] A = {
                { -2.0, -9.0,  1.0,  9.0 },
                {  1.0,  1.0, -1.0, -2.0 },
        };
        test(A, b, c);
    }

    // degenerate - cycles if you choose most positive objective function coefficient
    public static void test4() {
        double[] c = { 10.0, -57.0, -9.0, -24.0 };
        double[] b = {  0.0,   0.0,  1.0 };
        double[][] A = {
                { 0.5, -5.5, -2.5, 9.0 },
                { 0.5, -1.5, -0.5, 1.0 },
                { 1.0,  0.0,  0.0, 0.0 },
        };
        test(A, b, c);
    }
    
    public static void test(double[][] A, double[] b, double[] c) {
        Simplex lp = new Simplex(A, b, c);
        StdOut.println("value = " + lp.value());
        double[] x = lp.primal();
        for (int i = 0; i < x.length; i++)
            StdOut.println("x[" + i + "] = " + x[i]);
        double[] y = lp.dual();
        for (int j = 0; j < y.length; j++)
            StdOut.println("y[" + j + "] = " + y[j]);
    }

}
