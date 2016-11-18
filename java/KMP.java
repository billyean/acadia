public class KMP {
    public int subStr(String string, String pattern) {
        char[] cs = string.toCharArray();
        char[] pcs = pattern.toCharArray();
        
        int[] pMoves = calNextMove(pcs);
        
        int i = 0;
        int j = 0;
        
        while (i < cs.length && j < pcs.length) {
            if (cs[i] == pcs[j]) {
                i++;
                j++;
            } else if (j > 0) {
                j = pMoves[j - 1];
            } else {
                i++;
            }
        }
        
        if (j < pcs.length) {
            return -1;
        } else {
            return i - j;
        }
    }
    
    private int[] calNextMove(char[] cs) {
        int[] moves = new int[cs.length];
        
        moves[0] = 0;
        
        int i = 0;
        
        for (int j = 1; j < cs.length; j++) {
            while (i > 0 && cs[i] != cs[j]) {
                i = moves[i];
            }
            if (cs[i] == cs[j]) {
                i++;
            }
            moves[j] = i;
        }
        return moves;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        KMP kmp = new KMP();
        System.out.println(kmp.subStr("Tina Luo Tristan Yan", "an"));

    }

}

