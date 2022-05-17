package fr.epsi.rennes.poec.gweltaz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.epsi.rennes.poec.gweltaz.domain.Ingredient;
import fr.epsi.rennes.poec.gweltaz.domain.Pizza;
import fr.epsi.rennes.poec.gweltaz.exception.TechnicalException;

@Repository
public class PizzaDAO {
	
	@Autowired
	private DataSource ds;
	
	public int createPizza (String label) {
		String sql = "insert into pizza (label) values (?)";
		try (
			Connection conn = ds.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql)) {
				ps.setString(1, label);		
				ps.executeUpdate();
				
				ResultSet rs = ps.getGeneratedKeys();
				if(rs.next()) {
					return rs.getInt(1);
				}
				throw new TechnicalException(new SQLException("Pizza Create Error"));
		} catch (SQLException e) {
			throw new TechnicalException(e);
		}
		
	}
	
	
	public void addIngredientToPizza (int pizzaId, int ingredientId) {
		
		String sql = "insert into pizza-ingredient"
				+ " (pizzaId, ingredientId) values (?,?)";
		try (Connection conn = ds.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, pizzaId);
			ps.setInt(2, ingredientId);
			ps.executeUpdate();
		}catch (SQLException e) {
			throw new TechnicalException(e);
		}
		
	}
	
	
	
	public List<Pizza> getAllPizzas(){
		String sql = "select "
				+ "pizza.id, pizza.label, "
				+ "group_concat(ingredient.name, ingredient.label) as ingredient "
				+ "from pizza "
				+ "left join pizza_has_ingredient "
				+ "on pizza_has_ingredient.ingredientId = pizza.id "
				+ "right join pizza_has_ingredient "
				+ "on pizza_has_ingredient.ingredientId = ingredient.id "
				+ "Group by pizza.id;";
		
		try (Connection conn = ds.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			
			ResultSet rs = ps.executeQuery();
			
			List<Pizza> pizzas = new ArrayList<>();
			
			while (rs.next()) {
				Pizza pizza = new Pizza();
				String ingredients = rs.getString("ingredients");
				
				List<Ingredient> ingredientsList = new ArrayList<>();
				
				
				for(String ingredient : ingredients.split(", ")) {
					Ingredient ingredientPojo = new Ingredient();
					ingredientPojo.setId(Integer.parseInt(ingredient));
					ingredientsList.add(ingredientPojo);


				}
				pizza.setIngredients(ingredientsList);
				pizza.setId(rs.getInt("pizzaId"));
				pizza.setLabel(rs.getString("pizzaLabel"));
				pizzas.add(pizza);
			}
			return pizzas;
			
		} catch (SQLException e) {
			throw new TechnicalException(e);
		}
	}
}