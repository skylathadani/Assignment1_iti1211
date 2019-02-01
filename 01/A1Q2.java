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
public class A1Q2{
/**
* @author: Gregory Mitchell
* @author: Skyla Thadani
*/
	public static boolean hasLengthTwoRun(double[] ar){
		/**
		* @param ar represents the double array given as input to the method.
		* @return returns boolean value true if there is at least a run of two cards and false otherwise.
		*/

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