package com.example.android.easygobandprueba.commons

import com.example.android.data.models.EventType

/**
 * Transforms a list into a string of its values
 * Parameter: List<EventType>
 * Return: String of its properties. Every object separated by \n
 */
fun fromSessionsToString(list: List<EventType>): String {
    var str = ""

    list.forEach {
        str += "\n- Id: ${it.id} name: ${it.name}"
    }

    return str
}





