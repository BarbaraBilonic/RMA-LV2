package barbarabilonic.ferit.inspiringpeople

import kotlin.random.Random

object PeopleRepository {
    private val people= mutableListOf<InspiringPearson>(
        InspiringPearson("Albert Einstein","14 March 1879 – 18 April 1955",
                "Theoretical physicist, widely acknowledged to be one of the greatest physicists of all time.",
                             listOf("We cannot solve our problems with the same thinking we used when we created them.","The true sign of intelligence is not knowledge but imagination."),"https://thumbor.forbes.com/thumbor/fit-in/1200x0/filters%3Aformat%28jpg%29/https%3A%2F%2Fblogs-images.forbes.com%2Frainerzitelmann%2Ffiles%2F2019%2F06%2FE0MG76-e1560965378507-1200x1270.jpg"),

        InspiringPearson("Nikola Tesla","10 July 1856 – 7 January 1943","Inventor, electrical engineer, mechanical engineer, and futurist best known for his contributions to the design of the modern alternating current (AC) electricity supply system.",
                            listOf("Of all things, I liked books best.","One must be sane to think clearly, but one can think deeply and be quite insane."),"https://upload.wikimedia.org/wikipedia/commons/7/79/Tesla_circa_1890.jpeg")
    )

    fun getPeople() : List<InspiringPearson> =people

    fun addPearson(pearson:InspiringPearson){
        people.add(pearson)
    }


}