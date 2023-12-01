import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author Leônidas Alvarenga
 * @version 1.0
 * 
 * Classe que realiza o saque de conta dos clientes.
 */

public class Conta {

	private String tipoCliente;
	private double saldo;

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	/**
	 * Exibe o saldo do cliente especial
	 * 
	 * @param valor Saldo em conta
	 * @throws Throwable
	 */

	@Given("^Cliente especial com saldo de -(\\d+) reais$")
	public void cliente_especial_com_saldo_de_reais(int valor) throws Throwable {
		if ("especial".equals(tipoCliente)) {
			// Cliente especial pode sacar mesmo com saldo negativo
			saldo -= valor;
		} else if ("comum".equals(tipoCliente) && saldo >= valor) {
			// Cliente comum só pode sacar se o saldo for suficiente
			saldo -= valor;
		}
	}

	public double getSaldo() {
		return saldo;
	}

	/**
	 * Exibe o saque solicitado
	 * 
	 * @param valorSaque Valor do saque solicitado
	 * @throws Throwable
	 */

	@When("^solicitado saque no valor de (\\d+) reais$")
	public void solicitado_saque_no_valor_de_reais(int valorSaque) throws Throwable {
		if (tipoCliente.equals("especial")) {
			saldo -= valorSaque;
		} else {
			if (saldo > 0) {
				saldo -= valorSaque;
			} else {
				System.out.println("Saldo insuficiente.");
			}
		}
		throw new PendingException();
	}

	/**
	 * Efetua saque e atualiza o saldo
	 * 
	 * @param arg1 Valor do saldo atualizado
	 * @throws Throwable
	 */

	@Then("^efetuar saque e atualizar o saldo para -(\\d+) reais$")
	public void efetuar_saque_e_atualizar_o_saldo_para_reais(int arg1) throws Throwable {

		throw new PendingException();
	}

	/**
	 * 
	 * @throws Throwable
	 */

	@Then("^check more outcomes$")
	public void check_more_outcomes() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	public void main(String[] args) throws Throwable {
		// Exemplo de uso com os cenários do arquivo .feature
		Conta conta = new Conta();

		// Cenário 1: Cliente especial com saldo negativo
		conta.setTipoCliente("especial");
		conta.setSaldo(-200);
		System.out.println("Saldo inicial: " + conta.getSaldo());
		conta.solicitado_saque_no_valor_de_reais(100);
		System.out.println("Novo saldo: " + conta.getSaldo());

		// Cenário 2: Cliente comum com saldo negativo
		conta.setTipoCliente("comum");
		conta.setSaldo(-200);
		System.out.println("\nSaldo inicial: " + conta.getSaldo());
		conta.solicitado_saque_no_valor_de_reais(200);
		System.out.println("Novo saldo: " + conta.getSaldo());

	}
}
