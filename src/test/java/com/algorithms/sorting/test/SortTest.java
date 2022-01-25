package com.algorithms.sorting.test;

import com.algorithms.sorting.Sort;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortTest {
    int[] testArr;
    int[] sortedArr = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    private final ByteArrayOutputStream testOut = new ByteArrayOutputStream();
    private static final PrintStream stdOut = System.out;

    @BeforeEach
    public void init(){
        testArr = new int[] {4, 7, 1, 9, 0, 8, 6, 3, 2, 5};
    }

    @BeforeEach
    public void setupStreams(){
        System.setOut(new PrintStream(testOut));
    }

    @AfterAll
    public static void restoreStreams(){
        System.setOut(stdOut);
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

    @Test
    public void testCountingSortValid()
    {
        Sort.countingSort(testArr, 0, 9);
        assertArrayEquals(sortedArr, testArr);
    }

    @Test
    public void testCountingSortInvalidLow()
    {
        Sort.countingSort(testArr, -1, 9);
        String out = "The value for 'low' and 'high' args, must be positive values.\n";
        assertEquals(out, this.testOut.toString());
    }

    @Test
    public void testCountingSortInvalidRange()
    {
        Sort.countingSort(testArr, 5, 4);
        String out = "The low value cannot be greater than or equal to high value.\n";
        assertEquals(out, this.testOut.toString());
    }
}
