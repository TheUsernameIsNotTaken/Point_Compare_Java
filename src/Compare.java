import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;

public class Compare {
	public static void main(String[] args) {
		//Tömbök
		int[] t;
		int n[];
		t = new int[4]; // Nulla az alapértelmezett kezdőértek.
		n = new int[]{2, 5, 3, 4, 5};
		int[] s = {1, 2, 3, 4};
		//Rendezés
		Arrays.sort(n);
		System.out.println(Arrays.toString(n));

		System.out.println(" - - - - - ");

		//Saját osztályú tömbök
		Point[] pt = {
				new Point(1,2),
				new Point(1,1),
				new Point(2,2),
				new Point(2,1),
				new Point(0,2),
				new Point(2,0),
				new Point()
		};
		//Rendezés - Osztály által megmondott - Természetes rendezés
		System.out.println("1-es tömb rendezetlenül: " + Arrays.toString(pt));
		Arrays.sort(pt);		//Hiányzik a Comparable alapból!
		System.out.println("X szerint: " + Arrays.toString(pt));
		//Rendezés - Statikus osztállyal
		Arrays.sort(pt, new Point.SortByDisXY());
		System.out.println("Táv, X és Y szerint: " + Arrays.toString(pt));

		System.out.println(" - - - - - ");

		//Új tömb és rendezése
		Point[] pt2 = {
				new Point(3,4),
				new Point(-3,-4),
				new Point(-3,4),
				new Point(3, -4)
		};
		System.out.println("2-es tömb rendezetlenül: " + Arrays.toString(pt2));
		Arrays.sort(pt2);
		System.out.println("X szerint: " + Arrays.toString(pt2));
		Arrays.sort(pt2, new Point.SortByDisXY());
		System.out.println("Táv, X és Y szerint: " + Arrays.toString(pt2));

		System.out.println(" - - - - - ");

		//Lehet egyszeri rendezés: Most legyen csak X és Y szerint
		Arrays.sort(pt, new Comparator<Point>() {
			@Override
			public int compare(Point p1, Point p2) {
				int dif = Integer.compare(p1.getX(), p2.getX());
				if(dif != 0)
					return dif;
				return Integer.compare(p1.getY(), p2.getY());
			}
		});
		System.out.println("1-es X és Y szerint: " + Arrays.toString(pt));

		Arrays.sort(pt, (a,b) -> Double.compare(a.Distance(new Point(1,1)), b.Distance(new Point(1,1))));
		System.out.println("Távolság: " + Arrays.toString(pt));

		Arrays.sort(pt, (Point a, Point b) -> {
			int res = Double.compare(a.Distance(), b.Distance());
			if (res != 0)
				return res;
			return Integer.compare(a.getY(), b.getY());
		});
		System.out.println("Dis és Y: " + Arrays.toString(pt));

		Arrays.sort(pt, Comparator.comparing(new Function<Point, Integer>() {
			@Override
			public Integer apply(Point person) {
				return person.getY();
			}
		}));
		System.out.println("Y: " + Arrays.toString(pt));

		//Comparator.comparing használata
		System.out.println("- - Comparator.comparing használata a 2. tömbön - -");

		Arrays.sort(pt2, Comparator.comparing(a -> a.Distance(new Point(3,4))));
		System.out.println("Dis(3, 4): " + Arrays.toString(pt2));

		Arrays.sort(pt2, Comparator.comparing(Point::getX, Comparator.reverseOrder()));
		System.out.println("X fordítva: " + Arrays.toString(pt2));

		Arrays.sort(pt2, Comparator.comparing(Point::getX).thenComparing(Point::getY,Comparator.reverseOrder()));
		System.out.println("X és Y fordítva: " + Arrays.toString(pt2));
	}
}
