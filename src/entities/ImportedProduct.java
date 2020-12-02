package entities;

public class ImportedProduct extends Product{

	private Double customsFee;
	
	public ImportedProduct(){
			super();
	}

	public ImportedProduct(String name, Double price, Double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}

	public Double getCustomsfee() {
		return customsFee;
	}

	public void setCustomsfee(Double customsFee) {
		this.customsFee = customsFee;
	}
	
	@Override
	public String priceTag() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(super.getName());
		sb.append(" $ ");
		sb.append(String.format("%.2f", totalPrice()));
		sb.append(" (Customs free: $ ");
		sb.append(String.format("%.2f", customsFee) +")");
		
		return sb.toString();
	}
	public double totalPrice() {
		return super.getPrice() + customsFee;
	}
}
