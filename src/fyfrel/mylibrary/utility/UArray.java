package fyfrel.mylibrary.utility;

public class UArray {
    /**
     * Remove all occurrences of an element in an array
     * @param arrayBase array int
     * @param toDelete int value to search and delete from array
     * @return the array clean of all occurrences of the unwanted element
     */
    public static int[] delElement(int[] arrayBase, int toDelete) {
        for (int i = 0; i < arrayBase.length; i++) {
            if(arrayBase[i] == toDelete) {
                arrayBase = UArray.delIndex(arrayBase, i);
                return UArray.delElement(arrayBase, toDelete, i);
            }
        }
        return arrayBase;
    }

    /**
     * Remove all occurrences of an element in an array
     * @param arrayBase array int
     * @param toDelete int value to search and delete from array
     * @return the array clean of all occurrences of the unwanted element
     */
    private static int[] delElement(int[] arrayBase, int toDelete, int index) {
        for (int i = index; i < arrayBase.length; i++) {
            if(arrayBase[i] == toDelete) {
                arrayBase = UArray.delIndex(arrayBase, i);
                return UArray.delElement(arrayBase, toDelete, i);
            }
        }
        return arrayBase;
    }

    /**
     * Return an array without the value at the choosed index
     * @param arrayBase base array int
     * @param index index to remove
     * @return an array without the value at the choosed index
     */
    public static int[] delIndex(int[] arrayBase, int index) {
        int[] newArr = new int[arrayBase.length-1];
        Boolean passed = false;
        for (int i = 0; i < arrayBase.length; i++) {
            newArr[passed ? i-1 : i] = arrayBase[i];
            if(i == index) {
                passed = true;
            }
        }
        return newArr;
    }

    /**
     * Merge two sorted array into one big sorted array
     * @param arrayOne array int
     * @param arrayTwo array int
     * @return an array with the two sorted array
     */
    public static int[] mergeOrderedArray(int[] arrayOne, int[] arrayTwo) {
        int[] mergedArr = new int[arrayOne.length + arrayTwo.length];
        int i = 0, j = 0, k = 0;
        while (i < arrayOne.length && j < arrayTwo.length) {
            if (arrayOne[i] < arrayTwo[j]) {
                mergedArr[k++] = arrayOne[i++];
            } else {
                mergedArr[k++] = arrayTwo[j++];
            }
        }
        while (i < arrayOne.length) {
            mergedArr[k++] = arrayOne[i++];
        }
        while (j < arrayTwo.length) {
            mergedArr[k++] = arrayTwo[j++];
        }
        return mergedArr;
    }

    /**
     * Merge two array into one big sorted array
     * @param arrayOne array int
     * @param arrayTwo array int
     * @return an array with the two array
     */
    public static int[] mergeUnorderedArray(int[] arrayOne, int[] arrayTwo) {
        int[] mergedArr = new int[arrayOne.length + arrayTwo.length];
        int it = 0;
        for (int i = 0; i < arrayOne.length; i++) {
            mergedArr[it] = arrayOne[i];
            it++;
        }
        for (int i = 0; i < arrayTwo.length; i++) {
            mergedArr[it] = arrayTwo[i];
            it++;
        }
        return mergedArr;
    }

    /**
     * Search the index of a value in an array
     * @param arrayToSearch array int
     * @param toSearch an int to search the index in the array
     * @return the index
     */
    public static int searchIndexOf(int[] arrayToSearch, int toSearch) {
        return UArray.searchIndexOf(arrayToSearch, toSearch, 0, arrayToSearch.length);
    }

    /**
     * Search the index of a value in an array
     * @param arrayToSearch array int
     * @param toSearch an int to search the index in the array
     * @param startAt first index of the array
     * @param length last index of the array plus 1
     * @return
     */
    public static int searchIndexOf(int[] arrayToSearch, int toSearch, int startAt, int length) {
        try {
            if (arrayToSearch[(length - startAt) / 2 + startAt] != toSearch) {
                if (arrayToSearch[(length - startAt) / 2 + startAt] < toSearch) {
                    return searchIndexOf(arrayToSearch, toSearch, (length - startAt) / 2 + startAt, length);
                } else {
                    return searchIndexOf(arrayToSearch, toSearch, startAt, (length - startAt) / 2 + startAt);
                }
            } else {
                return (length - startAt) / 2 + startAt;
            }
        } catch(Exception e) {
            return -1;
        }
    }
}
