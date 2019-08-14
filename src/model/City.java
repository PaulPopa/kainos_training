package model;
public class City {

	private int ID;
	private String name;
	private int population;
	private String district;
	private String countryCode;
	
	public City() {}
	
	public City(int id, String name, String countryCode, String district, int population) {
		setID(id);
		setName(name);
		setCountryCode(countryCode);
		setDistrict(district);
		setPopulation(population);
	}
	
	public City(String name, String countryCode, String district, int population) {
		setName(name);
		setCountryCode(countryCode);
		setDistrict(district);
		setPopulation(population);
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

}
