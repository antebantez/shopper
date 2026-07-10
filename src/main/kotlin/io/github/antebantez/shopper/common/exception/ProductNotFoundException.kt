package io.github.antebantez.shopper.common.exception

import java.util.UUID

class ProductNotFoundException(id: UUID): RuntimeException("Product with id $id not found")