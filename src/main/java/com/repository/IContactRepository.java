package com.repository;
import com.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContactRepository extends JpaRepository<UserEntity,Integer>
{

}
