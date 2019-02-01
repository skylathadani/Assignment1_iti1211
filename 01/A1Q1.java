/**
* @author: Gregory Mitchell
* Student number: 300053307
* Course: ITI 1121-A00
* Assignment: 1

* @author: Skyla Thadani
* Student number: 300055455
* Course: ITI 1121-C00
* Assignment: 1
*/
public class A1Q1.java{
	public static int countPositive(double a1[]){
		int count = 0;

		for(int i =0; i<a1.length;i++){
			//if the value is positive increase the counter
			if (a1[i]>0){
				count++;
			}
		}

		return count;
	}
}