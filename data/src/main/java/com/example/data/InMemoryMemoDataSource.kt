package com.example.data

import com.example.domain.memo.Memo
import org.threeten.bp.LocalDateTime

class InMemoryMemoDataSource : MemoDataSource {

    private val memoList = mutableListOf<Memo>()

    override fun getMemoList(): List<Memo> {
        return memoList.toList()
    }

    override fun readById(memoId: Long): Memo? {
        return memoList.firstOrNull { it.id == memoId }
    }

    override fun write(
        content: String,
        createdAt: LocalDateTime
    ) {
        val id = (memoList.maxByOrNull { it.id }?.id ?: -1) + 1
        memoList.add(Memo(id, content, createdAt))
    }
}