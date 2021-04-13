package barbarabilonic.ferit.inspiringpeople.Model

import kotlin.random.Random


class InspiringPearson(
    val name:String,
    val dateBirthDeath:String,
    val description:String,
    private val quotes:List<String>,
    val imageUrl:String) {


    fun getQuote():String{
        return quotes[Random.nextInt(0,1)]
    }

}