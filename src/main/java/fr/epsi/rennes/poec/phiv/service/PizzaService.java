package fr.epsi.rennes.poec.phiv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.epsi.rennes.poec.phiv.dao.PizzaDAO;
import fr.epsi.rennes.poec.phiv.domain.Pizza;
import fr.epsi.rennes.poec.phiv.exception.BusinessException;

@Service
public class PizzaService {

	@Autowired
	private PizzaDAO pizzaDAO;
	
	public void createPizza(Pizza pizza) throws BusinessException{
		if(pizza.getLibelle() == null)
		{
			throw new BusinessException("pizza.libelle.null");
		}
		int pizzaId = pizzaDAO.createPizza(pizza.getLibelle());
		for (int i = 0; i< pizza.getIngredients().size();i++) {
			int ingredientId = pizza.getIngredients().get(i).getId();
			pizzaDAO.addIngredientToPizza(pizzaId, ingredientId);
		}
	}
	
	public void addIngredientToPizza(int pizzaId, int ingredientId) throws BusinessException{
		if(pizzaId < 0 || ingredientId <0)
		{
			throw new BusinessException("pizza.libelle.null");
		}
		pizzaDAO.addIngredientToPizza(pizzaId, ingredientId);
	}
	
	public List<Pizza> getAllPizzas(){
		List<Pizza> pizzas = pizzaDAO.getAllPizzas();
		return pizzas;
	}
}
