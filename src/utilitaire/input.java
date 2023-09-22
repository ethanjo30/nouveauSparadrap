package utilitaire;

import java.util.Scanner;

public class input {
	
	public static Scanner scan = new Scanner(System.in);
	
	// scan d'entier
	public static int nextInt() {

		return scan.nextInt();
	}
	
	public static void message(String x){
		System.out.println(x);
	}

}
