class Shape {

	public void draw(){
		System.out.println("drawing shape");
	}
	public void erase(){
		System.out.println("erasing shape");
	}
}

class Circle extends Shape {
	public void draw(){
		System.out.println("drawing circle");
	}
	public void erase(){
		System.out.println("erasing circle");
	}
}
class  Triangle extends Shape {
	public void draw(){
		System.out.println("drawing triangle");
	}
	public void erase(){
		System.out.println("erasing triangle");
	}
}
class Square extends Shape {
	public void draw(){
		System.out.println("drawing square");
	}
	public void erase(){
		System.out.println("erasing square");
	}
}
class ShapeDemo {
	public static void main(String [] args){
		Shape c = new Circle();
		Shape t = new Triangle();
		Shape s = new Square();
		c.draw(); c.erase();
		t.draw(); t.erase();
		s.draw(); s.erase();
	}
}
