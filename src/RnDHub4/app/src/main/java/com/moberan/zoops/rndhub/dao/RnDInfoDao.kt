package com.moberan.zoops.rndhub.dao

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.moberan.zoops.rndhub.data.RnDInfo

const val DATABASENAME =  "rndinfodb"
const val TABLENAME = "TBL_RNDINFO"
const val DATABASEVER = 2

class RnDInfoDao private constructor(ctx:Context): SQLiteOpenHelper(ctx, DATABASENAME, null, DATABASEVER) {

    val CREATE_TABLE_QUERY = "CREATE TABLE TBL_RNDINFO(_id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, readCnt INTEGER, cat TEXT, asocicateWord TEXT, researcherCnt INTEGER, catIconUrl TEXT)"
    val DROP_TABLE_QUERY = "DROP TABLE IF EXISTS TBL_RNDINFO"
    val SELECT_QUERY = "SELECT _id, title, readCnt, cat, asocicateWord, researcherCnt, catIconUrl FROM TBL_RNDINFO"

    var mGson = Gson()

    override fun onCreate(db: SQLiteDatabase?) {
        // 데이터 베이스가 생성되면 호출되는 이벤트
        // 보통 테이블을 생성한다.
        println("RnDInfoDao onCreate")

        db?.execSQL(CREATE_TABLE_QUERY)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // 데이터 베이스 버전이 올라가면 호출되는 이벤트
        // 보통 기존 테이블을 DROP(삭제) 하고 버전에 맞는 새로운 테이블을 생성한다.
        // 기존 테이블을 삭제하기 전에 새로운 테이블로 데이터를 옮길 수도 있다.
        println("RnDInfoDao onUpgrade : $oldVersion, $newVersion")

        db?.execSQL(DROP_TABLE_QUERY)
        onCreate(db)
    }

    fun insertRndInfo(info : RnDInfo) : Long {

        var data = ContentValues()
        data.put("title", info.title)
        data.put("readCnt", info.readCnt)
        data.put("cat", info.cat)
        data.put("asocicateWord", mGson.toJson(info.asocicateWord?.toTypedArray()))
        data.put("researcherCnt", info.researcherCnt)
        data.put("catIconUrl", info.catIconUrl)

        return writableDatabase.insert(TABLENAME, null, data)
    }

    fun getRndInfos(): MutableList<RnDInfo> {
        var infos: MutableList<RnDInfo> = mutableListOf()

        val cursor = readableDatabase.rawQuery(SELECT_QUERY, null)
        while (cursor.moveToNext()) {
            infos.add(RnDInfo(
                    cursor.getString(1)?:"",
                    cursor.getInt(2),
                    cursor.getString(3)?:"",
                    mGson.fromJson(cursor.getString(4)?:"[]", object:TypeToken<List<String>>(){}.type),
                    cursor.getInt(5),
                    cursor.getString(6)?:"",
                    cursor.getInt(0)
                    ))
        }
        return infos
    }

    fun  getReadableDB(): SQLiteDatabase {
        return readableDatabase
    }

    fun dbClose() {
        close()
    }

    companion object {
        @JvmStatic
        var mDao: RnDInfoDao? = null

        fun newInstance(ctx:Context): RnDInfoDao {
            if (mDao == null)
                mDao = RnDInfoDao(ctx)

            return mDao!!
        }
    }
}