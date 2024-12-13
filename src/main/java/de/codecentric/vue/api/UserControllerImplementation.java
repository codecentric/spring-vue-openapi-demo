package de.codecentric.vue.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import de.codecentric.generated.api.UsersApiDelegate;
import de.codecentric.generated.model.User;
import de.codecentric.vue.NotFoundException;

@Service
public class UserControllerImplementation implements UsersApiDelegate {

    private final HashMap<String, User> usersById = new HashMap<>(Stream.of(
            new User("1", "Max", "Musterman"),
            new User("2", "Lisa", "Müller"),
            new User("3", "John", "Doe"),
            new User("4", "Jane", "Smith"),
            new User("5", "Tom", "Brown"),
            new User("6", "Emma", "Johnson"),
            new User("7", "Oliver", "Williams"),
            new User("8", "Sophia", "Davis"),
            new User("9", "Liam", "Jones"),
            new User("10", "Ava", "Garcia"),
            new User("11", "Noah", "Martinez"),
            new User("12", "Isabella", "Hernandez")
    ).collect(Collectors.toMap(User::getId, Function.identity())));

    @Override
	public ResponseEntity<List<User>> usersGet() {
    	List<User> users = new ArrayList<User>(usersById.values());
		return ResponseEntity.ok(users);
	}

	@Override
	public ResponseEntity<User> usersIdGet(String id) {
		User user = usersById.get(id);
		if (user == null) {
			throw new NotFoundException("User not found");
		} else {
			return ResponseEntity.ok(user);
		}
	}

	@Override
	public ResponseEntity<User> usersIdPut(String id, User user) {
		usersById.put(id, user);
		return ResponseEntity.ok(user);
	}

}
