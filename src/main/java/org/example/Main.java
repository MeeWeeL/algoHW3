package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n\nArrays\n\n");

        test(1);
        test(2);
        test(5);
        test(10);
        test(20);
        test(50);
        test(100);
        test(1000);
        test(10000);
        test(100000);
        test(1000000);

        System.out.println("\n\nComparators\n\n");

        testObjects(5);
        testObjects(50);
        testObjects(500);
        testObjects(5000);
        testObjects(50000);
        testObjects(500000);
    }

    private static void testObjects(int arraySize) {
        System.out.println("List<ExampleObject> size: " + arraySize);
        List<ExampleInteger> list = createExampleIntegerList(arraySize);
        Random random = new Random();
        ArrayList<Long> timesList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            int randomInt = random.nextInt(list.size());
            long startTime = System.nanoTime();
            int searchIndex  = MyCollections.binarySearch(list, new ExampleInteger(randomInt));
            long endTime = System.nanoTime();
            timesList.add(endTime - startTime);
        }
        long sum = 0;
        for (Long time : timesList) {
            sum += time;
        }
        System.out.println("Average BINARY search time: " + sum / timesList.size() + " nanosecond");
    }

    private static void test(int arraySize) {
        int[] array = createIntArray(arraySize);
        System.out.println("Array size: " + arraySize);
        long simpleTime = testSearcher(array, SearchType.SIMPLE, arraySize);
        System.out.println("Average SIMPLE search time: " + simpleTime + " nanosecond");
        long binaryTime = testSearcher(array, SearchType.BINARY, arraySize);
        System.out.println("Average BINARY search time: " + binaryTime + " nanosecond");
    }

    private static long testSearcher(int[] array, SearchType searchType, int arraySize) {
        Random random = new Random();
        ArrayList<Long> timesList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            int randomInt = random.nextInt(array.length);
            long startTime = System.nanoTime();
            int searchIndex;
            switch (searchType) {
                case BINARY -> {
                    searchIndex = MyArrays.binarySearch(array, randomInt);
                }
                case SIMPLE -> {
                    searchIndex = simpleSearch(array, randomInt);
                }
            }
            long endTime = System.nanoTime();
            timesList.add(endTime - startTime);
        }
        long sum = 0;
        for (Long time : timesList) {
            sum += time;
        }
        return sum / timesList.size();
    }

    enum SearchType {
        SIMPLE, BINARY
    }

    private static void testBinarySearcher(int[] array) {
        Random random = new Random();
        ArrayList<Long> timesList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            int randomInt = random.nextInt(array.length);
            long startTime = System.nanoTime();
            int searchIndex = Arrays.binarySearch(array, randomInt);
            long endTime = System.nanoTime();
            timesList.add(endTime - startTime);
        }
        long sum = 0;
        for (Long time : timesList) {
            sum += time;
        }
        long averageTime = sum / timesList.size();
        System.out.println("Average time: " + averageTime + " nanosecond");
    }

    private static void testSimpleSearcher(int[] array) {
        System.out.println("Array: " + Arrays.toString(array));
        Random random = new Random();
        ArrayList<Long> timesList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            int randomInt = random.nextInt(array.length);
            System.out.println("Finding for: " + randomInt);
            long startTime = System.nanoTime();
            int searchItem = simpleSearch(array, randomInt);
            long endTime = System.nanoTime();
            System.out.println("Found item: " + array[searchItem]);
            timesList.add(endTime - startTime);
        }
        long sum = 0;
        for (Long time : timesList) {
            sum += time;
        }
        long averageTime = sum / timesList.size();
        System.out.println("Average time: " + averageTime + " nanosecond");
    }

    private static int[] createIntArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        return array;
    }

    private static int[] createRandomIntArray(int size) {
        Random random = new Random();
        ArrayList<Integer> donorList = new ArrayList<>();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            donorList.add(i);
        }
        for (int i = 0; i < size; i++) {
            int randomIndex = random.nextInt(donorList.size());
            int number = donorList.remove(randomIndex);
            array[i] = number;
        }
        return array;
    }

    private static List<ExampleInteger> createExampleIntegerList(int size) {
        List<ExampleInteger> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(new ExampleInteger(i));
        }
        return list;
    }

    static class ExampleInteger implements Comparable<ExampleInteger> {
        int a;
        int b;
        int c;

        ExampleInteger(int a) {
            this.a = a;
            this.b = a + 1;
            this.c = a - 1;
        }

        @Override
        public String toString() {
            return Integer.toString(a + b + c);
        }

        @Override
        public int compareTo(ExampleInteger other) {
            return Integer.compare(this.a, other.a);
        }
    }

    public static int simpleSearch(int[] a, int key) {
        int result = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key) {
                result = i;
                break;
            }
        }
        return result;
    }
}