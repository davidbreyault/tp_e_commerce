package fr.david.ecommerce.service;

import fr.david.ecommerce.exception.RessourceNotFoundException;
import fr.david.ecommerce.exception.StockException;
import fr.david.ecommerce.model.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getAllProducts();
    public Product getProductById(Long id) throws RessourceNotFoundException;
    public Product save(Product product);
    public boolean isProductAvailable(Product product, int quantity);
    public void removeProduct(Product product, int quantity) throws StockException;
}
