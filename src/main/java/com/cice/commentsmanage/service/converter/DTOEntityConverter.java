package com.cice.commentsmanage.service.converter;

import com.cice.commentsmanage.controller.dto.CommentsDTO;
import com.cice.commentsmanage.repository.entity.CommentsEntity;

public class DTOEntityConverter {

    public CommentsDTO convertEntityToDTO(CommentsEntity commentsEntity){
        CommentsDTO commentsDTO = null;
        commentsDTO = new CommentsDTO()
                .setId(commentsEntity.getId())
                .setNewsTitle(commentsEntity.getNewsTitle())
                .setComments(commentsEntity.getComments())
                .setDate(commentsEntity.getDate());

        return commentsDTO;
    }

    public CommentsEntity convertDTOToEntity(CommentsDTO commentsDTO){
        CommentsEntity commentsEntity = null;
        commentsEntity = new CommentsEntity()
                .setId(commentsDTO.getId())
                .setNewsTitle(commentsDTO.getNewsTitle())
                .setComments(commentsDTO.getComments())
                .setDate(commentsDTO.getDate());
        return commentsEntity;
    }
}
