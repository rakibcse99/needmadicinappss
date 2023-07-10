package com.rakib.needmedicinapps.db
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rakib.needmedicinapps.data.local.Product

@Database(entities = [Product::class], version = 1, exportSchema = false)
abstract class ProductDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao

    companion object {
        private var INSTANCE: ProductDatabase? = null

        fun getInstance(context: Context): ProductDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    ProductDatabase::class.java,
                    "pm_database"
                ).build()
                return INSTANCE as ProductDatabase
            }else{
                return INSTANCE as ProductDatabase
            }
        }
    }
}
