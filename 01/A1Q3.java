public class A1Q3{

	public static int getLongestRun(double ar[]){
		//this is for arrays that are type double

		//this is a temporary variable (needs to start at one because the smallest run will always be one)
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
		int tmp = 1;
		int count = 1;
		int maxCount = 1;

		if(ar.length == 0) {
			return 0;
		}

		for(int i = 0; i < ar.length-1;i++){
			if(ar[i].equals(ar[i+1])){
				count ++;
			}

			if(ar[i] != ar[i+1]){
				tmp = count;
				count = 1;

				if(tmp > maxCount){
					maxCount = tmp;
				}
			}


		}
		return maxCount;
	}

	
}