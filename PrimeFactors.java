import java.util.*;

public class PrimeFactors {
    public static List<Integer> list(int n) {
        List<Integer> factors = new ArrayList<Integer>();
        while (n%2 == 0) { factors.add(2); n = n/2; }
        for (int i=3; i<=n/i; i+=2)
            while (n%i==0) { factors.add(i); n /= i; }
        if (n>1) factors.add(n);
        return factors;
    }
    public void printFactors(int n) {
        while (n%2 == 0) {
            System.out.println(2);
            n = n/2;
        }
        for (int i = 3; i <= Math.sqrt(n); i = i+2) {
            while (n%i == 0) {
                System.out.println(i);
                n = n/i;
            }
        }
        if (n > 2)
            System.out.println(n);
    }
}