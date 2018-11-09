import java.util.ArrayList;
import java.util.Arrays;

public class IncludeExclude {

    public static void main(String[] args) {
        int M = 8;
        int[] arr = new int[M];
        for (int i=0; i<M; i++)
            arr[i] = i+1;
        ArrayList<String> ag = new ArrayList<>();
        printCombination(arr, M, 4, ag);
    }

    static void combinationUtil(int arr[], int n, int r, int index, int data[], int i, ArrayList<String> al) {
        if (index == r) {
            al.add(Arrays.toString(data));
            System.out.println(al.get(al.size()-1));
            return;
        }
        if (i >= n)
            return;
        data[index] = arr[i];
        combinationUtil(arr, n, r, index+1, data, i+1, al);
        combinationUtil(arr, n, r, index, data, i+1, al);
    }

    static void printCombination(int arr[], int n, int r, ArrayList<String> al) {
        int data[]=new int[r];
        combinationUtil(arr, n, r, 0, data, 0, al);
    }
}
