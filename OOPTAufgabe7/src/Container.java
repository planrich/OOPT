
public abstract class Container {
	
	private Terrarium[] terrariums;
	private int loadedTerrariums;
	private Tank[] tanks;
	private int loadedTanks;
	
	public Container(BigGame[] bigGame, int hitches, int tanks, int terrariums) {
		this.terrariums = new Terrarium[terrariums];
		this.tanks = new Tank[tanks];
		loadedTerrariums = 0;
		loadedTanks = 0;
	}
}
