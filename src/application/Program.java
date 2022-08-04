package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<TaxPayer> list = new ArrayList<>();
		
		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		
		for (int i=0; i<n; i++) {
			
			System.out.println("Tax Payer #" + (i+1) + " data: ");
			System.out.print("Individual or company (i/c)?");
			char c = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Anual Income: ");
			double income = sc.nextDouble();
			
			if (c == 'i') {
				System.out.print("Health Expenditures: ");
				double expenditures = sc.nextDouble();
				TaxPayer payer = new Individual(name, income, expenditures);
				list.add(payer);				
			}
			else {
				System.out.print("Number of employees: ");
				int employees = sc.nextInt();
				TaxPayer payer = new Company(name, income, employees);
				list.add(payer);
				
			}
		} //for ends here
		
		
		System.out.println();
		System.out.println("Taxes Paid: ");
		double sum = 0.0;		
		
		for(TaxPayer payer : list) {
			System.out.println(payer.getName() + ": $ " + String.format("%.2f", payer.tax()));
			sum+= payer.tax();
		}
		
		System.out.println();
		System.out.println("Total Taxes: $ " + String.format("%.2f", sum));
		
	
		sc.close();
	}

}
