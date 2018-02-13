package arrays;

public class Sort {

    /* BUBBLE SORT
     * only supports integer arrays
     */
    public static int[] bubbleSort(int[] array) {
        boolean sorted;

        if(array.length < 2) {
            return array;
        }

        // do at least once or until sorted
        do {
            sorted = true;
            // iterate through array
            for (int i = 1; i < array.length; i++) {
                // check if a pair is in the correct order
                if (array[i] >= array[i - 1]) {
                    continue;
                } else {
                    // swap if they are not
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                    sorted = false;
                }
            }
        } while (!sorted);

        return array;
    }

    /* INSERTION SORT
     * only supports integer arrays
     */
    public static int[] insertionSort(int[] array) {

        // iterate through original array
        for (int i = 1; i < array.length; i++) {
            int num = array[i];
            int j = i - 1;

            // push back to make room for num
            while (j >= 0 && array[j] > num) {
                array[j + 1] = array[j];
                j--;
            }

            // insert num
            array[j + 1] = num;
        }

        return array;
    }

    /* SELECTION SORT
     * only supports integer arrays
     */
    public static int[] selectionSort(int[] array) {
        int sorted = 0;

        // iterate until array is sorted
        while (sorted < array.length - 1) {
            int min = array[sorted];

            // find minimum item in unsorted portion of array
            for (int i = sorted; i < array.length; i++) {
                if (array[i] < array[min]) { min = i; }
            }

            // swap minimum item to front
            int temp = array[sorted];
            array[sorted] = array[min];
            array[min] = temp;

            sorted ++;
        }

        return array;
    }
}
