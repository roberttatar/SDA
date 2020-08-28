package Hexa;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Shape> shapes = new ArrayList<>();
		shapes.add( new Square("#70bf45", 3, 10));
		shapes.add( new Rectangle("#bf5b45", 2, 8, 15));
		shapes.add( new Circle("#bf5b45", 5, 3));
		shapes.add( new Rectangle("#2f9ebd", 2, 8, 15));
		
		for(Shape s: shapes)
		{					
			System.out.println("Name of the shape: ");			
			System.out.println(s.getName());
			
			System.out.println("Area of the shape: ");	
			System.out.println(s.getArea());
			
			System.out.println("Border width: ");	
			System.out.println(s.getBorderWidth());
			
			System.out.println("Hex color: ");	
			System.out.println(s.getHexFillColor());
			
			System.out.println();
			s.draw();
			System.out.println();			
		}			
		String stringArray[] = new String[shapes.size()];//adauga culori
		int z=0;
		for(Shape s: shapes)
		{
			stringArray[z]=s.getHexFillColor();
			z++;							
		}				
	    Arrays.sort(stringArray);//sorteaza string array
		
	    int numberOfAppearance;
			  
		for(int i=0; i<stringArray.length; i++)//de la 0 la z descrescator
		{	  		
			if(stringArray[i] == stringArray[i+1])
			{
			    i++;
			}			
			numberOfAppearance = countOccurrences(stringArray, stringArray.length, stringArray[i]);
			
			System.out.println(stringArray[i] + " - " + numberOfAppearance );							
		}					
	}	
	static int countOccurrences(String arr[], int n, String x)
	{ 
	    int res = 0; 
	    for (int i=0; i<n; i++) 
	        if (x == arr[i]) 
	          res++; 
	    return res; 
	} 
}