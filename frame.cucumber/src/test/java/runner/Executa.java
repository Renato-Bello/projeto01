package runner;

import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import driver.DriversFactory;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import io.github.bonigarcia.wdm.WebDriverManager;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = "src/test/resources/features",
		glue = "steps",
		dryRun = false, //TRUE: estou em planejamento - FALSE: estou em execução
		tags = "@regressivos",
		monochrome = false,
		plugin = {"pretty","html:target/cucumber-report.html"},
		snippets = SnippetType.CAMELCASE
	
		)

public class Executa extends DriversFactory {

	public static void abrirPage() {
		String ambiente = "https://buger-eats.vercel.app/deliver";
		String navegador = "Edge";
		
		if (navegador.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		driver.get(ambiente);
		driver.manage().window().maximize();

}
	public static void fecharPage() {
		driver.quit();
	}
}
