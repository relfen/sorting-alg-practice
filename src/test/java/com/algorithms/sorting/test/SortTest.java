package com.algorithms.sorting.test;

import com.algorithms.sorting.Sort;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SortTest {
    int[] testArr;
    int[] sortedArr = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    @Test
    public void testBubbleSort()
    {
        testArr = new int[] {4, 7, 1, 9, 0, 8, 6, 3, 2, 5};
        Sort.bubbleSort(testArr);

        assertArrayEquals(sortedArr, testArr);
    }

    @Test
    public void testSelectionSort()
    {
        testArr = new int[] {4, 7, 1, 9, 0, 8, 6, 3, 2, 5};
        Sort.selectionSort(testArr);

        assertArrayEquals(sortedArr, testArr);
    }

    @Test
    public void testInsertionSort()
    {
        testArr = new int[] {4, 7, 1, 9, 0, 8, 6, 3, 2, 5};
        Sort.insertionSort(testArr);

        assertArrayEquals(sortedArr, testArr);
    }

    @Test
    public void testShellInsertionSort()
    {
        testArr = new int[] {4, 7, 1, 9, 0, 8, 6, 3, 2, 5};
        Sort.shellSort(testArr);

        assertArrayEquals(sortedArr, testArr);
    }

    @Test
    public void testMergeSort()
    {
        testArr = new int[] {4, 7, 1, 9, 0, 8, 6, 3, 2, 5};
        Sort.mergeSort(testArr);

        assertArrayEquals(sortedArr, testArr);
    }

    @Test
    public void testQuickSort()
    {
        testArr = new int[] {4, 7, 1, 9, 0, 8, 6, 3, 2, 5};
        Sort.quickSort(testArr);
        Sort.printArray(testArr);

        assertArrayEquals(sortedArr, testArr);
    }

}
