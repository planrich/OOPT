import java.util.ArrayList;
import java.util.List;


public class Transporter {

	private final BigGame[] attached;
	
	private final Terrarium[] terrariums;
	private int terrarium_loaded;
	private final Tank[] tanks;
	private int tanks_loaded;
	
	private Transporter[] hitches;
	private int hitches_loaded;
	
	/**
	 * @return an array of biggames attached to the transporter, is NEVER null, array of length 0 instead
	 */
	public BigGame[] getAttachedBigGameAnimals() {
		return attached;
	}
	
	/**
	 * Create a new Transporter that is either pulling or can be attached to another transporter
	 * @param sectioncount amount of sections that allow loading of different animals (but not biggame)
	 * @param attached the fixed size biggame attached to this truck
	 */
	public Transporter(int terrariums, int tanks, int hitches, BigGame[] attached) { 
		this.terrariums = new Terrarium[terrariums];
		this.tanks = new Tank[tanks];
		this.hitches = new Transporter[hitches];
		this.terrarium_loaded = 0;
		this.tanks_loaded = 0;
		this.hitches_loaded = 0;
		if (attached == null) {
			this.attached = new BigGame[0];
		} else {
			this.attached = attached;
		}
		
	}
	
	/**
	 * This transporter must not be a pulling vehicle
	 * @return all {@link Animal}s from this transporter and all following ones.
	 */
	public List<Animal> list() {
		List<Animal> list = new ArrayList<Animal>();
		
		for (int i = 0; i < terrariums.length; i++) {
			if (terrariums[i] != null) {
				list.add(terrariums[i].animal);
			}
		}
		
		return list;
	}
	
	/**
	 * DUPLICATES ARE NOT CHECKED
	 * @param transporter must not be null
	 * @return true iff transporter found space, false otherwise
	 */
	public boolean load(Transporter transporter) {
		if (hitches_loaded >= hitches.length) {
			return false;
		}
		
		hitches[hitches_loaded++] = transporter;
		
		return true;
	}
	
	/**
	 * 
	 * @param transporter must not be null
	 * @return true iff transporter could be unloaded, false otherwise
	 */
	public boolean unload(Transporter transporter) {
		
		if (unload(transporter, hitches, hitches_loaded)) {
			hitches_loaded--;
			return true;
		}
		
		return false;
	}
	
	/**
	 * utility, all params MUST not be null or invalid (count)
	 * @param obj 
	 * @param from
	 * @param count
	 * @return true iff object found in array and removed successfully, false otherwise
	 */
	private boolean unload(Object obj, Object[] from, int count) {
		for (int i = 0; i < count; i++) {
			Object o = from[i];
			if (o.equals(obj)) {
				from[i] = null;
				for (int j = i + 1; j < count; j++, i++) {
					from[i] = from[j];
					from[j] = null;
				}
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * DUPLICATES ARE NOT CHECKED
	 * @param sec must not be null
	 * @return true iff section finds free space
	 */
	public boolean load(Section sec) {
		return sec.load(this);
	}
	
	/**
	 * 
	 * @param sec must not be null
	 * @return true iff section was in the transporter, false otherwise
	 */
	public boolean unload(Section sec) {
		return sec.unloadFrom(this);
	}
	
	/**
	 * DUPLICATES ARE NOT CHECKED
	 * @param terrarium must not be null
	 * @return true if there is free space, false otherwise
	 */
	public boolean load(Terrarium terrarium) {
		if (terrarium_loaded >= terrariums.length) {
			return false;
		}
		
		terrariums[terrarium_loaded++] = terrarium; 
		
		return true;
	}
	
	/**
	 * 
	 * @param terrarium must not be null
	 * @return true iff terraium was contained in the tranpsorter and removed succesfully, false otherwise
	 */
	public boolean unload(Terrarium terrarium) {
		if (unload(terrarium,terrariums,terrarium_loaded)) {
			terrarium_loaded--;
			return true;
		}
		
		return false;
	}
	
	/**
	 * DUPLICATES ARE NOT CHECKED
	 * @param tank must not be null
	 * @return true iff tank could be loaded, false otherwise
	 */
	public boolean load(Tank tank) { 
		if (tanks_loaded >= tanks.length) {
			return false;
		}
		
		tanks[tanks_loaded++] = tank; 
		
		return true;
	}
	
	/**
	 * checks the object reference NOT the contained animal
	 * @param tank must not be null
	 * @return true iff tank could be unloaded (was loaded), false otherwise
	 */
	public boolean unload(Tank tank) {
		if (unload(tank,tanks,tanks_loaded)) {
			tanks_loaded--;
			return true;
		}
		
		return false;
	}

	/**
	 * Unload both tanks and terrariums and give back the list!
	 * @return a List of Sections unloaded from the transporter
	 */
	public List<Section> unload() {
		List<Section> sections = new ArrayList<Section>();
		
		for (int i = 0; i < tanks.length; i++) {
			Section section = tanks[i];
			tanks[i] = null;
			if (section != null) {
				sections.add(section);
			}
		}
		
		for (int i = 0; i < terrariums.length; i++) {
			Section section = terrariums[i];
			terrariums[i] = null;
			if (section != null) {
				sections.add(section);
			}
		}
		
		return sections;
	}
}
