package barbarabilonic.ferit.inspiringpeople.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import barbarabilonic.ferit.inspiringpeople.Model.InspiringPearson
import barbarabilonic.ferit.inspiringpeople.Persistence.PeopleRepository
import barbarabilonic.ferit.inspiringpeople.databinding.ActivityAddPearsonBinding

class NewPearsonActivity : AppCompatActivity() {

    private lateinit var newPearsonBinding : ActivityAddPearsonBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        newPearsonBinding= ActivityAddPearsonBinding.inflate(layoutInflater)
        newPearsonBinding.btnNewPearsonSave.setOnClickListener{savePearson()}
        setContentView(newPearsonBinding.root)
    }

    private fun savePearson(){
        val name=newPearsonBinding.etPearsonNameInput.text.toString()
        val date=newPearsonBinding.etPearsonDateBirthDeathInput.text.toString()
        val description=newPearsonBinding.etPearsonDescriptionInput.text.toString()
        val quotes=listOf(newPearsonBinding.etPearsonQuoteInput1.text.toString(),newPearsonBinding.etPearsonQuoteInput2.text.toString())
        val imageURL=newPearsonBinding.etPearsonImageURLInput.text.toString()
        val inspiringPearson= InspiringPearson(name, date, description, quotes, imageURL)
        PeopleRepository.addPearson(inspiringPearson)
        finish()
    }
}