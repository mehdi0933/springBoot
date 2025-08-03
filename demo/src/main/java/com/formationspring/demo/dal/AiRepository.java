package com.formationspring.demo.dal;

import com.formationspring.demo.entity.AiRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AiRepository extends JpaRepository<AiRecordEntity,Long> {
}
