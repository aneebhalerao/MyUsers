package com.user.user.Repository;

import com.user.user.Entity.UsersDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersDetailRepository extends JpaRepository<UsersDetailEntity, Long> {

}
