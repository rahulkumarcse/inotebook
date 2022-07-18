package com.devrahul.inotebook.utility;

public class MongoValidationException extends  Exception{
    public static final long serialVersionUUID =1L;

    public  MongoValidationException(String message){
        super(message);
    }
    public  static  String NotFoundException(String id){
        return  id+"Not Found";
    }
    public  static  String IdAlreadyExist(String id){
        return  "ID already  exixt";
    }
}
