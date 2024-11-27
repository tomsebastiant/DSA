package basics;

import java.util.Arrays;
import java.util.Random;

public class ArraysMethods {

    public static void main(String[] args) {

        int[] firstArray = getRandomArray(10);
        System.out.println(Arrays.toString(firstArray));
        Arrays.sort(firstArray);                                // To sort elements
        System.out.println(Arrays.toString(firstArray));

        int[] secondArray = new int[10];
        System.out.println(Arrays.toString(secondArray));
        Arrays.fill(secondArray, 5);                        // To fill out elements
        System.out.println(Arrays.toString(secondArray));

        int[] thirdArray = getRandomArray(10);
        System.out.println(Arrays.toString(thirdArray));

        int[] fourthArray = Arrays.copyOf(thirdArray, thirdArray.length);   // To make copies of arrays
        System.out.println(Arrays.toString(fourthArray));

        Arrays.sort(fourthArray);
        System.out.println(Arrays.toString(thirdArray));
        System.out.println(Arrays.toString(fourthArray));

        int[] smallerArray = Arrays.copyOf(thirdArray, 5);      // while making copies
        System.out.println(Arrays.toString(smallerArray));

        int[] largerArray = Arrays.copyOf(thirdArray, 15);
        System.out.println(Arrays.toString(largerArray));

        String[] sArray = {"Able", "Jane", "Mark", "Ralph", "David"};
        Arrays.sort(sArray);
        System.out.println(Arrays.toString(sArray));
        if (Arrays.binarySearch(sArray, "Mark") >= 0) {
            System.out.println("Found Mark in the list");
        }

        int[] s1 = {1, 2, 3, 4, 5, 0};
        int[] s2 = {1, 2, 3, 4, 5, 0};

        if (Arrays.equals(s1, s2)) {
            System.out.println("Arrays are equal");
        } else {
            System.out.println("Arrays are not equal");
        }
    }

    private static int[] getRandomArray(int len) {

        Random random = new Random();
        int[] newInt = new int[len];
        for (int i = 0; i < len; i++) {
            newInt[i] = random.nextInt(100);        //Random elements from 0-99 are assigned
        }

        return newInt;
    }

    /*
    [3, 46, 11, 67, 90, 16, 19, 13, 11, 52]
    [3, 11, 11, 13, 16, 19, 46, 52, 67, 90]
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
    [5, 5, 5, 5, 5, 5, 5, 5, 5, 5]
    [4, 24, 61, 55, 52, 41, 54, 97, 65, 77]
    [4, 24, 61, 55, 52, 41, 54, 97, 65, 77]
    [4, 24, 61, 55, 52, 41, 54, 97, 65, 77]
    [4, 24, 41, 52, 54, 55, 61, 65, 77, 97]
    [4, 24, 61, 55, 52]
    [4, 24, 61, 55, 52, 41, 54, 97, 65, 77, 0, 0, 0, 0, 0]
    [Able, David, Jane, Mark, Ralph]
    Found Mark in the list
    Arrays are equal
     */

}
