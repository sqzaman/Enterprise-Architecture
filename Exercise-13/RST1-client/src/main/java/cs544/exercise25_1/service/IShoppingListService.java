package cs544.exercise25_1.service;

public interface IShoppingListService {

	public ShoppingList getList();

	public Item getItem(String product);

	public void addToList(Item item);

	public void removeFromList(String product);

	public void updateItem(Item item);

}