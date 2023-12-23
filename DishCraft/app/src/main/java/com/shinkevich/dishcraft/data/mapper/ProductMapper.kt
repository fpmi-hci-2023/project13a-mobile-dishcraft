package com.shinkevich.dishcraft.data.mapper

import com.shinkevich.dishcraft.data.networkstorage.entity.Product

class ProductMapper {
    companion object{
        fun productResponseToProduct(product : Product) : com.shinkevich.dishcraft.data.entity.Product{
            return com.shinkevich.dishcraft.data.entity.Product(
                product.productId,
                product.productName,
                ImageMapper.imageToBitmap(product.image),
                product.calories,
                product.proteins,
                product.fats,
                product.carbohydrates
            )
        }
    }
}