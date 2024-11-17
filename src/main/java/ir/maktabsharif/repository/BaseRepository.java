package ir.maktabsharif.repository;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<T>{
    Optional<T> findById(Long id) ;
    List<T> findAll() ;
    void saveOrUpdate(T obj) ;
    void delete(Long id) ;
}
