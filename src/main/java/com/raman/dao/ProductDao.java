package com.raman.dao;

import com.raman.entity.Product;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional(rollbackFor = {DaoException.class}, readOnly = true)
public interface ProductDao {
    //CRUD operations

    @Transactional(readOnly = false)
    public default void addProduct(Product product) throws DaoException {
        throw new DaoException("Method Not Implemented");
    }

    @Transactional(readOnly = false)
    public default void updateProduct(Product product) throws DaoException {
        throw new DaoException("Method Not Implemented");
    }

    public default Product getProduct(Integer productId) throws DaoException {
        throw new DaoException("Method Not Implemented");
    }

    @Transactional(readOnly = false)
    public default void deleteProduct(Integer productId) throws DaoException  {
        throw new DaoException("Method Not Implemented");
    }

    //Queries
    public default List<Product> getAllProducts() throws DaoException  {
        throw new DaoException("Method Not Implemented");
    }

    public default List<Product> getProductsByPriceRange(Double min, Double max) throws DaoException  {
        throw new DaoException("Method Not Implemented");
    }

    public default List<Product> getProductsInCategory(Integer categoryId) throws DaoException  {
        throw new DaoException("Method Not Implemented");
    }

    public default List<Product> getProductsNotInStock() throws DaoException {
        throw new DaoException("Method Not Implemented");
    }

    public default List<Product> getProductOnOrder() throws DaoException {
        throw new DaoException("Method Not Implemented");
    }

    public default List<Product> getDiscontinuedProducts() throws DaoException {
        throw new DaoException("Method Not Implemented");
    }

    public default long count() throws DaoException {
        throw new DaoException("Method Not Implemented");
    }
}