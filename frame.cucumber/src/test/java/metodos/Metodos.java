package metodos;

import static org.junit.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import driver.DriversFactory;

public class Metodos extends DriversFactory{
	
public void preencher(By elemento, String texto, String passo) {
		
		try {
			driver.findElement(elemento).sendKeys(texto);
		} catch (Exception e) {
			System.out.println("*** ERRO AO ESCREVER NO PASSO" + passo + " ***");
			System.out.println("*** CAUSA DO ERRO" + e.getCause());
			System.out.println("*** MENSAGEM DO ERRO" + e.getMessage());
		}
	}
	
	public void clicar(By elemento, String passo) {
		
		try {
			driver.findElement(elemento).click();
		} catch (Exception e) {
			System.out.println("*** ERRO AO CLICAR" + passo + " ***");
			System.out.println("*** CAUSA DO ERRO" + e.getCause());
			System.out.println("*** MENSAGEM DO ERRO" + e.getMessage());
		}
	}
	
	public void uploadArquivo(String descricaoPasso) throws AWTException {
	
		Robot robot = new Robot();
		robot.delay(1000);
		StringSelection ss = new StringSelection("C:\\Users\\Renato\\OneDrive\\Documentos\\CNH2.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.delay(1000);
		robot.keyRelease(KeyEvent.VK_V);
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(1000);
	}
	
	public void validarMgsAlert(By elemento, String textoEsperado) {
		String textoCapturadoDoElemento = driver.findElement(elemento).getText();
		assertEquals(textoEsperado, textoCapturadoDoElemento);
	}
	
	public void validarMgsAlert2(By elemento, String textoEsperado) {
		String textoCapturadoDoElemento = driver.findElement(elemento).getText();
		assertEquals(textoEsperado, textoCapturadoDoElemento);
	}
	
	public void capturarScreenShot(String historia, String nomeDoArquivo) {
		String timestamp = new SimpleDateFormat("ddMMYYYY").format(new Date());
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(screenshot, new File("./evidencias/" + historia + "/" + timestamp + "/" + nomeDoArquivo + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

}
	}
