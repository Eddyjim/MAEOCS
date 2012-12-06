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
	 * This method allows to get the local name
	 * @return a String that contains the node's name
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * This method allows to get the local number
	 * @return a String that contains the node's local number
	 */
	public String getLocalNumber() {
		return localNumber;
	}
	
	/**
	 * This method allows to get the category of the local
	 * @return the category of the node
	 */
	public Category getCategory(){
		return category;
	}
	
	/**
	 * This method allows to set the local name
	 * @param localName is an String that contains the value that is going to be settled
	 */
	public void setName(String localName) {
		this.name = localName;
	}

	/**
	 * This method allows to set the local number
	 * @param localNumber is an integer that contains the value that is going to be settled
	 */
	public void setLocalNumber(String localNumber) {
		this.localNumber = localNumber;
	}

	/**
	 * This method allows to set a category to the local
	 * @param localName is an String that contains the category that is going to be settled 
	 */
	public void setCategory(Category category) {
		this.category = category;
		
	}

}
