package com.skilldistillery.filmquery.entities;

public class InventoryItem {
	private int id;
	private String mediaCondition;
	
	
	public InventoryItem() {
		super();
	}

	public InventoryItem(int id, String mediaCondition) {
		super();
		this.id = id;
		this.mediaCondition = mediaCondition;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMediaCondition() {
		return mediaCondition;
	}

	public void setMediaCondition(String mediaCondition) {
		this.mediaCondition = mediaCondition;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((mediaCondition == null) ? 0 : mediaCondition.hashCode());
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
		InventoryItem other = (InventoryItem) obj;
		if (id != other.id)
			return false;
		if (mediaCondition == null) {
			if (other.mediaCondition != null)
				return false;
		} else if (!mediaCondition.equals(other.mediaCondition))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return mediaCondition;
	}
	
	

	
	
}
