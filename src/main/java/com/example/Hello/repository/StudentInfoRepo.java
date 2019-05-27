package com.example.Hello.repository;

import com.example.Hello.model.StudentInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentInfoRepo extends CrudRepository<StudentInfo,Integer> {
    /**
     * save student info
     * @param entity
     * @param <S>
     * @return
     */
    @Override
    <S extends StudentInfo> S save(S entity);

    /**
     * save all student info
     * @param entities
     * @param <S>
     * @return
     */
    @Override
    <S extends StudentInfo> Iterable<S> saveAll(Iterable<S> entities);

    /**
     * find student info by id
     * @param integer
     * @return
     */
    @Override
    Optional<StudentInfo> findById(Integer integer);

    /**
     *
     * @param integer
     * @return
     */
    @Override
    boolean existsById(Integer integer);

    /**
     * find all student info
     * @return
     */
    @Override
    List<StudentInfo> findAll();

    /**
     * find all student by id
     * @param integers
     * @return
     */
    @Override
    List<StudentInfo> findAllById(Iterable<Integer> integers);

    /**
     * find count
     * @return
     */
    @Override
    long count();

    /**
     * delete student info by id
     * @param integer
     */
    @Override
    void deleteById(Integer integer);

    /**
     * delete student info using entity
     * @param entity
     */
    @Override
    void delete(StudentInfo entity);

    /**
     * delete all student info with parameters
     * @param entities
     */
    @Override
    void deleteAll(Iterable<? extends StudentInfo> entities);

    /**
     * delete all student info without parameters
     */
    @Override
    void deleteAll();
}
