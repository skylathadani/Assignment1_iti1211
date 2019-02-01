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
public class A1Q3{
/**
* @author: Gregory Mitchell
* @author: Skyla Thadani
*/
	public static int getLongestRun(double ar[]){
		/**
		* @param ar double array 
		* @return maxCount, which is the length of the longest run if the array has a length > 1. Other wise returns 0. 
		*/
		int tmp = 1;
		//this is the counting variable
		int count = 1;
		//holds the value of the maximum count
		int maxCount = 1;

		if(ar.length == 0) {
			return 0;
		}

		for(int i = 0; i < ar.length-1;i++){
			//so basically if two elements in a row increase the counter
			if(ar[i] == ar[i+1]){
				count ++;
			}

			//if the run ends (subsequent values arent the same) then tmp holds the value of that run and count resets back to 1

			if(ar[i] != ar[i+1]){
				tmp = count;
				count = 1;

				//if tmp is bigger than the previous maxCount (the new run is longer than the previous maximum run) replace the maximum run with tmp to get the new max run

				if(tmp > maxCount){
					maxCount = tmp;
				}
			}


		}
		// return the max run
		return maxCount;
	}

	public static int getLongestRun(String ar[]){
		/**
		* @param ar String array 
		* @return maxCount, which is the length of the longest run if the array has a length > 1. Otherwise returns 0.
		*/
		
		//this is a temporary variable (needs to start at one because the smallest run will always be one)
		int tmp = 1;
		//this is the counting variable
		int count = 1;
		//holds the value of the maximum count
		int maxCount = 1;

		if(ar.length == 0) {
			return 0;
		}

		// Checks if element in front of current element is the same and increments count if they are.
		for(int i = 0; i < ar.length-1;i++){
			if(ar[i].equals(ar[i+1])){
				count ++;
			}

			// sets count back to one after run has been broken.
			if(ar[i] != ar[i+1]){
				tmp = count;
				count = 1;

				// sets maxCount to length of longest run found in array.
				if(tmp > maxCount){
					maxCount = tmp;
				}
			}


		}
		return maxCount;
	}

	
}