package com.example.service;

import com.example.domain.ProductLine;
import com.example.domain.ProductLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by DaikiTakeuchi on 2016/11/24.
 */
@Service
public class ProductLineService implements Pagination {

    @Autowired
    ProductLineRepository productLineRepository;

    @Transactional(readOnly = true, timeout = 3)
    public ProductLine findById(final Long id) {
        return productLineRepository.findOne(id);
    }

    @Transactional(readOnly = true, timeout = 3)
    public ProductLine findByPk(final String productLineCode) {
        return productLineRepository.findByPk(productLineCode);
    }

    @Transactional(readOnly = true, timeout = 10)
    public Iterable<ProductLine> findAll(int page, int size, String sort) {
        Pageable pager = new PageRequest(currentPage(page), size, Direction.ASC, sort);
        return productLineRepository.findAll(pager);
    }

    @Transactional(rollbackFor = Exception.class, timeout = 3)
    public ProductLine save(final ProductLine productLine) {
        return productLineRepository.save(productLine);
    }

    @Transactional(rollbackFor = Exception.class, timeout = 10)
    public List<ProductLine> saveAll(final Iterable<ProductLine> productLines) {
        return productLineRepository.save(productLines);
    }

    @Transactional(rollbackFor = Exception.class, timeout = 3)
    public void remove(final ProductLine productLine) {
        productLineRepository.delete(productLine);
    }

    @Transactional(rollbackFor = Exception.class, timeout = 10)
    public void removeAll(final Iterable<ProductLine> productLines) {
        productLineRepository.delete(productLines);
    }
}