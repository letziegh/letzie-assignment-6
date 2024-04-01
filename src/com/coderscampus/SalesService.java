package com.coderscampus;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.Normalizer.Form;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SalesService {

	String path1 = "model3.csv";
	String path2 = "modelS.csv";
	String path3 = "modelX.csv";

	List<Report> carList1 = new ArrayList<Report>(); //replace data type with object Report 
	List<Report> carList2 = new ArrayList<Report>();
	List<Report> carList3= new ArrayList<Report>();

	public void SalesService() throws IOException {
		

		
		 try( Stream<String> lines = Files.lines(Paths.get(path1))) {
			carList1 = lines
					.filter(line -> line.contains("-17"))
			 .map(line -> {
						System.out.println(line);
						String[] data = line.split(",");
						String date = data[0];
						String sales = data[1];
						return new Report(YearMonth.parse(date), Integer.parseInt(sales));
				})
			 .collect(Collectors.toList());
			 System.out.println(carList1);
			
		} catch (Exception e) {
			
		}
		 
		 System.out.println(carList1);
		Map<YearMonth, Integer> salesOf17 = carList1.stream()
		.filter(report -> report.getDate().isAfter(null))  //contains(//cant put a string in here like "-17"))
		.distinct()
		.collect(Collectors.groupingBy(Report::getDate, Collectors.summingInt(Report::getSales)));
		
		System.out.println(salesOf17);
		
		Set<Entry<YearMonth, Integer>> entrySet =salesOf17.entrySet();
		System.out.println(entrySet);
//		carList1.forEach(System.out::println);

//							 .forEach(System.out::println);

//		carList2 = Files.lines(Paths.get(path2)).map(line -> {
//			if(!line.contains("Date")) {
//				
//				String[] data = line.split(",");
//				String date = data[0];
//				String sales = data[1];
//				return new Report (date, Integer.parseInt(sales));
//			}
//			return null;
//		}) .collect(Collectors.toList());
//		
//		carList2.forEach(System.out::println);
		
//		carList3 = Files.lines(Paths.get(path3)) .map(line->{
//				 
//					  if(!line.contains("Date")) {
//						  String[] data= line.split(",");
//						  String date = data[0];
//						  String sales = data[1];
//						  return new Report (date, Integer.parseInt(sales));
//					  }
//					  return null;
//				  }) .collect(Collectors.toList());
//		carList3.forEach(System.out::println);
							
	}

}
