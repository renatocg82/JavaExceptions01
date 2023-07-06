package entities;

public class Contato {
	
	protected static Integer count = 0;
	

	protected String name;
	protected String tel;
	protected Integer id;
	protected String email;
	
	public Contato() {
		count = count + 1;
		this.id = count;
	}

	public Contato(String name, String tel, Integer id, String email) {
		
		this.name = name;
		this.tel = tel;
		this.id = id;
		this.email = email;
	}

	public Integer getCount() {
		return count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	
	public String toString() {
		String s;
		s = "[";
		s = s + "Id: " + id;
		s = s + ", Name: " + name;
		s = s + ", Telephone: " + tel;
		s += ", email: " + email;
		s += "]";
		return s;
	}
	
	
	
	
}
