package api.collection;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Test03 {

	public static void main(String[] args) {
		Random r = new Random();
		ArrayList a = new ArrayList();

		for (int i = 0; i < 6; i++) {
			a.add(r.nextInt(45) + 1);
			
			for (int j = 0; j < i; j++) {
				if (a.get(i) == a.get(j))
					i--;

			}

		}

		System.out.println(a);

	}

}
