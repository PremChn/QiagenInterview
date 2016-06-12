package com.Qiagen.interview;

public class findHighestofThree {
	public static void main(String args[]){
		int array[] =  {8,7,2,5,0,1,9};
		int arrayLength = array.length;
		
		int arrayMid = arrayLength/2 ;
		
		System.out.println(array[arrayMid]);
		if(array[0] > array[arrayMid] && array[0] > array[arrayMid] && array[0] > array[arrayLength - 1]){
			System.out.println("Greatest of 3 numbers is: " + array[0]);
			
		}else if(array[arrayMid] > array[0] && array[arrayMid] > array[arrayLength - 1]){
			System.out.println("Greatest of 3 numbers is: " + array[arrayMid]);
		}
		else{
			System.out.println("Greatest of 3 numbers is: " + array[arrayLength - 1]);
		}
			
	}
	

	
}
