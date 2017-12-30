package main.java.search;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search")
public class SearchController {
	
	// "Database" of users to query against
	static private List<User> userSet = Arrays.asList(
			new User("John", "Smith"),
			new User("Will", "Smith"),
			new User("John", "Billingsly"),
			new User("John", "Colt"),
			new User("Samuel", "Clemens"),
			new User("Longhorn", "Clemens"),
			new User("Mark", "Twain"),
			new User("John", "Doe"),
			new User("Jane", "Doe"),
			new User("Kosmo", "Kramer"),
			new User("Cosmo", "Jones"),
			new User("Abraham", "Lincoln"),
			new User("Theodore", "Roosevelt"),
			new User("William", "Smith"),
			new User("Terrence", "Jones"),
			new User("John", "Jacob"),
			new User("Master", "Chief"),
			new User("Jerry", "Seinfield"),
			new User("George", "Washington"),
			new User("George", "Bush"),
			new User("Booker", "Washington")
			);

	// POST method to search for users/people
	@RequestMapping(method = RequestMethod.POST)
	public List<User> search(@RequestBody User user) {
		return search(user, userSet);
	}
	
	// private helper method that looks for a user amongst a set of users returning any possible matches based on wildcards 
	private List<User> search(User user, List<User> dataSet) {
		final String lastName = user.getLastName().toUpperCase().replaceAll("\\*", ".\\*");
		final String firstName = user.getFirstName().toUpperCase().replaceAll("\\*", ".\\*");
		
		List<User> users = dataSet.stream().filter(u -> u.getLastName().toUpperCase().matches(lastName))
			.filter(u -> u.getFirstName().toUpperCase().matches(firstName))
			.collect(Collectors.toList());
		
		return users;
	}
}
