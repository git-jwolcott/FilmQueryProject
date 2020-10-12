package com.skilldistillery.filmquery.entities;

import java.util.List;

public class Film {

	private int id;
	private String title;
	private String description;
	private int releaseYear;
	private Language language;
	private int rentalDuration;
	private double rentalRate;
	private int length;
	private double replacementCost;
	private String rating;
	private String specialFeatures;
	
	private List<Category> category;
	private List<Actor> actors;
	private List<InventoryItem> inventoryItem;
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_MAGENTA = "\u001B[35m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public Film() {
		super();
	}

	public Film(int id, String title, String description, int releaseYear, Language language, int rentalDuration,
			double rentalRate, int length, double replacementCost, String rating, String specialFeatures,
			List<Actor> actors, List<Category> category, List<InventoryItem> inventoryItem) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.language = language;
		this.rentalDuration = rentalDuration;
		this.rentalRate = rentalRate;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.specialFeatures = specialFeatures;
		this.actors = actors;
		this.category = category;
		this.inventoryItem = inventoryItem;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public int getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public double getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public double getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}
	
	public List<Category> getCategory() {
		return category;
	}

	public void setCategory(List<Category> category) {
		this.category = category;
	}
	
	public List<InventoryItem> getInventoryItem() {
		return inventoryItem;
	}
	
	public void setInventoryItem(List<InventoryItem> inventoryItem) {
		this.inventoryItem = inventoryItem;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actors == null) ? 0 : actors.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((inventoryItem == null) ? 0 : inventoryItem.hashCode());
		result = prime * result + ((language == null) ? 0 : language.hashCode());
		result = prime * result + length;
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + releaseYear;
		result = prime * result + rentalDuration;
		long temp;
		temp = Double.doubleToLongBits(rentalRate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(replacementCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((specialFeatures == null) ? 0 : specialFeatures.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		if (actors == null) {
			if (other.actors != null)
				return false;
		} else if (!actors.equals(other.actors))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (inventoryItem == null) {
			if (other.inventoryItem != null)
				return false;
		} else if (!inventoryItem.equals(other.inventoryItem))
			return false;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		if (length != other.length)
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (releaseYear != other.releaseYear)
			return false;
		if (rentalDuration != other.rentalDuration)
			return false;
		if (Double.doubleToLongBits(rentalRate) != Double.doubleToLongBits(other.rentalRate))
			return false;
		if (Double.doubleToLongBits(replacementCost) != Double.doubleToLongBits(other.replacementCost))
			return false;
		if (specialFeatures == null) {
			if (other.specialFeatures != null)
				return false;
		} else if (!specialFeatures.equals(other.specialFeatures))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	public String toString() {
		return ("\n\nTitle: " + ANSI_GREEN + title + ANSI_RESET
				+ "\nYear Released: " + ANSI_BLUE + releaseYear + ANSI_RESET
				+ "\nRating: " + ANSI_RED + rating + ANSI_RESET
				+ "\nLanguage: " + ANSI_CYAN + showLanguage() + ANSI_RESET
				+ "\nDescription: " + ANSI_MAGENTA + description + ANSI_RESET
				+ "\nCast: " + ANSI_YELLOW + showActors() + ANSI_RESET);
	}
	
	public String showLanguage() {
		return language.getName();
	}
	
	public String showActors(){
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < actors.size(); i++) {
			if (i != actors.size() - 1) {
				builder.append(actors.get(i).toString());
				builder.append(", ");
			} else if (i == actors.size() - 1) {
				builder.append(actors.get(i).toString());
			}
		}
		return builder.toString();
	}
	
	public void showFilmDetails() {
		String s = "";
		s+=this.toString();
		s+= "\nRental Duration: " + rentalDuration 
			+ "\nRental Rate: " + ANSI_MAGENTA + rentalRate + ANSI_RESET 
			+ "\nLength: " + ANSI_CYAN + length + " minutes" + ANSI_RESET 
			+ "\nReplacement Cost: " + ANSI_RED + replacementCost + ANSI_RESET 
			+ "\nSpecial Features: " + ANSI_BLUE + specialFeatures + ANSI_RESET
			+ "\nCategory: " + ANSI_YELLOW + showCategory() + ANSI_RESET
			+ "\n" + showInventory();
			System.out.println(s);
	}
	
	public String showCategory() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < category.size(); i++) {
			if (i != category.size() - 1) {
				builder.append(category.get(i).getName());
				builder.append(", ");
			} else if (i == category.size() - 1) {
				builder.append(category.get(i).toString());
			}
		}
		return builder.toString();
	}
	
	public String showInventory() {
		StringBuilder builder = new StringBuilder();
		builder.append(inventoryItem.size());
		builder.append(" Copies in Inventory: ");
		for (int i = 0; i < inventoryItem.size(); i++) {
			if (i != inventoryItem.size() - 1) {
				builder.append("Copy ");
				builder.append(i + 1);
				builder.append(" Condition: ");
				 if(inventoryItem.get(i).getMediaCondition().equals("Used")) {
					builder.append(ANSI_BLUE);
				}
				else if(inventoryItem.get(i).getMediaCondition().equals("New")) {
					builder.append(ANSI_GREEN);
				}
				else if(inventoryItem.get(i).getMediaCondition().equals("Lost") || inventoryItem.get(i).getMediaCondition().equals("Damaged")) {
					builder.append(ANSI_RED);
				}
				else {builder.append(ANSI_YELLOW);}
				builder.append(inventoryItem.get(i).getMediaCondition());
				builder.append(ANSI_RESET);
				builder.append(", ");
			} else if (i == inventoryItem.size() - 1) {
				builder.append("Copy ");
				builder.append(i + 1);
				builder.append(" Condition: ");
				if(inventoryItem.get(i).getMediaCondition().equals("Used")) {
					builder.append(ANSI_BLUE);
				}
				else if(inventoryItem.get(i).getMediaCondition().equals("New")) {
					builder.append(ANSI_GREEN);
				}
				else if(inventoryItem.get(i).getMediaCondition().equals("Lost") || inventoryItem.get(i).getMediaCondition().equals("Damaged")) {
					builder.append(ANSI_RED);
				}
				else {builder.append(ANSI_YELLOW);}
				builder.append(inventoryItem.get(i).getMediaCondition());
				builder.append(ANSI_RESET);
			}
		}
		return builder.toString();
	}
	
}
