package com.coderscampus;

import java.io.IOException;
import java.time.YearMonth;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Assignment6Application {

	public static void main(String[] args) throws IOException {
		System.out.println("Hello!");

		SalesService saleService = new SalesService();
		saleService.readFile("model3.csv");

		Integer sumOfSales17 = saleService.getSales().stream()
				//.filter(report-> report.getDate().withYear(18)))
				.map(x -> x.getSales()).collect(Collectors.summingInt(Integer::intValue));
		

		System.out.println("Model 3 Yearly Sales Report");
		System.out.println("------------------------------");
		System.out.println("2017 -> " + sumOfSales17);
		System.out.println("2018 -> " + sumOfSales17);
		System.out.println("2019 -> " + sumOfSales17);
		System.out.println(         );
		System.out.println("The best month for Model 3 was: " + sumOfSales17);
		System.out.println("The worst month for Model 3 was: " + sumOfSales17);

//	.forEach(s-> System.out.println(saleService.getSales()));
		// sum all sales for each file

	}

}
