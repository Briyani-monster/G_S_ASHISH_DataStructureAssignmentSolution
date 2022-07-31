package com.greatlearning.question1;

import java.util.Scanner;
import java.util.Stack;

public class BuildingASkyscrapper {
	//Main code login is this for calculating order of building to be made	
	private void orderOfConstruction(int[] arr,int totalsize) {
		boolean flag=false;//is just to handle print of purpose of enter
		//stack will use to store order of stack
		Stack<Integer> floorHelperStack=new Stack<>();
		for(int index=0;index<arr.length;index++) {
			flag=false;
			System.out.println("Day :"+(index+1));
			floorHelperStack.push(arr[index]);
			while(!floorHelperStack.isEmpty() && floorHelperStack.peek()==totalsize) {
				System.out.print(floorHelperStack.pop()+" ");
				totalsize--;
				flag=true;
			}
			if(flag==true) {
				//flag is just use to add this after stack value is popped
				System.out.println();
			}
		}
		
	}
//	taking input and running main funtion is handled here
	public void solution() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the total no. of floor in Building: ");
		int totalsize=sc.nextInt();
		int[] floorSize=new int[totalsize];
		for(int i=1;i<=floorSize.length;i++) {
			System.out.println("Enter floor size on Day: "+i);
			floorSize[i-1]=sc.nextInt();
		}
		System.out.println("Order of construction is as follows:-");
		//calling main code logic
		orderOfConstruction(floorSize, totalsize);
	}
}
