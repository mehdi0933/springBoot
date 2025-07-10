package com.formationspring.demo.services;

import com.formationspring.demo.entity.EntityMistialAi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMistralAiRepository extends JpaRepository<EntityMistialAi,Long> {
}
