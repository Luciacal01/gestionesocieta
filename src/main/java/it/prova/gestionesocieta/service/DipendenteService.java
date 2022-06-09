package it.prova.gestionesocieta.service;

import java.util.Date;
import java.util.List;

import it.prova.gestionesocieta.model.Dipendente;

public interface DipendenteService {
	public List<Dipendente> listAll();
	
	public Dipendente caricaSingoloDipendente(Long id);
	
	public void aggiorna(Dipendente dipendenteInstance);
	
	public void inserisciNuovo(Dipendente dipendenteInstance);
	
	public void rimuovi(Dipendente dipendenteInstance);
	
	public List<Dipendente> findByExample(Dipendente example);
	
	public Dipendente cercaIlDipendentePiùAnziano() throws Exception;
}
