import java.util.ArrayList;

public class Lab2_1 {
    private ArrayList<Double> signals;
    private ArrayList<Double> F = new ArrayList<>();
    private ArrayList<Long> seconds = new ArrayList<>();
    private int N;

    public Lab2_1(ArrayList<Double> signals) {
        this.signals = signals;
        this.N = signals.size();
    }

    public void generateF() {
        for (int p = 0; p < N; p++) {
            seconds.add((long)p);

            double Fc = 0;
            double Fs = 0;

            for (int k = 0; k < N; k++) {
                Fc += signals.get(k) * Math.cos((2*Math.PI)/N*p*k);
                Fs += signals.get(k) * Math.sin((2*Math.PI)/N*p*k);
            }

            F.add(Math.sqrt(Math.pow(Fc, 2) + Math.pow(Fs, 2)));
        }
    }

    public void drawGraph() {
        Graph ex1 = new Graph("Lab2_1", "Signal", "F(k)", seconds, signals, F);
        ex1.draw(2);
    }

    public ArrayList<Double> getF() { return this.F; };
}
