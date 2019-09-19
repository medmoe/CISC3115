/**
@author: Mohammed Bekhouche
@since: 9-18-2019
version: 1.1
*/

public class Pet{
	private String name;
	private String animal;
	private int age;
	//mutators
	public void setName(String n){
		name = n;
	}
	public void setAnimal(String a){
		animal = a;
	}
	public void setAge(int a){
		age = a;
	}
	//accessors
	public String getName(){
		return name;
	}
	public String getAnimal(){
		return animal;
	}
	public int getAge(){
		return age;
	}
	public static void main(String [] args){
		Pet harry = new Pet();
		harry.setName("paul");
		System.out.println(harry.getName());
	}

}