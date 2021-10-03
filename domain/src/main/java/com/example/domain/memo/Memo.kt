package com.example.domain.memo

import org.threeten.bp.LocalDateTime

data class Memo(val id: Long, val content: String, val createdAt: LocalDateTime)