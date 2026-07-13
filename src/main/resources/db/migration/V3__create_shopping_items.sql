CREATE TABLE shopping_items
(
    id               UUID PRIMARY KEY,
    shopping_list_id UUID                     NOT NULL,
    product_id       UUID,
    name             VARCHAR(255)             NOT NULL,
    checked          BOOLEAN                  NOT NULL DEFAULT FALSE,
    created_at       TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_at       TIMESTAMP WITH TIME ZONE NOT NULL,


    CONSTRAINT fk_shopping_items_shopping_list
        FOREIGN KEY (shopping_list_id)
            REFERENCES shopping_lists (id)
            ON DELETE CASCADE,

    CONSTRAINT fk_shopping_items_product
        FOREIGN KEY (product_id)
            REFERENCES products (id)
            ON DELETE SET NULL
);