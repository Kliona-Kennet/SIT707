package web.service;

public class LoginService {

    public static boolean login(String username,
                                String password,
                                String dob) {

        if(username == null || password == null || dob == null) {
            return false;
        }

        if(username.isEmpty() || password.isEmpty() || dob.isEmpty()) {
            return false;
        }

        return username.equals("kliona")
                && password.equals("kliona_pass")
                && dob.equals("2002-03-04");
    }
}