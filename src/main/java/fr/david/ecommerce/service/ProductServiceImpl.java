package fr.david.ecommerce.service;

import fr.david.ecommerce.exception.RessourceNotFoundException;
import fr.david.ecommerce.exception.StockException;
import fr.david.ecommerce.model.Product;
import fr.david.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("products")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) throws RessourceNotFoundException {
        return productRepository.getById(id);
    }

    @Override
    public Product save(Product product) {
        productRepository.save(product);
        return product;
    }

    @Override
    public boolean isProductAvailable(Product product, int quantity) {
        return product.getQuantity() >= quantity;
    }

    @Override
    public void removeProduct(Product product, int quantity) throws StockException {
        if (isProductAvailable(product, quantity)) {
            product.setQuantity(product.getQuantity() - quantity);
        } else {
            throw new StockException();
        }
    }
}
