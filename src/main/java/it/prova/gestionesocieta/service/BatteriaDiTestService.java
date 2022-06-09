package it.prova.gestionesocieta.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		
		Societa societaACuiAggiungereDip= societaService.listAll().get(0);
		if(societaACuiAggiungereDip.getId()== null) throw new RuntimeException("impossibile aggiungere dipendente non ci sono società");
		Dipendente dipendente = new Dipendente("Lucia "+ nowInMillisecondi, "Giovinazzo " +nowInMillisecondi, new SimpleDateFormat("dd-MM-yyyy").parse("31-07-2001"), 46890);
		dipendente.setSocieta(societaACuiAggiungereDip);
		dipendenteService.inserisciNuovo(dipendente);
		if(dipendente.getId()==null && dipendente.getId() <1) throw new RuntimeException("testInserisciDipendente failled");
		
		System.out.println("test inserimento ok");
	}
}
