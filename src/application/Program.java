package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Contribuinte;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Contribuinte> lista = new ArrayList<Contribuinte>();
		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or company (i/c)?: ");
			sc.nextLine();
			char ch = sc.next().charAt(0);
			while (ch != 'i' && ch != 'c') {
				System.out.print("Invalid, please try again(i/c): ");
				ch = sc.next().charAt(0);
			}
			System.out.print("Name: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Anual income: ");
			Double rendaAnual = sc.nextDouble();
			if (ch == 'i') {
				System.out.print("Health expenditures: ");
				Double gastosSaude = sc.nextDouble();
				lista.add(new PessoaFisica(nome, rendaAnual, gastosSaude));
			}
			
			if (ch == 'c') {
				System.out.print("Number of employees: ");
				Integer numeroDeFuncionarios = sc.nextInt();
				lista.add(new PessoaJuridica(nome, rendaAnual, numeroDeFuncionarios));
			}
		}
		System.out.println();
		System.out.println("TAXES PAID:");
		Double soma = 0.0;
		for(Contribuinte c : lista) {
			System.out.println(c.impriminto());
			soma += c.valorImpostoPago();
		}
		
		System.out.println("TOTAL TAXES: " + String.format("%.2f", soma));
		
		sc.close();

	}

}
