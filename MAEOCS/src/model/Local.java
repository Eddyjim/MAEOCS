package model;

public class Local {
	
	/**
	 * String that contains the local number given by the organization
	 */
	private String localNumber;
	
	/**
	 * String that contains the name of the local's name
	 */
	private String name;
	
	/**
	 * This variable differences the category of a node
	 */
	private Category category;
	
	/**
	 * It's a method to get the node's name
	 * @return a String that contains the node's name
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * It's a method to get the node's local number
	 * @return a String that contains the node's local number
	 */
	public String getLocalNumber() {
		return localNumber;
	}
	
	/**
	 * It's a method to get the category of the local
	 * @return the category of the node
	 */
	public Category getCategory(){
		return category;
	}

}
