import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        long timeInMilliseconds = 0;
        long convertedTime = timeInMilliseconds * 1000000;

        int n = 10;
        int N = 64;
        int fr = 1200;

        Lab1_1 lab1_1 = new Lab1_1(n, fr, N, convertedTime);

        lab1_1.generateSignal();
//        lab1_1.drawGraph();

        ArrayList<Double> signals = lab1_1.getSignals();
        ArrayList<Double> mathExpectations = lab1_1.getMathExpectations();

//        Lab1_2 lab1_2 = new Lab1_2(signals, mathExpectations);

//        lab1_2.generateAutoCorelation();
//        lab1_2.drawGraph();

//        ArrayList<Double> Rxx = lab1_2.getRxx();

        Lab2_1 lab2_1 = new Lab2_1(signals);
        lab2_1.generateF();
        lab2_1.drawGraph();

        Lab2_2 lab2_2 = new Lab2_2(signals);
        lab2_2.generateF();
        lab2_2.drawGraph();
    }
}
