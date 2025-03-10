package com.BHL;

public class Star_Pattern {
	public static void main(String[] args) {
		int  star = 5;
		
		for (int i = 1; i<=star;i++) {
			for (int j= 1; j<=5;j++) {
				if(i==1 || i==5 || j==1|| j==5) {
					System.out.print("* ");
				}
				else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}
}
