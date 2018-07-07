public class Power {
    final static int M = 1000000009; 
    public static int pow(long a, int b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = ((res*a)%M);
            }
            b >>= 1;
            a = ((a*a)%M);
        }
        return ((int)res);
    }
}