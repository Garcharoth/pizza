package fr.epsi.rennes.poec.phiv.domain;

import java.util.List;
import java.util.Map;

public class Pizza {
	
	private int id;
	private String libelle;
	private int prix;
	private List<Ingredient> ingredients;
	private int nbCalories;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
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
}
