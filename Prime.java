public class Prime {
    private int n;
    private int[] p;
    public  Prime (int n) {
        this.n = n;
        this.p = new int[n+1];
        for (int factor=2; factor*factor<=n; factor++) {
            if (p[factor]==0) {
                p[factor] = 1;
                for (int j=factor; factor*j <= n; j++) {
                    p[factor*j] = -1;
                }
            }
        }
    }
    public boolean isPrime(int a) {
        if (a<2 || a>=n) return false;
        return (this.p[a]==1);
    }
}