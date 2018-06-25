package com.controller;

import com.model.UserEntity;
import com.service.ContactListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/contacts", produces ="application/json")
public class ContactListController
{
    @Autowired
    ContactListService contactListService;

    @GetMapping
    public List<UserEntity> getAllContacts()
    {
        return contactListService.getAllContacts();
    }

    @PostMapping
    public UserEntity insertContact(@RequestBody UserEntity userEntity)
    {
        System.out.println(userEntity);
       return contactListService.insertContact(userEntity);
    }


    @DeleteMapping(value = "/{id}")
    public void deleteContact(@PathVariable int id)
    {
      //  System.out.println("in delete controller method");
        contactListService.deleteContact(id);
      //  System.out.println("After delete statement");
    }

    @PutMapping(value = "/{id}")
        public  UserEntity upadateContact(@PathVariable int id ,@RequestBody UserEntity userEntity)
    {
         return contactListService.updateContact(id,userEntity);
    }
}
