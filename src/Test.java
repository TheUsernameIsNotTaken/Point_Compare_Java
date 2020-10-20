public class Test {
	public static void main(String[] args) {
		//Origó objektum
		Point o = new Point();
		//2 pont a síkon
		Point a = new Point(3,4);
		Point b = new Point(-5,10);
		//Origótól vett távolság
		o.Distance();
		a.Distance();
		b.Distance();
		//A távolsága az origótól - megeggyezik:
		a.Distance(o);
		//B távolsága A-tól
		b.Distance(a);
		Point.Distance(b, a);
		//Új C pont, majd A és C távolsága:
		Point c = new Point(-4,-3);
		Point.Distance(a, c);

		//Új D pont.
		Point d = new Point();
		//A D pontot egyenlővé teszem a-val.
		if(d.getX() == 0){
			d.setX(3);
		}
		if(d.getY() == 0){
			d.setY(4);
		}
		//Equals override nélkül nem egyenlő
		//Új equals definiálva egyenlő.
		//Általános equals-t kiegészítve már egyenlő.
		System.out.println("Az a" + a.toString() + " és d" + b.toString() + " pontok egyenlősége:");
		System.out.println(a.equals(d));
		System.out.println(a.Equals(d));
	}
}
