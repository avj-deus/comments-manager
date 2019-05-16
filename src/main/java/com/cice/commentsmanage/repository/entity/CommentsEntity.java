package com.cice.commentsmanage.repository.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Accessors(chain = true)
@Table(name = "comments")
public class CommentsEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String newsTitle;
    private String comments;
    private String date;
}
