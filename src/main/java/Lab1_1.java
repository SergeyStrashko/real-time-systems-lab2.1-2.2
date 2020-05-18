import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

class Lab1_1 {
    private int n;
    private int fr;
    private int N;
    private long timeInNanoseconds;
    public long arrayTime;
    public long arrayListTime;

    private ArrayList<Long> seconds;
    private ArrayList<Double> signals;
    private ArrayList<Double> mathExpectations;
    private ArrayList<Double> dispersions;

    public Lab1_1(int n, int fr, int N, long timeInNanoseconds) {
        this.timeInNanoseconds = timeInNanoseconds;
        this.n = n;
        this.fr = fr;
        this.N = N;

        this.seconds = new ArrayList<Long>((int)((this.timeInNanoseconds == 0) ? N : 0));
        this.signals = new ArrayList<Double>(N);
        this.mathExpectations = new ArrayList<Double>(N);
        this.dispersions = new ArrayList<Double>(N);
    }

    public void generateSignal() {
        long start = System.nanoTime();
        Random rand = new Random();

        long t = 0;

        while (t < ((this.timeInNanoseconds == 0) ? N : this.timeInNanoseconds)) {
            long iterTime = 0;

            seconds.add(t);

            int frTemp = this.fr / n;
            int step = frTemp;

            Double sygnal = 0.0;
            Double mathEpectation = 0.0;
            Double dispersion = 0.0;

            for (int x = 0; x < n; x++, frTemp += step) {
                double A = rand.nextDouble();
                double fi = rand.nextDouble();

                sygnal += A * Math.sin(frTemp * t + fi);
            }

            mathEpectation = sygnal / N;
            dispersion = Math.pow(sygnal - mathEpectation, 2) / (N - 1);

            signals.add(sygnal);
            mathExpectations.add(mathEpectation);
            dispersions.add(dispersion);

            long end = System.nanoTime();
            iterTime = end - start;

            t += ((this.timeInNanoseconds == 0) ? 1 : iterTime);
        }
        long end = System.nanoTime();
        arrayListTime = (end - start);
//        System.out.println("ArrayList time: " + (end - start));
    }

    public void generateSignalArrays() {
        long[] secondsArr = new long[N];
        double[] mathExpArr = new double[N];
        double[] signalsArr = new double[N];
        double[] dispArr = new double[N];


        long start = System.nanoTime();
        Random rand = new Random();

        long t = 0;

        while (t < ((this.timeInNanoseconds == 0) ? N : this.timeInNanoseconds)) {
            long iterTime = 0;

            secondsArr[(int)t] = t;

            int frTemp = this.fr / n;
            int step = frTemp;

            double sygnal = 0.0;
            double mathEpectation = 0.0;
            double dispersion = 0.0;

            for (int x = 0; x < n; x++, frTemp += step) {
                double A = rand.nextDouble();
                double fi = rand.nextDouble();

                sygnal += A * Math.sin(frTemp * t + fi);
            }

            mathEpectation = sygnal / N;
            dispersion = Math.pow(sygnal - mathEpectation, 2) / (N - 1);

            signalsArr[(int)t] = sygnal;
            mathExpArr[(int)t] = mathEpectation;
            dispArr[(int)t] = dispersion;

            long end = System.nanoTime();
            iterTime = end - start;

            t += ((this.timeInNanoseconds == 0) ? 1 : iterTime);
        }
        long end = System.nanoTime();
        arrayTime = (end - start);
        System.out.println("Array time: " + (end - start));
    }

    public ArrayList<Long> getSeconds() { return this.seconds; };
    public ArrayList<Double> getSignals() { return this.signals; };
    public ArrayList<Double> getMathExpectations() { return this.mathExpectations; };
    public ArrayList<Double> getDispersions() { return this.dispersions; };

    public void drawGraph() {
        Graph ex1 = new Graph("Lab1_1", "Signal", seconds, signals);
        ex1.draw(1);

        Graph ex2 = new Graph("Lab1_1", "Math expectation", seconds, mathExpectations);
        ex2.draw(1);

        Graph ex3 = new Graph("Lab1_1", "Dispersion", seconds, dispersions);
        ex3.draw(1);
    }
}