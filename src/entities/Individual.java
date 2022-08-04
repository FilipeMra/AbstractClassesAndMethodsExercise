package entities;

public class Individual extends TaxPayer {
	
	private Double healthExpenditures;	
	

	public Individual() {
		super();
	}

	public Individual(String name, Double anualIncome, Double healthExpenditures) {
		super(name, anualIncome);
		this.healthExpenditures = healthExpenditures;
	}
	

	public Double getHealthExpenditures() {
		return healthExpenditures;
	}

	public void setHealthExpenditures(Double healthExpenditures) {
		this.healthExpenditures = healthExpenditures;
	}

	
	@Override
	public Double tax() {
		double sum;
		if (getAnualIncome() < 20000.0) {
			sum = (getAnualIncome() * 0.15) - (getHealthExpenditures() * 0.5);
			return sum;
		}
		else {
			sum = (getAnualIncome() * 0.25) - (getHealthExpenditures() * 0.5);
			return sum;
		}
		
			
			
	}

}
