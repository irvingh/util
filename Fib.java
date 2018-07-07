
public class Fib {
    long[] res;
    public long fibo(int n) {
        if (n<=1)
            return n;
        return fibo(n-1) + fibo(n-2);
    }
    public long fiboTB(int n) {
        if (n<=1) 
            return n;
        if (res==null)
            res = new long[n+1];
        if (res[n]==0)
            res[n] = fiboTB(n-1) + fiboTB(n-2);
        return res[n];
    }
    public long fiboBU(int n) {
		res = new long[n+1];
		res[0] = 0; res[1] = 1;
		for (int i=2; i<=n; i++)
			res[i] = res[i-1] + res[i-2];
		return res[n];
	}
}