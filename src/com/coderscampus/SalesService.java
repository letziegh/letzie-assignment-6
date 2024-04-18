package com.coderscampus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class SalesService {
	
	String path1 = "model3.csv";
	String path2 = "modelS.csv";
	String path3 = "modelX.CSV";
	
	
	List <Report> sales;
	
	List<Report> carList1 = new ArrayList<>();
	List<Report> carList2 = new ArrayList<>();
	List<Report> carList3 = new ArrayList<>();
	
	
	public SalesService() {
		this.sales = new ArrayList<>();
	}

	public List<Report> getSales(){
	return this.sales;
	}

	public String readFile(String fileName) throws IOException {
		
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		
		String line;
		
		while((line = reader.readLine()) !=null){
			if (line.contains("Date")) {
				continue;
			}
			String date = line.split(",")[0];
			String sales = line.split(",")[1]; 
			
			Report report = new Report(date, Integer.parseInt(sales));
			this.sales.add(report);
			
		}
		return line;

		

		 
//		 System.out.println(carList1);
//		Map<YearMonth, Integer> salesOf17 = carList1.stream()
//		.filter(report -> report.getDate().isAfter(null))  //contains(//cant put a string in here like "-17"))
//		.distinct()
//		.collect(Collectors.groupingBy(Report::getDate, Collectors.summingInt(Report::getSales)));
//		
//		System.out.println(salesOf17);
//		
//		Set<Entry<YearMonth, Integer>> entrySet =salesOf17.entrySet();
//		System.out.println(entrySet);
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
