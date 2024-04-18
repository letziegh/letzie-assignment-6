package com.coderscampus;

import java.io.IOException;
import java.time.YearMonth;
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
		System.out.println("Hello!");

		SalesService saleService = new SalesService();
		saleService.readFile("model3.csv");
		//instead of hash map can use Integer to display sum of sales17
		
		 Map<YearMonth, Integer> sumOfSales17 = saleService.getSales().stream()
				.filter(report -> report.getDate().getYear() == 2017)
				//.map(x -> x.getSales()).collect(Collectors.summingInt(Integer::intValue));
				//.map(Report::getSales));
				//.max(Comparator.comparing(Report::getSales));
				//.filter(report -> report.getDate().getYear() == 2018)
						//.filter(report -> report.getDate().getYear() == 2019)
			
				.collect(Collectors.groupingBy(Report::getDate, Collectors.summingInt(Report::getSales)));
		 System.out.println("Model 3 Yearly Sales Report");
		 System.out.println("------------------------------");
		 System.out.println(sumOfSales17);
		 
		 Optional<Report> test = saleService.getSales().stream()
				 .filter(t -> t.getDate().getYear() == 2019)
	
				   .max(Comparator.comparing(Report::getSales));
					                       // .sorted(Comparator.comparingInt(Report::getSales).reversed())
				 							//.sorted((o1, o2)->o2.getSales()-o1.getSales()
					                        //.reversed()
				 							//.max(Comparator.comparing(Report::getSales))
//					                        .limit(1)
//					                        .map(Report::getDate)
//					                       .forEach(test);
				 //add filter to get best month 
				 //WATCH YOUTBE VIDEO JAVA 8 STREAMS BY OGGI AI
				 									  // .filter(test->test. )
				 									   //.max(Comparator.comparing(Report::getSales));
		 System.out.println("The best month for Model 3 was: " + test.get());
		 
		 
		 Optional<Report> test2 = saleService.getSales().stream()
				 .filter(t -> t.getDate().getYear() == 2017)
				   .min(Comparator.comparing(Report::getSales));
		 System.out.println("The worst month for Model 3 was: " + test2.get());
		
	/*
	 * COPY CODE FOR EVERYTHING AND REPEAT FOR  ALL models
	 * THEN work on getting total asles for each year 
	 * DO THIS ON 4/18
	 */
		 
		

//		Map<YearMonth, Integer> sumOfSales17 = (Map<YearMonth, Integer>) saleService.getSales().stream()
//				.collect(groupingBy(YearMonth::getYear,maxBy(comparingInt(Integer::get)));
//		 .filter(report-> report.getDate().withYear(18)))
//		 .map(x -> x.getSales()).collect(Collectors.summingInt(Integer::intValue));

//		System.out.println("Model 3 Yearly Sales Report");
//		System.out.println("------------------------------");
//		System.out.println("2017 -> " + sumOfSales17);
//		System.out.println("2018 -> " + sumOfSales17);
//		System.out.println("2019 -> " + sumOfSales17);
//		System.out.println(         );
//		System.out.println("The best month for Model 3 was: " + sumOfSales17);
//		System.out.println("The worst month for Model 3 was: " + sumOfSales17);

//	.forEach(s-> System.out.println(saleService.getSales()));
		// sum all sales for each file

	}

}
