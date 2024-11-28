import java.util.concurrent.atomic.AtomicInteger;

public class DecodeString_394 {
	
	String decodeString(final String s) {
		AtomicInteger offset = new AtomicInteger();
		String res = decodeString(s, offset);
		return res;
	}
	
	String decodeString(final String s, AtomicInteger sIndex) {
		StringBuilder res = new StringBuilder();

		while (sIndex.get() < s.length()) {
			Object token = readToken(s, sIndex);
			if (token instanceof Character ch) {
				if (ch == '[') {
					decodeString(s, sIndex);
				}
				else if (ch == ']') {
					return res.toString();
				}
			}
			else if (token instanceof Integer times) {
				sIndex.incrementAndGet(); // skip '['
				String after = decodeString(s, sIndex);
				String multiplied = stringMultiply(after, times);
				res.append(multiplied);
			}
			else if (token instanceof String strToken) {
				res.append(token);
			}
		}
		return res.toString();
	}
	
	
	Object readToken(String s, AtomicInteger sIndex) {
		char ch = s.charAt(sIndex.getAndIncrement());
		
		if (ch == '[') return '[';
		if (ch == ']') return ']';
		
		if (Character.isDigit(ch)) {
			int num = ch - '0'; 
			while (true) {
				Character next = nextChar(s, sIndex.get());
				if (next == null || !Character.isDigit(next)) break;
				Character c = nextChar(s, sIndex.getAndIncrement());
				num = num * 10 + (c - '0');
			}
			return Integer.valueOf(num);
		}
		else if (Character.isAlphabetic(ch)) {
			String res = "" + ch;
			while (true) {
				Character c = nextChar(s, sIndex.get());
				if (c == null || !Character.isAlphabetic(c)) break;
				res += nextChar(s, sIndex.getAndIncrement());
			}
			return res;
		}
			
		throw new RuntimeException("Illegal place");
	}
	
	Character nextChar(String s, int idx) {
		if (s == null) return null;
		if (idx < 0) return null;
		if (idx >= s.length()) return null;
		return s.charAt(idx);
	}



	String stringMultiply(String str, int times) {
    	if (str == null) return null;
    	if (times == 0) return null;
    	if (times == 1) return str;
    	
    	StringBuilder sb = new StringBuilder(str.length() * times);
		for (int i = 0; i < times; i++) sb.append(str);
		String res = sb.toString();
		return res;
    }
    
    
    public static void main(String[] args) {
		DecodeString_394 prog = new DecodeString_394();
		
		/*
		testCase_1: {
			String s = "3[a]2[bc]";
			String expected = "aaabcbc";
			String res = prog.decodeString(s);
			System.out.println(res + " == " + expected + ", " + (expected.equals(res)));
		}
		//*/
		
		testCase_3: {
			String s = "2[abc]3[cd]ef";
			String expected = "abcabccdcdcdef";
			String res = prog.decodeString(s);
			System.out.println(res + " == " + expected + ", " + (expected.equals(res)));
		}
		
		//*
		testCase_7: {
			String s = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";
			String expected = "zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef";
			String res = prog.decodeString(s);
			System.out.println(res + " == " + expected + ", " + (expected.equals(res)));
		}
		//*/
		
	}
}
