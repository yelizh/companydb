package com.yeliz.repository;

public interface ICrud<T> {

    boolean save(T t);

    boolean delete(int id);

}
