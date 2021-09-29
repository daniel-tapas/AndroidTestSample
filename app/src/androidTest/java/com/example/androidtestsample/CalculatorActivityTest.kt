package com.example.androidtestsample

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

internal class CalculatorActivityTest {

    @get:Rule
    val rule = ActivityScenarioRule(CalculatorActivity::class.java)

    @Test
    fun change_input_to_text_of_number_button_when_number_clicked() {
        for(i in 0 .. 9) {
            onView(withText(i.toString()))
                .perform(click())

            onView(withId(R.id.input))
                .check(matches(withText(i.toString())))
        }
    }
}