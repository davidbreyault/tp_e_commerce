package fr.david.ecommerce.service;

import fr.david.ecommerce.exception.RessourceNotFoundException;
import fr.david.ecommerce.exception.StockException;
import fr.david.ecommerce.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("products")
public class ProductServiceImpl implements ProductService {

    private final List<Product> allProducts = new ArrayList<>();

    @Override
    public List<Product> getAllProducts() {
        return allProducts;
    }

    @Override
    public Product getProductById(Long id) throws RessourceNotFoundException {
        Product product = null;
        for (int i = 0; i < allProducts.size(); i++) {
            if (allProducts.get(i).getId() == id) {
                product = allProducts.get(i);
                return product;
            }
        }
        throw new RessourceNotFoundException("Product not found");
    }

    @Override
    public Product save(Product product) {
        allProducts.add(product);
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
