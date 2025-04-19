package service;

public class AuthService {

    // This class handles user authentication and authorization
    public boolean login(String username, String password) {
        // Logic to authenticate user
        // This is a placeholder for actual authentication logic
        if (username.equals("admin") && password.equals("password")) {
            return true;
        }
        return false;
    }

}
