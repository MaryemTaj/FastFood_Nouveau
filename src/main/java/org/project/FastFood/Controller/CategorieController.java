package org.project.FastFood.Controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.project.FastFood.Request.CategorieRequest;
import org.project.FastFood.Response.CategorieResponse;

import org.project.FastFood.Services.CategorieService;
import org.project.FastFood.dto.CategorieDto;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorie")
public class CategorieController {
@Autowired
CategorieService categorieService;

/********************************API AJOUTER CATEGORIE***************************************/

@PostMapping("/add")
public ResponseEntity<CategorieResponse> addCategorie(@RequestBody CategorieRequest catRequest){
	ModelMapper modelmap = new ModelMapper();
	CategorieDto CatDto = modelmap.map(catRequest, CategorieDto.class);
	CategorieDto newCat = categorieService.AddCategorie(CatDto);
	CategorieResponse catResponse = modelmap.map(newCat, CategorieResponse.class);
	return new ResponseEntity<CategorieResponse>(catResponse,HttpStatus.OK);
	
}

/********************************API MODIFIER CATEGORIE***************************************/

@PutMapping("/{id_cat}")
public ResponseEntity<CategorieResponse> updateCategorie(@RequestBody CategorieRequest catRequest ,@PathVariable String id_cat){
	CategorieDto categorieDto = new CategorieDto();
	BeanUtils.copyProperties(catRequest, categorieDto);
	CategorieDto updateCategorie = categorieService.updateCategorie(categorieDto, id_cat);
    CategorieResponse categorieResponse = new CategorieResponse();	
	BeanUtils.copyProperties(updateCategorie, categorieResponse);
	return new ResponseEntity<CategorieResponse>(categorieResponse, HttpStatus.ACCEPTED);	
}

/********************************API SUPPRIMER CATEGORIE***************************************/

@DeleteMapping("/{id_cat}")

public ResponseEntity<Object> deleteCategorie(@PathVariable String id_cat) {
	categorieService.deleteCategorie(id_cat);
	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	
}

/********************************API AFFICHER LES CATEGORIES***************************************/
@GetMapping
public ResponseEntity<List<CategorieResponse>> getAllCategories(@RequestParam(value="page", defaultValue = "") int page,@RequestParam(value="limit", defaultValue = "")  int limit ,@RequestParam(value="search", defaultValue = "") String search,@RequestParam(value="status", defaultValue = "") int status) {
	
	List<CategorieResponse> categoriesResponse = new ArrayList<>();
	
	List<CategorieDto> categories = categorieService.getAllCategorie(page, limit, search, status);
	
	for(CategorieDto categorieDto: categories) {
		
		ModelMapper modelMapper = new ModelMapper();
		CategorieResponse categorieResponse =  modelMapper.map(categorieDto, CategorieResponse.class);
		
		categoriesResponse.add(categorieResponse);
	}
	
	return new ResponseEntity<List<CategorieResponse>>(categoriesResponse, HttpStatus.OK);
}


}
