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
    int[] sortedArrDesc = new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
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
    public void testMergeSortAsc()
    {
        Sort.mergeSort(testArr, true);
        assertArrayEquals(sortedArr, testArr);
    }

    @Test
    public void testMergeSortDesc()
    {
        Sort.mergeSort(testArr, false);
        assertArrayEquals(sortedArrDesc, testArr);
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
        String out = "The value for 'min' arg must be a positive value.\n";
        assertEquals(out, this.testOut.toString());
    }

    @Test
    public void testCountingSortInvalidRange()
    {
        Sort.countingSort(testArr, 5, 4);
        String out = "The min value cannot be greater than or equal to max value.\n";
        assertEquals(out, this.testOut.toString());
    }

    @Test
    public void testRadixIntSort()
    {
        int[] intArr = new int[] {123, 778, 243, 555, 100, 277, 701, 444};
        int[] sortedArr = new int[] {100, 123, 243, 277, 444, 555, 701, 778};
        Sort.radixSort(intArr, 10, 3);
        assertArrayEquals(sortedArr, intArr);
    }

    @Test
    public void testRadixStringSort()
    {
        String[] strings = new String[] {"chat", "food", "aabb", "zzaz", "fool", "back", "kloc"};
        String[] sortedArr = new String[] {"aabb", "back", "chat", "food", "fool", "kloc", "zzaz"};
        Sort.radixSort(strings, 26, 4);
        assertArrayEquals(sortedArr, strings);
    }
}
