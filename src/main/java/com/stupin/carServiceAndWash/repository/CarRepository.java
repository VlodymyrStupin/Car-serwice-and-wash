package com.stupin.carServiceAndWash.repository;

import com.stupin.carServiceAndWash.dao.CarDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CarRepository extends JpaRepository<CarDao, String> {
    long deleteByIdIgnoreCase(String id);
    @Query("SELECT c FROM CarDao c WHERE c.id = ?1")
    CarDao findByVinCode(String id);
    @Query("SELECT c FROM CarDao c WHERE c.userDao.id = ?1")
    List<CarDao> findByUserId(Integer id);
    @Query("DELETE FROM CarDao c WHERE c.id = ?1")
    void deleteByVin(String vin);
}
