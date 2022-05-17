package fr.epsi.rennes.poec.phiv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.epsi.rennes.poec.phiv.domain.Ingredient;
import fr.epsi.rennes.poec.phiv.domain.Pizza;
import fr.epsi.rennes.poec.phiv.exception.TechnicalException;

@Repository
public class PizzaDAO {

	@Autowired
	private DataSource ds;

	public int createPizza(String libelle) {
		String sql = "Insert into pizza (libelle) values (?)";
		try {
			Connection conn = ds.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, libelle);
			ps.executeUpdate();
			
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) {
				return rs.getInt(1);
			}
			throw new TechnicalException(new SQLException("Pizza create error"));
		} catch (SQLException e) {
			throw new TechnicalException(e);
		}

	}

	public void addIngredientToPizza(int pizzaId, int ingredientID) {
		String sql = "Insert into pizza_has_ingredient (pizzaid, Ingredientid) values (?, ?)";
		try {
			Connection conn = ds.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, pizzaId);
			ps.setInt(2, ingredientID);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new TechnicalException(e);
		}
	}

	public List<Pizza> getAllPizzas(){
			String sql ="Select pizza.id as pizzaid, "
					+ "pizza.libelle as pizzalibelle, "
					+ "group_concat(ingredient.id, ingredient.libelle) as ingredient "
					+ "from pizza "
					+ "right join pizza_has_ingredient "
					+ "on pizza_has_ingredient.pizzaid = pizza.id "
					+ "left join ingredient "
					+ "on pizza_has_ingredient.ingredientid = ingredient.id "
					+ "group by pizza.id;";
			try {
				Connection conn = ds.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				
			ResultSet rs =	ps.executeQuery();
			
			List<Pizza> pizzas = new ArrayList<>();
			while (rs.next()) {
				Pizza pizza = new Pizza();
				String ingredients = rs.getString("ingredient");
				
				List<Ingredient> ingredientsList = new ArrayList<>();
				for (String ingredient: ingredients.split(",")) {
					Ingredient ingredientPojo = new Ingredient();
					ingredientPojo.setId(Integer.parseInt(ingredient));	
				}	
				pizza.setIngredients(ingredientsList);
                pizza.setId(rs.getInt("pizzaId"));
                pizza.setLibelle(rs.getString("libelle"));
                pizzas.add(pizza);
			}
		return pizzas;			
		} catch(SQLException e) {
			throw new TechnicalException(e);
		}	
	}
}
