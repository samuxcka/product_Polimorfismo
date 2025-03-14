package application;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		String calendar;
		LocalDate date;
		
		System.out.println("Enter department's name: ");
		Department department = new Department(scan.nextLine());
		System.out.print("Enter Worker data: ");
		System.out.println();
		System.out.print("Name: ");
		String name = scan.nextLine();
		System.out.print("Level: ");
		String level = scan.nextLine();
		System.out.print("Base Salary: ");
		double salary = scan.nextDouble();
		Worker worker = new Worker(name, WorkerLevel.valueOf(level), salary, department);
		
		System.out.println();
		System.out.println("How many contracts do this worker? ");
		int quantityContract = scan.nextInt();
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		for(int i =0; i < quantityContract; i++) {
			System.out.println("Enter contract #"+ (i+1) + " data: ");
			System.out.print("Date: DD/MM/YYYY: ");
			calendar = scan.next();
			date = LocalDate.parse(calendar, fmt);
			System.out.print("Value per hour: ");
			salary = scan.nextDouble();
			System.out.print("Duration ( hours): ");
			Integer hour = scan.nextInt();
			HourContract contract = new HourContract(date, salary, hour);
			worker.AddContract(contract);
			System.out.println();
		}
		System.out.println("Enter month and year to calculate income (MM/yyyy): ");
		String newDate = scan.next();
		DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("MM/yyyy");
		YearMonth yearMonth = YearMonth.parse(newDate, fmt2);
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income from "+ yearMonth + ": "+ worker.income(yearMonth.getYear(), yearMonth.getMonthValue()));
		scan.close();
	}

}
