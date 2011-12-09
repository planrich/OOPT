import java.util.List;
import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {

		List<Animal> animals = new ArrayList<Animal>();
		List<Section> sections = new ArrayList<Section>();

		Dolphin dolphin = new Dolphin("Flipper");
		Mamba mamba0 = new Mamba("Kurt");
		Mamba mamba1 = new Mamba("Armin");

		animals.add(dolphin);
		animals.add(mamba0);
		animals.add(mamba1);

		MambaTerrarium terr0 = new MambaTerrarium();
		MambaTerrarium terr1 = new MambaTerrarium();
		WaterTank tank0 = new WaterTank();

		terr0.load(mamba0);
		terr1.load(mamba1);
		tank0.load(dolphin);

		sections.add(terr0);
		sections.add(terr1);
		sections.add(tank0);

		for (Section s : sections) {
			s.printAnimal();
		}

		System.out.print("Creating transporters to carry all animals...");

		Transporter truck = new Transporter(2, 1, 20, null);
		Transporter x = new Transporter(0, 0, 0, null);
		truck.load(new Transporter(0, 0, 0, null));
		truck.load(x);
		truck.load(new Transporter(0, 0, 0, null));
		truck.load(new Transporter(0, 0, 0, null));
		truck.load(new Transporter(0, 0, 0, null));
		truck.load(new Transporter(0, 0, 0, null));
		truck.load(new Transporter(0, 0, 0, null));
		truck.load(new Transporter(0, 0, 0, null));
		truck.load(new Transporter(0, 0, 0, null));
		truck.load(new Transporter(0, 0, 0, null));
		truck.load(new Transporter(0, 0, 0, null));
		truck.load(new Transporter(0, 0, 0, null));
		truck.load(new Transporter(0, 0, 0, null));
		
		truck.unload(x);

		System.out.println("done");

		Section sec = terr0;
		truck.load(sec);
		sec = tank0;
		truck.load(sec);
	}
}
