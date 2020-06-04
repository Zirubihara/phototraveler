package com.phototraveler.phototraveler.Repository;

import com.phototraveler.phototraveler.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
