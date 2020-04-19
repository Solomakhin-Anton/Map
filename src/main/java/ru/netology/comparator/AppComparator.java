package ru.netology.comparator;

import java.util.Comparator;

public class AppComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }
}
