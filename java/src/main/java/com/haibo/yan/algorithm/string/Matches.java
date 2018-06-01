package com.haibo.yan.algorithm.string;

import java.util.HashMap;

public class Matches {
    public boolean match(String s, String p) {
        return match(s, 0, p, 0, new HashMap<>());
    }

    private boolean match(String s, int ss, String p, int ps, HashMap<Character, String> hist) {
        if (ss == s.length() && ps == p.length()) {
            return true;
        } else if (ss >= s.length() ) {
            return false;
        } else if (ps >= p.length()) {
            return false;
        } else {
            char c = s.charAt(ss);
            String h = hist.get(c);
            if (h != null) {
                if (ps + h.length() <= p.length() && p.substring(ps, ps + h.length()).equals(h)) {
                    return match(s, ss + 1, p, ps + h.length(), hist);
                } else {
                    return false;
                }
            } else {
                boolean m = false;
                for (int i = 0; i < p.length() - ps && !m; i++) {
                    hist.put(c, p.substring(ps, ps + i + 1));
                    m |= match(s, ss + 1, p, ps + i + 1, hist);
                    hist.remove(c);
                }
                return m;
            }
        }
    }
}
