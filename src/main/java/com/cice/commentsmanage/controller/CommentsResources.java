package com.cice.commentsmanage.controller;

import com.cice.commentsmanage.controller.dto.CommentsDTO;
import com.cice.commentsmanage.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentsResources {

    @Autowired
    CommentsService commentsService;

    @RequestMapping(path = "/comments", method = RequestMethod.POST)
    public ResponseEntity<CommentsDTO> createComments(@RequestBody CommentsDTO commentsDTO){
        ResponseEntity<CommentsDTO> response = null;
        if(validateComments(commentsDTO)){
            CommentsDTO commentsDTO1 = commentsService.createComment(commentsDTO);
            response = ResponseEntity.ok(commentsDTO1);
        }else{
            response = ResponseEntity.badRequest().body(commentsDTO);
        }
        return response;
    }

    @RequestMapping(path = "commentsupdate", method = RequestMethod.PATCH)
    public ResponseEntity<CommentsDTO> updateComment(@RequestBody CommentsDTO commentsDTO){



        return null;
    }

    private boolean validateComments(CommentsDTO commentsDTO){
        return (commentsDTO.getNewsTitle().isEmpty() && commentsDTO.getComments().isEmpty()) ? false : true;
    }

}
