package com.cice.commentsmanage.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class CommentsDTO {
    private Long id;
    private String newsTitle;
    private String comments;
    private String date;
}
