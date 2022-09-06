package org.upb.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.upb.data.Etudiant;

public interface IEtudiant extends JpaRepository<Etudiant, String> {
	 public Etudiant findBymatriculeEtudiant(String etudiant);
	 
	 @Query(value="SELECT * FROM etudiant,filiere,niveau WHERE (etudiant.Niveau_id_niveau=niveau.id_niveau and etudiant.Filiere_id_filiere=filiere.id_filiere) and (filiere.designation_filiere LIKE '%idfiliere%' and niveau.designation_niveau LIKE '%idniveau%')",nativeQuery = true)
	 public List<Etudiant> getListe(String idfiliere , String idniveau);
}
