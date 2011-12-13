import java.util.ArrayList;
import java.util.List;


public abstract class Container {
	
	private BigGame[] bigGame;
	private Section[] sections;
	private Hitch[] hitches;
	
	/**
	 * Initalizes a new Container
	 * @param bigGame Nust be not null.
	 * @param hitches Must be greater or equal than bigGame.length.
	 * @param waterTanks Must be >= 0
	 * @param waterLandTanks Must be >= 0
	 * @param bigTurtleTerrariums Must be >= 0
	 * @param smallTurtleTerrariums Must be >= 0
	 * @param mambaTerrariums Must be >= 0
	 * @param pythonTerrariums Must be >= 0
	 */
	public Container(BigGame[] bigGame, int hitches, int waterTanks, int waterLandTanks, int bigTurtleTerrariums, int smallTurtleTerrariums,
			int mambaTerrariums, int pythonTerrariums) {
		this.sections = new Section[waterTanks + waterLandTanks + bigTurtleTerrariums + smallTurtleTerrariums];
		this.hitches = new Hitch[hitches - bigGame.length];
		this.bigGame = bigGame;
		
		// initialize the sections, ordering is important
		// always put SmallTurtles into SmallTurtles Terrariums first, etc.
		int count = 0;
		for (int i = 0; i < waterTanks; i++) {
			sections[i] = new WaterTank();
		}
		count += waterTanks;
		for (int i = 0; i < waterLandTanks; i++) {
			sections[count + i] = new WaterLandTank();
		}
		count += waterLandTanks;
		for (int i = 0; i < smallTurtleTerrariums; i++) {
			sections[count + i] = new SmallTurtleTerrarium();
		}
		count += smallTurtleTerrariums;
		for (int i = 0; i < bigTurtleTerrariums; i++) {
			sections[count + i] = new BigTurtleTerrarium();
		}
		count += bigTurtleTerrariums;
		for (int i = 0; i < mambaTerrariums; i++) {
			sections[count + i] = new MambaTerrarium();
		}
		count += mambaTerrariums;
		for (int i = 0; i < pythonTerrariums; i++) {
			sections[count + i] = new PythonTerrarium();
		}
		
		for (int i = 0; i < hitches-bigGame.length; i++) {
			this.hitches[i] = new Hitch();
		}
	}
	
	public List<Animal> list() {
		List<Animal> result = new ArrayList<Animal>();
		// All the attached trailers (kind of recursive call)
		for (Hitch hitch : hitches) {
			if (hitch.getTrailer() != null) {
				result.addAll(hitch.getTrailer().list());
			}
		}
		
		// All the big animals
		for (BigGame bg : bigGame) {
			result.add(bg);
		}
		
		// All the animals in the sections
		for (Section section : sections) {
			if (section.getAnimal() != null) {
				result.add(section.getAnimal());
			}
		}
		return result;
	}
	
	public boolean load(Trailer trailer) {
		for (Hitch hitch : hitches) {
			if (hitch.loadTrailer(trailer)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean loadMamba(Mamba mamba) {
		for (Section section : sections) {
			if (section.loadMamba(mamba)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean loadPython(Python python) {
		for (Section section : sections) {
			if (section.loadPython(python)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean loadBigTurtle(BigTurtle turtle) {
		for (Section section : sections) {
			if (section.loadBigTurtle(turtle)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean loadSmallTurtle(SmallTurtle turtle) {
		for (Section section : sections) {
			if (section.loadSmallTurtle(turtle)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean loadDolphin(Dolphin dolphin) {
		for (Section section : sections) {
			if (section.loadDolphin(dolphin)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean loadSwordfish(Swordfish swordfish) {
		for (Section section : sections) {
			if (section.loadSwordfish(swordfish)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean loadSeal(Seal seal) {
		for (Section section : sections) {
			if (section.loadSeal(seal)) {
				return true;
			}
		}
		return false;
	}
}
