import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] words = {"apple", "banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango", "nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine", "blueberry", "watermelon"};

        // Word to search
        String target = "kiwi";

        // Perform sequential search
        long startTime = System.nanoTime();
        int sequentialComparisons = sequentialSearch(words, target);
        long endTime = System.nanoTime();
        long sequentialTime = endTime - startTime;

        System.out.println("Sequential Search:");
        System.out.println("Comparisons: " + sequentialComparisons);
        System.out.println("Time (nanoseconds): " + sequentialTime);

        // Sort the array for binary search
        Arrays.sort(words);

        // Perform binary search
        startTime = System.nanoTime();
        int binaryComparisons = binarySearch(words, target);
        endTime = System.nanoTime();
        long binaryTime = endTime - startTime;

        System.out.println("\nBinary Search:");
        System.out.println("Comparisons: " + binaryComparisons);
        System.out.println("Time (nanoseconds): " + binaryTime);
    }

    public static int sequentialSearch(String[] array, String target) {
        int comparisons = 0;
        for (String word : array) {
            comparisons++;
            if (word.equals(target)) {
                return comparisons;
            }
        }
        return comparisons; // Return total comparisons even if not found
    }

    public static int binarySearch(String[] array, String target) {
        int left = 0;
        int right = array.length - 1;
        int comparisons = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            comparisons++;

            if (array[mid].equals(target)) {
                return comparisons;
            } else if (array[mid].compareTo(target) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return comparisons; // Return total comparisons even if not found
    }
}
