package lab1;

import java.util.Scanner;

public class Lab01 {

	public static void main(String[] args) {
		double[] array = new double[10];
		array = getArray(array);
		double[] copiedArr = recipircal(array);

		System.out.println("Original Array:");
		printArr(array);
		System.out.println();
		
		sqrtArr(array);
		System.out.println("Original Array:");
		printArr(array);
		System.out.println();
		
		fiveHundred(array);
		System.out.println("Original Array:");
		printArr(array);
		System.out.println();
		
		System.out.println("Reciprical of Array:");
		printArr(copiedArr);
		System.out.println("Original Array:");
		printArr(array);
	}
	
	public static double[] getArray(double[] arr){
		Scanner in = new Scanner(System.in);
		
		for(int i = 0; i < arr.length; i++){
			arr[i] = in.nextDouble();
		}
		
		return arr;
	}
	
	public static void printArr(double[] arr){
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void sqrtArr(double[] arr){
		System.out.println("Square Root of Array Values:");
		for(int i = 0; i < arr.length; i++){
			System.out.print(Math.sqrt(arr[i]) + " ");
		}
		System.out.println();
	}
	
	public static void fiveHundred(double[] arr){
		double[] change = new double[arr.length];
		
		System.out.println("Array with no higher than 500:");
		for(int i = 0; i < change.length; i++){
			change[i] = arr[i];
			if(change[i] > 500){
				change[i] = 500;
			}
			System.out.print(change[i] + " ");
		}
		System.out.println();
	}
	
	public static double[] recipircal(double[] arr){
		double[] newArr = new double[arr.length];
		
		for(int i = 0; i < newArr.length; i++){
			newArr[i] = 1 / (arr[i]);
		}
		
		return newArr;
	}
}
