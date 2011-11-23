
public abstract class Person implements Comparable<Person> {

	private final String name;
	
	public Person(String name) {		// not null
		this.name = name;
	}

	@Override
	public int compareTo(Person person) {
		return name.compareToIgnoreCase(person.name);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj instanceof Person) {
			Person person = (Person) obj;
			return person.compareTo(this) == 0;
		}
		return false;
	}
	
	public String getName() {
		return name;
	}
}
