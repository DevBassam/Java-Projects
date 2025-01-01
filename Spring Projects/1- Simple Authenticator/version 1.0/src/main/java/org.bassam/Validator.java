package org.bassam;

public class Validator {
    public boolean isValidName(String name){
        String nameRegex = "^[a-zA-Z]+$";
        return name.matches(nameRegex);
    }
    public boolean isValidEmail(String email){
        String emailRegex = "^[a-zA-Z0-9._%+-]+@gmail\\.com$";
        return email.matches(emailRegex);
    }
    public boolean isValidPassword(String pass){
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$";
        return pass.matches(passwordRegex);
    }
    public boolean isEmailExist(String email){
        return UserData.members.containsKey(email);
    }
    public boolean isPasswordCorrect(String email, String pass){
        return UserData.members.get(email)[2].equals(pass);
    }
}
