import java.util.Comparator;

public class Point implements Comparable<Point>{

	private int x, y;

	//Alt+Insert  -> Constructor
	//Az üres paraméterlistás konstruktor alapértelmezett, de üres.
	//Ez nekünk legyen az origó értéke.
	public Point() {
		x = 0;
		y = 0;
	}

	//Lehet más construktort is generálni.
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
		//System.out.println("Új pont: " + this.toString());
	}

	//Lehetnek metódusai egy osztálynak
	double Distance(){
		double dis = Math.sqrt(Math.pow(x, 2) + Math.pow(this.y, 2));
		//System.out.println(toString() + " távolsága az origótól: " + dis);
		return dis;
	}

	public double Distance(Point b){
		double dis = Math.sqrt(Math.pow(this.x - b.x, 2) + Math.pow(this.y - b.y, 2));
		//System.out.println(toString() + " távolsága a " + b.toString() + " ponttól: " + dis);
		return dis;
	}

	//És lehet osztályszintű metódus is.
	public static double Distance(Point a, Point b){
		double dis = Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
		StringBuilder sb = new StringBuilder();
		sb.append("A ").append(a.toString());
		sb.append(" és ").append(b.toString());
		sb.append(" pontok közötti távolság: ");
		sb.append(dis);
		//System.out.println(sb.toString());
		return dis;
	}

	//Getterek és Setterek
	//Alt+Insert -> Getter and Setter
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	//toString - az elem kiírása
	//Alt+Insert -> toString()
	/*
	@Override

	public String toString() {
		return "(x:" + x + ", y:" + y + ')';
	}
	*/
	//Van még StringBuilder is:
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("(x:");
		sb.append(x);
		sb.append(", y:");
		sb.append(y);
		sb.append(')');
		return sb.toString();
	}

	//Vannak alapszintű metódusok, miket overrideolni lehet. Ezeknél esetekben elég a generált, de van hogy kevesebb is.
	//Alt+Insert -> Override methods
	//A super a már öröklés előtt definiált metódust hívja meg.
	/*
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	*/

	//2 elem mikor egyenlő.
	//Egyes halmazok a HashCode után ezt használják az egyenlőség meghatározására.
	//Ez lehet pl. halmazoknál. Valami csak hashcode, de valami ezt is megnézi már.
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		//if ( obj == null || !(obj instanceof Point)) {
		//	return false;
		//}
		Point point = (Point) obj;
		return	point.x == this.x &&
				point.y == this.y;
		//return super.equals(obj);
	}

	//Ha már más bemeneti argumentumlista van, akkor egyedi metódus.
	//Most a név is más, hogy könnyen hivatkozhassam a test-ben.
	public boolean Equals(Point point) {
		return	point.x == this.x &&
				point.y == this.y;
	}

	@Override
	public int compareTo(Point other) {
		return ((Integer)x).compareTo(other.x);
	}

	static public class SortByDisXY implements Comparator<Point> {
		@Override
		public int compare(Point p1, Point p2) {
			int dif = Double.compare(p1.Distance(), p2.Distance());
			if(dif != 0)
				return dif;
			dif = Integer.compare(p1.getX(), p2.getX());
			if(dif != 0)
				return dif;
			return Integer.compare(p1.getY(), p2.getY());
		}
	}
}
