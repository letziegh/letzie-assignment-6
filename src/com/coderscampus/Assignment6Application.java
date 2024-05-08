package com.coderscampus;

import java.io.IOException;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Assignment6Application {

    public static void main(String[] args) throws IOException {


        SalesService saleService = new SalesService();
        System.out.println("Model 3 Yearly Sales Report");
        System.out.println("---------------------------------");

        saleService.readFile("model3.csv");
        List<Report> salesForModel3 = saleService.getSales();
        printSales(salesForModel3);
        getBestMonth(salesForModel3);
        getWorstMonth(salesForModel3);
        //findBestMonthForSales(salesForModel3);
        //System.out.println(STR."The best month for Model 3 was: \{.getDate().format(DateTimeFormatter.ofPattern("yyyy-MM"))}");

        System.out.println(" ");
        System.out.println("Model S Yearly Sales Report");
        System.out.println("---------------------------------");
        saleService.readFile("modelS.csv");
        List<Report> salesForModelS = saleService.getSales();
        printSales(salesForModelS);
        getBestMonth(salesForModelS);
        getWorstMonth(salesForModelS);



        System.out.println(" ");
        System.out.println("Model X Yearly Sales Report");
        System.out.println("---------------------------------");
        saleService.readFile("modelX.csv");
        List<Report> salesForModelX = saleService.getSales();
        printSales(salesForModelX);
        getBestMonth(salesForModelX);
        getWorstMonth(salesForModelX);


    }

    private static void getWorstMonth( List<Report> sales) {


        Optional<Report> worstMonth = sales.stream()

                .min(Comparator.comparing(Report::getSales));

        worstMonth.ifPresent(report ->

        {
            System.out.println("The worst month for sales was: " +
                    report.getDate().format(DateTimeFormatter.ofPattern("yyyy-MM")));
        });
    }

    public static void getBestMonth(List<Report> bMonth) {
        Optional<Report> bestMonth = bMonth
                .stream()
                .max(Comparator.comparing(Report::getSales));

        bestMonth.ifPresent(report -> {
            System.out.println("The best month for sales was: " +
                    report.getDate().format(DateTimeFormatter.ofPattern("yyyy-MM")));
        });
    }


    public static void printSales(List<Report> list) {

        Map<Integer, Integer> salesforModel3ReportMap = list.stream()
                .distinct()
                .collect(Collectors.groupingBy(item -> item.getDate().getYear(), Collectors.summingInt(Report::getSales)));

        salesforModel3ReportMap.entrySet()
                .stream()
                .forEach(report -> System.out.println(report.getKey() + " -> " + report.getValue()));
    }


}