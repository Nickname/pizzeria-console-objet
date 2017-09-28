package fr.pizzeria.model;

import java.lang.reflect.*;

public class Pizza {
	private int id;
	@ToString
	private String code;
	@ToString
	private String nom;
	@ToString
	private double prix;
	@ToString
	private CategoriePizza categorie;
	static int currentId = 0;
	
	public Pizza(String code, String nom, double prix, CategoriePizza categorie) {
		this.id = currentId++;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categorie = categorie;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	public String getCategorie() {
		return categorie.getCategorie();
	}

	public void setCategorie(CategoriePizza categorie) {
		this.categorie = categorie;
	}

	public String toString() {
		//return (this.code + "-> " + this.nom + " (" + this.prix + " \u20ac) " + this.categorie);
		String pizzaStr = new String("");
		Class<?> pizza = this.getClass();
		
		Field[] attributs = pizza.getDeclaredFields();
		
		try {
			for (Field f : attributs) {
				f.setAccessible(true);
				if (f.getAnnotation(ToString.class) != null) {
					if (f.getName() == "code") {
						pizzaStr += f.get(this) + " ";
					}
					if (f.getName() == "nom") {
						pizzaStr += "-> ";
						pizzaStr += f.get(this);
					}
					if (f.getName() == "prix") {
						pizzaStr += " (" + f.get(this) + " \u20ac)";
					}
					if (f.getName() == "categorie") {
						pizzaStr += " " + this.getCategorie();
					}
				}
			}
		} catch (SecurityException e) {
			e.getMessage();
			return "";
		} catch (IllegalArgumentException e) {
			e.getMessage();
			return "";
		} catch (IllegalAccessException e) {
			e.getMessage();
			return "";
		}
		return pizzaStr;
	}

}
