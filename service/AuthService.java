package service;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AuthService {

    // This is a simple in-memory user store for demonstration purposes
    private Map<String, String> users = new HashMap<>();

    public AuthService(){
        // Pre-populate with a default user for testing
        users.put("admin", "password");
    }
    public void signup(Scanner scanner) {
        System.out.print("Enter a username: ");
        String username = scanner.nextLine();
        if (users.containsKey(username)) {
            System.out.println("Username already exists. Please try a different one.");
            return;
        }
        System.out.print("Enter a password: ");
        String password = scanner.nextLine();
        users.put(username, password);
        System.out.println("Signup successful!");
    }

    // This class handles user authentication and authorization
    public boolean login(Scanner scanner) {
        // Logic to authenticate user
        // This is a placeholder for actual authentication logic
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        if (users.containsKey(username) && users.get(username).equals(password)) {
            System.out.println("Login successful! Welcome, " + username + "!");
            return true;
        } else {
            System.out.println("Invalid username or password. Please try again.");
            return false;
        }
    }

}
