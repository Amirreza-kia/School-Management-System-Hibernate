package ir.maktabsharif.repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface BaseRepository<T> {
    Optional<T> findById(int id) ;
    List<T> findAll() ;
    void persist(T entity) ;
    void update(T entity) ;
    void delete(T entity) ;
}
