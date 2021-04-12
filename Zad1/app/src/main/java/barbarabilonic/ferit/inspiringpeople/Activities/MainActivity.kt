package barbarabilonic.ferit.inspiringpeople.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import barbarabilonic.ferit.inspiringpeople.Listeners.OnImageClickListener
import barbarabilonic.ferit.inspiringpeople.Adapters.PeopleAdapter
import barbarabilonic.ferit.inspiringpeople.Persistence.PeopleRepository
import barbarabilonic.ferit.inspiringpeople.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() , OnImageClickListener {

    private lateinit var mainBinding: ActivityMainBinding

   private lateinit var onImageClickListener: OnImageClickListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding= ActivityMainBinding.inflate(layoutInflater)
        mainBinding.fabAddPearson.setOnClickListener{createNewPearson()}
        onImageClickListener=this@MainActivity
        setupRecyclerView()


        setContentView(mainBinding.root)

    }
     private fun createNewPearson(){
         val newPearsonIntent=Intent(this, NewPearsonActivity::class.java)
         startActivity(newPearsonIntent)
     }
    private fun setupRecyclerView(){
        mainBinding.rvPeople.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        mainBinding.rvPeople.adapter = PeopleAdapter(PeopleRepository.getPeople(), onImageClickListener)
    }

    override fun onResume() {
        super.onResume()
        (mainBinding.rvPeople.adapter as PeopleAdapter).refreshData(PeopleRepository.getPeople())
    }





    override fun onImageClick(quote:String) {
       Toast.makeText(this@MainActivity,quote,Toast.LENGTH_LONG).show()
    }


}



