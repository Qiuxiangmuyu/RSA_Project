
public class Mod {
	public static int getMod(int s, int f, int N) {
		if (f > 1)
			return getMod(getMod(s, f - 1, N) * getMod(s, 1, N), 1, N);
		else
			return s % N;
	}

	public static int getModLoop(int s, int f, int N) {
		int temp = ((s % N) * (s % N)) % N;
		for (int i = 2; i != f; i++) {
			temp = ((temp % N) * (s % N)) % N;
		}
		return temp;
	}
}
