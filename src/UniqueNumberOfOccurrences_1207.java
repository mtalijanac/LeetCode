public class UniqueNumberOfOccurrences_1207 {
	
    public boolean uniqueOccurrences(int[] arr) {
        int[] occurences = new int[2001];
        for (int num: arr) occurences[num + 1000]++;
        
        boolean[] valueSeen = new boolean[1002];
        for (int o: occurences) {
        	if (o == 0) continue;
        	if (valueSeen[o]) return false;
        	valueSeen[o] = true;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
    	UniqueNumberOfOccurrences_1207 prog = new UniqueNumberOfOccurrences_1207();
		testcase_1: {
			int[] arr = {1,2,2,1,1,3};
			boolean res = prog.uniqueOccurrences(arr);
			boolean exp = true;
			System.out.println(res + " == " + exp + ", " + (res == exp));
		}
	}
}
