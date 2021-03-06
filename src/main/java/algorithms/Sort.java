package algorithms;

public class Sort {

    /**
     * Sorts an array using Bubble Sort
     * @param array to be sorted
     * @param <N> any Number Object
     * @return the sorted array
     */
    public static <N extends Number> N[] bubbleSort(N[] array) {

        long startTime = System.nanoTime();

        if (array.length < 2) {
            return array;
        }

        // iterate through array
        for (int i = 0; i < array.length; i++) {
            // iterate through unsorted array
            for (int j = 0; j < array.length - i - 1; j++) {
                // check if a pair is in the incorrect order
                if (array[j].doubleValue() > array[j + 1].doubleValue()) {
                    // swap
                    N temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }

        System.out.println("\nTime: " + (System.nanoTime() - startTime));

        return array;
    }

    /**
     * Sorts an array using Insertion Sort
     * @param array to be sorted
     * @param <N> any Number Object
     * @return the sorted array
     */
    public static <N extends Number> N[] insertionSort(N[] array) {

        long startTime = System.nanoTime();

        if (array.length < 2) {
            return array;
        }

        // iterate through original array
        for (int i = 1; i < array.length; i++) {
            N num = array[i];
            int j = i - 1;

            // push back to make room for num
            while (j >= 0 && array[j].doubleValue() > num.doubleValue()) {
                array[j + 1] = array[j];
                j--;
            }

            // insert num
            array[j + 1] = num;
        }

        System.out.println("\nTime: " + (System.nanoTime() - startTime));

        return array;
    }

    /**
     * Sorts an array using Selection Sort
     * @param array to be sorted
     * @param <N> any Number Object
     * @return the sorted array
     */
    public static <N extends Number> N[] selectionSort(N[] array) {

        long startTime = System.nanoTime();

        if (array.length < 2) {
            return array;
        }

        int sorted = 0;

        // iterate until array is sorted
        while (sorted < array.length - 1) {
            int min = sorted;

            // find minimum item in unsorted portion of array
            for (int i = sorted; i < array.length; i++) {
                if (array[i].doubleValue() < array[min].doubleValue()) { min = i; }
            }

            // swap minimum item to front
            N temp = array[sorted];
            array[sorted] = array[min];
            array[min] = temp;

            sorted ++;
        }

        System.out.println("\nTime: " + (System.nanoTime() - startTime));

        return array;
    }

    /**
     * Sorts an array using Merge Sort
     * @param array to be sorted
     * @param <N> any Number Object
     * @return the sorted array
     */
    public static <N extends Number> N[] mergeSort(N[] array) {

        long startTime = System.nanoTime();

        if (array.length < 2) {
            return array;
        }

        if (array.length > 1) {

            // get array sizes
            int leftSize = (int)Math.floor(array.length / 2.0);
            int rightSize = (int)Math.ceil(array.length / 2.0);

            // create sub arrays
            Number[] left = new Number[leftSize];
            Number[] right = new Number[rightSize];
            System.arraycopy(array, 0, left, 0, leftSize);
            System.arraycopy(array, leftSize, right, 0, rightSize);

            // recursively sort left
            left = mergeSort(left);

            // recursively sort right
            right = mergeSort(right);

            // merge
            int i = 0, j = 0;

            while (i < left.length && j < right.length) {
                if (left[i].doubleValue() < right[j].doubleValue()) {
                    array[i + j] = (N)left[i];
                    i++;
                } else {
                    array[i + j] = (N)right[j];
                    j++;
                }
            }

            while (i < left.length) {
                array[i + j] = (N)left[i];
                i++;
            }

            while (j < right.length) {
                array[i + j] = (N)right[j];
                j++;
            }
        }

        System.out.println("\nTime: " + (System.nanoTime() - startTime));

        return array;
    }


    /**
     * Sorts an array using Quick Sort
     * @param array to be sorted
     * @param boundaries used for recursion
     * @param <N> any Number Object
     * @return the sorted array
     */
    public static <N extends Number> N[] quickSort(N[] array, int ... boundaries) {

        long startTime = System.nanoTime();

        if (array.length < 2) {
            return array;
        }

        // start sorting algorithm
        if (boundaries.length < 2) {
            return quickSort(array,0,array.length - 1);
        }

        // base case
        if (array.length < 2) {
            return array;
        }

        // get center of current boundaries as pivot points
        double pivot = array[boundaries[0] + (boundaries[1] - boundaries[0]) / 2].doubleValue();

        // set incrementers to the current boundaries
        int left = boundaries[0], right = boundaries[1];

        // iterate towards center until boundary incrementers meet
        while (left < right) {

            // move left boundary to the right
            while (array[left].doubleValue() < pivot) {
                left++;
            }

            // move right boundary to the left
            while (array[right].doubleValue() > pivot) {
                right--;
            }

            // move elements to correct side of pivot
            if (left <= right) {
                // swap
                N temp = array[left];
                array[left] = array[right];
                array[right] = temp;

                // move both boundaries toward center once
                left++;
                right--;
            }
        }

        // recursive call if left boundary is less than new pivot point (right)
        if (boundaries[0] < right) {
            quickSort(array, boundaries[0], right);
        }
        // recursive call if right boundary is greater than new pivot point (left)
        if (boundaries[1] > left) {
            quickSort(array, left, boundaries[1]);
        }

        System.out.println("\nTime: " + (System.nanoTime() - startTime));

        return array;
    }
}
