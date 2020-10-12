package entities;

public class PessoaJuridica extends Contribuinte {
	
	private Integer numeroDeFuncionarios;
	
	public PessoaJuridica() {
	}

	public PessoaJuridica(String nome, Double rendaAnual, Integer numeroDeFuncionarios) {
		super(nome, rendaAnual);
		this.numeroDeFuncionarios = numeroDeFuncionarios;
	}

	public Integer getNumeroDeFuncionarios() {
		return numeroDeFuncionarios;
	}

	public void setNumeroDeFuncionarios(Integer numeroDeFuncionarios) {
		this.numeroDeFuncionarios = numeroDeFuncionarios;
	}

	@Override
	public double valorImpostoPago() {
		Double imposto = 0.0;
		if (numeroDeFuncionarios >= 10) {
			imposto = getRendaAnual() * 14 / 100;
		} else {
			imposto = getRendaAnual() * 16 / 100;
		}
		return imposto;
	}

	@Override
	public String impriminto() {		
		return getNome() + ": $ " + String.format("%.2f", valorImpostoPago()) ;
	}	

}
