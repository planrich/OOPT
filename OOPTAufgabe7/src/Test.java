import java.util.List;
import java.util.ArrayList;


public class Test {

	public static void main(String[] args) {
		
		List<Animal> animals = new ArrayList<Animal>();
		List<Section> sections = new ArrayList<Section>();
		
		animals.add(new Dolphin("Flipper"));
		animals.add(new Mamba("Kurt"));
		animals.add(new Python("Armin"));
		
		sections.add(new PythonTerrarium());
		sections.add(new MambaTerrarium());
		sections.add(new WaterTank());
		
	}
}
