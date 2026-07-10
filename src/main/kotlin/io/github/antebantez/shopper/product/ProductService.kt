package io.github.antebantez.shopper.product

import io.github.antebantez.shopper.common.exception.ProductNotFoundException
import org.springframework.stereotype.Service
import java.time.Instant
import java.util.UUID

@Service
class ProductService(
    private val productRepository: ProductRepository
){
    fun getAll(): List<Product> =
        productRepository.findAll()

    fun getById(id: UUID): Product =
        productRepository.findById(id).orElseThrow{ ProductNotFoundException(id) }

    fun create(name: String): Product =
        productRepository.save(Product(name = name))

    fun update(id: UUID, name: String): Product {
        val product = getById(id)

        product.name = name
        product.updatedAt = Instant.now()

        return productRepository.save(product)
    }

    fun delete(id: UUID) {
        productRepository.delete(getById(id))
    }
}