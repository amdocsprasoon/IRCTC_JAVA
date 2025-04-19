package service;

import entity.IrctcUser;

import java.util.*;

public class AuthService {

    // This is a simple in-memory user store for demonstration purposes
    List<IrctcUser> users = new ArrayList<>();

    public AuthService(){
        // Pre-populate with a default user for testing
        users.add(new IrctcUser(201L, "admin", "password"));
        users.add(new IrctcUser(202L, "seb", "jabba"));
    }
    public void signup(Scanner scanner) {
        System.out.print("Enter a username: ");
        String username = scanner.nextLine();
        if (users.stream().map(IrctcUser::getUsername).anyMatch(existingUsername -> existingUsername.equals(username))) {
            System.out.println("Username already exists. Please try a different one.");
            return;
        }
        System.out.print("Enter a password: ");
        String password = scanner.nextLine();
        users.add(new IrctcUser((users.get(users.size()-1)).getUserId() + 1, username, password));
        System.out.println("Signup successful!");
    }

    // This class handles user authentication and authorization
    public IrctcUser login(Scanner scanner) {
        // Logic to authenticate user
        // This is a placeholder for actual authentication logic
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        Optional<IrctcUser> user = users.stream()
                .filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password))
                .findFirst();

        if (user.isPresent())
        {
            System.out.println("Login successful! Welcome, " + username + "!");
            return user.get();
        } else {
            System.out.println("Invalid username or password. Please try again.");
            return null;
        }
    }

}
