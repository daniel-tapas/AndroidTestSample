package com.example.data

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.threeten.bp.LocalDateTime

internal class InMemoryMemoDataSourceTest {
    private lateinit var memoDataSource: MemoDataSource

    @BeforeEach
    internal fun setUp() {
        memoDataSource = InMemoryMemoDataSource()
    }

    @Test
    fun `메모를 추가하면 1개의 메모가 저장된다`() {
        memoDataSource.write("hello, world!", LocalDateTime.now())

        assertThat(memoDataSource.getMemoList().size).isEqualTo(1)
    }

    @Test
    fun `저장된 메모를 가져오면 동일해야 한다`() {
        val createdAt = LocalDateTime.now()
        memoDataSource.write("hello, world!", createdAt)

        val memo = memoDataSource.readById(0L)
        memo?.let {
            assertThat(it.content).isEqualTo("hello, world!")
            assertThat(it.createdAt).isEqualTo(createdAt)
        }
    }
}