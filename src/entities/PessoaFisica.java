package entities;

public class PessoaFisica extends Contribuinte {
	
	private Double gastosSaude;
	
	public PessoaFisica() {
	}

	public PessoaFisica(String nome, Double rendaAnual, Double gastosSaude) {
		super(nome, rendaAnual);
		this.gastosSaude = gastosSaude;
	}

	public Double getGastosSaude() {
		return gastosSaude;
	}

	public void setGastosSaude(Double gastosSaude) {
		this.gastosSaude = gastosSaude;
	}

	@Override
	public double valorImpostoPago() {
		Double imposto = 0.0;
		if (getRendaAnual() < 2000.00) {
			imposto = (getRendaAnual() * 15 / 100) - (gastosSaude * 50 / 100);
		}else  {
			imposto = (getRendaAnual() * 25 / 100) - (gastosSaude * 50 / 100);
		}		
		
		return imposto;
	}

	@Override
	public String impriminto() {		
		return getNome() + ": $ " + String.format("%.2f", valorImpostoPago()) ;
	}	
	

}
