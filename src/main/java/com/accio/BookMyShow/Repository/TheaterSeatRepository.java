package com.accio.BookMyShow.Repository;

import com.accio.BookMyShow.Models.TheaterSeats;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterSeatRepository extends JpaRepository<TheaterSeats, Integer> {
}
