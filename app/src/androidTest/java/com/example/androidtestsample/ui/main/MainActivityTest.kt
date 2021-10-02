package com.example.androidtestsample.ui.main

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.matcher.ViewMatchers
import com.example.androidtestsample.R
import com.example.androidtestsample.ui.calculator.CalculatorActivity
import de.mannodermaus.junit5.ActivityScenarioExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.RegisterExtension

internal class MainActivityTest {

    @JvmField
    @RegisterExtension
    val scenarioExtension = ActivityScenarioExtension.launch<MainActivity>()

    @Test
    fun button_has_hello_world_text() {
        // View 지정
        // ID 로 찾기
        Espresso.onView(ViewMatchers.withId(R.id.up))
            .perform(ViewActions.click()) // 클릭 실행
            .check(ViewAssertions.matches(ViewMatchers.withText("UP"))) // 뷰 확인

        // Text 로 찾기
        Espresso.onView(ViewMatchers.withText("UP"))
    }

    @Test
    fun textview_shown_tapas_text() {
        Espresso.onView(ViewMatchers.withId(R.id.counter))
            .check(ViewAssertions.matches(ViewMatchers.withText("0")))
    }

    @Test
    fun increase_counter_up_button_clicked() {
        // when
        Espresso.onView(ViewMatchers.withId(R.id.up))
            .perform(ViewActions.click())

        // then
        Espresso.onView(ViewMatchers.withId(R.id.counter))
            .check(ViewAssertions.matches(ViewMatchers.withText("1")))
    }

    @Test
    fun decrease_counter_down_button_clicked() {
        // when
        Espresso.onView(ViewMatchers.withId(R.id.down))
            .perform(ViewActions.click())

        // then
        Espresso.onView(ViewMatchers.withId(R.id.counter))
            .check(ViewAssertions.matches(ViewMatchers.withText("-1")))
    }

    @Test
    fun increase_three_counter_up_button_three_clicked() {
        // when
        repeat(3) {
            Espresso.onView(ViewMatchers.withId(R.id.up))
                .perform(ViewActions.click())
        }

        // then
        Espresso.onView(ViewMatchers.withId(R.id.counter))
            .check(ViewAssertions.matches(ViewMatchers.withText("3")))
    }

    @Test
    fun open_calculator_activity_calculator_button_clicked() {
        Intents.init()

        Espresso.onView(ViewMatchers.withId(R.id.calculator))
            .perform(ViewActions.click())

        Intents.intended(IntentMatchers.hasComponent(CalculatorActivity::class.qualifiedName))
        Intents.release()
    }
}