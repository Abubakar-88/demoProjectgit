package com.demol.repository;
import com.demol.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository <Users , Long>{
}
