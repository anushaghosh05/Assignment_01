import java.util.Arrays;
import java.util.Scanner;

public class ArrayTransformation {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            if (!sc.hasNextInt()) return;
            
            int n = sc.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }
            long k = sc.nextLong();

            long remainder = ((a[0] % k) + k) % k;
            for (int i = 1; i < n; i++) {
                if (((a[i] % k) + k) % k != remainder) {
                    System.out.println("-1");
                    return;
                }
            }

            Arrays.sort(a);
            long median = a[n / 2];
            long totalOperations = 0;

            for (long val : a) {
                totalOperations += Math.abs(val - median) / k;
            }

            System.out.println(totalOperations);
        }
    }
}
