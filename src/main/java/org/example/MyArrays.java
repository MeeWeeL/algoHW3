package org.example;

import java.util.Comparator;

public class MyArrays {

    // 1) static int binarySearch(byte[] a, byte key)- 1 балл
    public static int binarySearch(byte[] a, byte key) {
        return binarySearch(a, 0, a.length, key);
    }

    // 2) static int binarySearch(byte[] a, int fromIndex, int toIndex, byte key) - 2 балла
    public static int binarySearch(byte[] a, int fromIndex, int toIndex, byte key) {
        while (fromIndex < toIndex) {
            int mid = fromIndex + (toIndex - fromIndex) / 2;
            if (a[mid] < key) {
                fromIndex = mid + 1;
            } else if (a[mid] > key) {
                toIndex = mid;
            } else {
                return mid;
            }
        }
        return -(fromIndex + 1);
    }

    // 3) static int binarySearch(char[] a, char key) - 1 балл
    public static int binarySearch(char[] a, char key) {
        return binarySearch(a, 0, a.length, key);
    }

    // 4) static int binarySearch(char[] a, int fromIndex, int toIndex, char key) - 2 балла
    public static int binarySearch(char[] a, int fromIndex, int toIndex, char key) {
        while (fromIndex < toIndex) {
            int mid = fromIndex + (toIndex - fromIndex) / 2;
            if (a[mid] < key) {
                fromIndex = mid + 1;
            } else if (a[mid] > key) {
                toIndex = mid;
            } else {
                return mid;
            }
        }
        return -(fromIndex + 1);
    }

    // 5) static int binarySearch(double[] a, double key)- 1 балл
    public static int binarySearch(double[] a, double key) {
        return binarySearch(a, 0, a.length, key);
    }

    // 6) static int binarySearch(double[] a, int fromIndex, int toIndex, double key)- 2 балла
    public static int binarySearch(double[] a, int fromIndex, int toIndex, double key) {
        while (fromIndex < toIndex) {
            int mid = fromIndex + (toIndex - fromIndex) / 2;
            if (a[mid] < key) {
                fromIndex = mid + 1;
            } else if (a[mid] > key) {
                toIndex = mid;
            } else {
                return mid;
            }
        }
        return -(fromIndex + 1);
    }

    // 7) static int binarySearch(float[] a, float key) - 1 балл
    public static int binarySearch(float[] a, float key) {
        return binarySearch(a, 0, a.length, key);
    }

    // 8) static int binarySearch(float[] a, int fromIndex, int toIndex, float key) - 2 балла
    public static int binarySearch(float[] a, int fromIndex, int toIndex, float key) {
        while (fromIndex < toIndex) {
            int mid = fromIndex + (toIndex - fromIndex) / 2;
            if (a[mid] < key) {
                fromIndex = mid + 1;
            } else if (a[mid] > key) {
                toIndex = mid;
            } else {
                return mid;
            }
        }
        return -(fromIndex + 1);
    }

    // 9) static int binarySearch(int[] a, int key)- 1 балл
    public static int binarySearch(int[] a, int key) {
        return binarySearch(a, 0, a.length, key);
    }

    // 10) static int binarySearch(int[] a, int fromIndex, int toIndex, int key)- 2 балла
    public static int binarySearch(int[] a, int fromIndex, int toIndex, int key) {
        while (fromIndex < toIndex) {
            int mid = fromIndex + (toIndex - fromIndex) / 2;
            if (a[mid] < key) {
                fromIndex = mid + 1;
            } else if (a[mid] > key) {
                toIndex = mid;
            } else {
                return mid;
            }
        }
        return -(fromIndex + 1);
    }

    // 11) static int binarySearch(long[] a, long key) - 1 балл
    public static int binarySearch(long[] a, long key) {
        return binarySearch(a, 0, a.length, key);
    }

    // 12) static int binarySearch(long[] a, int fromIndex, int toIndex, long key) - 2 балла
    public static int binarySearch(long[] a, int fromIndex, int toIndex, long key) {
        while (fromIndex < toIndex) {
            int mid = fromIndex + (toIndex - fromIndex) / 2;
            if (a[mid] < key) {
                fromIndex = mid + 1;
            } else if (a[mid] > key) {
                toIndex = mid;
            } else {
                return mid;
            }
        }
        return -(fromIndex + 1);
    }

    // 13) static int binarySearch(short[] a, short key)- 1 балл
    public static int binarySearch(short[] a, short key) {
        return binarySearch(a, 0, a.length, key);
    }

    // 14) static int binarySearch(short[] a, int fromIndex, int toIndex, short key) - 2
    public static int binarySearch(short[] a, int fromIndex, int toIndex, short key) {
        while (fromIndex < toIndex) {
            int mid = fromIndex + (toIndex - fromIndex) / 2;
            if (a[mid] < key) {
                fromIndex = mid + 1;
            } else if (a[mid] > key) {
                toIndex = mid;
            } else {
                return mid;
            }
        }
        return -(fromIndex + 1);
    }

    // 15) static int binarySearch(T[] a, T key, Comparator c) - 2 балла
    public static <T> int binarySearch(T[] a, T key, Comparator<? super T> c) {
        return binarySearch(a, 0, a.length, key, c);
    }

    // 16) static int binarySearch(T[] a, int fromIndex, int toIndex, T key, Comparator c) - 2 балла
    public static <T> int binarySearch(T[] a, int fromIndex, int toIndex, T key, Comparator<? super T> c) {
        while (fromIndex < toIndex) {
            int mid = fromIndex + (toIndex - fromIndex) / 2;
            int cmp = c.compare(a[mid], key);
            if (cmp < 0) {
                fromIndex = mid + 1;
            } else if (cmp > 0) {
                toIndex = mid;
            } else {
                return mid;
            }
        }
        return -(fromIndex + 1);
    }
}
