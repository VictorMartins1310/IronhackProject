package com.bootcamp.project.mappers;

import com.bootcamp.project.dto.DTOProduct;
import com.bootcamp.project.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {
    DTOProduct toDto (Product dto);
    Product toEntity (DTOProduct entity);
}