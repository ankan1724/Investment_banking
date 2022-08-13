package com.local.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.local.Model.Banker;

@Repository
public interface BankerRepo extends JpaRepository<Banker, Long> {

}
