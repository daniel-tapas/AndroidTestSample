package com.example.androidtestsample

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import de.mannodermaus.junit5.ActivityScenarioExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.RegisterExtension
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class CalculatorActivityTest {

    @JvmField
    @RegisterExtension
    val scenarioExtension = ActivityScenarioExtension.launch<CalculatorActivity>()

    @ParameterizedTest
    @ValueSource(strings = ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9"])
    fun change_input_to_text_of_number_button_when_number_clicked(buttonText: String) {
        onView(withText(buttonText))
            .perform(click())

        onView(withId(R.id.input))
            .check(matches(withText(buttonText)))
    }

    @ParameterizedTest
    @ValueSource(strings = ["+", "-", "*", "/"])
    fun change_input_to_text_of_number_button_when_operator_clicked(operatorText: String) {
        onView(withText(operatorText))
            .perform(click())

        onView(withId(R.id.input))
            .check(matches(withText(operatorText)))
    }

    @Test
    fun change_input_to_ten_when_button_one_and_button_zero_clicked() {
        onView(withText("1"))
            .perform(click())

        onView(withText("0"))
            .perform(click())

        onView(withId(R.id.input))
            .check(matches(withText("10")))
    }
}