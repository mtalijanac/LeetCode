public class Dota2Senate_649 {
	
    
    
    //
    // početak kruga
    // sve koji su bili blokirani prošli krug napravi aktivnima
    // sve koji su zablokirani prošli krug napravi bananima
    
    // iuraj krug
    //
    
	final static char R = 'R';
    final static char D = 'D';
    final static char banned = 'b';
    
    public String predictPartyVictory(String senate) {
    	char[] voters = senate.toCharArray();
    	
    	int rBans = 0, dBans = 0;
    	
    	// voting turn:
    	while (true) {
    		int rVoted = 0, dVoted = 0;
    		
	    	for (int idx = 0; idx < voters.length; idx++) {
	    		char s = voters[idx];
	    		if (s == banned) continue;
	    		
	    		if (s == R) {
	    			if (rBans > 0) {
	    				voters[idx] = banned;
	    				rBans--;
	    			}
	    			else {
	    				rVoted++;
	    				dBans++;
	    			}
	    		}
	    		
	    		else if (s == D) {
	    			if (dBans > 0) {
	    				voters[idx] = banned;
	    				dBans--;
	    			}
	    			else {
	    				dVoted++;
	    				rBans++;
	    			}
	    		}
	    	}
	    	
	    	if (rVoted > 0 && dVoted == 0) return "Radiant";
	    	if (dVoted > 0 && rVoted == 0) return "Dire";
    	}
    }
    
    public static void main(String[] args) {
		Dota2Senate_649 prog = new Dota2Senate_649();
		testCase2: {
			String party = prog.predictPartyVictory("RDD");
			System.out.println(party);
		}
		
		testCase_79: {
			String senate = "DDDDRRDDDRDRDRRDDRDDDRDRRRRDRRRRRDRDDRDDRRDDRRRDDRRRDDDDRRRRRRRDDRRRDDRDDDRRRDRDDRDDDRRDRRDRRRDRDRDR";
			String expected = "Dire";
			String party = prog.predictPartyVictory(senate);
			System.out.println(party);
		}
	}
}
