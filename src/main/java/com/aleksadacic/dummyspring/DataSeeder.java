package com.aleksadacic.dummyspring;

import com.aleksadacic.dummyspring.model.*;
import com.aleksadacic.dummyspring.repositories.CategoryRepository;
import com.aleksadacic.dummyspring.repositories.OrderRepository;
import com.aleksadacic.dummyspring.repositories.ProductRepository;
import com.aleksadacic.dummyspring.repositories.UserRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        seedUsers();
        seedCategories();
        seedProducts();
        seedOrders();
    }

    private void seedUsers() throws IOException {
        File usersFile = new ClassPathResource("data/users.json").getFile();
        List<User> users = objectMapper.readValue(usersFile, new TypeReference<>() {
        });
        userRepository.saveAll(users);
    }

    private void seedCategories() throws IOException {
        File categoriesFile = new ClassPathResource("data/categories.json").getFile();
        List<Category> categories = objectMapper.readValue(categoriesFile, new TypeReference<>() {
        });
        categoryRepository.saveAll(categories);
    }

    private void seedProducts() throws IOException {
        File productsFile = new ClassPathResource("data/products.json").getFile();
        List<Map<String, Object>> productData = objectMapper.readValue(productsFile, new TypeReference<List<Map<String, Object>>>() {
        });

        for (Map<String, Object> productMap : productData) {
            String categoryName = (String) productMap.get("category");
            Category category = categoryRepository.findByName(categoryName);

            if (category != null) {
                Product product = new Product();
                product.setName((String) productMap.get("name"));
                product.setPrice((Double) productMap.get("price"));
                product.setCategory(category);

                productRepository.save(product);
            }
        }
    }

    private void seedOrders() throws IOException {
        File ordersFile = new ClassPathResource("data/orders.json").getFile();
        List<Map<String, Object>> orderData = objectMapper.readValue(ordersFile, new TypeReference<>() {
        });

        for (Map<String, Object> orderMap : orderData) {
            String userName = (String) orderMap.get("user");
            User user = userRepository.findByName(userName);

            if (user != null) {
                Order order = new Order();
                order.setUser(user);
                order.setOrderStatus(OrderStatus.valueOf((String) orderMap.get("orderStatus")));

                List<String> productNames = (List<String>) orderMap.get("products");
                for (String productName : productNames) {
                    Product product = productRepository.findByName(productName);
                    if (product != null) {
                        order.getProducts().add(product);
                    }
                }

                // Handle Payment and Shipping
                Payment payment = new Payment();
                payment.setAmount(calculateTotal(order.getProducts()));
                payment.setPaymentMethod(PaymentMethod.valueOf((String) orderMap.get("paymentMethod")));
                order.setPayment(payment);

                Shipping shipping = new Shipping();
                shipping.setAddress((String) orderMap.get("address"));
                order.setShipping(shipping);

                orderRepository.save(order);
            }
        }
    }

    private Double calculateTotal(List<Product> products) {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }
}
