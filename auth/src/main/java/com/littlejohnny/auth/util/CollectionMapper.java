package com.littlejohnny.auth.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionMapper {
    public static String collectionToString(Collection collection) {
        return Arrays.toString(collection.toArray());
    }

    public static List<String> stringToList(String stringifiedCollection) {
        return Stream.of(stringifiedCollection.replace("[", "").replace("]", "").split(",")).map(String::trim).collect(Collectors.toList());
    }

    public static Set<String> stringToSet(String stringifiedCollection) {
        return Stream.of(stringifiedCollection.replace("[", "").replace("]", "").split(",")).map(String::trim).collect(Collectors.toSet());
    }
}
