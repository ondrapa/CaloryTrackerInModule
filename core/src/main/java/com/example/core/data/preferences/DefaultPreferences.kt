package com.example.core.data.preferences

import android.content.SharedPreferences
import com.example.core.domain.model.ActivityLevel
import com.example.core.domain.model.Gender
import com.example.core.domain.model.GoalType
import com.example.core.domain.model.UserInfo
import com.example.core.domain.preferences.Preferences

class DefaultPreferences(
    private val sharedPreferences: SharedPreferences
): Preferences {

    override fun saveGender(gender: Gender) {
        sharedPreferences.edit()
            .putString(Preferences.KEY_GENDER, gender.name)
            .apply()
    }

    override fun saveAge(age: Int) {
        sharedPreferences.edit()
            .putInt(Preferences.KEY_AGE, age)
            .apply()
    }

    override fun saveWeight(weight: Float) {
        sharedPreferences.edit()
            .putFloat(Preferences.KEY_WEIGHT, weight)
            .apply()
    }

    override fun saveHeight(height: Int) {
        sharedPreferences.edit()
            .putInt(Preferences.KEY_HEIGHT, height)
            .apply()
    }

    override fun saveActivityLevel(level: ActivityLevel) {
        sharedPreferences.edit()
            .putString(Preferences.KEY_ACTIVITY_LEVEL, level.name)
            .apply()
    }

    override fun saveGoalType(type: GoalType) {
        sharedPreferences.edit()
            .putString(Preferences.KEY_GOAL_TYPE, type.name)
            .apply()
    }

    override fun saveCarbRatio(ratio: Float) {
        sharedPreferences.edit()
            .putFloat(Preferences.KEY_CARB_RATIO, ratio)
            .apply()
    }

    override fun saveProteinRatio(ratio: Float) {
        sharedPreferences.edit()
            .putFloat(Preferences.KEY_PROTEIN_RATIO, ratio)
            .apply()
    }

    override fun saveFatRatio(ratio: Float) {
        sharedPreferences.edit()
            .putFloat(Preferences.KEY_FAT_RATIO, ratio)
            .apply()
    }

    override fun loadUserInfo(): UserInfo {
        val age = sharedPreferences.getInt(Preferences.KEY_AGE, -1)
        val height = sharedPreferences.getInt(Preferences.KEY_HEIGHT, -1)
        val weight = sharedPreferences.getFloat(Preferences.KEY_WEIGHT, -1f)
        val genderString = sharedPreferences.getString(Preferences.KEY_GENDER, null)
        val activityLevel = sharedPreferences.getString(Preferences.KEY_ACTIVITY_LEVEL, null)
        val goalType = sharedPreferences.getString(Preferences.KEY_GOAL_TYPE, null)
        val carbRatio = sharedPreferences.getFloat(Preferences.KEY_CARB_RATIO, -1f)
        val proteinRatio = sharedPreferences.getFloat(Preferences.KEY_PROTEIN_RATIO, -1f)
        val fatRatio = sharedPreferences.getFloat(Preferences.KEY_FAT_RATIO, -1f)

        return UserInfo(
            Gender.fromString(genderString ?: "male"),
            age,
            weight,
            height,
            ActivityLevel.fromString(activityLevel ?: "medium"),
            GoalType.fromString(goalType ?: "keep_weight"),
            carbRatio,
            proteinRatio,
            fatRatio
        )
    }

}