package com.example.androidtestsample.softassertion

import com.google.common.truth.Expect
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

class CustomExtensionTest {

    @Test
    @ExtendWith(ExpectExtension::class)
    fun test(expect: Expect) {
        expect.that<Int>(1).isEqualTo(2)
        expect.that<Int>(1).isEqualTo(3)
        expect.that<Int>(1).isEqualTo(4)
    }
}