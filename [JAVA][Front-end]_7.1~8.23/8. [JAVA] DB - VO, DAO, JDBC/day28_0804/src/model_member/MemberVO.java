package model_member;

public class MemberVO {
	private int mid;
	private String name;
	private int age;
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "MemberVO [mid=" + mid + ", name=" + name + ", age=" + age + "]";
	}
	
}
