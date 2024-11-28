
public class RemovingStarsFromAString_2390 {
	
	// FIXME very slow program
    public String removeStars(String s) {
    	StringBuilder sb = new StringBuilder(s);
    	
    	int idx = 0;
    	int lastSeenNonStarIdx = -1;
    	while (idx < sb.length()) {
    		if (sb.length() == 0) break;
    		if (idx < 0) idx = 0;
    		
    		char ch = sb.charAt(idx);
    		if (ch != '*') {
    			lastSeenNonStarIdx = idx;
    			idx++;
    			continue;
    		}
    		
    		if (lastSeenNonStarIdx >= 0) {
    			sb.deleteCharAt(lastSeenNonStarIdx);
    			idx--;
//    			System.out.println(sb);
    		}
    		sb.deleteCharAt(idx);
    		idx--;
//    		System.out.println(sb);
    	}
    	
    	String res = sb.toString();
    	return res;
    }
    
    public static void main(String[] args) {
    	RemovingStarsFromAString_2390 prog = new RemovingStarsFromAString_2390();
		
    	testCase_1: {
    		String s = "leet**cod*e";
    		String res = prog.removeStars(s);
    	}
    	
    	testCase_2: {
    		String s = "erase*****";
    		String res = prog.removeStars(s);
    	}
    	
    	testCase_40: {
    		String s = "u*ensso****x*q";
    		String expected = "eq";
    		String res = prog.removeStars(s);
    		System.out.println("'" + res + "' == '" + expected + "', " + (expected.equals(res)));
    		System.out.println(res);
    	}
	}
}
