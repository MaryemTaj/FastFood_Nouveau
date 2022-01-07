package org.project.FastFood.ServicesImp;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.project.FastFood.Entity.CategorieEntity;
import org.project.FastFood.Entity.UserEntity;
import org.project.FastFood.Repository.CategorieRepository;
import org.project.FastFood.Services.CategorieService;
import org.project.FastFood.Util.Utils;
import org.project.FastFood.dto.CategorieDto;
import org.project.FastFood.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class CategorieServiceImp implements CategorieService{
	@Autowired 
	CategorieRepository categorieRepository;
	@Autowired
	Utils util;
	
/*****************************Ajouter Categorie ***************************/
	@Override
	public CategorieDto AddCategorie(CategorieDto categorieDto) {
		ModelMapper modelMapper = new ModelMapper();
		CategorieEntity catEntity = modelMapper.map(categorieDto,CategorieEntity.class);
		catEntity.setCatId(util.generateStringId(32));
		CategorieEntity newCategorie =categorieRepository.save(catEntity);
		CategorieDto catDto = modelMapper.map(newCategorie, CategorieDto.class);
		
		return catDto;
	}
	
	
/*****************************Update Categorie ****************************/	
	
	@Override
	public CategorieDto updateCategorie(CategorieDto categorieDto,String id_cat) {
		CategorieEntity catEntity = categorieRepository.findByCatId(id_cat);
		catEntity.setDescription(categorieDto.getDescription());
		catEntity.setName(categorieDto.getName());
		catEntity.setImage(categorieDto.getImage());		
		CategorieEntity CategorieUpdated =categorieRepository.save(catEntity);	
		CategorieDto categorie = new CategorieDto();
		BeanUtils.copyProperties(CategorieUpdated, categorie);
			
		return categorie;
	}
	
/*****************************Supprimer Categorie ***************************/	
	
@Override
public void deleteCategorie(String id_cat) {
	CategorieEntity catEntity = categorieRepository.findByCatId(id_cat);
	if(catEntity == null) throw new UsernameNotFoundException(id_cat); 		
	categorieRepository.delete(catEntity);			
}


@Override
public List<CategorieDto> getAllCategorie(int page, int limit, String search, int status) {

		if(page > 0) page = page - 1;
		
		List<CategorieDto> categoriesDto = new ArrayList<>();
		
		Pageable pageableRequest = PageRequest.of(page, limit);
		
		Page<CategorieEntity> categoriePage;
		
		
			categoriePage = categorieRepository.findAll(pageableRequest);
		
		
		
		List<CategorieEntity> categories = categoriePage.getContent();
		
		for(CategorieEntity categorieEntity: categories) {
			
			ModelMapper modelMapper = new ModelMapper();	
			CategorieDto categorie = modelMapper.map(categorieEntity,CategorieDto.class);
			
			categoriesDto.add(categorie);
		}		
		return categoriesDto;
	}
	
}

