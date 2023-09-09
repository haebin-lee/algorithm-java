package sort;

import java.util.SortedSet;
import java.util.TreeSet;

public class main {

    public static void main(String[] args) {
        SortedSet<String> strings = new TreeSet<>(new LexicographicalComparator());
        strings.add("app");
        strings.add("b");
        strings.add("apple");
        strings.add("bbb");
        strings.forEach(m -> {
            System.out.println(m);
        });
    }
}
