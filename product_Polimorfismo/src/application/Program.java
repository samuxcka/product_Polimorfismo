package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Product> product = new ArrayList<Product>();
		int n;
		String name;
		Double price;
		Double customsFee;
		String d;
		LocalDate date;

		System.out.print("Enter the number of products: ");
		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.print("Common, used or imported? (c/u/i) ");
			char a = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			name = sc.nextLine();
			System.out.print("Price: ");
			price = sc.nextDouble();
			if (a == 'i') {
				System.out.println("Customs Fee: ");
				customsFee = sc.nextDouble();
				product.add(new ImportedProduct(name, price, customsFee));
			}
			if (a == 'c') {
				product.add(new Product(name, price));
			}
			if (a == 'u') {
				DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				System.out.print("Manufacture date: ( dd/mm/yyyy) ");
				d = sc.next();
				date = LocalDate.parse(d, fmt);
				product.add(new UsedProduct(name, price, date));
			}

		}
		
		for(Product prod : product) {
		System.out.println(prod.priceTag());
		}
		
		sc.close();
	}
}
