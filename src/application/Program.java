package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.US);
		Locale.setDefault(Locale.US);
		
		List<Product> list = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for(int i = 1;i <= n;i ++) {
			System.out.println();
			System.out.println("Product #" +i+ " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char ver = sc.next().charAt(0);
			sc.nextLine();
			
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			
			if(ver == 'c') {
				list.add(new Product(name, price));
			}else if(ver == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(sc.next());
				
				list.add(new UsedProduct(name, price, manufactureDate));
			}else {
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				
				list.add(new ImportedProduct(name, price, customsFee));
			}
		}
		
		System.out.println();
		System.out.println("PRICE TAGS:");
		for(Product p : list) {
			System.out.println(p.priceTag());
		}
	
		sc.close();
	}
}
