package fr.epsi.rennes.poec.gweltaz.service;

import org.springframework.stereotype.Service;

import fr.epsi.rennes.poec.gweltaz.dao.PanierDAO;
import fr.epsi.rennes.poec.gweltaz.domain.Panier;
import fr.epsi.rennes.poec.gweltaz.domain.Pizza;

@Service
public class PanierService {
	
	private PanierDAO panierDAO;
	
	public int addPizza(Pizza pizza, int panierId) {
		boolean exists = panierDAO.isPanierExists(panierId);
		if(!exists) {
			panierId = panierDAO.createPanier();
		}
		panierDAO.addPizza(pizza, panierId);
		return panierId;
	}
	
	public Panier getPanierById(int panierId) {
		return panierDAO.getPanierById(panierId);
	}

}
