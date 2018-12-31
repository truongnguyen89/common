package com.football.common.repository;

import com.football.common.model.auth.GroupRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: truongnq
 * @date: 26-Dec-18 3:31 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public interface GroupRoleRepository extends CrudRepository<GroupRole, Long> {
    List<GroupRole> findByStatus(int status);
}
