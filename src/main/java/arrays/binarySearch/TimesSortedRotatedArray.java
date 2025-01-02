package main.java.arrays.binarySearch;

public class TimesSortedRotatedArray {
    public static void main(String[] args) {
        int arr[] = {7, 8, 9, 1, 2, 3, 4, 5, 6};


        int min = new TimesSortedRotatedArray().minimumInRotatedBinarySearch(arr);
        System.out.println("The array has been rotated  :" + min);
    }

    //return the index of minimum element from the sorted rotated array
    //this specifies how many times array has been rotated
    //logic is to find data in the sorted part as data may/may not be available in the sorted half
    public int minimumInRotatedBinarySearch(int arr[]) {
        int high = arr.length - 1;
        int low = 0;
        int min = high;
        int mid;
        while (low <= high) {
            mid = (high + low) / 2;
            if (arr[low] <= arr[mid]) {//left half is sorted
                if (arr[low] < arr[min]) {
                    min = low;
                }
                low = mid + 1; //check in the other half after calculating min
            } else { //right half is sorted , at any point in a rotated array on half is sorted
                if (arr[mid] < arr[min]) {
                    min = low;
                }
                high = mid - 1; //check in the other half after calculating min
            }

        }
        return min;
    }


}
