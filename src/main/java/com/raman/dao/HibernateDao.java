package com.raman.dao;

import com.raman.entity.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("htDao")
public class HibernateDao implements ProductDao {
    @Autowired
    private Session session;
    private Transaction tx;

    @Override
    public void addProduct(Product product) throws DaoException {
        session.persist(product);
    }

    @Override
    public void updateProduct(Product product) throws DaoException {
        session.merge(product);
    }

    @Override
    public Product getProduct(Integer productId) throws DaoException {
        return session.get(Product.class, productId);
    }

    @Override
    public void deleteProduct(Integer productId) throws DaoException {
        ProductDao.super.deleteProduct(productId);
    }

    @Override
    public List<Product> getAllProducts() throws DaoException {
        Query<Product> qry = session.createQuery("from Product ", Product.class);
        return qry.getResultList();
    }

    @Override
    public List<Product> getProductsByPriceRange(Double min, Double max) throws DaoException {
        Query<Product> qry = session.createQuery("from Product where unitPrice between :MIN_PRICE and :MAX_PRICE", Product.class);
        qry.setParameter("MIN_PRICE", min);
        qry.setParameter("MAX_PRICE", max);
        return qry.getResultList();
    }

    @Override
    public List<Product> getProductsInCategory(Integer categoryId) throws DaoException {
        return ProductDao.super.getProductsInCategory(categoryId);
    }

    @Override
    public List<Product> getProductsNotInStock() throws DaoException {
        return ProductDao.super.getProductsNotInStock();
    }

    @Override
    public List<Product> getProductOnOrder() throws DaoException {
        return ProductDao.super.getProductOnOrder();
    }

    @Override
    public List<Product> getDiscontinuedProducts() throws DaoException {
        return ProductDao.super.getDiscontinuedProducts();
    }

    @Override
    public long count() throws DaoException {
        return ProductDao.super.count();
    }
}
