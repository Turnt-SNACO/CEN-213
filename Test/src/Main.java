public class Main {
	//this exists so when calling the recursive function only one argument needs to be passed.
	public static double root(double initial){
		return rootRecursion(initial,initial);
	}
	//actual recursive function to find the root of the given number initial
	public static double rootRecursion(double initial, double Guess){
		double guess=Guess/2;
		// exact answer					//acceptable error margin
		if (guess*guess==initial  || (initial-guess*guess< 0.0000000000001 && initial-guess*guess>-0.0000000000001))
			return guess;
		//generate next guess
		double nextGuess = guess+initial/guess;
		//call next guess
		return rootRecursion(initial, nextGuess);
	}
	//Test
	public static void main(String[] args) {
		System.out.println(root(54912));
	}
}