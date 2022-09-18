package com.Davidcode.MyWeb.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.Davidcode.MyWeb.model.entity.Todo;

// 第一個參數為訪問的實體，第二參數是這個Entity ID的資料型態
public interface TodoDao extends CrudRepository<Todo, Integer> {

}