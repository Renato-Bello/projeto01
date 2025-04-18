package steps;

import java.awt.AWTException;
import java.awt.Robot;

import elementos.ElementosDaPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import metodos.Metodos;
import runner.Executa;

public class CadastroTeste {
	
	ElementosDaPage preenchimento = new ElementosDaPage();
	Metodos metodo = new Metodos();
	

	@Given("que eu esteja na tela de cadastro")
	public void queEuEstejaNaTelaDeCadastro() {
		Executa.abrirPage(); 
	}
	
	@Given("preencha dados pessoais validos")
	public void preenchaDadosPessoaisValidos() {
		preenchimento.dadosPessoais("Renato", "44670089854", "rs-bello@hotmail.com", "11988353046");
		preenchimento.evidencias("positivomoto1");
	}
	
	@Given("preencha endereco valido")
	public void preenchaEnderecoValido() {
		preenchimento.endereco("05271200", "605", "não tem");
		preenchimento.click();
	}
	
	@Given("selecione tipo de veiculo")
	public void selecioneTipoDeVeiculo() {
		preenchimento.entregaMoto();
		preenchimento.evidencias("positivomoto2");
	   
	}
	
	@When("envio a foto da cnh valida")
	public void envioAFotoDaCnhValida() throws AWTException {
		preenchimento.clickUpload();
		 preenchimento.enviarImagem();
	}
	
	@Then("clicar em cadastrar para fazer entregas")
	public void clicarEmCadastrarParaFazerEntregas() {
		preenchimento.clicarParaCadastrar();
	}
	
	@Then("valido cadastro realizado com sucesso")
	public void validoCadastroRealizadoComSucesso() throws AWTException {
		Robot robot = new Robot();
		preenchimento.validaMsgAlert();
		robot.delay(2000);
		preenchimento.evidencias("positivomoto3");
		Executa.fecharPage();
	}
	
	
	
	
	
		
	@Given("preencha dados necessarios corretamente")
	public void preenchaDadosNecessariosCorretamente() {
		preenchimento.dadosPessoais("Renato", "44670089854", "rs-bello@hotmail.com", "11988353046");
		preenchimento.evidencias("positivobicicleta1");
		preenchimento.endereco("05271200", "605", "não tem");
		preenchimento.click();
	}
	@Given("selecione tipo de veiculo como bicicleta")
	public void selecioneTipoDeVeiculoComoBicicleta() {
		preenchimento.entregaBicicleta();
		preenchimento.evidencias("positivobicicleta2");
	}
	@When("envio foto da cnh valida")
	public void envioFotoDaCnhValida() throws AWTException {
		preenchimento.clickUpload();
		preenchimento.enviarImagem();
	}
	@Then("clicar em cadastrar para fazer as entregas")
	public void clicarEmCadastrarParaFazerAsEntregas() {
		preenchimento.clicarParaCadastrar();
	}
	@Then("valido mensagem cadastro realizado com sucesso")
	public void validoMensagemCadastroRealizadoComSucesso() throws AWTException {
		preenchimento.validaMsgAlert();
		Robot robot = new Robot();
		robot.delay(2000);
		preenchimento.evidencias("positivobicicleta3");
		Executa.fecharPage();
	}
	
	
	
	
	
	

	@Given("preencha todos os dados necessarios corretamente")
	public void preenchaTodosOsDadosNecessariosCorretamente() {
		preenchimento.dadosPessoais("Renato", "44670089854", "rs-bello@hotmail.com", "11988353046");
		preenchimento.evidencias("positivovan1");
		preenchimento.endereco("05271200", "605", "não tem");
		preenchimento.click();
	}
	@Given("selecione tipo de veiculo como van")
	public void selecioneTipoDeVeiculoComoVan() {
		preenchimento.entregaCarroVan();
		preenchimento.evidencias("positivovan2");
	}
	@When("envio uma foto da cnh valida")
	public void envioUmaFotoDaCnhValida() throws AWTException {
		preenchimento.clickUpload();
		preenchimento.enviarImagem();
	}
	@Then("clicar em cadastrar para fazer a entrega")
	public void clicarEmCadastrarParaFazerAEntrega() {
		preenchimento.clicarParaCadastrar();
	}
	@Then("valido o cadastro realizado com sucesso")
	public void validoOCadastroRealizadoComSucesso() throws AWTException {
		preenchimento.validaMsgAlert();
		Robot robot = new Robot();
		robot.delay(2000);
		preenchimento.evidencias("positivovan3");
		Executa.fecharPage();
	}
	
	
	
	
	
	
	
