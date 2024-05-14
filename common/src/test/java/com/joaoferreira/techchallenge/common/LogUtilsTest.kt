package com.joaoferreira.techchallenge.common

import android.util.Log
import io.mockk.mockkStatic
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LogUtilsTest {

    @BeforeEach
    fun setup() {
        mockkStatic(Log::class)
    }

    @Test
    @DisplayName("GIVEN LogUtil WHEN TAG is invoked THEN should return the class name")
    fun shouldReturnTheClassNameWhenTAG() {
        assertEquals("LogUtilsTest", TAG)
    }
}
