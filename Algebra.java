// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		for (int i = 0; i < x2; i++) {
			x1++; 
		}
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		for (int i = 0; i < x2; i++) {
			x1--; 
		}
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		
		int product = 0;

		for (int i = 0; i < x2; i++) {
			product = plus(product, x1);
		}
		return product;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		
		int product = 1;

		for (int i = 0; i < n; i++) {
			product = times(product, x);
		}
		return product;

	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {

		boolean negative = (x1 < 0) ^ (x2 < 0);
		
		if (x1 < 0) x1 = -x1;
    	if (x2 < 0) x2 = -x2;
	
		int result = 0;
		while (x1 >= x2) {
			x1 -= x2;
			result++;
		}
		return negative ? (-result) : result;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		
		if (x1 < 0) x1 = -x1;
    	if (x2 < 0) x2 = -x2;

		while (x1 >= x2) {
			x1 -= x2;
		
		}
		
		return x1;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		
		double epsilon = 0.01, L = 1.0, H = x;
		double g = (L + H) / 2.0;
		
		double number1 = times(g, g);
		double number2 = minus(number1, x);
		
		if (number2 < 0) number2 = -number2;
		
		while (number2 >= epsilon) {
			if (number1 < x) {
				L = g;
			} else { 
				H = g;
			}
			g = (L + H) / 2;

			number1 = times(g, g);
			number2 = minus(number1, x);
			if (number2 < 0) number2 = -number2;

			}
		return (int) g;
	}
}