	@Given("nao informo nenhum dado obrigatorio")
	public void naoInformoNenhumDadoObrigatorio() throws AWTException {
		preenchimento.dadosPessoais("", "", "", "");
		preenchimento.endereco("", "", "");
		preenchimento.clickUpload();
		preenchimento.enviarImagem();
	}
	@When("eu clicar em cadastrar")
	public void euClicarEmCadastrar() {
		preenchimento.clicarParaCadastrar();
	}
	@Then("eu valido as mensagens nos campos indicando a obrigatoriedade do preenchimento")
	public void euValidoAsMensagensNosCamposIndicandoAObrigatoriedadeDoPreenchimento() throws AWTException {
		metodo.validarMgsAlert(preenchimento.msgAlertNomeBranco, "É necessário informar o nome");
		metodo.validarMgsAlert(preenchimento.msgAlertCpfBranco, "É necessário informar o CPF");
		metodo.validarMgsAlert(preenchimento.msgAlertEmailBranco, "É necessário informar o email");
		metodo.validarMgsAlert(preenchimento.msgAlertCepBranco, "É necessário informar o CEP");
		metodo.validarMgsAlert(preenchimento.msgAlertEnderecoBranco, "É necessário informar o número do endereço");
		metodo.validarMgsAlert(preenchimento.msgAlertMetodoEntrega, "Selecione o método de entrega");
		//metodo.validarMgsAlert(preenchimento.msgAlertFotoCnh, "Adicione uma foto da sua CNH");
		Robot robot = new Robot();
		robot.delay(3000);
		Executa.fecharPage();
	}
	
	
	
	
	
	
	
	

	@Given("informo dados obrigatorios invalidos")
	public void informoDadosObrigatoriosInvalidos() throws AWTException {
		preenchimento.dadosPessoais("Renato", "446700898", "rs-bello@hotmail.com", "88353046");
		preenchimento.endereco("0527120", "trinta", "não tem");
		preenchimento.click();
		preenchimento.entregaCarroVan();
		preenchimento.clickUpload();
		preenchimento.enviarImagem();
	}
	@When("eu clicar para cadastrar")
	public void euClicarParaCadastrar() {
		preenchimento.clicarParaCadastrar();
	}
	@Then("eu valido as mensagens nos campos indicando os dados invalidos")
	public void euValidoAsMensagensNosCamposIndicandoOsDadosInvalidos() throws AWTException {
		metodo.validarMgsAlert(preenchimento.msgCpfInvalido, "Oops! CPF inválido");
		Robot robot = new Robot();
		robot.delay(3000);
		Executa.fecharPage();
	}
	
	
	
	
	
	
	
	@Given("preencho os campos obrigatorios")
	public void preenchoOsCamposObrigatorios() {
		preenchimento.dadosPessoais("Renato", "44670089854", "rs-bello@hotmail.com", "11988353046");
		preenchimento.endereco("05271200", "605", "não tem");
	}
	@Given("nao anexo a cnh")
	public void naoAnexoACnh() {
		preenchimento.click();
		preenchimento.entregaBicicleta();
	}
	@When("eu clicar no botão para cadastrar")
	public void euClicarNoBotãoParaCadastrar() {
		preenchimento.clicarParaCadastrar();
	}
	@Then("eu valido a mensagem de erro sobre a obrigatoriedade do anexo")
	public void euValidoAMensagemDeErroSobreAObrigatoriedadeDoAnexo() throws AWTException {
		metodo.validarMgsAlert(preenchimento.msgAlertFotoCnh, "Adicione uma foto da sua CNH");
		Robot robot = new Robot();
		robot.delay(3000);
		Executa.fecharPage();
	}

	
	
	
	
	

	@Given("preencho todos os campos obrigatorios")
	public void preenchoTodosOsCamposObrigatorios() {
		preenchimento.dadosPessoais("Renato", "44670089854", "rs-bello@hotmail.com", "11988353046");
		preenchimento.endereco("05271200", "605", "não tem");
	}
	@Given("nao informo nenhum metodo de entrega")
	public void naoInformoNenhumMetodoDeEntrega() throws AWTException {
		preenchimento.click();
		preenchimento.clickUpload();
		preenchimento.enviarImagem();
	}
	@When("eu clicar no botão cadastrar")
	public void euClicarNoBotãoCadastrar() {
		preenchimento.clicarParaCadastrar();
	}
	@Then("eu valido a mensagem de erro sobre a obrigatoriedade de um metodo")
	public void euValidoAMensagemDeErroSobreAObrigatoriedadeDeUmMetodo() throws AWTException {
		metodo.validarMgsAlert(preenchimento.msgAlertMetodoEntrega, "Selecione o método de entrega");
		Robot robot = new Robot();
		robot.delay(3000);
		Executa.fecharPage();
	}




























}
