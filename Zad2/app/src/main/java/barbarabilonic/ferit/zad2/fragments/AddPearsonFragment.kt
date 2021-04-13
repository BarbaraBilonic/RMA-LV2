package barbarabilonic.ferit.zad2.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import barbarabilonic.ferit.zad2.model.InspiringPearson
import barbarabilonic.ferit.zad2.listeners.OnPearsonSaveClickListener
import barbarabilonic.ferit.zad2.persistence.PeopleRepository
import barbarabilonic.ferit.zad2.databinding.FragmentAddPearsonBinding

class AddPearsonFragment : Fragment() {
    private lateinit var addPearsonBinding : FragmentAddPearsonBinding
    private lateinit var onPearsonSaveClick: OnPearsonSaveClickListener
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        addPearsonBinding = FragmentAddPearsonBinding.inflate(inflater, container, false)
        addPearsonBinding.btnNewPearsonSave.setOnClickListener{
            savePearson()
            onPearsonSaveClick.onPearsonSave()

        }
        return addPearsonBinding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is OnPearsonSaveClickListener){
            onPearsonSaveClick = context
        }
    }

    private fun savePearson(){
       val id= PeopleRepository.getNextId()
        val name=addPearsonBinding.etPearsonNameInput.text.toString()
        val date=addPearsonBinding.etPearsonDateBirthDeathInput.text.toString()
        val description=addPearsonBinding.etPearsonDescriptionInput.text.toString()
        val quotes=listOf(addPearsonBinding.etPearsonQuoteInput1.text.toString(),addPearsonBinding.etPearsonQuoteInput2.text.toString())
        val imageURL=addPearsonBinding.etPearsonImageURLInput.text.toString()
        val inspiringPearson= InspiringPearson(
            id,
            name,
            date,
            description,
            quotes,
            imageURL
        )
        PeopleRepository.addPearson(inspiringPearson)


    }



    companion object {
        const val TAG = "Add Pearson"
        fun create(): AddPearsonFragment {
            return AddPearsonFragment()
        }
    }
}