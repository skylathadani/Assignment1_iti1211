/**
*
*
* @author Skyla Thadani 300055455
*/

import java.util.Random;

public class Die {
	
	int difValue;
	Random value = new Random();
	public static int MAXVALUE = 6;

	// Gives value to Die object when first made.
	public Die() {
		this.difValue = value.nextInt(6) +  1;
	}
	// 'Gets' the value of object made.
	public int getValue() {
		return difValue;
	}
	// Generates new int value for Die objects.
	public int roll() {
		difValue = value.nextInt(6) + 1;
		return difValue;
	}

	public String toString() {
		String result = "Die {value: " + difValue +  " }";
		return result;
	}
	// Testing code.
	/*
	public static void main(String[] args) {
		Die d = new Die();
		System.out.println(d.getValue());
		d.roll();
		System.out.println(d.getValue());
		System.out.println(d);
	}
	*/	
}