package misc;

public class Bisect {
    static int lowerBound(int x, int[] arr) {
        int low = 0, high = arr.length;
        while (low < high - 1) {
            int mid = (low + high) / 2;
            if (x <= arr[mid]) {
                high = mid;
            } else if (x > arr[mid]) {
                low = mid;
            }
        }
        return arr[low] < x ? high : low;
    }

    static int higherBound(int x, int[] arr) {
        int low = 0, high = arr.length;
        while (low < high - 1) {
            int mid = (low + high) / 2;
            if (x < arr[mid]) {
                high = mid;
            } else if (x >= arr[mid]) {
                low = mid;
            }
        }
        return arr[high] > x ? low : high;
    }
}
