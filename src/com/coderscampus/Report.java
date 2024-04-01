package com.coderscampus;

import java.time.YearMonth;

public class Report {
	private YearMonth date;
	
	private Integer sales;
	
	public Report(YearMonth date, Integer sales) {
		this.date = date;
		this.sales = sales;
	}
	
	public YearMonth getDate() {
		return date;
	}
	public void setDate(YearMonth date) {
		this.date = date;
	}
	public Integer getSales() {
		return sales;
	}
	public void setSales(Integer sales) {
		this.sales = sales;
	}

	@Override
	public String toString() {
		return "Report [date=" + date + ", sales=" + sales + "]";
	}
	
	
	//change everything to yearmonth
	
	
}