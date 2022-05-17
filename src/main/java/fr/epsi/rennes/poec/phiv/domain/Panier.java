package fr.epsi.rennes.poec.phiv.domain;

import java.util.List;

public class Panier {

	private int id;
	private int userEmail;
	private List<Pizza> pizzas;
	private double totalCalories;
	private double totalPrix;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(int userEmail) {
		this.userEmail = userEmail;
	}
	public List<Pizza> getPizzas() {
		return pizzas;
	}
	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}
	public double getTotalCalories() {
		return totalCalories;
	}
	public void setTotalCalories(double totalCalories) {
		this.totalCalories = totalCalories;
	}
	public double getTotalPrix() {
		return totalPrix;
	}
	public void setTotalPrix(double totalPrix) {
		this.totalPrix = totalPrix;
	}
	
	
}
