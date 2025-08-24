package com.example.nextLearnServer.util;

import org.apache.commons.math3.stat.regression.OLSMultipleLinearRegression;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class PageViewsPrediction {
    public static void main(String[] args) {
        // Load data
        List<Integer> data = Arrays.asList(12, 52, 64, 12, 623, 24, 2, 1, 5, 24, 3);

        // Feature selection and preprocessing
        double[][] X = IntStream.range(0, data.size() - 1)
                .mapToObj(i -> new double[]{data.get(i)})
                .toArray(double[][]::new);
        double[] y = IntStream.range(1, data.size())
                .mapToDouble(i -> data.get(i))
                .toArray();

        // Train model
        OLSMultipleLinearRegression regressor = new OLSMultipleLinearRegression();
        regressor.newSampleData(y, X);
        double[] beta = regressor.estimateRegressionParameters();

        // Predict future data points
        int futurePoints = 5;
        for (int i = data.size(); i < data.size() + futurePoints; i++) {
            double prediction = beta[0] * data.get(i - 5) + beta[1];
            System.out.println("Predicted value for point " + i + ": " + prediction);
        }
    }
}
