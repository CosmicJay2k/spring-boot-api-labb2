package com.example.labb2.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.labb2.entity.Parkingmeter;

public interface ParkingmeterRepository extends ListCrudRepository<Parkingmeter, Long> {

        Parkingmeter findById(long id);

        List<Parkingmeter> findByClosed(boolean closed);

        List<Parkingmeter> findByClosedAndPerson_id(boolean closed, long id);

        List<Parkingmeter> findByClosedAndCar_lp(boolean closed, String lp);

        @Query("""
                        UPDATE Parkingmeter SET end = :time WHERE id = :id
                        """)
        @Modifying
        void updateEnd(@Param("id") int id, LocalDateTime time);

        @Query("""
                        UPDATE Parkingmeter SET closed = true WHERE id = :id
                        """)
        @Modifying
        void closeParkingmeter(@Param("id") int id);

}
