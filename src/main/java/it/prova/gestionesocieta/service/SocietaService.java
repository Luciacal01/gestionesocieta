package it.prova.gestionesocieta.service;

import java.util.List;

import it.prova.gestionesocieta.model.Societa;


public interface SocietaService {
	public List<Societa> listAll();
	
	public Societa caricaSingolaSocieta(Long id);
	
	public void aggiorna(Societa societaInstance);
	
	public void inserisciNuovo(Societa societaInstance);
	
	public void rimuovi(Societa societaInstance);
	
	public List<Societa> findByExample(Societa example);
	
	public List<Societa> CercatutteLeSocietaConDipendentiCheHannoRedditoAnnuoLordopiùalto(int valore);
}
