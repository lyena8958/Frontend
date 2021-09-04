package day12_0707;


class Book{
	Book(String title){
		//this(title,"작자미상"); 
		// == this(title,"작자미상",10000); -> 11열로 넘어감
		this(title,0); //-> 8열로 넘어감
	}							
	Book(String title, int price){
		this(title,"작자미상",price);
	}
	Book(String title, String author){
		this(title,author,10000);
	}
	Book(String title, String author, int price){
		this.title=title;
		this.author=author;
		this.price = price;
	}
	private String title;
	private String author;
	private int price;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	void show() {
		System.out.println("["+this.title+": "+this.author+"] "+this.price+"원" );
	}
	
}

public class Test1 {

	public static void main(String[] args) {
		
		Book b1 = new Book("어린왕자", "생텍쥐페리");
		Book b2 = new Book("해리포터", "JK롤링",30000);
		Book b3 = new Book("춘향전");
		
		//b2.author="김효경";
		b2.setPrice(50000);
		
		b1.show();
		b2.show();
		b3.show();

	}

}
