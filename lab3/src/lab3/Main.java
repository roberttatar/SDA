package lab3;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) { 

		List<Shape> shapes = new ArrayList<>();
		
		shapes.add( new Square("#70bf45", 3, 10));
		shapes.add( new Rectangle("#bf5b45", 2, 8, 15));
		shapes.add( new Circle("#2f9ebd", 5, 3));	

		for(Shape s: shapes)
		{
			System.out.print("Forma geometrica este: ");			
			System.out.println(s.getName());
			System.out.print("Aria este: ");	
			System.out.println(s.getArea());
			System.out.print("Border width: ");	
			System.out.println(s.getBorderWidth());
			System.out.print("Hex color: ");	
			System.out.println(s.getHexFillColor());
			System.out.println();
			s.Draw();
			System.out.println();
		}
	}
}