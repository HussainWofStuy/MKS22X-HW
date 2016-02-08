public class Recursion implements hw01{
    double guess = 1; 
    public String name(){return "Waris,Hussain";}
    public double sqrt(double n){
	if(n < 0){throw new IllegalArgumentException("Input must be greater than or equal to O");}
	if(Math.abs(((Math.pow(guess,2)-n)/n)*100) < 0.000001){return guess;}
	guess = (n / guess + guess) / 2;
	return sqrt(n);
    }
}
