package com.phototraveler.phototraveler.Repository;

import com.phototraveler.phototraveler.Model.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
}
