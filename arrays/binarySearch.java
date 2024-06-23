package arrays;

public class binarySearch {
    // binary search only work on sorted array and t.c = O(logn)
    public static int binaryS(int num[], int key) {
        int start = 0, end = num.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (num[mid] == key) {
                return mid;
            } else if (num[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }return -1;
    }

    public static void main(String[] args) {
        int number[] = { 1, 2, 3, 4, 5, 6, 7 };
        System.err.println("index:"+binaryS(number, 4));
    }
}
