public class Between2Sets {
    public static int getTotalX(int[] a, int[] b) {
        // Complete this function
        int[] p = new int[b[0]+1];
        for (int i=0; i<a.length; i++) {
            int n = a[a.length-1] - a[a.length - 1] % a[i];
            while (n <= b[0]) {
                p[n]++; 
                n += a[i];
            }
        }
        int res = 0;
        for (int i=a[a.length-1]; i<=b[0]; i++) {
            boolean fac = true;
            if (p[i]==a.length) {
                for (int j=0; j<b.length; j++) {
                    if (b[j]%i==0) continue;
                    fac = false;
                    break;
                }
                if (fac) res++;
            }
        }
        return res;
    }
}