package sort;

import java.util.Comparator;

public class LexicographicalComparator implements Comparator<String>{
    @Override
    public int compare(String o1, String o2) {
        char[] a = o1.toCharArray();
        char[] b = o2.toCharArray();
        for (int i = 0; i < a.length && i < b.length; i++) {
            if (a[i] == b[i])
                continue;
            else
                return (int)a[i] -(int)b[i];
        }

        if (a.length > b.length) return 1;
        if (a.length < b.length) return -1;
        return 0;
    }
}
