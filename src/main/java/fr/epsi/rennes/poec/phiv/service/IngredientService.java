package fr.epsi.rennes.poec.phiv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.epsi.rennes.poec.phiv.dao.IngredientDAO;
import fr.epsi.rennes.poec.phiv.domain.Ingredient;

@Service
public class IngredientService {

	@Autowired
	private IngredientDAO ingredientDAO;
	
	public List<Ingredient> getAllIngredients(){
		return ingredientDAO.getAllIngredients();
	}
}
