package com.moberan.zoops.rndhub.model.Response

import com.moberan.zoops.rndhub.model.RnDInfoItem

data class RnDInfoRes(  var result:Boolean,
                        var msgCode: String,
                        var message: String = "",
                        var list: List<RnDInfoItem>)