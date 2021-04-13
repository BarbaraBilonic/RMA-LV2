package barbarabilonic.ferit.zad2.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import barbarabilonic.ferit.zad2.listeners.EditFragmentOnClickListener
import barbarabilonic.ferit.zad2.persistence.PeopleRepository
import barbarabilonic.ferit.zad2.databinding.EditPearsonFragmentBinding

class EditPearsonFragment(private val index:Int) : Fragment() {
    private lateinit var editPearsonFragmentBinding: EditPearsonFragmentBinding
    private lateinit var editFragmentClickListener: EditFragmentOnClickListener


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        editPearsonFragmentBinding = EditPearsonFragmentBinding.inflate(inflater, container, false)
        setUp()
        editPearsonFragmentBinding.btnDelete.setOnClickListener { editFragmentClickListener.onDeleteButtonClick(
            PeopleRepository.getPearson(index).id) }
        editPearsonFragmentBinding.btnDone.setOnClickListener {
            getChanges()
            editFragmentClickListener.onDoneButtonClick()
        }
        return editPearsonFragmentBinding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is EditFragmentOnClickListener){
            editFragmentClickListener=context
        }
    }
    private fun setUp(){
        val pearson= PeopleRepository.getPearson(index)
        editPearsonFragmentBinding.etPearsonNameEdit.setText(pearson.name)
        editPearsonFragmentBinding.etPearsonDateBirthDeathEdit.setText(pearson.dateBirthDeath)
        editPearsonFragmentBinding.etPearsonDescriptionEdit.setText(pearson.description)
        editPearsonFragmentBinding.etPearsonQuoteEdit1.setText(pearson.getQuote(0))
        editPearsonFragmentBinding.etPearsonQuoteEdit2.setText(pearson.getQuote(1))
        editPearsonFragmentBinding.etPearsonImageURLEdit.setText(pearson.imageUrl)
    }

    private fun getChanges(){
       PeopleRepository.getPearson(index).name=editPearsonFragmentBinding.etPearsonNameEdit.text.toString()
        PeopleRepository.getPearson(index).dateBirthDeath=editPearsonFragmentBinding.etPearsonDateBirthDeathEdit.text.toString()
        PeopleRepository.getPearson(index).description=editPearsonFragmentBinding.etPearsonDescriptionEdit.text.toString()
        PeopleRepository.getPearson(index).quotes= listOf(editPearsonFragmentBinding.etPearsonQuoteEdit1.text.toString(),editPearsonFragmentBinding.etPearsonQuoteEdit2.text.toString())
        PeopleRepository.getPearson(index).imageUrl=editPearsonFragmentBinding.etPearsonImageURLEdit.text.toString()


    }

    companion object {
        const val TAG = "Edit pearson"

    }

}