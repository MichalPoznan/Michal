package io.github.mat3e.todo;

import io.github.mat3e.HibernateUtil;
import io.github.mat3e.lang.Lang;

import java.util.List;
import java.util.Optional;

class TodoRepository {
    List<Todo> findAll() {
        var session = HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();

        var result = session.createQuery("from Todo", Todo.class).list();

        transaction.commit();
        session.close();
        return result;
    }

    Todo toogleTodo(Integer id) {
        var session = HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();

        var result = session.get(Todo.class, id);

        result.setDone(!result.getDone());

        transaction.commit();
        session.close();
        return result;
    }

    Todo addTodo(Todo newTodo){
        var session = HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();
        session.persist(newTodo);
//        newTodo
        //session.g
        transaction.commit();
        session.close();
        return newTodo;
    }
//    public Optional<Todo> findById(Integer id) {
//        var session = HibernateUtil.getSessionFactory().openSession();
//        var transaction = session.beginTransaction();
//
//        var result = session.get(Todo.class, id);
//
//        transaction.commit();
//        session.close();
//        return Optional.ofNullable(result);
//    }
}
