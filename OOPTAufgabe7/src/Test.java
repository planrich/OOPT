import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		
		System.out.println("Moving animals from Springbrun!");
		
		List<Animal> animals = new ArrayList<Animal>();
		
		System.out.println("2 Elefants");
		System.out.println("2 Giraffes");
		BigGame[] bigGames = new BigGame[2];
		bigGames[0] = new Elefant("Elefant1");
		bigGames[1] = new Giraffe("Giraffe1");
		
		BigGame[] bigGames2 = new BigGame[2];
		bigGames2[0] = new Giraffe("Giraffe3");
		bigGames2[1] = new Giraffe("Giraffe4");
		
		animals.add(bigGames[0]);
		animals.add(bigGames[1]);

		animals.add(bigGames2[0]);
		animals.add(bigGames2[1]);
		
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
		
		System.out.println("66 swordfish");
		for (int i = 0; i < 66; i++) {
			animals.add(new Swordfish("swordfish" + i));
		}
		
		int numOfAnimals = animals.size();
		System.out.println("Animals count: " + numOfAnimals);
		System.out.println();
		
		Transporter truck = new Transporter(bigGames, 4, 3, 3, 0, 0, 4, 6);
		Trailer trailer = new Trailer(bigGames2, 2, 3, 5, 0, 0, 5, 5);
		Trailer trailer2 = new Trailer(new BigGame[0], 2, 0, 0, 5, 5, 0, 0);
		truck.load(trailer);
		truck.load(trailer2);

		System.out.println("Moving all animals to Sch�nbrunn using the given transporter (including trailers, of course)!");
		
		List<Animal> animalsInSchoenbrunn = new ArrayList<Animal>();
		
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
					System.out.println("loaded to transporter");
					loaded++;
				} else {
					System.out.println("trying to load into one of the trailers instead...");
					if (canLoadTo(trailer, a)) {
						it.remove();
						System.out.println("loaded to trailer");
						loaded++;
					} else if (canLoadTo(trailer2, a)){
						it.remove();
						System.out.println("loaded to trailer2");
						loaded++;
					} else {
						System.out.println("failed loading to trailers");
					}
					System.out.println("failed loading to the transporter");
				}				
			}
			
			if (loaded == 0) {
				break;
			}
			
			System.out.println("trip " + trip + " (loaded "+loaded+")... Unloading in Sch�nbrunn");
			trip++;

			List<Animal> unloadedAnimals = truck.unload();
			System.out.println("Unloaded:" + unloadedAnimals.size());
			for(Animal a : unloadedAnimals) {
				if (!animalsInSchoenbrunn.contains(a)) {
					animalsInSchoenbrunn.add(a);
				}
			}
		}
		System.out.println("Finished Transporting! Schoenbrunn has now " + animalsInSchoenbrunn.size() + " more animals");	
			
		// TEST 2
		System.out.println("\n\nTest 2: Trying to load 2 Mambas and 1 Python into a transporter with only 3 Python Terrariums:");
			
		List<Animal> animals2 = new ArrayList<Animal>();
		animals2.add (new Mamba("Mamba 1"));
		animals2.add (new Mamba("Mamba 2"));
		animals2.add (new Python("Python 1"));
			
		BigGame[] bigGames3 = new BigGame[1];
		bigGames3[0] = new Elefant("Elefant3");
			
			
		System.out.println("Creating new Transporter with only 3 sections of Python Terrariums (and one Elephant)");
		Transporter transporter2 = new Transporter(bigGames3, 1, 0, 0, 0, 0, 0, 3);
			
		for(Animal animal : animals2) {
			System.out.println("Trying to load " + animal.getName() + " into the transporter");
			if (canLoadTo(transporter2, animal)) {
				System.out.println("Loaded");
			} else {
				System.out.println("Failed");
			}
		}
			
		System.out.println("Animals now on the Transporter:");
		List<Animal> animalsOnTransporter = transporter2.list();
		
		
		for(Animal animal: animalsOnTransporter) {
			System.out.println(animal.getName());
		}	
		System.out.println();
		
		System.out.println("can you add more animals to transporter?");
		System.out.print("loading mamba...");
		System.out.println(new Mamba("").load(transporter2) ? "done" : "failed");
		System.out.print("loading dolphin...");
		System.out.println(new Dolphin("").load(transporter2) ? "done" : "failed");
		System.out.print("loading seal...");
		System.out.println(new Seal("").load(transporter2) ? "done" : "failed");
		
		System.out.println();
		
		System.out.print("Can you load an elefant to a transporter with only 1 watertank? ");
		System.out.println((new Elefant("").load(new Transporter(new BigGame[0],0,1,0,0,0,0,0))) ? "yes" : "hell no");
		
		System.out.print("Can you load a python to a transporter with no sections at all? ");
		System.out.println((new Python("python3.2").load(new Transporter(new BigGame[0],0,0,0,0,0,0,0))) ? "yes" : "hell no");
		
		System.out.print("Can you load a small turtle to a transporter with only 1 big trutle terrarium? ");
		System.out.println((new SmallTurtle("").load(new Transporter(new BigGame[0],0,0,0,1,0,0,0))) ? "yes" : "hell no");
		
		System.out.print("Can you load a big turtle to a transporter with only 1 big trutle terrarium? ");
		System.out.println((new BigTurtle("").load(new Transporter(new BigGame[0],0,0,0,1,0,0,0))) ? "yes" : "hell no");

		System.out.print("Can you load a big turtle to a transporter with only 1 small trutle terrarium? ");
		System.out.println((new BigTurtle("").load(new Transporter(new BigGame[0],0,0,0,0,1,0,0))) ? "yes" : "hell no");
		
		System.out.print("Can you load a dolphin to a transporter with only 1 waterlandtank? ");
		System.out.println((new Dolphin("").load(new Transporter(new BigGame[0],0,0,1,0,0,0,0))) ? "yes" : "hell no");
		
		System.out.print("Can you load a seal to a transporter with only 1 watertank? ");
		System.out.println((new Seal("").load(new Transporter(new BigGame[0],0,1,0,0,0,0,0))) ? "yes" : "hell no");
	}
	
	private static boolean canLoadTo(Container container, Animal animal) {
		if (animal.load(container)) {
			return true;
		}
		return false;
	}
	
}
