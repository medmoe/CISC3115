/**
@author: Mohammed Bekhouche
@since: 9-18-2019
versin:1.0
*/

public class Book {
	private String title;
	private String author;
	private String publisher;
	private int copiesSold;

	//constructor
	public Book(String title, String author, String publisher, int copiesSold){
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.copiesSold = copiesSold;
	}
	//mutators
	public void setTitle(String t){
		title = t;
	}
	public void setAuthor(String auth){
		author = auth;
	}
	public void setPublisher(String pub){
		publisher = pub;
	}
	public void setCopiesSold(int cSold){
		copiesSold = cSold;
	}
	//accessors
	public String getTitle(){
		return title;
	}
	public String getAuthor(){
		return author;
	}
	public String getPublisher(){
		return publisher;
	}
	public int getCopiesSold(){
		return copiesSold;
	}
}