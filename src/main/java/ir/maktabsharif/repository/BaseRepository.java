package ir.maktabsharif.repository;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<T>{
    Optional<T> findById(long id) ;
    List<T> findAll() ;
    void saveOrUpdate(T obj) ;
    void delete(long id) ;
}
