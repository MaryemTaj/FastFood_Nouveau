package org.project.FastFood.Services;

import java.util.List;

import org.project.FastFood.dto.CategorieDto;

public interface CategorieService {
	CategorieDto AddCategorie(CategorieDto categorieDto);
	CategorieDto updateCategorie(CategorieDto categorieDto,String id_cat);
	void deleteCategorie(String id_cat);
	List<CategorieDto> getAllCategorie(int page, int limit, String search, int status);
	
	
	

}
