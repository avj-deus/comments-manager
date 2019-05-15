package com.cice.commentsmanage.service;

import com.cice.commentsmanage.controller.dto.CommentsDTO;

import java.util.List;

public interface CommentsService {

    /**
     * method thad allow us create a new comment
     * @param commentsDTO
     * @return
     */
    CommentsDTO createComment(CommentsDTO commentsDTO);

    /**
     * method that allow us update any comment
     * @param commentsDTO
     * @return
     */
    CommentsDTO updateComment(CommentsDTO commentsDTO);

    /**
     * method that allow us see any comment grace to a title
     * @param title
     * @return
     */
    CommentsDTO getCommentsByTitle(String title);

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
     * @param title
     */
    void deleteCommentByNewsTitle(String title);



}
