package com.cice.commentsmanage.service.impl;

import com.cice.commentsmanage.controller.dto.CommentsDTO;
import com.cice.commentsmanage.repository.CommentsRepository;
import com.cice.commentsmanage.repository.entity.CommentsEntity;
import com.cice.commentsmanage.service.CommentsService;
import com.cice.commentsmanage.service.converter.DTOEntityConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentsServiceimpl implements CommentsService {

    @Autowired
    CommentsRepository commentsRepository;

    DTOEntityConverter convert = new DTOEntityConverter();



    @Override
    public CommentsEntity createComment(CommentsDTO commentsDTO) {
        CommentsEntity responseDTO = null;
        responseDTO = commentsRepository.save(convert.convertDTOToEntity(commentsDTO));
        return responseDTO;
    }

    @Override
    public CommentsDTO updateComment(Long id, CommentsDTO commentsDTO) {
        CommentsDTO responseDTO = null;
        Optional<CommentsEntity> commentsById = commentsRepository.findById(id);
        if(commentsById.isPresent()){
            CommentsEntity commentsEntity = commentsById.get();
            if(commentsDTO.getNewsTitle() != null){
                commentsById.get().setNewsTitle(commentsDTO.getNewsTitle());
            }
            if(commentsDTO.getComments() != null){
                commentsById.get().setComments(commentsDTO.getComments());
            }
            if(commentsDTO.getDate() != null){
                commentsById.get().setDate(commentsDTO.getDate());
            }
        }
        CommentsEntity commentsEntity = commentsRepository.save(commentsById.get());
        responseDTO = convert.convertEntityToDTO(commentsEntity);
        return responseDTO;

    }

    @Override
    public Optional<CommentsEntity> getCommentsById(Long id) {
        Optional<CommentsEntity> responseEntity = null;
        responseEntity = commentsRepository.findById(id);
        return responseEntity;
    }

    @Override
    public List<CommentsDTO> getAllComments() {
        List<CommentsDTO> listcomments = Collections.EMPTY_LIST;
        listcomments = commentsRepository
                .findAll()
                .stream()
                .map(entity -> convert.convertEntityToDTO(entity))
                .collect(Collectors.toList());
        return listcomments;
    }

    @Override
    public void deleteCommentById(Long id) {
        CommentsDTO responseDTO = null;
        commentsRepository.deleteById(id);

    }

    @Override
    public void deleteAllComment() {
        commentsRepository.deleteAll();

    }
}
