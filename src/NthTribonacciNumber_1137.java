
public class NthTribonacciNumber_1137 {
	
    public int tribonacci(int n) {
        int[] tns = {0, 1, 1};
        for (int iter = 3; iter < n + 1; iter++) {
        	int idx = iter % 3;
        	int tn = tns[0] + tns[1] + tns[2];
        	tns[idx] = tn;
        }
        
        int res = tns[ n % 3];
        return res;
    }
    		
    public static void main(String[] args) {
    	NthTribonacciNumber_1137 prog = new NthTribonacciNumber_1137();
		
    	testCase_1: {
    		int n = 4;
    		int expected = 4;
    		int res = prog.tribonacci(n);
    		System.out.println(res + " == " + expected + "; " + (res == expected));
    	}
    		
	}
}
