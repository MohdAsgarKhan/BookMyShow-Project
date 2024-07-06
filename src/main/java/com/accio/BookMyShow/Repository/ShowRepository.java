package com.accio.BookMyShow.Repository;

import com.accio.BookMyShow.Models.Shows;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Shows, Integer> {
}
