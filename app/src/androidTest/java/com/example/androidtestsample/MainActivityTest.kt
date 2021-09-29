package com.example.androidtestsample

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
internal class MainActivityTest {

    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun button_has_hello_world_text() {
        // View 지정
        // ID 로 찾기
        onView(withId(R.id.up))
            .perform(click()) // 클릭 실행
            .check(matches(withText("UP"))) // 뷰 확인

        // Text 로 찾기
        onView(withText("UP"))
    }

    @Test
    fun textview_shown_tapas_text() {
        onView(withId(R.id.counter))
            .check(matches(withText("0")))
    }

    @Test
    fun increase_counter_up_button_clicked() {
        // when
        onView(withId(R.id.up))
            .perform(click())

        // then
        onView(withId(R.id.counter))
            .check(matches(withText("1")))
    }

    @Test
    fun decrease_counter_down_button_clicked() {
        // when
        onView(withId(R.id.down))
            .perform(click())

        // then
        onView(withId(R.id.counter))
            .check(matches(withText("-1")))
    }

    @Test
    fun increase_three_counter_up_button_three_clicked() {
        // when
        repeat(3) {
            onView(withId(R.id.up))
                .perform(click())
        }

        // then
        onView(withId(R.id.counter))
            .check(matches(withText("3")))
    }
}