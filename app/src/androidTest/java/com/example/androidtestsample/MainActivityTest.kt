package com.example.androidtestsample

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
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
        onView(withId(R.id.button))
            .perform(click()) // 클릭 실행
            .check(matches(withText("Hello, world!"))) // 뷰 확인

        // Text 로 찾기
        onView(withText("Hello, world!"))
    }

    @Test
    fun editText_change_tapas_to_hello() {
        onView(withId(R.id.editText))
            .perform(replaceText("Hello")) // text 입력
            .check(matches(withText("Hello")))
    }
}