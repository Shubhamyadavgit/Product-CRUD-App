package productcrudapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import productcrudapp.dao.ProductDao;
import productcrudapp.entity.Product;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    public void createProduct(Product product) {
        productDao.createProduct(product);
    }

    public List<Product> getAllProduct() {
    	System.out.println("Home Service");
        return productDao.getAllProduct();
    }

    public void deleteProduct(int id) {
        productDao.delete(id);
    }

    public Product getProductById(int id) {
        return productDao.getProductById(id);
    }

	public void updateProduct(Product updatedProduct) {
		productDao.createProduct(updatedProduct);
	}
}
