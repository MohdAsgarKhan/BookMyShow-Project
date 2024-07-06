package com.accio.BookMyShow.Repository;

import com.accio.BookMyShow.Models.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<Theater, Integer> {
}
