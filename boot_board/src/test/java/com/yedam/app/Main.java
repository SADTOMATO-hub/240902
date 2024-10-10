package com.yedam.app;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a;
		int b;
		
		System.out.print("정수 a 입력 : ");
		a = sc.nextInt();
		System.out.print("정수 b 입력 : ");
		b = sc.nextInt();
		
		System.out.println(a - b);
		
		sc.close();
	}
}
