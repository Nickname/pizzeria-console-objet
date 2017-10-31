package fr.pizzeria.ihm;

abstract class OptionMenu {
	
	/** Renvoie le libellé du menu
	 * @return
	 */
	public abstract String getLibelle();
	
	/** Méthode abstraite des classes de Menus
	 * @param clavier
	 * @return
	 * @throws Exception
	 */
	protected abstract boolean execute() throws Exception;
}
