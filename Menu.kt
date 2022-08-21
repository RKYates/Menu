import kotlin.random.Random

fun main(args: Array<String>) {
    val meals = Array(7) {""}
    // get number of days to eat out meals
    var numOutDays = 1
    if (args.isNotEmpty()) {
        numOutDays = args[0].toIntOrNull() ?: 1
    }
    val outDays = getOutDays(numOutDays)

    // for each of 7 days...
    for (i in meals.indices) {
        // determine if today should be an out meal
        if (i in outDays) {
            // if out meal, choose randomly from out meal list and remove it from the list
            val n = Random.nextInt(outMeals.size)
            meals[i] = outMeals[n]
            outMeals.removeAt(n)
        } else {
            // else choose randomly from in meals and remove it from the list
            var n: Int
            do {
                n = Random.nextInt(homeMeals.size)
            } while (homeMeals[n].needsTime && days[i] in daysWithLowTime)
            meals[i] = homeMeals[n].name
            homeMeals.removeAt(n)
        }

    }
    // print out list
    println("Meals:")
    for (i in meals.indices) {
        println("${days[i]}: ${meals[i]}")
    }
}

val homeMeals = mutableListOf(
    Meal("Soup & Salad", false),
    Meal("Mr. Dave's Chicken + Broccoli", true),
    Meal("Salmon & Nugs + Broccoli", false),
    Meal("Italian Subs", false),
    Meal("Jambo", false),
    Meal("Pasta w/sauce + meatballs + green beans", false),
    Meal("Breadcrumb Pasta + green beans", false),
    Meal("Black Bean Burgers + Brussels Sprouts", false),
    Meal("Homemade Pizza", true),
    Meal("Breakfast for dinner", true),
    Meal("BLTs", false),
    Meal("Taco Salad", true),
    Meal("Vegetable stir-fry", false),
    Meal("Chickpea broccoli casserole", false),
    Meal("Enchiladas", false),
    Meal("Spinach Lasagna", false),
    Meal("Chicken caesar salad", false),
    Meal("Roasted chicken & veggies",true),
    Meal("Chana Masala", false),
    Meal("Chili & cornbread", false),
    Meal("BBQ Chicken & broccoli", true),
    Meal("Chicken quesadilla", false),
    Meal("Caprese pasta", false),
    Meal("Pesto pasta", false),
    Meal("Cilantro chicken", true),
    Meal("Burgers/hot dogs and tots",true),
    Meal("Grilled chicken + baked beans", true),
    Meal("Polish night", true),
    Meal("Eggplant", false),
    Meal("homemade pasta", true)
)

val outMeals = mutableListOf(
    "Jersey Mike's",
    "Breakaway",
    "Crispelli's",
    "Mediterranean",
    "Thai",
    "Indian",
    "Noni's",
    "Chinese",
    "Camp Ticonderoga",
    "Brewpub",
    "Polish cultural center"
)

val days = listOf(
    "Sunday",
    "Monday",
    "Tuesday",
    "Wednesday",
    "Thursday",
    "Friday",
    "Saturday"
)

val daysWithLowTime = listOf(
    "Tuesday",
    "Wednesday",
    "Thursday"
)

class Meal(val name: String, val needsTime: Boolean)

fun getOutDays(numOutMeals: Int): List<Int> {
    var n = numOutMeals
    val outDays = mutableListOf<Int>()
    while (n > 0) {
        val day = Random.nextInt(7)
        if (!daysWithLowTime.contains(days[day])) { // not in exclusion list
            outDays.add(day)
            n--
        }
    }
    return outDays
}