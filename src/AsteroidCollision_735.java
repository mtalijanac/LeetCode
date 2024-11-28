import java.util.Arrays;

public class AsteroidCollision_735 {

    public int[] asteroidCollision(int[] asteroids) {
        
    	// + >>> - <<<<
    	// If two asteroids meet, the smaller one will explode. 
    	// If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
    	
    	int arrayLen = asteroids.length;
    	
    	while (true) {
    		boolean noColision = true;
	    	for (int j = arrayLen - 2; j >= 0; j--) {
	    		int leftAst = asteroids[j];
	    		int righAst = asteroids[j + 1];
	    		
	    		if (leftAst > 0 && righAst < 0) // collision
	    		{
	    			noColision = false;
	    			int righAstAbs = Math.abs(righAst);
	    			if (leftAst == righAstAbs) {
	    				// ukloi oba elementa
	    				// b = c -> 0 a (bc) d e f
	    				System.arraycopy(asteroids, j + 2, asteroids, j, arrayLen - j - 2);
	    				arrayLen -= 2;
	    			}
	    			else if (leftAst > righAstAbs) {
	    				// ukloni desni element
	    				// b > c -> 0 a b (c) d e f
	    				System.arraycopy(asteroids, j + 2, asteroids, j + 1, arrayLen - j - 2);
	    				arrayLen -= 1;
	    			}
	    			else {
	    				// ukloni lijevi element
	    				// b < c -> 0 a (b) c d e f
	    				System.arraycopy(asteroids, j + 1, asteroids, j, arrayLen - j - 1 );
	    				arrayLen -= 1;
	    			}
	    		}
	    	}
	    	if (noColision) break;
    	}
    	
    	int[] res = new int[arrayLen];
    	System.arraycopy(asteroids, 0, res, 0, arrayLen);
    	return res;
    }
    
    
    public static void main(String[] args) {
    	AsteroidCollision_735 prog = new AsteroidCollision_735();
    	
		testCase_1: {
			int[] asteroids = {5, 10, -5};
			int[] res = prog.asteroidCollision(asteroids);
			System.out.println(Arrays.toString(res));
		}
		
		testCase_2: {
			int[] asteroids = {8, -8};
			int[] res = prog.asteroidCollision(asteroids);
			System.out.println(Arrays.toString(res));
		}
		
		testCase_3: {
			int[] asteroids = {10, 6, -5, 3, 4};
			int[] res = prog.asteroidCollision(asteroids);
			System.out.println(Arrays.toString(res));
		}
	}
}
