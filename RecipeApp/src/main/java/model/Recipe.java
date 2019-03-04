package model;


import java.util.List;

public class Recipe {

private String title;
private String href;
private String strthumbnail;
private List<String> ingredients;
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getHref() {
	return href;
}
public void setHref(String href) {
	this.href = href;
}
public List<String> getIngredients() {
	return ingredients;
}
public void setIngredients(List<String> ingredients) {
	this.ingredients = ingredients;
}
public String getStrthumbnail() {
	return strthumbnail;
}
public void setStrthumbnail(String strthumbnail) {
	this.strthumbnail = strthumbnail;
}
	
}
