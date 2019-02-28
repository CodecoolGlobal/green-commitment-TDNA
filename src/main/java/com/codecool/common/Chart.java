package com.codecool.common;

import java.awt.*;
import java.io.*;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.w3c.dom.Document;

public class Chart {

    public static void run(List<Document> documentList, String type) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
        for (Document document : documentList) {
            line_chart_dataset.addValue(
                Integer.valueOf(document.getDocumentElement().getChildNodes().item(0).getChildNodes().item(1).getTextContent()),
                "temp", sdf.format(new Date(Long.valueOf(document.getDocumentElement().getChildNodes().item(0).getChildNodes().item(0).getTextContent()))
                )
                );
        }


        JFreeChart lineChartObject = ChartFactory.createBarChart(
            "Test Chart","Time",
            "Temperature",
            line_chart_dataset,PlotOrientation.VERTICAL,
            true,true,false);
        CategoryPlot plot = lineChartObject.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        Color color = new Color(80, 151, 189);
        renderer.setSeriesPaint(0, color);



        int width = 1366;    /* Width of the image */
        int height = 768;   /* Height of the image */
        File lineChart = new File( type + ".jpeg" );
        ChartUtilities.saveChartAsJPEG(lineChart ,lineChartObject, width ,height);
    }
}
