/**
*
*
* @author Skyla Thadani 300055455
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