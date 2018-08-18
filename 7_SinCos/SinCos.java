import java.lang.Math;
import java.util.List;
import java.util.ArrayList;

class Pair {
    public final Integer a;
    public final Integer b;

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public String toString() {
        return "(" + a.toString() + ", " + b.toString() + ")";
    }
}

class SinCos {
    public static void main(String[] args) {
        int N = 10;

        List<Pair> pairs = new ArrayList<Pair>();
        for(int a=1; a<N; a++) {
            for (int b=0; b<N; b++) {
                if (a==b)
                    continue;

                if (Math.cos(Math.toRadians(a))*Math.sin(Math.toRadians(b)) <= b/(2*a))
                    pairs.add(new Pair(a, b));
            }
        }

        for (Pair p : pairs)
            System.out.println(p);
    }
}
