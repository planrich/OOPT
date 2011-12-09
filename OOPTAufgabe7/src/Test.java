import java.util.List;
import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {

		System.out.println("Moving animals from Springbrun!");
		
		List<Animal> animals = new ArrayList<Animal>();
		
		System.out.println("2 Elefants");
		animals.add(new Elefant("Reingard"));
		animals.add(new Elefant("Bado"));
		
		System.out.println("4 Giraffes");
		animals.add(new Giraffe("Heinz"));
		animals.add(new Giraffe("Franz"));
		animals.add(new Giraffe("Sepp"));
		animals.add(new Giraffe("Depp"));
		
		System.out.println("20 Pythons");
		for (int i = 0; i < 20; i++) {
			animals.add(new Python("python"+i));
		}
		
		System.out.println("30 Mambas");
		for (int i = 0; i < 30; i++) {
			animals.add(new Mamba("mamba"+i));
		}
		
		System.out.println("4 Turtles (2 small 2 big)");
		animals.add(new BigTurtle("Michelangelo"));
		animals.add(new BigTurtle("Leonardo"));
		animals.add(new SmallTurtle("Rafael"));
		animals.add(new SmallTurtle("Donartello"));
		
		
		System.out.println("a dolphin");
		animals.add(new Dolphin("Flipper"));
		
		System.out.println("2 seals");
		animals.add(new Seal("Mikey"));
		animals.add(new Seal("Maus"));
		
		System.out.println("a swordfish");
		animals.add(new Swordfish("Tom"));
		
		
		List<Section> sections = new ArrayList<Section>();

		System.out.print("Creating transporters to carry all animals...");

		Transporter truck = new Transporter(2, 1, 1, null);
		Transporter trailer0 = new Transporter(5, 1, 2, null);
		Transporter trailer1 = new Transporter(2, 0, 1, null);
		Transporter trailer2 = new Transporter(3, 1, 0, null);
		Transporter trailer3 = new Transporter(2, 0, 0, null);

		System.out.println("done");

	}
}
