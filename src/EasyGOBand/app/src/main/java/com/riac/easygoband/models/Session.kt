package com.riac.easygoband.models

data class Session(
    val id: Int,
    val name: String
) {
    override fun toString(): String {
        return "ID: $id \n" +
                "Name: $name"
    }
}