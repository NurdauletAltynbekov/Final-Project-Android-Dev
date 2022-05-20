package com.example.todolist.model

class Country (
    var country_id: Int? = null,
    var country: String? = null,
    var slug: String? = null,
    var is02: String? = null,
) {
    companion object {
        const val serializedName: String = "country"
    }
}