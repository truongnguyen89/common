package com.football.common.repository;

import com.football.common.model.area.Commune;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Truong Nguyen
 * Date: 06-Dec-18
 * Time: 10:03 AM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public interface CommuneRepository extends CrudRepository<Commune, Long> {
    List<Commune> findByCode(String code);
}
