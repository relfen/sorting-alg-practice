package com.algorithms.sorting;

public class Sort {

    public static void bubbleSort(int[] intArr){
        int end = intArr.length - 1;

        if (end > 0){
            for(int i = 0; i < end; i++){
                for(int j = i+1; j <= end; j++){
                    if (intArr[i] > intArr[j]){
                        int temp = intArr[i];
                        intArr[i] = intArr[j];
                        intArr[j] = temp;
                    }
                }
            }
        }
    }

    public static void selectionSort(int[] intArr){
        int end = intArr.length - 1;

        if (end > 0) {
            int max = 0;

            for(int i = 1; i <= end; i++){
                if(intArr[i] > intArr[max]){
                    max = i;
                }
                if(i == end){
                    if(max != end){
                        int temp = intArr[end];
                        intArr[end] = intArr[max];
                        intArr[max] = temp;
                    }

                    // reset indexers
                    end--;
                    i = 0;
                    max = 0;
                }
            }
        }
    }

    public static void insertionSort(int[] intArr){
        if (intArr.length > 1) {
            for(int i = 1; i < intArr.length; i++){
                int elementVal = intArr[i];
                int j;

                for(j = i; j > 0; j--){
                    if(elementVal < intArr[j-1]){
                        intArr[j] = intArr[j-1];
                    } else {
                        break;
                    }
                }
                intArr[j] = elementVal;
            }
        }
    }

    public static void shellSort(int[] intArr){
        if (intArr.length > 1) {
            int gap = intArr.length / 2;

            while(gap > 0) {
                for (int i = gap; i < intArr.length; i++) {
                    int elementVal = intArr[i];
                    int j;

                    for (j = i; j - gap >= 0; j -= gap) {
                        if (elementVal < intArr[j - gap]) {
                            intArr[j] = intArr[j - gap];
                        } else {
                            break;
                        }
                    }
                    intArr[j] = elementVal;
                }
                gap /= 2;
            }
        }
    }

    public static void mergeSort(int[] intArr){
        if(intArr.length > 1){
            mergeSort(intArr, 0, intArr.length);
        }
    }

    private static void mergeSort(int[] intArr, int start, int end){
        if (end - start < 2){
            return;
        }

        // Find the middle of the array, so it can be split into left/right
        int middle = (start + end) / 2;

        // Left side
        mergeSort(intArr, start, middle);

        // Right side
        mergeSort(intArr, middle, end);

        // Merge each of the sorted arrays
        mergeSortedArray(intArr, start, middle, end);
    }

    private static void mergeSortedArray(int[] intArr, int start, int middle, int end){
        if(intArr[middle - 1] <= intArr[middle]){
            return;
        }

        int[] tempArr = new int[end - start];
        int i = start;
        int j = middle;
        int tempArrIdx = 0;

        while(i < middle && j < end){
            if(intArr[i] <= intArr[j]){
                tempArr[tempArrIdx] = intArr[i];
                i++;
            } else {
                tempArr[tempArrIdx] = intArr[j];
                j++;
            }
            tempArrIdx++;
        }
        int copyIdx = start + tempArrIdx;
        while(i < middle) {
            intArr[copyIdx++] =  intArr[i++];
        }

        int l = 0;
        for(int k = start; k < end && l < tempArrIdx; k++){
            intArr[k] = tempArr[l++];
        }
    }

    public static void quickSort(int[] intArr){
        if(intArr.length > 1){
            int start = 0;
            int end = intArr.length-1;

            quickSort(intArr, start, end);
        }
    }

    private static void quickSort(int[] intArr, int start, int end){
        if(end <= start){
            return;
        }

        int pivotIdx = partition(intArr, start, end);
        quickSort(intArr, start, pivotIdx-1);
        quickSort(intArr, pivotIdx+1, end);
    }

    private static int partition(int[] intArr, int start, int end) {
        int pivot = intArr[end];
        int i = start-1;
        int j;

        for(j = start; j < end; j++){
            if(intArr[j] < pivot) {
                int temp = intArr[++i];
                intArr[i] = intArr[j];
                intArr[j] = temp;
            }
        }

        int temp = intArr[end];
        intArr[end] = intArr[++i];
        intArr[i] = temp;
        return i;
    }

    public static void printArray(int[] testArr) {
        for(int i : testArr){
            System.out.print(i);
        }
        System.out.println();
    }
}
