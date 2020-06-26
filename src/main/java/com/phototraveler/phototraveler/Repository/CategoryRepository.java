package com.phototraveler.phototraveler.Repository;

import com.phototraveler.phototraveler.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
