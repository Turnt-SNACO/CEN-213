
public class Sqrt {
	Sqrt(){}
	public double rootRecursion(double initial, double Guess){
		double guess=Guess/2;
		// exact answer					//acceptable error margin
		if (guess*guess==initial  || (initial-guess*guess< 0.01 && initial-guess*guess>-0.01))
			return guess;
		//generate next guess
		double nextGuess = guess+initial/guess;
		//call next guess
		return rootRecursion(initial, nextGuess);
	}
}
