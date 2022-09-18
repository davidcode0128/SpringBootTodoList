package com.Davidcode.MyWeb.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Davidcode.MyWeb.model.dao.TodoDao;
import com.Davidcode.MyWeb.model.entity.Todo;


@Service
public class TodoService {
    @Autowired
    TodoDao todoDao; // 取得Dao物件

    public Iterable<Todo> getTodo () {
        return todoDao.findAll();
    }
    
    public Iterable<Todo> createTodo(Todo todo) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        df.setTimeZone(TimeZone.getTimeZone("GMT"));
        String date = df.format(new Date());
        todo.setCreateTime(date);
        todo.setUpdateTime(date);
        todoDao.save(todo);
        return getTodo();
    }
    
    public Todo updateTodo(Integer id,Todo todo) {
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            df.setTimeZone(TimeZone.getTimeZone("GMT"));
            String date = df.format(new Date());
            Todo resTodo = findById(id);
            Integer status = todo.getStatus();
            resTodo.setStatus(status);
            resTodo.setUpdateTime(date);
            return todoDao.save(resTodo);
        }catch (Exception exception) {
            return null;
        }

    }

 public Todo findById(Integer id) {
        Todo todo = todoDao.findById(id).get();
        return todo;
 }

 public Boolean deleteTodo(Integer id) {
     try {            
            todoDao.deleteById(id);
            return true;
        } catch (Exception exception) {
            return false;
        }
  }
}