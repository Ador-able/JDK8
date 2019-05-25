package main.java.Lambda;

import java.util.*;

public class StringComparator {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("langfang", "shijiazhuang", "beijing");

        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println(names);

        Collections.sort(names, (o1, o2) -> {
            return o1.compareTo(o2);
        });

        Collections.sort(names, (o1, o2) -> o1.compareTo(o2));

        System.out.println(names);

        Collections.sort(names, Collections.reverseOrder());

        System.out.println(names);
    }
}
