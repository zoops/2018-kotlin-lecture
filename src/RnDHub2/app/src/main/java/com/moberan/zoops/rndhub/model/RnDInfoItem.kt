package com.moberan.zoops.rndhub.model

data class RnDInfoItem(var title: String,
                       var readCnt: Int = 0,
                       var cat: String = "",
                       var asocicateWord: List<String> = emptyList(),
                       var researcherCnt: Int = 0)