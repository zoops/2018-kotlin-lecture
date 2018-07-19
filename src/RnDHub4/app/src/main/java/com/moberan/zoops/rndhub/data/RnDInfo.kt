package com.moberan.zoops.rndhub.data

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.TypeConverters
import com.moberan.zoops.rndhub.dao.RnDInfoRoom

@Entity(tableName = "TBL_RNDINFO")
data class RnDInfo( var title:String,
                    var readCnt:Int = 0,
                    var cat: String?,
                    @TypeConverters(RnDInfoRoom.Converters::class)
                    var asocicateWord:MutableList<String>?,
                    var researcherCnt:Int = 0,
                    var catIconUrl: String? = "",
                    @PrimaryKey(autoGenerate = true)
                    val _id:Int = -1)

data class RnDInfoRes(  var result: Boolean,
                        var msgCode: String,
                        var message: String,
                        var list : List<RnDInfo>)