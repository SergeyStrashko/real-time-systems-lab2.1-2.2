import java.util.ArrayList;
import java.util.Random;

public class Lab1_2 {
    private ArrayList<Double> signals;
    private ArrayList<Double> mathExpectation;
    private ArrayList<Double> Rxx;
    private ArrayList<Long> seconds;

    private ArrayList<Double> autoCorelation;
    private int N;

    public Lab1_2(ArrayList<Double> signals, ArrayList<Double> mathExpectation) {
        this.signals = signals;
        this.mathExpectation = mathExpectation;
        this.seconds = new ArrayList<>();
        this.Rxx = new ArrayList<>();

        this.N = signals.size();
    }

    public void generateAutoCorelation() {
        int endPoint = (int)(signals.size()/2);

        for (long T = 0; T < endPoint; T++)
        {
            seconds.add(T);
            double R = 0;

            for (int t = 0; t < N - T; t++)
            {
                R += ((signals.get(t) - mathExpectation.get(t))*(signals.get(t + (int)T) - mathExpectation.get(t + (int)T)))/(N - 1);
            }

            Rxx.add(R);
        }
    }

    public void drawGraph() {
        Graph ex1 = new Graph("Lab1_2", "Rxx", seconds, Rxx);
        ex1.draw(1);
    }

    public ArrayList<Double> getRxx() { return this.Rxx; };
}
