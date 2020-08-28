package CautareBinara;
import java.util.Arrays;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int[] sir = new int[10];
		sir[0] = 12;
		sir[1] = 25;
		sir[2] = 47;
		sir[3] = 58;
		sir[4] = 47;
		sir[5] = 7;
		sir[6] = 96;
		sir[7] = 14;
		sir[8] = 3;
		sir[9] =9;
		Arrays.sort(sir);
		boolean a = false;
		int b = 0;
		System.out.println(java.util.Arrays.toString(sir));
		System.out.println("Introduceti numarul cautat :");
		int p = scanner.nextInt();
		CautareBinara(sir, p);
	}
	static boolean CautareBinara(int[] sir, int p) {
		boolean a = false;
		int sol = -1;
		int Left = 0, Right = sir.length - 1;
		while (Left <= Right) {
			int Mid = (Left + Right) / 2;
			if (sir[Mid] == p) {
				a = true;
				sol = Mid;
				break;
			}
			if (sir[Mid] > p)
				Right = Mid - 1;
			if (sir[Mid] < p)
				Left = Mid + 1;
		}
		System.out.println(a);
		if (a == true)
			System.out.printf("Numarul se afla in pozitia: :%d", sol);
		return a;
	}
}