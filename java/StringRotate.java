
public class StringRotate {
	public String rotate(String string) {
		char[] cs = string.toCharArray();
		rotate(cs, 0, cs.length);
		return new String(cs);
	}
	
	public String rotateWord(String string) {
		char[] cs = string.toCharArray();
		int i = 0, j = 0;
		while (j < cs.length) {
			if (cs[j] == ' ') {
				rotate(cs, i, j);
				j++;
				i = j;
			}
			j++;
		}
		rotate(cs, i, j);
		rotate(cs, 0, cs.length);
		return new String(cs);
	}
	
	private void rotate(char[] cs, int s, int e) {
		for (int i = s; i < (s + e) / 2; i++) {
			char t = cs[i];
			cs[i] = cs[e - i + s - 1];
			cs[e - i + s - 1] = t;
		}	
	}
	
	public static void main(String[] args) {
		System.out.println(new StringRotate().rotate("Tristan Yan Holy World"));
		System.out.println(new StringRotate().rotateWord("Tristan Yan Holy World"));
	}

}

