package com.devrahul.inotebook.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@Document(collection = "Notes")
@ToString
public class NotesEntity {

    @Id
    private String id;

    @NotNull(message = "Title cannot be null")
    private String title;

    @NotNull(message = "description cannot be null")
    private  String description;

    @NotNull(message = "tag cannot be null")
    private  String tag;

    private Date date;

}
