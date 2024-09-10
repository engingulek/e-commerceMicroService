package com.example.inventory_microservice.core.mapper;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
 ModelMapper forResponse();
    ModelMapper forRequest();
}
