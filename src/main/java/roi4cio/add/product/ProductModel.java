package roi4cio.add.product;

public class ProductModel {
	private final String title;
	
	private final String category;
	
	private final String deliveryType;

	public ProductModel(String title, String deliveryType, String category) {
		super();
		this.title = title;
		this.category = category;
		this.deliveryType = deliveryType;
	}

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public String getDeliveryType() {
		return deliveryType;
	}

	@Override
	public String toString() {
		return "ProductModel [title=" + title + ", category=" + category + ", deliveryType=" + deliveryType + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((deliveryType == null) ? 0 : deliveryType.hashCode());
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
		ProductModel other = (ProductModel) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (deliveryType == null) {
			if (other.deliveryType != null)
				return false;
		} else if (!deliveryType.equals(other.deliveryType))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	
	
}
