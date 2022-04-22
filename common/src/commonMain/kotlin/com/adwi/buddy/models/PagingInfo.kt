package com.adwi.buddy.models

data class PagingInfo(
    var count: Int,
    var pages: Int,
    var next: Int?,
    var prev: Int?,
)