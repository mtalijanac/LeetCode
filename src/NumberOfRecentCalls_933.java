
public class NumberOfRecentCalls_933 {
	
	static
	class RecentCounter {
		int[] pings = new int[10_000];
		int iterator = 0;

	    public RecentCounter() {
	    }
	    
	    public int ping(int t) {
	        pings[iterator] = t;
	        iterator += 1;
	        
	        int limit = t - 3000;
	        int counter = 0;

	        for (int idx = iterator - 1; idx >= 0; idx--) {
	            if (pings[idx] < limit) break;
	            counter++;
	        }
	        
	        return counter;
	    }
	}

}
