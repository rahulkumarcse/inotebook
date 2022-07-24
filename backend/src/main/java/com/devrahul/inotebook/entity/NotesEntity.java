package com.devrahul.inotebook.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Document(collection = "Notes")
public class NotesEntity {
    @Id
    private String id;
    private  String user;
    private String title;
    private  String description;
    private  String tag;
    private Date date;

}
