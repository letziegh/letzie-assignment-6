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
		saleService.readFile("model3.csv");
		// Total sales for the year 2017

		Map<YearMonth, Integer> sumOfSales17 = saleService.getSales().stream()
				.filter(report -> report.getDate().getYear() == 2017)

				.collect(Collectors.groupingBy(report -> YearMonth.from(report.getDate()),
						Collectors.summingInt(Report::getSales)));

		// Total sales for the year 2018
		Map<YearMonth, Integer> sumOfSales2018 = saleService.getSales().stream()
				.filter(report -> report.getDate().getYear() == 2018).collect(Collectors.groupingBy(
						report -> YearMonth.from(report.getDate()), Collectors.summingInt(Report::getSales)));

		// Total sales for the year 2019
		Map<YearMonth, Integer> sumOfSales2019 = saleService.getSales().stream()
				.filter(report -> report.getDate().getYear() == 2019).collect(Collectors.groupingBy(
						report -> YearMonth.from(report.getDate()), Collectors.summingInt(Report::getSales)));

// Printing out the total sum of sales for the year 2017
		int totalSales2017 = sumOfSales17.values().stream().mapToInt(Integer::intValue).sum();
		int totalSales2018 = sumOfSales2018.values().stream().mapToInt(Integer::intValue).sum();
		int totalSales2019 = sumOfSales2019.values().stream().mapToInt(Integer::intValue).sum();

		
		System.out.println("Model 3 Yearly Sales Report");
		System.out.println("------------------------------");
		System.out.println(" 2017 -> " + totalSales2017);
		System.out.println(" 2018 -> " + totalSales2018);
		System.out.println(" 2019 -> " + totalSales2019);
		

		Optional<Report> model3 = saleService.getSales().stream().filter(t -> t.getDate().getYear() == 2019)

				.max(Comparator.comparing(Report::getSales));

		
		System.out.println("The best month for Model 3 was: " + model3.get().getDate().format(DateTimeFormatter.ofPattern("yyyy-MM")));

		Optional<Report> otherModel3 = saleService.getSales().stream().filter(t -> t.getDate().getYear() == 2017)
				.min(Comparator.comparing(Report::getSales));
		System.out.println("The worst month for Model 3 was: " + otherModel3.get().getDate().format(DateTimeFormatter.ofPattern("yyyy-MM")));

		// Model S

		saleService.readFile("modelS.csv");
		// Total sales for the year 2017

		Map<YearMonth, Integer> allOfSales16 = saleService.getSales().stream()
				.filter(report -> report.getDate().getYear() == 2016)

				.collect(Collectors.groupingBy(report -> YearMonth.from(report.getDate()),
						Collectors.summingInt(Report::getSales)));

		Map<YearMonth, Integer> allOfSales17 = saleService.getSales().stream()
				.filter(report -> report.getDate().getYear() == 2017)

				.collect(Collectors.groupingBy(report -> YearMonth.from(report.getDate()),
						Collectors.summingInt(Report::getSales)));

		// Total sales for the year 2018
		Map<YearMonth, Integer> allOfSales2018 = saleService.getSales().stream()
				.filter(report -> report.getDate().getYear() == 2018).collect(Collectors.groupingBy(
						report -> YearMonth.from(report.getDate()), Collectors.summingInt(Report::getSales)));

		// Total sales for the year 2019
		Map<YearMonth, Integer> allOfSales2019 = saleService.getSales().stream()
				.filter(report -> report.getDate().getYear() == 2019).collect(Collectors.groupingBy(
						report -> YearMonth.from(report.getDate()), Collectors.summingInt(Report::getSales)));

		// Printing out the total sum of sales for the year 2017
		int modelSSales2016 = allOfSales16.values().stream().mapToInt(Integer::intValue).sum();
		int modelSSales2017 = allOfSales17.values().stream().mapToInt(Integer::intValue).sum();
		int modelSSales2018 = allOfSales2018.values().stream().mapToInt(Integer::intValue).sum();
		int modelSSales2019 = allOfSales2019.values().stream().mapToInt(Integer::intValue).sum();

		System.out.println();
		
		System.out.println("Model S Yearly Sales Report");
		System.out.println("------------------------------");
		System.out.println(" 2016 -> " + modelSSales2016);
		System.out.println(" 2017 -> " + modelSSales2017);
		System.out.println(" 2018 -> " + modelSSales2018);
		System.out.println(" 2019 -> " + modelSSales2019);
		
		Optional<Report> otherModelS = saleService.getSales().stream().filter(s -> s.getDate().getYear() == 2016)

				.max(Comparator.comparing(Report::getSales));

		
		System.out.println("The best month for Model S was: " + otherModelS.get().getDate().format(DateTimeFormatter.ofPattern("yyyy-MM")));

		Optional<Report> modelS2 = saleService.getSales().stream().filter(s -> s.getDate().getYear() == 2019)
				.min(Comparator.comparing(Report::getSales));
		System.out.println("The worst month for Model S was: " + modelS2.get().getDate().format(DateTimeFormatter.ofPattern("yyyy-MM")));
		
		
		//MODEL X
		
		saleService.readFile("modelX.csv");
		// Total sales for the year 2016

		Map<YearMonth, Integer> xOfSales16 = saleService.getSales().stream()
				.filter(report -> report.getDate().getYear() == 2016)

				.collect(Collectors.groupingBy(report -> YearMonth.from(report.getDate()),
						Collectors.summingInt(Report::getSales)));

		Map<YearMonth, Integer> xOfSales17 = saleService.getSales().stream()
				.filter(report -> report.getDate().getYear() == 2017)

				.collect(Collectors.groupingBy(report -> YearMonth.from(report.getDate()),
						Collectors.summingInt(Report::getSales)));

		// Total sales for the year 2018
		Map<YearMonth, Integer> xOfSales2018 = saleService.getSales().stream()
				.filter(report -> report.getDate().getYear() == 2018).collect(Collectors.groupingBy(
						report -> YearMonth.from(report.getDate()), Collectors.summingInt(Report::getSales)));

		// Total sales for the year 2019
		Map<YearMonth, Integer> xOfSales2019 = saleService.getSales().stream()
				.filter(report -> report.getDate().getYear() == 2019).collect(Collectors.groupingBy(
						report -> YearMonth.from(report.getDate()), Collectors.summingInt(Report::getSales)));

		// Printing out the total sum of sales for the year 2017
		int modelXSales2016 = xOfSales16.values().stream().mapToInt(Integer::intValue).sum();
		int modelXSales2017 = xOfSales17.values().stream().mapToInt(Integer::intValue).sum();
		int modelXSales2018 = xOfSales2018.values().stream().mapToInt(Integer::intValue).sum();
		int modelXSales2019 = xOfSales2019.values().stream().mapToInt(Integer::intValue).sum();

		System.out.println();
		
		System.out.println("Model X Yearly Sales Report");
		System.out.println("------------------------------");
		System.out.println(" 2016 -> " + modelXSales2016);
		System.out.println(" 2017 -> " + modelXSales2017);
		System.out.println(" 2018 -> " + modelXSales2018);
		System.out.println(" 2019 -> " + modelXSales2019);
		

		Optional<Report> otherModelX = saleService.getSales().stream().filter(x -> x.getDate().getYear() == 2018)

				.max(Comparator.comparing(Report::getSales));

		
		System.out.println("The best month for Model X was: " + otherModelX.get().getDate().format(DateTimeFormatter.ofPattern("yyyy-MM")));

		Optional<Report> modelX2 = saleService.getSales().stream().filter(x -> x.getDate().getYear() == 2016)
				.min(Comparator.comparing(Report::getSales));
		System.out.println("The worst month for Model X was: " + modelX2.get().getDate().format(DateTimeFormatter.ofPattern("yyyy-MM")));
		
		
		
		

	}

}
