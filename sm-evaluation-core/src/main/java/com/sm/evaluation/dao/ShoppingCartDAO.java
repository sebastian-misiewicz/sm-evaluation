package com.sm.evaluation.dao;

import org.springframework.data.repository.CrudRepository;

import com.sm.evaluation.entity.ShoppingCartBE;

public interface ShoppingCartDAO extends CrudRepository<ShoppingCartBE, String> {

}
