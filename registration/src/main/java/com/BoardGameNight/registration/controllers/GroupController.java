package com.BoardGameNight.registration.controllers;

import com.BoardGameNight.registration.model.Group;
import com.BoardGameNight.registration.payload.request.GroupRequest;
import com.BoardGameNight.registration.payload.response.MessageResponse;
import com.BoardGameNight.registration.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/groups")
public class GroupController {
    @Autowired
    GroupRepository groupRepository;

    @PostMapping("")
    public ResponseEntity<?> newGroup(@RequestBody GroupRequest groupRequest){
        if (groupRepository.existsByName(groupRequest.getName())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Group name is already taken!"));
        }
        Group newGroup = new Group(
                groupRequest.getName(),
                groupRequest.getDescription());
        groupRepository.save(newGroup);
        return ResponseEntity.ok(new MessageResponse("Group successfully created!"));
    }
//    @PostMapping("/user/{id}")
//    public ResponseEntity<?> joinGroup (@RequestBody GroupRequest)
}
