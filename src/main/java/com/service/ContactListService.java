package com.service;

import com.model.UserEntity;
import com.repository.IContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ContactListService
{
    @Autowired
    IContactRepository iContactRepository;

    public List<UserEntity> getAllContacts()
    {
        return iContactRepository.findAll();
    }

    public UserEntity insertContact(UserEntity userEntity)
    {
        if((iContactRepository.save(userEntity))!= null) {
            return userEntity;
        }
        else return null;
    }

    public void deleteContact(int id)
    {
        System.out.println("in delete service method");
        iContactRepository.delete(id);
        System.out.println("After delete statement");
    }
     public UserEntity updateContact(int id, UserEntity userEntity)
     {

         UserEntity myUserEntity= iContactRepository.findOne(id);
         myUserEntity.setFirstName(userEntity.getFirstName());
         myUserEntity.setLastName(userEntity.getLastName());
         myUserEntity.setPhoneNumber(userEntity.getPhoneNumber());
         myUserEntity.setCity(userEntity.getCity());
         return iContactRepository.save(myUserEntity);
     }
}