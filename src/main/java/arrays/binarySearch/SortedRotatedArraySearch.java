package main.java.arrays.binarySearch;

public class SortedRotatedArraySearch {
    public static void main(String[] args) {
        int arr[] = {7, 8, 9, 1, 2, 3, 4, 5, 6};

        int target = 1;
        int index = new SortedRotatedArraySearch().rotatedBinarySearch(arr, target);
        System.out.println("Index of the target :" + target + " is :" + index);

        target = 3;
        index = new SortedRotatedArraySearch().rotatedBinarySearch(arr, 3);
        System.out.println("Index of the target :" + target + " is :" + index);

        target = 7;
        index = new SortedRotatedArraySearch().rotatedBinarySearch(arr, 7);
        System.out.println("Index of the target :" + target + " is :" + index);

        target = 6;
        index = new SortedRotatedArraySearch().rotatedBinarySearch(arr, 6);
        System.out.println("Index of the target :" + target + " is :" + index);

        target = 5;
        index = new SortedRotatedArraySearch().rotatedBinarySearch(arr, target);
        System.out.println("Index of the target :" + target + " is :" + index);





        int arr1[] = {3,1,2, 3,3,3,3};

        target = 2;
        boolean flag = new SortedRotatedArraySearch().rotatedDuplicateCheckBinarySearch(arr1, target);
        System.out.println("Target :" + target + " exists :" + flag);

        target = 23;
        flag = new SortedRotatedArraySearch().rotatedDuplicateCheckBinarySearch(arr1, target);
        System.out.println("Target :" + target + " exists :" + flag);

        target = 3;
        flag = new SortedRotatedArraySearch().rotatedDuplicateCheckBinarySearch(arr1, target);
        System.out.println("Target :" + target + " exists :" + flag);

    }

    //return the index of the searched element from the sorted rotated array
    //logic is to find data in the sorted part as data may/may not be available in the sorted half
    public int rotatedBinarySearch(int arr[], int target) {
        int high = arr.length - 1;
        int low = 0;
        int mid;
        while (low <= high) {
            mid = (high + low) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[low] <= arr[mid]) {//left half is sorted
                if (arr[low] <= target && target <= arr[mid]) {
                    //number lies between low and mid
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else { //right half is sorted , at any point in a rotated array on half is sorted
                if (arr[mid] <= target && target <= arr[high]) {
                    //number lies between high and mid
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

        }
        return -1;
    }

    //this logic is to handle multiple occurences of same number,
    // checks if number exists and returns true
    public boolean rotatedDuplicateCheckBinarySearch(int arr[], int target) {
        int high = arr.length - 1;
        int low = 0;
        int mid;
        while (low <= high) {
            mid = (high + low) / 2;
            if (arr[mid] == target) {
                return true;
            }
            if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
                //{ 3,1,2,3,3,3} low , target, mid all have same duplicate element
                low++;
                high--;
                continue;
            }
            if (arr[low] <= arr[mid]) {//left half is sorted
                if (arr[low] <= target && target <= arr[mid]) {
                    //number lies between low and mid
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else { //right half is sorted , at any point in a rotated array on half is sorted
                if (arr[mid] <= target && target <= arr[high]) {
                    //number lies between high and mid
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

        }
        return false;
    }

}
