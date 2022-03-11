package com.te.springbootdemo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.te.springbootdemo.dto.Player;

@Repository
public interface PlayerRepo extends CrudRepository<Player, Integer>{

}