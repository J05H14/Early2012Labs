package lab2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab02 {

	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		List<String> servants = getNames();
		int choice;
		String menu = 	"1. Easy Problem\n" +
				"2. Hard Problem\n" +
				"3. Quit";

		do{
			System.out.println(menu);
			choice = input.nextInt();

			if(choice == 1){
				System.out.println("You got " + easyProblem(servants) + " correct answers");
				servants = getNames();
			}
			else if(choice == 2){
				System.out.println("You got " + hardProblem(servants) + " correct answers");
				servants = getNames();
			}
			else if(choice == 3){
				System.out.println("GoodBye!");
			}
			else{
				System.out.println("Invalid Input");
			}
		}while(choice != 3);

	}

	public static int easyProblem(List<String> list) {
		String answer;
		String question;
		boolean isCorrect = true;
		int numC = 0;

		input.nextLine();

		if(list.size() == 0){
			System.out.println("Do the dishes yourself");
		}
		else{
			for(int i = 0; isCorrect == true; i++){
				question = "Day " + i + ": " + list.get(i % list.size()) + " must do the dishes";
				System.out.println(question);
				System.out.print("input: ");
				answer = input.nextLine();

				if(!(answer.equals(question))){
					isCorrect = false;
				}
				else if(answer.equals(question)){
					System.out.println("CORRECT");
				}
				numC = i;
			}
		}
		return numC;
	}

	public static int hardProblem(List<String> list) {
		String answer;
		String question;
		boolean isCorrect = true;
		int numC = 0;

		if(list.size() == 0){
			System.out.println("Do the dishes yourself");
		}
		else{
			input.nextLine();
			for(int i = 0; isCorrect == true; i++){
				question = "Day " + i + ": " + list.get(i % list.size()) + " must do the dishes";
				System.out.print("input:");
				answer = input.nextLine();

				if(!(answer.equals(question))){
					isCorrect = false;
				}
				else if(answer.equals(question)){
					System.out.println("CORRECT");
				}
				numC = i;
			}
		}
		return numC;
	}

	public static List<String> getNames(){
		List<String> names = new ArrayList<String>();
		int num;

		System.out.println("How Many Kids?");
		num = input.nextInt();
		input.nextLine();

		System.out.println("Names of Children");
		for(int i = 0; i < num; i++){
			names.add(input.nextLine());
		}

		return names;
	}
}
