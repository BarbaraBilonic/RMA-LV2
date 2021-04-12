package barbarabilonic.ferit.zad2.persistence

import barbarabilonic.ferit.zad2.model.InspiringPearson

object PeopleRepository {
    private val people= mutableListOf<InspiringPearson>(
        InspiringPearson(
            1,
            "Albert Einstein",
            "14 March 1879 – 18 April 1955",
            "Theoretical physicist, widely acknowledged to be one of the greatest physicists of all time.",
            "We cannot solve our problems with the same thinking we used when we created them.",
            "https://upload.wikimedia.org/wikipedia/commons/8/8f/Albert_Einstein_Head_%28cropped%29.jpg"
        ),

        InspiringPearson(
            2,
            "Nikola Tesla",
            "10 July 1856 – 7 January 1943",
            "Inventor, electrical engineer, mechanical engineer, and futurist best known for his contributions to the design of the modern alternating current (AC) electricity supply system.",
            "One must be sane to think clearly, but one can think deeply and be quite insane.",
            "https://upload.wikimedia.org/wikipedia/commons/7/79/Tesla_circa_1890.jpeg"
        )
    )

    fun getPeople() : List<InspiringPearson> =
        people

    fun addPearson(pearson: InspiringPearson){
        people.add(pearson)
    }

    fun getPearson(index:Int): InspiringPearson {
        return people[index]
    }

    fun getNextId():Int{

        return people[people.count()-1].id+1
    }

    fun removePearson(id:Int){
        val pearson=
            people.find { it.id==id }
        people.remove(pearson)
    }


}