package com.bootcamp.project.mappers;

import com.bootcamp.project.dto.ProductDTO;
import com.bootcamp.project.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {
    ProductDTO toDto (Product dto);
    Product toEntity (ProductDTO entity);
}