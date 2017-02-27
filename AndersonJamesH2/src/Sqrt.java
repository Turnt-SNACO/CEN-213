
public class Sqrt {
	Sqrt(){}
	public double root(double initial){
		return rootRecursion(initial,initial);
	}
	private double rootRecursion(double initial, double Guess){
		double guess=Guess/2;
		// exact answer					//acceptable error margin
		if (guess*guess==initial  || (initial-guess*guess< 0.0000000000001 && initial-guess*guess>-0.0000000000001))
			return guess;
		//generate next guess
		double nextGuess = guess+initial/guess;
		//call next guess
		return rootRecursion(initial, nextGuess);
	}
}
