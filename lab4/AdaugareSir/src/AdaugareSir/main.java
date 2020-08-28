package AdaugareSir;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Introduceti pozitia :");
		int p = scanner.nextInt();
		System.out.println("Introduceti numarul :");
		int val = scanner.nextInt();
		int[] sir = new int[11];
			sir[0] = 12;
			sir[1] = 25;
			sir[2] = 47;
			sir[3] = 58;
			sir[4] = 47;
			sir[5] = 7;
			sir[6] = 96;
			sir[7] = 14;
			sir[8] = 3;
			sir[9] = 9;
		int[] sircoppy = new int[11];
		
		for (int i = 0; i < sir.length; i++) {
			sircoppy[i] = sir[i];
		}
		int n = sircoppy.length;
		if(p<=n)
		{
		for (int i = n - 2; i >= p; i--)
			sircoppy[i + 1] = sircoppy[i];
		sircoppy[p] = val;
		sir = sircoppy;
		System.out.println(java.util.Arrays.toString(sir));
		}
		else
			System.out.println("Pozitia introdusa depaseste pozitia maxima din sir");
	}
}