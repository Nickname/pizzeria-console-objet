package fr.pizzeria.model;

public enum CategoriePizza {
	VIANDE("Viande"), POISSON("Poisson"), SANS_VIANDE("Sans Viande");
	
	String categorie;
	
	private CategoriePizza(String categorie) {
		this.categorie = categorie;
	}
	
	public String getCategorie() {
		return this.categorie;
	}
	
	public static CategoriePizza getType(String libelle) {
		CategoriePizza[] categories = values();
		
		for (CategoriePizza categ : categories) {
			if (categ.getCategorie().equals(libelle)) {
				return categ;
			}
		}
		return null;
	}
}
