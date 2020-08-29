package tema6;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;

public class TestHashMap{
    /* Definire date de test */    
    static String[][] studenti = { {"Tatar", "Robert"},
                            {"Tataru", "Alexandru"},
                            {"Tartar", "Ion"},
                            {"Tarat", "Vasile"},
                            {"Tratat", "Ioana"},
                            {"Trator", "Ana"},
                            {"Trater", "Gheorge"},
                            {"Tarar", "Marcela"},
                            {"Tatra", "Dorel"},
                            {"Pacate", "Ion"}
    };   
    static String[] cnpUri =   { "1981112080041",
                            	 "1980101716000",
                            	 "1982220185804",
                            	 "1980625343234",
                            	 "2983112752822",
                            	 "2980709223344",
                            	 "1971203332211",
                            	 "2990502345234",
                            	 "1990402034532",
                            	 "1980506070304"
    };  
    static public class StudentDetails {
        String nume;
        String prenume;
        double[] noteLibRomana = new double[10];
        double[] noteMatematica = new double[10];
    }    
    static StudentDetails student;
    
    public static void printStudent(String cnp, StudentDetails student) {
        System.out.println("[" + cnp + "] - " + student.prenume + ", " + student.nume);
        System.out.println("  note Romana: " + Arrays.toString(student.noteLibRomana));
        System.out.println("  note Mate:   " + Arrays.toString(student.noteMatematica));
    }
    public static HashMap<String, StudentDetails> catalog = new HashMap<String, StudentDetails>();
    public static LinkedHashMap<String, StudentDetails> lCatalog = new LinkedHashMap<String, StudentDetails>();
        
    public static void main(String []args){               
        // 1. Creare catalog cu HashMap (generare note aleator intre 4 si 10)
        
        System.out.println("\nCatalogul (HashMap) este:");

        for (int i=0; i<10; i++) {
            student = new StudentDetails();
            student.nume = studenti[i][0];
            student.prenume = studenti[i][1];
            Random ran = new Random();
            for (int j=0; j<10; j++) {
                student.noteLibRomana[j] = ran.nextInt(7) + 4;
                student.noteMatematica[j] = ran.nextInt(7) + 4;
            }
            printStudent(cnpUri[i], student);
            catalog.put(cnpUri[i], student);
        }
        // Afisare informatii pentru studentul cu CNP introdus la consola:
        System.out.print("\nIntrodu CNP: ");
        Scanner scanner = new Scanner(System.in);
        String studCNP = scanner.nextLine();
        StudentDetails s = catalog.get(studCNP);
        if (s!=null) {
            System.out.println("\nDetaliile pentru studentul cu CNP: ["+studCNP+"] sunt:");
            printStudent(studCNP, s);
            System.out.println();
        } else {
            System.out.println("\nStudentul cu CNP: ["+studCNP+"] nu exista in catalog");
        }       
        // 5. Rescriere detalii pentru studentul cu CNP introdus anterior la consola, 
        // daca exista in catalog CNP-ul respectiv
        if (s!=null) {
			// modificare prenume
            s.prenume = "Error";
			// modificare a doua nota la Romana si la Mate
            s.noteLibRomana[2-1] = 22.0;
            s.noteMatematica[2-1] = 11.0;
            catalog.put(studCNP, s);
        }       
        // re-afisare detalii catalog pentru acelasi student:
        s = catalog.get(studCNP);
        if (s!=null) {
            System.out.println("\nNoile detaliile pentru studentul cu CNP: ["+studCNP+"] sunt:");
            printStudent(studCNP, s);
            System.out.println();
        } else {
            System.out.println("\nStudentul cu CNP: ["+studCNP+"] nu exista in catalog");
        }          
        // 2. Afisare catalog cu getKey()
        System.out.println("\nAfisare catalog (HashMap):");
        Set set = catalog.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry)iterator.next();
            String rCNP = (String) mentry.getKey();
            StudentDetails rSD = new StudentDetails();
            rSD = (StudentDetails) mentry.getValue();
            printStudent( rCNP, rSD );
        }
         // 3. Creare catalog cu LinkedHashMap (generare note aleator intre 4 si 10)

        System.out.println("\nCatalogul (LinkedHashMap) este:");

        for (int i=0; i<10; i++) {
            student = new StudentDetails();
            student.nume = studenti[i][0];
            student.prenume = studenti[i][1];
            Random ran = new Random();
            for (int j=0; j<10; j++) {
                student.noteLibRomana[j] = ran.nextInt(7) + 4;
                student.noteMatematica[j] = ran.nextInt(7) + 4;
            }
            printStudent(cnpUri[i], student);
            lCatalog.put(cnpUri[i], student);
        }
        // Afisarea catalogului generat cu LinkedHashMap
        System.out.println("\nAfisare catalog (LinkedHashMap):");
        Set lSet = lCatalog.entrySet();
        Iterator lIterator = lSet.iterator();
        while(lIterator.hasNext()) {
            Map.Entry lMentry = (Map.Entry)lIterator.next();
            String rCNP = (String) lMentry.getKey();
            StudentDetails rSD = new StudentDetails();
            rSD = (StudentDetails) lMentry.getValue();
            printStudent( rCNP, rSD );
        }
     }
}