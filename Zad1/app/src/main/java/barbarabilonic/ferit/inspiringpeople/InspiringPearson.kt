package barbarabilonic.ferit.inspiringpeople

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import kotlin.random.Random

class InspiringPearson(
    val name:String,
    val dateBirthDeath:String,
    val description:String,
    val quotes:List<String>,
    val imageUrl:String) {


    fun getQuote():String{
        val quoteIndex= Random.nextInt(0, quotes.count()-1)
        return quotes[quoteIndex]


    }

}