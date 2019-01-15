package files.explorer.source;

public class PersonMapper {

	public PersonDto map(Person person) {
		return new PersonDto(person.getName());

	}

}
