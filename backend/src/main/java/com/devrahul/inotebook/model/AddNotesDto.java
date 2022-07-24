package com.devrahul.inotebook.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AddNotesDto {
    private String title;

    private  String description;

    private  String tag;
}
