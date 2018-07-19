package com.moberan.zoops.rndhub.dao

import android.arch.persistence.room.*
import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.moberan.zoops.rndhub.data.RnDInfo


class RnDInfoRoom {

    @Database(entities = arrayOf(RnDInfo::class), version = 2, exportSchema = false)
    @TypeConverters(Converters::class)
    abstract class RnDInfoDatabase : RoomDatabase() {
        abstract fun rndInfoRoomDao() : RndInfoRoomDao
    }

    @Dao
    interface RndInfoRoomDao {

        @Query("SELECT _id, title, readCnt, cat, asocicateWord, researcherCnt, catIconUrl FROM TBL_RNDINFO")
        fun getRndInfos(): List<RnDInfo>

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        fun insertRndInfo(info: RnDInfo)

        @Update
        fun update(info: RnDInfo)

        @Delete
        fun delete(info: RnDInfo)
    }

    class Converters {
        var mGson = Gson()

        @TypeConverter
        fun fromString(v: String?): MutableList<String> {
            return mGson.fromJson(v?:"[]", object: TypeToken<MutableList<String>>(){}.type)
        }

        @TypeConverter
        fun ListToString(l: MutableList<String>?): String? {
            return mGson.toJson(l?.toTypedArray())
        }
    }

    companion object {
        var database: RnDInfoDatabase? = null
        fun getInstance(ctx:Context? = null): RnDInfoDatabase {
            if (database == null && ctx != null) {
                database = Room.databaseBuilder<RnDInfoDatabase>(
                        ctx!!,
                        RnDInfoDatabase::class.java,
                        "rndinfodb-room-db"
                ).fallbackToDestructiveMigration().build()
            }
            return database!!
        }
    }
}

