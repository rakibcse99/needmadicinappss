package com.rakib.needmedicinapps.utils

import com.rakib.needmedicinapps.data.local.Product
import com.rakib.needmedicinapps.data.local.Banner

object Utils {
    //demo data for slider list
    val sliderItems = listOf(
        Banner(
            id = 1,
            title = "Welcome Our Apps",
            slideImg = "https://images.unsplash.com/photo-1584308666744-24d5c474f2ae?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=830&q=80"
        ),
        Banner(
            id = 2,
            title = "",
            slideImg = "https://media.istockphoto.com/id/1441494864/photo/medical-team-portrait.jpg?s=1024x1024&w=is&k=20&c=3V5ZanhKQ_Fux9WvxjaYAPALwvLiL9u4Fzi8xPpgciY="
        ),

        Banner(
            id = 3,
            title = "",
            slideImg = "https://media.istockphoto.com/id/1465073112/photo/blue-capsules-on-conveyor-at-modern-pharmaceutical-factory-tablet-and-capsule-manufacturing.jpg?s=1024x1024&w=is&k=20&c=he28UxqwhixH6YWmirYFRBj980I4kvkQ2ZKiIzAvlQQ="
        ),
        Banner(
            id = 4,
            title = "",
            slideImg = "https://images.unsplash.com/photo-1573883431205-98b5f10aaedb?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=870&q=80"
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