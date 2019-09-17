package com.sun.newlanguage.bean

/**
 * {"code":1,"msg":[{"id":"5d20a722c200571242cb8471","userId":"18555556688","name":"帕吉","gender":1,"date":"2010-01-01","type":0,"gameType":[{"type":1010,"price":5},{"type":1000,"price":5},{"type":1011,"price":10}],"price":0,"gold":98539.0,"gameZone":0,"sign":"一起大保健","url":"http://39.100.96.9:7070/peipeiImg/icon/576bb550618fd2ac9ba19de15451c6f5","inviteCode":"98PQ2YA","inviteFlag":1,"favor":2,"interest":"大保健","profession":"身体是革命的本钱，保持健康乐观。","applyName":"特朗普","applyIdentity":"340521199808091345","applyPhone":18555556688,"applyAccount":"啊啊啊","otherGame":"大保健","localX":31.241941,"localY":121.671253,"address":"上海","isShowLbs":1,"userName":"sun","userNameUpset":1,"evaluateNum":7,"evaluateSum":54,"evaluateTotal":378,"favorList":[],"favorListSize":0}]}
 */

data class KotlinBean(
    var code: Int,
    var msg: List<Msg>
)

data class Msg(
    var address: String,
    var applyAccount: String,
    var applyIdentity: String,
    var applyName: String,
    var applyPhone: Long,
    var date: String,
    var evaluateNum: Int,
    var evaluateSum: Int,
    var evaluateTotal: Int,
    var favor: Int,
    var favorList: List<Any>,
    var favorListSize: Int,
    var gameType: List<GameType>,
    var gameZone: Int,
    var gender: Int,
    var gold: Double,
    var id: String,
    var interest: String,
    var inviteCode: String,
    var inviteFlag: Int,
    var isShowLbs: Int,
    var localX: Double,
    var localY: Double,
    var name: String,
    var otherGame: String,
    var price: Int,
    var profession: String,
    var sign: String,
    var type: Int,
    var url: String,
    var userId: String,
    var userName: String,
    var userNameUpset: Int
)

data class GameType(
    var price: Int,
    var type: Int
)