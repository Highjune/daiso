package com.daiso.service;

import org.springframework.stereotype.Service;

import com.daiso.vo.ProductVO;


public interface ProductService {
	int selectProductId(String name);

	String selectProductSrc(int id);

	ProductVO selectProduct(int id);
}
