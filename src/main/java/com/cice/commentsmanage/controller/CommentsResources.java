package com.cice.commentsmanage.controller;

import com.cice.commentsmanage.controller.dto.CommentsDTO;
import com.cice.commentsmanage.repository.entity.CommentsEntity;
import com.cice.commentsmanage.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CommentsResources {

    @Autowired
    CommentsService commentsService;

    @RequestMapping(path = "/comments", method = RequestMethod.POST)
    public CommentsEntity createComments(@RequestBody CommentsDTO commentsDTO){
        CommentsEntity response = null;
        response = commentsService.createComment(commentsDTO);

        return response;
    }

    @RequestMapping(path = "/commentsupdate", method = RequestMethod.PATCH)
    public ResponseEntity<CommentsDTO> updateComment(@PathVariable(name = "id")Long id,@RequestBody CommentsDTO commentsDTO){
        ResponseEntity<CommentsDTO> response = null;
        CommentsDTO commentsDTO1 = commentsService.updateComment(id, commentsDTO);
        response = ResponseEntity.ok(commentsDTO1);
        return response;
    }
    @RequestMapping(path = "/comments", method = RequestMethod.GET)
    public Optional<CommentsEntity> getCommentsById(@PathVariable(name = "id")Long id){
        Optional<CommentsEntity> response = commentsService.getCommentsById(id);
        if(!response.isPresent());
        return response;
    }
    @RequestMapping(path = "comments", method = RequestMethod.GET)
    public ResponseEntity<List<CommentsDTO>> getAllComments(){
        ResponseEntity<List<CommentsDTO>> response = null;
        List<CommentsDTO> allComments = commentsService.getAllComments();
        response = ResponseEntity.ok(allComments);
        return response;
    }

    @RequestMapping(path = "/comments/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<CommentsDTO> deleteCommentsById(@PathVariable(name = "id") Long id){
        commentsService.deleteCommentById(id);
        return ResponseEntity.accepted().build();
    }

    @RequestMapping(path = "/comments", method = RequestMethod.DELETE)
    public void deletaAllComments(){
        commentsService.deleteAllComment();
    }



}
