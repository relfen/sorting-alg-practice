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
            insertionSort(intArr, intArr.length);
        }
    }

    private static void insertionSort(int[] intArr, int numItems){
        if(numItems < 2){
            return;
        }

        insertionSort(intArr, numItems - 1);

        int idx = numItems - 1;
        int j;
        int elementVal = intArr[idx];
        for(j = idx; j > 0; j--){
            if(elementVal < intArr[j-1]){
                intArr[j] = intArr[j-1];
            } else {
                break;
            }
        }
        intArr[j] = elementVal;
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

    public static void mergeSort(int[] intArr, boolean ascending){
        if(intArr.length > 1){
            mergeSort(intArr, 0, intArr.length, ascending);
        }
    }

    private static void mergeSort(int[] intArr, int start, int end, boolean ascending){
        if (end - start < 2){
            return;
        }

        // Find the middle of the array, so it can be split into left/right
        int middle = (start + end) / 2;

        // Left side
        mergeSort(intArr, start, middle, ascending);

        // Right side
        mergeSort(intArr, middle, end, ascending);

        // Merge each of the sorted arrays
        mergeSortedArray(intArr, start, middle, end, ascending);
    }

    private static void mergeSortedArray(int[] intArr, int start, int middle, int end, boolean ascending){
        if(ascending && intArr[middle - 1] <= intArr[middle]){
            return;
        } else if (!ascending && intArr[middle - 1] >= intArr[middle]) {
            return;
        }

        int[] tempArr = new int[end - start];
        int i = start;
        int j = middle;
        int tempArrIdx = 0;

        while(i < middle && j < end){
            if((ascending && intArr[i] <= intArr[j]) || !ascending && intArr[i] >= intArr[j]){
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
            intArr[copyIdx++] = intArr[i++];
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

    public static void printArray(int[] intArr) {
        for(int i : intArr){
            System.out.print(i);
        }
        System.out.println();
    }

    public static void countingSort(int[] intArr, int min, int max){
        if(min >= max) {
            System.out.println("The min value cannot be greater than or equal to max value.");
            return;
        } else if (min < 0){
            System.out.println("The value for 'min' arg must be a positive value.");
            return;
        }

        if(intArr.length > 0){
            int range = (max - min) + 1;
            int[] countArr = new int[range];

            // Populate the count array with a count of each value in the range from min to max
            for(int i : intArr) {
                // Support relative positioning in order to support ranges that don't start at 0
                int pos = i - min;
                countArr[pos]++;
            }

            int i = 0;
            int curVal = min;
            for(int count : countArr){
                while(count > 0){
                    intArr[i++] = curVal;
                    --count;
                }
                curVal++;
            }
        }
    }

    public static void radixSort(int[] intArr, int radix, int width){
        if(intArr.length > 1){
            for(int i = 0; i < width; i++){
                radixPositionSort(intArr, i, radix);
            }
        }
    }

    private static void radixPositionSort(int[] intArr, int pos, int radix) {
        int numItems = intArr.length;
        int[] countArray = new int[radix];

        // Track number of occurrence of each digit
        for(int value: intArr){
            countArray[getDigit(pos, value, radix)]++;
        }

        // Add up adjacent counts to give a total for each digit position, summed by its siblings
        // i.e. position 2 = position 1 + position 0; position 3 = position 2 + position 1 + position 0;
        for(int i = 1; i < countArray.length; i++){
            countArray[i] += countArray[i-1];
        }

        // Going from right to left, copy the full values from our source array, into a temp array
        // These will go in order based on position and will be stable.
        int[] temp = new int[numItems];
        for(int j = numItems - 1; j >= 0; j--){
            int digit = getDigit(pos, intArr[j], radix);
            int count = --countArray[digit];
            temp[count] = intArr[j];
        }

        // Move all the temp positions back to the source array
        System.arraycopy(temp, 0, intArr, 0, intArr.length);

    }

    private static int getDigit(int pos, int value, int radix) {
        return (value / (int) Math.pow(radix, pos)) % radix;
    }
}
