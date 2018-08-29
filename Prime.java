public class Prime {
    private int max;
    private int[] p;

    Prime(int n) {
        this.max = n;
        this.p = new int[n + 1];
        for (int factor = 2; factor*factor <= n; factor++) {
            if (p[factor] == 0) {
                p[factor] = 1;
                for (int j = factor; factor*j <= n; j++) {
                    p[factor*j] = -1;
                }
            }
        }
    }

    public boolean isPrime(int a) {
        if ( a < 2 || a >= max) return false;
        return (this.p[a] == 1);
    }

    public int next(int n) {
        while (n <= this.max) {
            if (p[n] == 1)
                return n;
            n++;
        }
        return -1;
    }
}