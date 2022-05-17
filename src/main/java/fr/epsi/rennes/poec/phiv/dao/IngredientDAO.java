package fr.epsi.rennes.poec.phiv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.epsi.rennes.poec.phiv.domain.Ingredient;
import fr.epsi.rennes.poec.phiv.exception.TechnicalException;

@Repository
public class IngredientDAO {

	@Autowired
	private DataSource ds;
	
	public List<Ingredient> getAllIngredients(){
		String sql ="select * from ingredient";
		try (Connection conn = ds.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			List<Ingredient> ingredients = new ArrayList<>();
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				Ingredient ingredient = new Ingredient();
				ingredient.setId(rs.getInt("id"));
				ingredient.setLibelle(rs.getString("libelle"));
				ingredient.setNbCalories(rs.getDouble("nbCalories"));
				ingredient.setPrix(rs.getDouble("prix"));
				ingredient.setType(rs.getString("type"));
				ingredients.add(ingredient);
			}
			return ingredients;
		}catch (Exception e) {
			throw new TechnicalException(e);
		}
		
	}
}
