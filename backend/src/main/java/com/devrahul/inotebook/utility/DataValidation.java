package com.devrahul.inotebook.utility;

import java.util.Arrays;

public class DataValidation {
    public  static  boolean nameValidation(String name){
        boolean validation = false;
        if(name.length() >=7 && !name.endsWith(" ")){
            for(char c : name.toCharArray()){
                if(((int) c>=65 && (int) c <=90) ||  ((int) c>=97 && (int) c <=122) || c== ' ' ){
                    validation = true;
                }
               else {
                    validation = false;
                    break;
                }
            }

        }
        return  validation;


    }

    public static boolean emailValidation(String email){
        if(email.contains("@") && email.contains(".")){
            int indexOfAt = email.indexOf("@");
            String substr= email.substring(indexOfAt);
            if(substr.indexOf(".") >=1 && ((substr.charAt(substr.indexOf(".")+2)>1))){
                return true;
            }
            else return false;
        }
        else return false;
    }

    public static boolean passwordValidation(String password){
        boolean validation = false;
        if(password.length() >=8 && !password.contains(" ")){
             boolean capsCheck = false;
             boolean numCheck = false;
             boolean smallLetCheck = false;
             boolean specCharCheck = false;
             for(char c : password.toCharArray()){
                 if((int) c>=65 && (int) c <=90){
                     capsCheck = true;
                 }
                 if((int) c>=48 && (int) c <=57){
                     numCheck = true;
                 }
                 if((int) c>=97 && (int) c <=122){
                     smallLetCheck = true;
                 }
                 if(c =='@' || c =='!' ||c =='#' ||c =='$' ||c =='%' ||c =='^' ||c =='&' ||c =='*' ||c =='_' ||c =='?'  ){
                     specCharCheck = true;
                 }
             }
             if(capsCheck && numCheck && smallLetCheck && specCharCheck){
                 validation=true;
             }

        }
        return  validation;
    }

    public  static  boolean userNameValidation(String userName){
        boolean validation = false;
        if(userName.length() >=7 && !userName.contains(" ")){
            boolean capsCheck = false;
            boolean numCheck = false;
            boolean smallLetCheck = false;
            for(char c : userName.toCharArray()){
                if((int) c>=65 && (int) c <=90){
                    capsCheck = true;
                }
                if((int) c>=48 && (int) c <=57){
                    numCheck = true;
                }
                if((int) c>=97 && (int) c <=122){
                    smallLetCheck = true;
                }

            }
            if(capsCheck && numCheck && smallLetCheck ){
                validation=true;
            }

        }
        return  validation;

    }
}
