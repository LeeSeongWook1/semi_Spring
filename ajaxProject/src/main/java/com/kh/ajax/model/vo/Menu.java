package com.kh.ajax.model.vo;

public class Menu {

	private int menuNo;
	private String menuName;
	private int price;
	private String material;
	public int getMenuNo() {
		return menuNo;
	}
	public void setMenuNo(int menuNo) {
		this.menuNo = menuNo;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public Menu(int menuNo, String menuName, int price, String material) {
		super();
		this.menuNo = menuNo;
		this.menuName = menuName;
		this.price = price;
		this.material = material;
	}
	public Menu() {
		super();
	}
	@Override
	public String toString() {
		return "Menu [menuNo=" + menuNo + ", menuName=" + menuName + ", price=" + price + ", material=" + material
				+ "]";
	}
	
	

}
