package Week_Four;

public class Address {
	private String country, province, city, street, postcode;

	public Address() {
		country = "中国";
		province = "湖北省";
		city = "武汉市";
		street = "阳光大道";
		postcode = "123456";
	}
	
	public Address(String country, String province, String city, String street, String postcode) {
		this.country = country;
		this.province = province;
		this.city = city;
		this.street = street;
		this.postcode = postcode;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountry() {
		return this.country;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getProvince() {
		return this.province;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCity() {
		return this.city;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreet() {
		return this.street;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getPostcode() {
		return this.postcode;
	}

	public String getAddress() {
		String address;
		address = this.country;
		address += "-" + this.province;
		address += "-" + this.city;
		address += "-" + this.street;
		address += "-" + this.postcode;
		return address;
	}
}