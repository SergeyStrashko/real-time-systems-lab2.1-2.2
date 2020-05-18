import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class Graph extends JFrame {
    private static final long serialVersionUID = 6294689542092367723L;
    private String title;
    private String legendName;
    private String legendName2;
    private ArrayList<Long> xAxis;
    private ArrayList<Double> yAxis;
    private ArrayList<Double> yAxis2;

    public Graph(String title, String legendName, ArrayList<Long> xAxis, ArrayList<Double> yAxis) {
        super(title);

        this.title = title;
        this.legendName = legendName;
        this.xAxis = xAxis;
        this.yAxis = yAxis;

        // Create dataset
        XYDataset dataset = createDataset(legendName, xAxis, yAxis);

        // Create chart
        JFreeChart chart = ChartFactory.createXYLineChart(
                legendName,
                "",
                "",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        XYPlot plot = (XYPlot)chart.getPlot();
        plot.setBackgroundPaint(new Color(255, 255, 255));

        // Create Panel
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    private XYDataset createDataset(String legendName, ArrayList<Long> xAxis, ArrayList<Double> yAxis) {
        XYSeriesCollection dataset = new XYSeriesCollection();

        XYSeries series = new XYSeries(legendName);
        for (int i = 0; i < xAxis.size(); i++) {
            series.add(xAxis.get(i), yAxis.get(i));
        }

        //Add series to dataset
        dataset.addSeries(series);

        return dataset;
    }

    public Graph(String title, String legendName1, String legendName2, ArrayList<Long> xAxis, ArrayList<Double> yAxis1, ArrayList<Double> yAxis2) {
        super(title);

        this.title = title;
        this.legendName = legendName1;
        this.legendName2 = legendName2;
        this.xAxis = xAxis;
        this.yAxis = yAxis1;
        this.yAxis2 = yAxis2;

        // Create dataset
        XYDataset dataset = createDataset(legendName1, legendName2, xAxis, yAxis1, yAxis2);

        // Create chart
        JFreeChart chart = ChartFactory.createXYLineChart(
                legendName,
                "",
                "",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        XYPlot plot = (XYPlot)chart.getPlot();
        plot.setBackgroundPaint(new Color(255, 255, 255));

        // Create Panel
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    private XYDataset createDataset(String legendName1, String legendName2, ArrayList<Long> xAxis, ArrayList<Double> yAxis1, ArrayList<Double> yAxis2) {
        XYSeriesCollection dataset = new XYSeriesCollection();

        XYSeries series1 = new XYSeries(legendName1);
        XYSeries series2 = new XYSeries(legendName2);

        for (int i = 0; i < xAxis.size(); i++) {
            series1.add(xAxis.get(i), yAxis1.get(i));
            series2.add(xAxis.get(i), yAxis2.get(i));
        }

        //Add series to dataset
        dataset.addSeries(series1);
        dataset.addSeries(series2);

        return dataset;
    }

    public void draw(int graphSelector) {
        if (graphSelector == 1) {
            Graph example = new Graph(title, legendName, xAxis, yAxis);
            example.setSize(800, 400);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            example.setVisible(true);
        } else {
            Graph example = new Graph(title, legendName, legendName2, xAxis, yAxis, yAxis2);
            example.setSize(800, 400);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            example.setVisible(true);
        }
    }
}