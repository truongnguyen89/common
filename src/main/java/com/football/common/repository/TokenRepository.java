package com.football.common.repository;

import com.football.common.model.auth.Token;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: truongnq
 * @date: 17-Dec-18 12:41 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public interface TokenRepository extends CrudRepository<Token, Long> {
    List<Token> findByToken(String token);

    List<Token> findByUserIdAndStatus(long userId, int status);

    List<Token> findByStatus(int status);
}
