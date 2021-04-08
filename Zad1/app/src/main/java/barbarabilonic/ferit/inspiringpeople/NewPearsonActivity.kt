package barbarabilonic.ferit.inspiringpeople

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import barbarabilonic.ferit.inspiringpeople.databinding.ActivityAddPearsonBinding

class NewPearsonActivity : AppCompatActivity() {

    private lateinit var newPearsonBinding : ActivityAddPearsonBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        newPearsonBinding= ActivityAddPearsonBinding.inflate(layoutInflater)
        newPearsonBinding.btnNewPearsonSave.setOnClickListener{saveNote()}
        setContentView(newPearsonBinding.root)
    }

    private fun saveNote(){
        val name=newPearsonBinding.etPearsonNameInput.text.toString()
        val date=newPearsonBinding.etPearsonDateBirthDeathInput.text.toString()
        val description=newPearsonBinding.etPearsonDescriptionInput.text.toString()
        val quote=newPearsonBinding.etPearsonQuoteInput.text.toString()
        val imageURL=newPearsonBinding.etPearsonImageURLInput.text.toString()
        val inspiringPearson=InspiringPearson(name,date,description,listOf(quote),imageURL)
        PeopleRepository.addPearson(inspiringPearson)
        finish()
    }
}