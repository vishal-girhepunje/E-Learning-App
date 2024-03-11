package com.GrowSkill.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GrowSkill.model.Session;

public interface ISessionRepository extends JpaRepository<Session, Long>{

}
