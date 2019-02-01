/**
* Author: Gregory Mitchell
* Student number: 300053307
* Course: ITI 1121-A00
* Assignment: 1

* Author: Skyla Thadani
* Student number: 300055455
* Course: ITI 1121-C00
* Assignment: 1
*/
public class A1Q2{
	public static boolean hasLengthTwoRun(double[] ar){

		for(int i = 0; i < ar.length-1;i++){
			//if there is a run of two -> return true and program will terminate
			if(ar[i] == ar[i+1]){
				return true;
			}

		}
//default return value is false
		return false;
	}

}