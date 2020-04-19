package ru.netology.domain;

import ru.netology.comparator.AppComparator;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class FileOpenManager {
    Map<String, String> map = new HashMap<>();

    public FileOpenManager() {
    }

    public String remove(String key) {
        return map.remove(key.toLowerCase());
    }

    public void register(String app, String key) {
        map.putIfAbsent(key.toLowerCase(), app);
    }

    public String name(String key) {
        return map.get(key.toLowerCase());
    }

    public Set<String> showAllApps() {
        Collection<String> result = map.values();
        return new HashSet<>(result);
    }

    public List<String> showAllTypes() {
        Set<String> strings = map.keySet();
        List<String> list = new ArrayList<>(strings);
        AppComparator comparator = new AppComparator();
        list.sort(comparator);
        return list;
    }

}