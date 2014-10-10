package linear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;

public class ParenMatch {

	public static boolean parenMatch(String expr) {
		// COMPLETE THIS METHOD
		// FOLLOWING LINE IS A PLACEHOLDER TO MAKE THE COMPILER HAPPY
		return false;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(
								new InputStreamReader(System.in));
		System.out.print("Enter expression: ");
		String expr = br.readLine();
		if (parenMatch(expr)) {
			System.out.println("Matched!");
		} else {
			System.out.println("Not matched");
		}

	}

}
