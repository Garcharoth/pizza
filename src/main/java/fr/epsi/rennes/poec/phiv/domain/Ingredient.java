package fr.epsi.rennes.poec.phiv.domain;

public class Ingredient {
	
	private int id;
	private String type;
	private String libelle;
	private double nbCalories;
	private double prix;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public double getNbCalories() {
		return nbCalories;
	}
	public void setNbCalories(double d) {
		this.nbCalories = d;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
}
