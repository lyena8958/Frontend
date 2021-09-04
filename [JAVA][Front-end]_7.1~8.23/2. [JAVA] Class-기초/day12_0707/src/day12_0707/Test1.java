package day12_0707;


class Book{
	Book(String title){
		//this(title,"���ڹ̻�"); 
		// == this(title,"���ڹ̻�",10000); -> 11���� �Ѿ
		this(title,0); //-> 8���� �Ѿ
	}							
	Book(String title, int price){
		this(title,"���ڹ̻�",price);
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
		System.out.println("["+this.title+": "+this.author+"] "+this.price+"��" );
	}
	
}

public class Test1 {

	public static void main(String[] args) {
		
		Book b1 = new Book("�����", "�������丮");
		Book b2 = new Book("�ظ�����", "JK�Ѹ�",30000);
		Book b3 = new Book("������");
		
		//b2.author="��ȿ��";
		b2.setPrice(50000);
		
		b1.show();
		b2.show();
		b3.show();

	}

}
