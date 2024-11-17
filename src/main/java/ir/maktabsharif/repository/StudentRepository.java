package ir.maktabsharif.repository;

import ir.maktabsharif.model.model.Student;

public interface StudentRepository extends BaseRepository<Student>{

    int getStudentCount();
}
