package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {
	public static void main(String[] args) throws ParseException {
	
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Product> list = new ArrayList<Product>();
	
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			System.out.println("Porduct #" + i + " data:");
			System.out.print("Common, used, imported? ");
			char type = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price? ");
			double price = sc.nextDouble();
			if(type == 'c') {
				list.add(new Product (name, price));
			}
			if(type == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(sc.next());
			
				list.add(new UsedProduct (name, price, manufactureDate));
			}
			if(type == 'i') {
				System.out.print("Costums Fee? ");
				double costumsFee = sc.nextDouble();

				list.add(new ImportedProduct (name, price, costumsFee));
			}

		}
		
		System.out.println();
		System.out.println("Price Tags: ");
		for(Product p : list) {
			System.out.println(p.priceTag());
		}
	
		sc.close();

	}
}
