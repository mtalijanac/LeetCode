
public class MinimumFlipsToMakeAORBEqualToC {

    public int minFlips(int a, int b, int c) {
    	int opCount = 0;
    	for (int i = 0; i < 32; i++) {
    		int mask = 1 << i;
    		int bitA = a & mask;
    		int bitB = b & mask;
    		int bitC = c & mask;
    		
    		if (bitC == 0) {
    			if (bitA != 0) opCount++;
    			if (bitB != 0) opCount++;
    		}
    		else {
    			if (bitA == 0 && bitB == 0) opCount++;
    		}
    	}
    	return opCount;
    }
	
    
    public static void main(String[] args) {
    	for (int i = 0; i < 33; i++) {
    		String str = Integer.toBinaryString(1 << i);
    		System.out.println(i + ": " + str);
    	}
	}
}
