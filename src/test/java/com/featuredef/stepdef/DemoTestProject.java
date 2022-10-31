package com.featuredef.stepdef;

import java.io.IOException;
import java.util.Scanner;

class Vehicle{
	void run() {
		System.out.println("vehicle is running");
	}
}

public class DemoTestProject extends Vehicle{

	public static void main(String[] args) throws IOException {
		
	
		char operator;
		double num1,num2;
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the operator (+ , - , * , / ");
		operator = sc.next().charAt(0);
		System.out.println("Enter two numbers : ");
		num1 = sc.nextDouble();
		num2 = sc.nextDouble();
		
		sc.close();
		
		switch(operator) {
		case '+':
			System.out.printf("%.2f + %.2f = %.2f", num1,num2,(num1+num2));
			break;
		case '-':
			System.out.printf("%.2f - %.2f = %.2f", num1,num2,(num1-num2));
			break;
		
		case '*':
			System.out.printf("%.2f * %.2f = %.2f", num1,num2,(num1*num2));
			break;
		
		case '/':
			if(num2 !=0)
			System.out.printf("%.2f / %.2f = %.2f", num1,num2,(num1/num2));
			else
				System.out.println("divide by 0 situation");
			break;
			default:
				System.out.printf("invalid operator " , operator);
		}
		
	}
}
	


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	

