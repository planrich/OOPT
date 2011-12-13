import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		
		System.out.println("Moving animals from Springbrun!");
		
		List<Animal> animals = new ArrayList<Animal>();
		
		System.out.println("2 Elefants");
		animals.add(new Elefant("elefant0"));
		animals.add(new Elefant("elefant1"));
		
		System.out.println("4 Giraffes");
		animals.add(new Giraffe("griaffe0"));
		animals.add(new Giraffe("griaffe1"));
		animals.add(new Giraffe("griaffe2"));
		animals.add(new Giraffe("griaffe3"));
		
		System.out.println("20 Pythons");
		for (int i = 0; i < 20; i++) {
			animals.add(new Python("python"+i));
		}
		
		System.out.println("30 Mambas");
		for (int i = 0; i < 30; i++) {
			animals.add(new Mamba("mamba"+i));
		}
		
		System.out.println("4 Turtles (2 small 2 big)");
		animals.add(new BigTurtle("bigtrutle0"));
		animals.add(new BigTurtle("bigturtle1"));
		animals.add(new SmallTurtle("smallturtle0"));
		animals.add(new SmallTurtle("smallturtle1"));
		
		
		System.out.println("a dolphin");
		animals.add(new Dolphin("Flipper"));
		
		System.out.println("2 seals");
		animals.add(new Seal("seal0"));
		animals.add(new Seal("seal1"));
		
		System.out.println("66 swordfishs");
		for (int i = 0; i < 66; i++) {
			animals.add(new Swordfish("swordfish" + i));
		}
		
		
		System.out.println("Animals count: " + animals.size());
		System.out.println();
		
		System.out.println("For moving there are some different kinds of moving boxes:");
		
		List<Section> sections = new ArrayList<Section>();
		
		System.out.println("big & small terrarium (each 1)");
		Section sec0 = new BigTurtleTerrarium();
		Section sec1 = new SmallTurtleTerrarium();
		sections.add(sec0);
		sections.add(sec1);
		
		System.out.println("2 mamba terrariums and 4 python terrariums");
		Section t0 = new MambaTerrarium();
		Section t1 = new MambaTerrarium();
		Section t3 = new PythonTerrarium();
		Section t4 = new PythonTerrarium();
		Section t5 = new PythonTerrarium();
		Section t6 = new PythonTerrarium();
		sections.add(t0);
		sections.add(t1);
		sections.add(t3);
		sections.add(t4);
		sections.add(t5);
		sections.add(t6);
		
		System.out.println("1 land/water tank & 2 watertanks");
		Section s0 = new WaterLandTank();
		Section s1 = new WaterTank();
		sections.add(s0);
		sections.add(s1);
		
		System.out.println("Sections count: " + sections.size());
		System.out.println();
		
		System.out.println("Creating containers to carry all animals:");
		
		BigGame[] bigGames = new BigGame[2];
		bigGames[0] = new Elefant("Elefant1");
		bigGames[1] = new Giraffe("Giraffe1");
		
		BigGame[] bigGames2 = new BigGame[2];
		bigGames[0] = new Giraffe("Giraffe3");
		bigGames[1] = new Giraffe("Giraffe4");
		
		Transporter truck = new Transporter(bigGames, 3, 3, 3, 2, 2, 2, 2);
		Trailer trailer = new Trailer(bigGames2, 2, 3, 3, 2, 2, 2, 2);
		truck.load(trailer);

		System.out.println("Moving all animals to Schšnbrunn using the given transporters!");
		System.out.println("Of course there is by far not enought space to move them in one trip so lets compute the trips:");

		
		List<Animal> animals_in_schoenbrunn = new ArrayList<Animal>();
		
		int trip = 1;
		int loaded = -1;
		while (loaded != 0) {
			loaded = 0;
			Iterator<Animal> it = animals.iterator();
			while (it.hasNext()) {
				Animal a = it.next();
				System.out.print("trying to load animal '" + a.getName() + "' to a transporter...");
				if (canLoadTo(truck,a)) {
					it.remove();
					System.out.println("loaded");
					loaded++;
				} else {
					System.out.println("failed");
				}
			}
			
			System.out.println("trip " + trip + ": tried to load as much animals as possible (loaded "+loaded+")... unloading all transporters in Schšnbrunn");
			trip++;

			List<Animal> unloadedAnimals = truck.unload();
			for(Animal a : unloadedAnimals) {
				animals_in_schoenbrunn.add(a);
			}
		}		
	}
	
	private static boolean canLoadTo(Transporter transporter, Animal animal) {
		if (animal.load(transporter)) {
			return true;
		}
		return false;
	}
	
}
