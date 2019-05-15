package com.cice.commentsmanage.service.impl;

import com.cice.commentsmanage.controller.dto.CommentsDTO;
import com.cice.commentsmanage.repository.CommentsRepository;
import com.cice.commentsmanage.repository.entity.CommentsEntity;
import com.cice.commentsmanage.service.CommentsService;
import com.cice.commentsmanage.service.converter.DTOEntityConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsServiceimpl implements CommentsService {

    @Autowired
    CommentsRepository commentsRepository;

    DTOEntityConverter convert = new DTOEntityConverter();



    @Override
    public CommentsDTO createComment(CommentsDTO commentsDTO) {
        CommentsDTO responseDTO = null;
        CommentsEntity commentsEntity = commentsRepository.save(convert.convertDTOToEntity(commentsDTO));
        responseDTO = convert.convertEntityToDTO(commentsEntity);
        return responseDTO;
    }

    @Override
    public CommentsDTO updateComment(CommentsDTO commentsDTO) {
        

        return null;
    }

    @Override
    public CommentsDTO getCommentsByTitle(String title) {
        return null;
    }

    @Override
    public List<CommentsDTO> getAllComments() {
        return null;
    }

    @Override
    public void deleteCommentById(Long id) {

    }

    @Override
    public void deleteCommentByNewsTitle(String title) {

    }
}
