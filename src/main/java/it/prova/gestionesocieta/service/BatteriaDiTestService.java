package it.prova.gestionesocieta.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.prova.gestionesocieta.model.Societa;

@Service
public class BatteriaDiTestService {
	@Autowired
	private SocietaService societaService;
	
	@Autowired
	private DipendenteService dipendenteService;
	
	public void testInserisciSocieta() throws Exception {
		Long nowInMillisecondi= new Date().getTime();
		
		Societa societaI= new Societa("Claudio s.p.a."+ nowInMillisecondi, "via dei mille, 16"+ nowInMillisecondi, new SimpleDateFormat("dd-MM-yyyy").parse("12-03-1965") );
		if(societaI.getId()!=null) throw new RuntimeException("testInserisciNuovoMunicipio failled");
		societaService.inserisciNuovo(societaI);
		if(societaI.getId()==null && societaI.getId() <1) throw new RuntimeException("testInserisciNuovoMunicipio failled");
		
		System.out.println("test inserimento ok");
	}
}
