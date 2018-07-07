public class Pyramid {
    int cubeCount(int h, int l) {
        if (h==0) return 0;
        int tot = l*l + cubeCount(h-1, l+2); 
        return tot;
    }
}