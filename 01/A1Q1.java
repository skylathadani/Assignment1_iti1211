public class A1Q1.java{
	public static double countPositive(double a1[]){
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