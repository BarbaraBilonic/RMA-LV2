package barbarabilonic.ferit.zad2.model

import kotlin.random.Random


class InspiringPearson(
    var id:Int,
    var name:String,
    var dateBirthDeath:String,
    var description:String,
     var quotes:List<String>,
    var imageUrl:String) {

    fun getQuote():String{
        return quotes[Random.nextInt(0,1)]
    }
    fun getQuote(index:Int):String{
        return quotes[index]
    }


}