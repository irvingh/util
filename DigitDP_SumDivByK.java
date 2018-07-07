
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DigitDP_SumDivByK {
	static int K;
	static Integer[] digits;
	static int[][][] dp = new int[12][2][83];
	static int count = 0;
	public static int solve(int n, int k) {
		K = k;
		for (int i=0; i<12; i++)
			for (int j=0; j<2; j++)
				for (int l=0; l<83; l++)
					dp[i][j][l] = -1;
		digits = parse(n);
		dpSolve(0, true, 0);
		return count;
	}
	public static Integer[] parse(int n) {
		List<Integer> dig = new ArrayList<>();
		while (n != 0) { dig.add(n % 10); n /= 10; }
		Collections.reverse(dig);
		return dig.toArray(new Integer[dig.size()]);
	}
	public static int dpSolve(int index, boolean smaller, int reminder) {
		if (index==digits.length)
			return (reminder==0 ? 1 : 0);
		if (dp[index][(smaller ? 1 : 0)][reminder]!=-1)
			return dp[index][(smaller ? 1 : 0)][reminder];
		int limit = (smaller ? digits[index] : 9);
		int init_count = 0;
		for (int d=0; d<=limit; d++) {
			if (d<digits[index])
				smaller = false;
			init_count += dpSolve(index+1, smaller, (reminder+d)%K);
		}
		dp[index][(smaller ? 1 : 0)][reminder] = init_count;
		return init_count;
	}
}
