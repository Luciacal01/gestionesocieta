package it.prova.gestionesocieta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.prova.gestionesocieta.service.BatteriaDiTestService;

@SpringBootApplication
public class GestionesocietaApplication implements CommandLineRunner {
	
	@Autowired
	public BatteriaDiTestService batteriaDiTestService;
	
	public static void main(String[] args) {
		SpringApplication.run(GestionesocietaApplication.class, args);
	}
	
	public void run(String... args) throws Exception{
		System.out.println("Inizio test");
		
		//batteriaDiTestService.testInserisciSocieta();
		//batteriaDiTestService.testInserisciDipendente();
		//batteriaDiTestService.testFindByExampleSocieta();
		//batteriaDiTestService.testRimuoviSocieta();
		//batteriaDiTestService.testModificaDipendente();
		//batteriaDiTestService.testCercaSocietaConDipendetiConRALMaggioreDi();
		batteriaDiTestService.testCercaIlDipendentePiÃ¹Anziano();
		System.out.println("Fine");
	}

}
