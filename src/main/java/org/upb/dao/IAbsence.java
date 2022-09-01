package org.upb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.upb.data.Absence;

public interface IAbsence extends JpaRepository<Absence, Integer>{

}
