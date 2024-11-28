
public class StringCompression_443 {
	
    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        char groupCh = chars[0];
        int len = 1;
        for (int idx = 1; idx < chars.length; idx++) {
        	char ch = chars[idx];
        	if (ch == groupCh) {
        		len++;
        		continue;
        	}
        	
    		sb.append(groupCh);
    		if (len > 1) sb.append(len);
    		groupCh = ch;
    		len = 1;
        }
        sb.append(groupCh);
		if (len > 1) sb.append(len);

        System.out.println(sb);
        for (int i = 0; i < sb.length(); i++) {
        	chars[i] = sb.charAt(i);
        }
        return sb.length();
    }
    
    
    public static void main(String[] args) {
    	StringCompression_443 prog = new StringCompression_443();
    	
		testcase_1: {
			char[] ch = "aabbccc".toCharArray();
			int size = prog.compress(ch);
			System.out.println(size);
		}
	}
}
