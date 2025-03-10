package com.BHL;

public class prime_number {
	
	public int count;
	public static void main(String[] args) {
		
		int num=8398;
		//int count = 0;
		for(int i = 2; i<num/2 ;i++) {
			if(num%i==0) {
				System.out.println("number is not prime");
				break;
			}
			else {
				System.out.println("number is prime");	
				break;
			}
				
		}	
		
	}
}
