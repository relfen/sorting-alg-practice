package com.algorithms.sorting.test;

import com.algorithms.sorting.Sort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SortTest {
    int[] testArr;
    int[] sortedArr = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    @BeforeEach
    public void init(){
        testArr = new int[] {4, 7, 1, 9, 0, 8, 6, 3, 2, 5};
    }

    @Test
    public void testBubbleSort()
    {
        Sort.bubbleSort(testArr);
        assertArrayEquals(sortedArr, testArr);
    }

    @Test
    public void testSelectionSort()
    {
        Sort.selectionSort(testArr);
        assertArrayEquals(sortedArr, testArr);
    }

    @Test
    public void testInsertionSort()
    {
        Sort.insertionSort(testArr);
        assertArrayEquals(sortedArr, testArr);
    }

    @Test
    public void testShellInsertionSort()
    {
        Sort.shellSort(testArr);
        assertArrayEquals(sortedArr, testArr);
    }

    @Test
    public void testMergeSort()
    {
        Sort.mergeSort(testArr);
        assertArrayEquals(sortedArr, testArr);
    }

    @Test
    public void testQuickSort()
    {
        Sort.quickSort(testArr);
        assertArrayEquals(sortedArr, testArr);
    }

}
