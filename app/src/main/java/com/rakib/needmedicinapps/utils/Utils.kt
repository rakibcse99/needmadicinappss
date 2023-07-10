package com.rakib.needmedicinapps.utils

import com.rakib.needmedicinapps.data.local.Product
import com.rakib.needmedicinapps.data.local.Banner

object Utils {
    //demo data for slider list
    val sliderItems = listOf(
        Banner(
            id = 1,
            title = "Welcome Our Apps",
            slideImg = "https://firebasestorage.googleapis.com/v0/b/fir-test-d4ed2.appspot.com/o/background.png?alt=media&token=8c4ea6c0-d03b-4345-a4b1-8d98aa52c3f6"
        ),
        Banner(
            id = 2,
            title = "",
            slideImg = "https://media.gettyimages.com/id/1312706413/photo/modern-hospital-building.jpg?s=1024x1024&w=gi&k=20&c=2nU8Ac2_g9NiiRTgZXfBqSRx50tR4x8R7io7X1OCUFg="
        ),

        Banner(
            id = 3,
            title = "",
            slideImg = "https://images.pexels.com/photos/3769151/pexels-photo-3769151.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
        ),
        Banner(
            id = 4,
            title = "",
            slideImg = "https://images.pexels.com/photos/3279203/pexels-photo-3279203.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
        )
    )

    //demo data for product list
    val productItems = listOf(
        Product(
            id = 1,
            productTitle = "Surgel",
            productSubtitle = "Esomeprazole Magnesium Trihydrate",
            productImage = "https://epharma.com.bd/storage/app/public/1pw6NCLPzF81RxHPgc6LKmw8O7dy9F3POUBHPi63.jpg",
            createdDate = "06 jun,2023",
            stock = true
        ),
        Product(
            id = 2,
            productTitle = "Napa",
            productSubtitle = "Paracetamol 500mg",
            productImage = "https://chaldn.com/_mpimage/napa-tablet-500mg-10-tablets?src=https%3A%2F%2Feggyolk.chaldal.com%2Fapi%2FPicture%2FRaw%3FpictureId%3D106095&q=low&v=1&m=400&webp=1",
            createdDate = "02 jun,2021",
            stock = false
        ),
        Product(
            id = 3,
            productTitle = "Biotin Plus",
            productSubtitle = "Biotin",
            productImage = "https://d35cnulyv0pa6p.cloudfront.net/products/images/2022/363716/biotin_plus_30.jpg?EZpU9iSSptgHCf4vbz97NCTpusgOKjm7=",
            createdDate = "26 jan,2022",
            stock = true
        ),
        Product(
            id = 4,
            productTitle = "Amotid 250gm",
            productSubtitle = "Amoxicillin",
            productImage = "https://www.biopharmabd.com/public/uploads/images/product_img_167807157668341.png",
            createdDate = "16 dec,2018",
            stock = true
        ),
        Product(
            id = 5,
            productTitle = "Fexo",
            productSubtitle = "Fexofenadine Hydrochloride",
            productImage = "https://firebasestorage.googleapis.com/v0/b/fir-test-d4ed2.appspot.com/o/fexo-tablet-120mg-10-tablets.jpg?alt=media&token=31e01ff8-6d43-4297-9269-2a750887dc0e",
            createdDate = "09 jun,2023",
            stock = true
        ),
        Product(
            id = 6,
            productTitle = "Don-A",
            productSubtitle = "Dosage and administration",
            productImage = "https://firebasestorage.googleapis.com/v0/b/fir-test-d4ed2.appspot.com/o/Don-A%2010%20mg%20Tablet-400x400.jpg?alt=media&token=38bffae7-80c0-4ff9-bc23-9b1d24642d88",
            createdDate = "10 jun,2023",
            stock = true
        ),
        Product(
            id = 7,
            productTitle = "Nomi",
            productSubtitle = "Zolmitriptan",
            productImage = "https://firebasestorage.googleapis.com/v0/b/fir-test-d4ed2.appspot.com/o/Screenshot_1.png?alt=media&token=b82e78c2-93d1-45df-97d3-5dcd97b365c6",
            createdDate = "10 jun,2023",
            stock = false
        ),
        Product(
            id = 8,
            productTitle = "E-Cap",
            productSubtitle = "Vitamin E (Alpha-tocopherol)",
            productImage = "https://firebasestorage.googleapis.com/v0/b/fir-test-d4ed2.appspot.com/o/Screenshot_16.png?alt=media&token=0320761b-6279-4d2c-9073-235568f9a944",
            createdDate = "06 jun,2023",
            stock = true
        ),
    )
}