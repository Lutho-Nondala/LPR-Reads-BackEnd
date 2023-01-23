package com.lpr.afsol.LPR.Reads.Repository;

import com.lpr.afsol.LPR.Reads.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<User, String> {
}
