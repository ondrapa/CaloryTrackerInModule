package com.example.core.domain.model

sealed class ActivityLevel(val name: String) {

    object Low: ActivityLevel("low")
    object Medium: ActivityLevel("medium")
    object High: ActivityLevel("high")

    companion object {
        fun fromString(name: String): ActivityLevel {
            return when(name) {
                "low" -> Low
                "mediu" -> Medium
                "high" -> High
                else -> Low //will never happen
            }
        }
    }
}
