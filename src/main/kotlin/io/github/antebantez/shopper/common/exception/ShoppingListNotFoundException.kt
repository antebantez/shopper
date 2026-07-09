package io.github.antebantez.shopper.common.exception

import java.util.UUID

class ShoppingListNotFoundException(id: UUID): RuntimeException("ShoppingList with id $id not found")