package com.football.common.repository;

import com.football.common.model.auth.UserRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: truongnq
 * @date: 26-Dec-18 3:24 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public interface UserRoleRepository extends CrudRepository<UserRole, Long> {
    List<UserRole> findByStatus(int status);
}
