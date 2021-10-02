package com.example.androidtestsample.ui.calculator

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.example.androidtestsample.R
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
        Espresso.onView(ViewMatchers.withText(buttonText))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.input))
            .check(ViewAssertions.matches(ViewMatchers.withText(buttonText)))
    }

    @ParameterizedTest
    @ValueSource(strings = ["+", "-", "*", "/"])
    fun change_input_to_text_of_number_button_when_operator_clicked(operatorText: String) {
        Espresso.onView(ViewMatchers.withText(operatorText))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.input))
            .check(ViewAssertions.matches(ViewMatchers.withText(operatorText)))
    }

    @Test
    fun change_input_to_ten_when_button_one_and_button_zero_clicked() {
        Espresso.onView(ViewMatchers.withText("1"))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withText("0"))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.input))
            .check(ViewAssertions.matches(ViewMatchers.withText("10")))
    }

    @Test
    fun calculate() {
        Espresso.onView(ViewMatchers.withText("2"))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withText("+"))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withText("5"))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withText("="))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.input))
            .check(ViewAssertions.matches(ViewMatchers.withText("7")))
    }

    @Test
    fun remove() {
        Espresso.onView(ViewMatchers.withText("2"))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withText("+"))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withText("5"))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withText("지우기"))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withText("지우기"))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.input))
            .check(ViewAssertions.matches(ViewMatchers.withText("2")))
    }
}