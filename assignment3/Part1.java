
class Fruit {
	private String name;
	private String taste;
	private double size;
	
	// constructor
	public Fruit(String name, String taste){
		
		this.name = name;
		this.taste = taste;
	}//end constructor
	public String getName(){
		return name;
	}
	public String getTaste(){
		return taste;
	}
	public void eat(){
		System.out.println(getName() + " tastes " + getTaste());
	}
}//end Fruit class

class Apple extends Fruit {
	Apple(){
	super("Appel", "sweet");
	}
	public void eat(){
		System.out.println("Apple  tastes sweet");
	}
}// end Apple class
class Orange extends Fruit {
	Orange(){
	super("Orange", "sour");
	}
	public void eat(){
		System.out.println("Orange tastes sour");
	}
}//end Orange class
class Part1 {
	public static void main(String[] args){
		Apple a = new Apple();
		Orange o = new Orange();
		a.eat();
		o.eat();
	}
}
