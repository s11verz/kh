package array2d;

public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1번 문제
		int data1[][] = new int[5][5];
		int num = 1;
		for (int i = 0; i < data1.length; i++) {
			for (int j = 0; j < data1[i].length; j++) {
				data1[i][j] = num;
				num++;
			}

		}
		for (int i = 0; i < data1.length; i++) {

			for (int j = 0; j < data1[i].length; j++) {
				System.out.print(data1[i][j] + "\t");
			}
			System.out.println();
		}

		// 2번 문제

		int num2 = 1;
		for (int i = 0; i < data1.length; i++) {
			for (int j = 0; j < data1[i].length; j++) {
				data1[j][i] = num2;
				num2++;
			}

		}
		System.out.println();
		System.out.println();
		for (int i = 0; i < data1.length; i++) {

			for (int j = 0; j < data1[i].length; j++) {
				System.out.print(data1[i][j] + "\t");
			}
			System.out.println();
		}

		// 3번 문제
		int num3 = 1;
		for (int i = 0; i < data1.length; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < data1[i].length; j++) {
					data1[i][j] = num3;
					num3++;
				}
			} else {
				for (int k = 0; k < data1[i].length; k++) {
					int len = data1[i].length - 1;
					data1[i][len - k] = num3;
					num3++;
				}
			}
		}
		System.out.println();
		System.out.println();
		for (int i = 0; i < data1.length; i++) {

			for (int j = 0; j < data1[i].length; j++) {
				System.out.print(data1[i][j] + "\t");
			}
			System.out.println();
		}

	}

}
