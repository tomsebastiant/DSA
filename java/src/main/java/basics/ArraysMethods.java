package basics;

import java.util.Arrays;
import java.util.Random;

public class ArraysMethods {

    public static void main(String[] args) {

        int[] firstArray = getRandomArray(10);
        System.out.println(Arrays.toString(firstArray));        // Example: [3, 46, 11, 67, 90, 16, 19, 13, 11, 52]
        Arrays.sort(firstArray);                                // To sort elements
        System.out.println(Arrays.toString(firstArray));         // Prints the same random array in sorted order

        int[] secondArray = new int[10];
        System.out.println(Arrays.toString(secondArray));        // [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
        Arrays.fill(secondArray, 5);                             // To fill out elements
        System.out.println(Arrays.toString(secondArray));        // [5, 5, 5, 5, 5, 5, 5, 5, 5, 5]

        int[] thirdArray = getRandomArray(10);
        System.out.println(Arrays.toString(thirdArray));         // Example: [4, 24, 61, 55, 52, 41, 54, 97, 65, 77]

        int[] fourthArray = Arrays.copyOf(thirdArray, thirdArray.length);   // To make copies of arrays
        System.out.println(Arrays.toString(fourthArray));        // Same values as thirdArray

        Arrays.sort(fourthArray);
        System.out.println(Arrays.toString(thirdArray));         // Original thirdArray remains unchanged
        System.out.println(Arrays.toString(fourthArray));        // Sorted copy of thirdArray

        int[] smallerArray = Arrays.copyOf(thirdArray, 5);      // while making copies
        System.out.println(Arrays.toString(smallerArray));       // First 5 values from thirdArray

        int[] largerArray = Arrays.copyOf(thirdArray, 15);
        System.out.println(Arrays.toString(largerArray));        // thirdArray values followed by 5 zeroes

        String[] sArray = {"Able", "Jane", "Mark", "Ralph", "David"};
        Arrays.sort(sArray);
        System.out.println(Arrays.toString(sArray));             // [Able, David, Jane, Mark, Ralph]
        int markPosition = Arrays.binarySearch(sArray, "Mark");
        if (markPosition >= 0) {
            System.out.println("Found Mark at position " + markPosition); // Found Mark at position 3
        }

        int[] s1 = {1, 2, 3, 4, 5, 0};
        int[] s2 = {1, 2, 3, 4, 5, 0};

        if (Arrays.equals(s1, s2)) {
            System.out.println("Arrays are equal");              // Arrays are equal
        } else {
            System.out.println("Arrays are not equal");          // Arrays are not equal
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
}
