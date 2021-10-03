package com.example.data

import com.example.domain.memo.Memo
import org.threeten.bp.LocalDateTime

interface MemoDataSource {
    fun getMemoList(): List<Memo>
    fun readById(memoId: Long): Memo?
    fun write(content: String, createdAt: LocalDateTime)
}