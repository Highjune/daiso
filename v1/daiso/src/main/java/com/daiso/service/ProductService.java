package com.daiso.service;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service("productserivce")
public interface ProductService {
	void selectProduct(Map map); 
}
