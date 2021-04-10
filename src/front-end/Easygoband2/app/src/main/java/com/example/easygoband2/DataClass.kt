package com.example.easygoband2

var itemsArray2: Array<Datos2> = emptyArray()

class Datos2(val access_group_name: String,
            val access_group_id: Int,
            val total_uses: Int,
            val sessions: Array<sessionsList2>,
            val event_id: Int,
            val structure_decode: Boolean,
            val name: String,
            val id: Int,
            val basic_product_id: Int)


class sessionsList2(val name: String,
                   val id: Int)


//List<sessionsList2>,