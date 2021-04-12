package barbarabilonic.ferit.inspiringpeople.Persistence

import barbarabilonic.ferit.inspiringpeople.Model.InspiringPearson

object PeopleRepository {
    private val people= mutableListOf<InspiringPearson>(
            InspiringPearson("Albert Einstein", "14 March 1879 – 18 April 1955",
                    "Theoretical physicist, widely acknowledged to be one of the greatest physicists of all time.",
                     "The true sign of intelligence is not knowledge but imagination.", "https://upload.wikimedia.org/wikipedia/commons/8/8f/Albert_Einstein_Head_%28cropped%29.jpg"),

            InspiringPearson("Nikola Tesla", "10 July 1856 – 7 January 1943", "Inventor, electrical engineer, mechanical engineer, and futurist best known for his contributions to the design of the modern alternating current (AC) electricity supply system.",
                    "One must be sane to think clearly, but one can think deeply and be quite insane.", "https://upload.wikimedia.org/wikipedia/commons/7/79/Tesla_circa_1890.jpeg")
    )

    fun getPeople() : List<InspiringPearson> = people

    fun addPearson(pearson: InspiringPearson){
        people.add(pearson)
    }


}