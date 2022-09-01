package org.upb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.upb.dao.ISemestre;
import org.upb.data.Semestre;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/upb")
@Api(value = "",tags = {"Semestres :"})
@Tag(name = "Semestres :",description = "ressources Semestres")
public class SemestreController {
  
	@Autowired
	private ISemestre semestre;
	
	@ApiOperation(value = "L'URL pour la liste des semestres")
	@GetMapping(value = "/semestres")
	public List<Semestre> getListeSemestre(){
		return semestre.findAll();
	}
	
	@ApiOperation(value = "L'URL pour enregistrer un semestre")
	@PostMapping(value = "/semestres")
	public Semestre EnregistrerSemestre(@RequestBody Semestre a){
		return semestre.save(a);
	}
	
	@ApiOperation(value = "L'URL pour récuperer un semestre en fonction de son identifiant")
	@GetMapping(value = "/semestres/{id}")
    public Semestre getListeSemestreId(@PathVariable(name = "id") Integer id){
    	return semestre.findById(id).get();
    }
	  
	@ApiOperation(value = "L'URL pour modifier les informations d'un semestre")
	@PutMapping(value = "/semestres/{id}")
	public Semestre updateSemestre(@PathVariable(name="id") Integer id,@RequestBody Semestre p) {
		p.setIdSemestre(id);
		return semestre.save(p);
	}

	@ApiOperation(value = "L'URL pour retirer un semestre de labase de donnée")
	@DeleteMapping(value = "/semestres/{id}")
	public void supprimerNiveau(@PathVariable(name="id") Integer id) {
		
	}
}
