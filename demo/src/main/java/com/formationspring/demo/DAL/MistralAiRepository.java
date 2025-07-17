package com.formationspring.demo.DAL;

import com.formationspring.demo.entity.MistralRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MistralAiRepository extends JpaRepository<MistralRecordEntity,Long> {
}
