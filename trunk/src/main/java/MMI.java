
public class MMI {
	public static int getMMI(int f1, int r) {
		int f2 = 0;
		int k = 1;
		do {
			f2 = (k * r + 1) / f1;
			int m = (k * r + 1) % f1;
			k++;
			if (m == 0)
				break;
		} while (true);

		return f2;
	}
}
