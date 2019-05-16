package com.cice.commentsmanage.service;

import com.cice.commentsmanage.controller.dto.CommentsDTO;
import com.cice.commentsmanage.repository.entity.CommentsEntity;

import java.util.List;
import java.util.Optional;

public interface CommentsService {

    /**
     * method thad allow us create a new comment
     * @param commentsDTO
     * @return
     */
    CommentsEntity createComment(CommentsDTO commentsDTO);

    /**
     * method that allow us update any comment
     * @param commentsDTO
     * @return
     */
    CommentsDTO updateComment(Long id, CommentsDTO commentsDTO);

    /**
     * method that allow us see any comment grace to a id
     * @param id
     * @return
     */
    Optional<CommentsEntity> getCommentsById(Long id);

    /**
     * method that allow us see all comments
     * @return
     */
    List<CommentsDTO> getAllComments();

    /**
     * method that allow us delete any comment grace to a id
     * @param id
     * @return
     */
    void deleteCommentById(Long id);

    /**
     * method that allow us delete all comment of a news
     * @return
     */
    void deleteAllComment();



}
