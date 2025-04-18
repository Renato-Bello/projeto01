package elementos;

import java.awt.AWTException;

import org.openqa.selenium.By;

import metodos.Metodos;

public class ElementosDaPage {
	
	// ******** PRENCHIMENTO DADOS PESSOAIS ********
		public By nome = By.name("name");
		public By cpf = By.name("cpf");
		public By email = By.name("email");
		public By whatsapp = By.name("whatsapp");

		// ******** PRENCHIMENTO ENDEREÇO ********
		public By cep = By.name("postalcode");
		public By button = By.xpath("//input[@type='button']");
		public By numero = By.name("address-number");
		public By complemento = By.name("address-details");

		// ******** OPÇÕES DE ENTREGA ********
		public By entregaMoto = By.xpath("//span[text()='Moto']");
		public By entregaBicicleta = By.xpath("//span[text()='Bicicleta']");
		public By entregaCarroVan = By.xpath("//span[text()='Van/Carro']");

		// ******** ANEXAR CNH ********
		public By buttonArquivo = By.xpath("//*[text()='Foto da sua CNH']");

		// ******** ANEXAR CNH ********
		public By buttonCadastro = By.xpath("//*[text()='Cadastre-se para fazer entregas']");
		
		// ******** MSGs ALERT ********
			public By msgAlert = By.xpath("//*[text()='Recebemos os seus dados. Fique de olho na sua caixa de email, pois e em breve retornamos o contato.']");
			public By msgAlertNomeBranco = By.xpath("//*[text()='É necessário informar o nome']");
			public By msgAlertCpfBranco = By.xpath("//*[text()='É necessário informar o CPF']");
			public By msgAlertEmailBranco = By.xpath("//*[text()='É necessário informar o email']");
			public By msgAlertCepBranco = By.xpath("//*[text()='É necessário informar o CEP']");
			public By msgAlertEnderecoBranco = By.xpath("//*[text()='É necessário informar o número do endereço']");
			public By msgAlertMetodoEntrega = By.xpath("//*[text()='Selecione o método de entrega']");
			public By msgAlertFotoCnh = By.xpath("//*[text()='Adicione uma foto da sua CNH']");
			public By msgCpfInvalido = By.xpath("//*[text()='Oops! CPF inválido']");
			
		Metodos metodo = new Metodos();

		public void dadosPessoais(String nome, String cpf, String email, String whatsapp) {
			metodo.preencher(this.nome, nome, "informar o nome");
			metodo.preencher(this.cpf, cpf, "informar o cpf");
			metodo.preencher(this.email, email, "informar o email");
			metodo.preencher(this.whatsapp, whatsapp, "informar o whatsapp");

		}

		public void endereco(String cep, String numero, String complemento) {
			metodo.preencher(this.cep, cep, "informar o cep");
			metodo.preencher(this.numero, numero, "informar o numero");
			metodo.preencher(this.complemento, complemento, "informar o complemento");
		}

		public void click() {
			metodo.clicar(this.button, "presionar botão clicar");
		}

		public void entregaMoto() {
			metodo.clicar(this.entregaMoto, "Opção de entrega");
		}

		public void entregaBicicleta() {
			metodo.clicar(this.entregaBicicleta, "Opção de entrega");
		}

		public void entregaCarroVan() {
			metodo.clicar(this.entregaCarroVan, "Opção de entrega");
		}

		public void clickUpload() {
			metodo.clicar(this.buttonArquivo, "botão upload de imagem");
		}

		public void enviarImagem() throws AWTException {
			metodo.uploadArquivo("clicando no botão confirmar cadastro");
		}

		public void clicarParaCadastrar() {
			metodo.clicar(this.buttonCadastro, "botão de cadastrar");
		}
		public void validaMsgAlert() {
			metodo.validarMgsAlert(this.msgAlert, "Recebemos os seus dados. Fique de olho na sua caixa de email, pois e em breve retornamos o contato.");
		}
		
		public void evidencias(String nomeDoTeste) {
			metodo.capturarScreenShot("Cadastro", nomeDoTeste);
		}
		
		

}
