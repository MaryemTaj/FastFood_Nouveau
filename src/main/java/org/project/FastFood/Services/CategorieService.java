package org.project.FastFood.Services;

import java.util.List;

import org.project.FastFood.dto.CategorieDto;

public interface CategorieService {
	CategorieDto AddCategorie(CategorieDto categorieDto);
	CategorieDto updateCategorie(String id_cat,CategorieDto categorieDto);
	void deleteCategorie(String id_cat);
	List<CategorieDto> getAllCategorie(int page, int limit, String search, int status);
	CategorieDto getCatById(String catId);
	
	
	

}
