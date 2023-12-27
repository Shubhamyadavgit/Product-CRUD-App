package productcrudapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import productcrudapp.entity.Product;

@Repository
public class ProductDao {
	
	@Autowired
	private EntityManagerFactory entityManager;

	public void createProduct(Product product) {
		EntityManager manager = entityManager.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.merge(product);
		transaction.commit();
		manager.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> getAllProduct(){
		EntityManager manager = entityManager.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Query query = manager.createQuery("From Product");
		List<Product> products = query.getResultList();
		transaction.commit();
		manager.close();
		return products;
	}
	public void delete(int id) {
		EntityManager manager = entityManager.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Product product = manager.find(Product.class, id);
		manager.remove(product);
		transaction.commit();
		manager.close();
	}
	public Product getProductById(int id) {
		EntityManager manager = entityManager.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Product product = manager.find(Product.class, id);
		return product;
	}
}
