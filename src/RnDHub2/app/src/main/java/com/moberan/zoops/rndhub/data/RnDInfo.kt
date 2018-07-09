package com.moberan.zoops.rndhub.data

data class RnDInfo( var title:String,
                    var readCnt:Int,
                    var cat: String,
                    var asocicateWord:List<String>,
                    var researcherCnt:Int)

data class RnDInfoRes(  var result: Boolean,
                        var msgCode: String,
                        var message: String,
                        var list : List<RnDInfo>)