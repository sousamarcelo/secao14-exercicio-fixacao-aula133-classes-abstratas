package application;

import java.util.Locale;

import entities.PessoaFisica;
import entities.PessoaJuridica;

public class ProgramTeste {

	public static void main(String[] args) {
		
		PessoaJuridica pf = new PessoaJuridica("SoftTech", 400000.00, 25);
		
		System.out.println(pf.impriminto());

	}

}
