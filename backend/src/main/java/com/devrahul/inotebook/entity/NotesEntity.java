package com.devrahul.inotebook.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Date;

@NoArgsConstructor
@Getter
@Setter
@Document(collection = "Notes")
@ToString
public class NotesEntity {

    @Id
    private String title;
    private  String description;
    private  String tag;
    private Date date;

}
