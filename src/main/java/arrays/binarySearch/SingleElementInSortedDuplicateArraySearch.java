package main.java.arrays.binarySearch;

public class SingleElementInSortedDuplicateArraySearch {
    public static void main(String[] args) {
        int arr[] = {1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6};


        int uniqueElement = new SingleElementInSortedDuplicateArraySearch().findUniqueElementInDuplicateSortedArray(arr);
        System.out.println("Unique element is :" + uniqueElement);

        int arr1[] = {1, 1, 2, 2, 3, 3, 4,4, 5, 5, 6, 6};
        uniqueElement = new SingleElementInSortedDuplicateArraySearch().findUniqueElementInDuplicateSortedArray(arr1);
        System.out.println("Unique element is :" + uniqueElement);
    }

    //return the unique element that occurs once
    //logic : before the unique element - all data is duplicate in E, O
    // after the unique element - all data is duplicate in O,E
    // for unique elemenet identification - element-1 and +1 are not same to the element
    public int findUniqueElementInDuplicateSortedArray(int arr[]) {
        int high = arr.length - 1;
        int low = 0;
        int mid;
        //edge cases
        if (arr.length == 1) {
            return arr[0];
        }
        if (arr[0] != arr[1]) {
            return arr[0];
        }
        if (arr[arr.length - 1] != arr[arr.length - 2]) {
            return arr[arr.length - 1]; //last element is unique
        }

        while (low <= high && low != arr.length -1) {
            // low != arr.length -1 is to handle line 37 Index out of bounds
            mid = (high + low) / 2;
            if (arr[mid] != arr[mid + 1] && arr[mid] != arr[mid - 1]) {
                return arr[mid]; //unique element
            }
            if ((mid % 2 == 1 && arr[mid] == arr[mid - 1]) || (mid % 2 == 0 && arr[mid] == arr[mid + 1])) {
                    /* you are standing at odd index and even (previous) index is same element
                    or
                    you are standing at even index and odd (next index) index is same element ,
                    then this is a duplicate element , check the other half after mid
                     */
                low = mid + 1;

            } else {
                high = mid - 1;
            }

        }
        return -1;
    }


}
