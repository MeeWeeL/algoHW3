package org.example;

import java.util.Comparator;
import java.util.List;

public class MyCollections {


    // 1) static int binarySearch(List> list, T key) - 2 балла
    public static <T extends Comparable<? super T>> int binarySearch(List<? extends T> list, T key) {
        return binarySearch(list, 0, list.size(), key);
    }

    // 2) static int binarySearch(List list, T key, Comparator c) - 2 балла
    public static <T> int binarySearch(List<? extends T> list, T key, Comparator<? super T> c) {
        return binarySearch(list, 0, list.size(), key, c);
    }

    private static <T extends Comparable<? super T>> int binarySearch(List<? extends T> list, int fromIndex, int toIndex, T key) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            T midVal = list.get(mid);

            if (midVal.compareTo(key) < 0) {
                low = mid + 1;
            } else if (midVal.compareTo(key) > 0) {
                high = mid - 1;
            } else {
                return mid; // ключ найден
            }
        }
        return -(low + 1);
    }

    private static <T> int binarySearch(List<? extends T> list, int fromIndex, int toIndex, T key, Comparator<? super T> c) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            T midVal = list.get(mid);
            int cmp = c.compare(midVal, key);

            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -(low + 1);
    }
}
