import java.util.ArrayList;

public class Lab2_2 {
    private ArrayList<Double> signals;
    private ArrayList<Double> F = new ArrayList<>();
    private ArrayList<Long> seconds = new ArrayList<>();
    private int N;

    public Lab2_2(ArrayList<Double> signals) {
        this.signals = signals;
        this.N = signals.size();
    }

    public void generateF() {
        for (int p = 0; p < N; p++) {
            seconds.add((long)p);

            double[] Fc = {0, 0};
            double[] Fs = {0, 0};

            for (int k = 0; k < N / 2; k++) {
                Fc[0] += this.signals.get(2*k) * Math.sin((4 * Math.PI * p * k) / N);
                Fs[0] += this.signals.get(2*k + 1) * Math.sin((2 * Math.PI * p * (k * 2 + 1)) / N);

                Fc[1] += this.signals.get(2*k) * Math.cos((4 * Math.PI * p * k) / N);
                Fs[1] += this.signals.get(2*k + 1) * Math.cos((2 * Math.PI * p * (k * 2 + 1)) / N);
            }

            F.add(Math.sqrt(Math.pow(Fc[0] + Fs[0], 2) + Math.pow(Fc[1] + Fs[1], 2)));
        }
    }

    public void drawGraph() {
        Graph ex1 = new Graph("Lab2_2", "Signal", "F(k)", seconds, signals, F);
        ex1.draw(2);
    }

    public ArrayList<Double> getF() { return this.F; };
}
