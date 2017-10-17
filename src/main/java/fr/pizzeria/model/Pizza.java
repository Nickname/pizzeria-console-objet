package fr.pizzeria.model;

import java.lang.reflect.*;

import javax.persistence.*;

@Entity
public class Pizza {
	
	@Id
	@Column(name="ID")
	private int id;
	
	@ToString
	@Column(name="CODE")
	private String code;
	
	@ToString
	@Column(name="NOM")
	private String nom;
	
	@ToString
	@Column(name="PRIX")
	private double prix;
	
	@ToString
	@Enumerated(EnumType.STRING)
	@Column(name="CATEGORIE")
	private CategoriePizza categorie;
	
	static int currentId = 0;
	
	public Pizza() {	}
	
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
		StringBuilder pizzaStr = new StringBuilder();
		Class<?> pizza = this.getClass();
		
		Field[] attributs = pizza.getDeclaredFields();
		
		try {
			for (Field f : attributs) {
				f.setAccessible(true);
				if (f.getAnnotation(ToString.class) != null) {
					if (f.getName() == "code") {
						pizzaStr.append(f.get(this) + " ");
					}
					if (f.getName() == "nom") {
						pizzaStr.append("-> " + f.get(this));
					}
					if (f.getName() == "prix") {
						pizzaStr.append(" (" + f.get(this) + " \u20ac)");
					}
					if (f.getName() == "categorie") {
						pizzaStr.append(" " + this.getCategorie());
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
		return pizzaStr.toString();
	}

}
