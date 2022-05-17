package fr.epsi.rennes.poec.gweltaz.domain;

import java.util.List;
import java.util.Map;

public class Pizza {
	
	private int id;
	private String label;
	private double price;
	private List<Ingredient> ingredients;
	private int nbCalories;
	
	
	
	///// GETTERS AND SETTERS /////
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public List<Ingredient> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	public int getNbCalories() {
		return nbCalories;
	}
	public void setNbCalories(int nbCalories) {
		this.nbCalories = nbCalories;
	}


    public void setPrix() {
		this.price=0;
    }

	public void setCalories() {
		this.nbCalories=0;
	}
}
