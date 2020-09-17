package entities;

public class ImportedProduct extends Product {
	
	private Double costumsFee;
	
	public ImportedProduct() {
		super();
	}

	public ImportedProduct(String name, Double price, Double costumsFee) {
		super(name, price);
		this.costumsFee = costumsFee;
	}

	public Double getCostumFee() {
		return costumsFee;
	}

	public void setCostumsFee(Double costumsFee) {
		this.costumsFee = costumsFee;
	}
	
	public Double totalPrice() {
		return getPrice() + costumsFee;
	}
	
	@Override
	
	public String priceTag () {
		return getName()
					+ " $ "
					+ String.format("%.2f", totalPrice())
					+ " (" 
					+ String.format("Costums fee: %.2f", costumsFee)
					+ ")";
	}
	
}
