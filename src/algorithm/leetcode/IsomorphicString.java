package algorithm.leetcode;

public class IsomorphicString {

    public static void main(String[] args) {
        String s = "egg", t = "add";
        System.out.println(isIsomorphic(s, t)); // t
        s = "foo"; t = "bar";
        System.out.println(isIsomorphic(s, t)); // f
        s = "paper"; t = "title";
        System.out.println(isIsomorphic(s, t)); // t
        s = "badc"; t = "baba";
        System.out.println(isIsomorphic(s, t)); // f
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;

        char[] sAlphabet = new char[128]; // source
        char[] tAlphabet = new char[128]; // target
        char[] source = s.toCharArray();
        char[] target = t.toCharArray();
        for (int i = 0 ; i < s.length(); i ++) {
            char si = sAlphabet[source[i]];
            char ti = tAlphabet[target[i]];
            if (si == '\0' && ti == '\0') {
                sAlphabet[source[i]] = target[i];
                tAlphabet[target[i]] = source[i];
            } else if (si != target[i] || ti != source[i]) {
                return false;
            }
        }

        return true;
    }
}
