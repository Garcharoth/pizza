package fr.epsi.rennes.poec.phiv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.epsi.rennes.poec.phiv.domain.Ingredient;
import fr.epsi.rennes.poec.phiv.domain.Pizza;
import fr.epsi.rennes.poec.phiv.domain.Response;
import fr.epsi.rennes.poec.phiv.exception.BusinessException;
import fr.epsi.rennes.poec.phiv.service.IngredientService;
import fr.epsi.rennes.poec.phiv.service.PizzaService;

@RestController
public class AdminController {

	@Autowired
	private PizzaService pizzaService;
	
	@Autowired
	private IngredientService ingredientservice;
	
	@GetMapping("/admin/ingredients")
	public Response<List<Ingredient>> getAllIngredients(){
		List<Ingredient> ingredients = ingredientservice.getAllIngredients();
		
		Response<List<Ingredient>> response = new Response<>();
		response.setData(ingredients);
		
		return response;
	}
	
	
	@PostMapping("/admin/pizza/create")
	public Response<Void> createPizza (@RequestBody Pizza pizza) throws BusinessException{
		pizzaService.createPizza(pizza);
		return new Response<>();
	}
	
	@PostMapping("/admin/pizza/ingredients")
	public Response<Void> addIngredientToPizza(@RequestParam int pizzaId, @RequestParam int ingredientId) throws BusinessException{
		pizzaService.addIngredientToPizza(pizzaId, ingredientId);
		return new Response<>();
	}
	
	@GetMapping("/admin/pizzas")
	public Response<List<Pizza>> getAllPizzas() {
		List<Pizza> pizzas = pizzaService.getAllPizzas();
		
		Response<List<Pizza>> response = new Response<>();
		response.setData(pizzas);
		return response;	
	}
}
