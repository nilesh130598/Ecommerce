package app.ecommerce.category.model;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Category {

	@Id
	int id;
	String name;
	String image;
	boolean enabled;
	int parentid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public int getParentid() {
		return parentid;
	}
	public void setParentid(int parentid) {
		this.parentid = parentid;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", image=" + image + ", enabled=" + enabled + ", parentid="
				+ parentid + "]";
	}
	
	
	
}
