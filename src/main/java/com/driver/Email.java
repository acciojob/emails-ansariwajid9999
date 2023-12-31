package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        if(oldPassword.equals(this.getPassword()) && newPassword.length()>=8)
        {
            if(isValid(newPassword))
            {
                this.password=newPassword;
            }
        }
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
    }
    public boolean isValid(String pass) {
        boolean atLeastOneUpperCase=false;
        boolean atLeastOneLowerCase=false;
        boolean atLeastOneDigit=false;
        boolean atLeastOneSpecialChar=false;
        for(int i=0;i<pass.length();i++)
        {
            char ch=pass.charAt(i);
            if(ch>='A' && ch<='Z')atLeastOneUpperCase=true;
            else if(ch>='a' && ch<='z')atLeastOneLowerCase=true;
            else if(ch>='0' && ch<='9')atLeastOneDigit=true;
            else atLeastOneSpecialChar=true;
        }

        return atLeastOneUpperCase && atLeastOneLowerCase && atLeastOneSpecialChar && atLeastOneDigit;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
