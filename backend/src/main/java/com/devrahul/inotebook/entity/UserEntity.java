package com.devrahul.inotebook.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Date;
@Getter
@Setter
@ToString
@NoArgsConstructor
@Document(collection = "User")
public class UserEntity {

    @Id
    private String email;
    private  String name;
    private  String password;
    private Date date;

}
