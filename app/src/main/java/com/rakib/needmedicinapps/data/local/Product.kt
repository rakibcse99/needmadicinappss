package com.rakib.needmedicinapps.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product_table")
data class Product(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val productTitle: String,
    val productSubtitle: String,
    val productImage: String,
    val createdDate: String,
    val stock: Boolean

)