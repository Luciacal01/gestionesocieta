package it.prova.gestionesocieta.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.prova.gestionesocieta.Exception.SonoPresentiDipendenti;
import it.prova.gestionesocieta.model.Dipendente;
import it.prova.gestionesocieta.model.Societa;

@Service
public class BatteriaDiTestService {
	@Autowired
	private SocietaService societaService;
	
	@Autowired
	private DipendenteService dipendenteService;
	
	public void testInserisciSocieta() throws Exception {
		Long nowInMillisecondi= new Date().getTime();
		
		Societa societaI= new Societa("Calabria s.p.a."+ nowInMillisecondi, "via dei mille, 980 "+ nowInMillisecondi, new SimpleDateFormat("dd-MM-yyyy").parse("31-10-1888") );
		if(societaI.getId()!=null) throw new RuntimeException("testInserisciNuovoMunicipio failled");
		societaService.inserisciNuovo(societaI);
		if(societaI.getId()==null && societaI.getId() <1) throw new RuntimeException("testInserisciNuovoMunicipio failled");
		
		System.out.println("test inserimento ok");
	}
	
	public void testInserisciDipendente() throws Exception {
		Long nowInMillisecondi= new Date().getTime();
		
		Societa societaACuiAggiungereDip= societaService.listAll().get(1);
		if(societaACuiAggiungereDip.getId()== null) throw new RuntimeException("impossibile aggiungere dipendente non ci sono società");
		Dipendente dipendente = new Dipendente("Veronica "+ nowInMillisecondi, "Cortina " +nowInMillisecondi, new SimpleDateFormat("dd-MM-yyyy").parse("23-07-2004"), 8000);
		dipendente.setSocieta(societaACuiAggiungereDip);
		dipendenteService.inserisciNuovo(dipendente);
		if(dipendente.getId()==null && dipendente.getId() <1) throw new RuntimeException("testInserisciDipendente failled");
		
		System.out.println("test inserimento ok");
	}
	
	public void testFindByExampleSocieta() throws Exception {
		
		System.out.println(".......TestFindByExample inizio.......");
		Societa societaExample= new Societa("PC s.p.a.", null, null);
		List<Societa> trovata= societaService.findByExample(societaExample);
		for (Societa societaItem : trovata) {
			System.out.println(societaItem.getRagioneSociale());
		}
		if(trovata.size()!=1) throw new RuntimeException("Test Failed: società non trovata");
		System.out.println(".......TestFindByExample terminato.......");
		
	}
	
	public void testRimuoviSocieta() throws ParseException {
		System.out.println("........TestRimuoviSocieta..........");
		Societa societaI= new Societa("Calabria s.p.a.", "via dei mille, 980 ", new SimpleDateFormat("dd-MM-yyyy").parse("31-10-1888") );
		societaService.inserisciNuovo(societaI);
		if(societaI.getDipendenti().size()!=0) throw new SonoPresentiDipendenti("Test Failed: sono ancora associati dei dipendenti");
		societaService.rimuovi(societaI);
		System.out.println(".......testRimuoviSocieta terminato........");
	}
	
	public void testModificaDipendente() throws Exception {
		System.out.println("..........TestModificaDipendente inizio...........");
		
		Societa societa= new Societa("Gerani ", "Corso Franci, 980 ", new SimpleDateFormat("dd-MM-yyyy").parse("31-10-2009") );
		societaService.inserisciNuovo(societa);
		if(societa.getId()== null) throw new RuntimeException("impossibile aggiungere dipendente non ci sono società");
		Dipendente dipendente = new Dipendente("Giuseppe ", "Verdi" , new SimpleDateFormat("dd-MM-yyyy").parse("10-02-2009"), 650000);
		dipendente.setSocieta(societa);
		dipendenteService.inserisciNuovo(dipendente);
		if(dipendente.getId()==null && dipendente.getId() <1) throw new RuntimeException("testInserisciDipendente failled");
		
		Dipendente dipendenteDaModificare = new Dipendente("Mario ", "Verdi" , new SimpleDateFormat("dd-MM-yyyy").parse("10-02-2009"), 650000);
		dipendenteDaModificare.setSocieta(societa);
		dipendenteDaModificare.setId(dipendente.getId());
		
		dipendenteService.aggiorna(dipendenteDaModificare);
		
		System.out.println("..........TestModificaDipendente fine...........");
	}
}
/*
Societa societa= new Societa("Gerani ", "Corso Franci, 980 ", new SimpleDateFormat("dd-MM-yyyy").parse("31-10-2009") );
societaService.inserisciNuovo(societa);
if(societa.getId()== null) throw new RuntimeException("impossibile aggiungere dipendente non ci sono società");
Dipendente dipendente = new Dipendente("Giuseppe ", "Verdi" , new SimpleDateFormat("dd-MM-yyyy").parse("10-02-2009"), 650000);
dipendente.setSocieta(societa);
dipendenteService.inserisciNuovo(dipendente);
if(dipendente.getId()==null && dipendente.getId() <1) throw new RuntimeException("testInserisciDipendente failled");
*/