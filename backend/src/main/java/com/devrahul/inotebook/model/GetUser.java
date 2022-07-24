package com.devrahul.inotebook.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Date;
@Getter
@NoArgsConstructor
@Setter
public class GetUser {

    private String id;
    private String email;
    private  String name;
    private Date date;
}
