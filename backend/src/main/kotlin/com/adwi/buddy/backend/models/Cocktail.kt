package com.adwi.buddy.backend.models

data class Cocktail(
    val id: Int,
    val name: String,
    val rating: MutableList<Int>,
    val description: String,
    val ingredients: List<Ingredient> = emptyList(),
) {
    fun totalRating(): Double {
        return rating.average()
    }
}

data class Ingredient(
    val name: String,
)

val cocktails = listOf(
    Cocktail(
        id = 1,
        name = "FROZEN BANANADAIQUIRI",
        rating = mutableListOf(5),
        description = """
            Mix these with a wild and crazy tropical shirt and let it all
            hang out at the next company picnic.
            1. Pour ingredients in blender.
            2. Blend until smooth.
            3. Pour into oversized wine glass.
            4. Garnish with lime wedge.
        """.trimIndent(),
        ingredients = listOf(
            Ingredient("11/2ounces light rum"),
            Ingredient("1/2 ounce lime juice"),
            Ingredient("1 ounce banana liqueur"),
            Ingredient("1/4 sliced banana"),
            Ingredient("1 teaspoon sugar"),
            Ingredient("1/2 ounce cream"),
            Ingredient("1/2 cup crushed ice"),
        )
    ),
    Cocktail(
        id = 2,
        name = "Hulla Balloo",
        rating = mutableListOf(5),
        description = """
            Created by the other founding father of Bramble, Jas Scott. Combining banana
with a spirit called Monkey Shoulder is more than just a clever association
(monkeys like bananas, in case you didn’t pick that up)—the fruit, spiced with
cinnamon, also delivers a happy harmony with the smooth and sweet blended
whisky.
Shake all the ingredients hard with ice. Double strain into a glass and garnish
with 3 banana slices.
Banana and cinnamon purée
Blend 1 ripe banana with 2 pinches of cinnamon (or thereabouts, to taste) and
1fl oz/25ml of water. Don’t over-blend, as this will make a gluey consistency.
Store in the refrigerator for up to 1 week.
Today whisky is a truly global spirit enjoyed by imbibers across the world, not
least those in South America, and in many countries it is now the number one
spirit import. Juliàn Díaz is owner of the 878 bar in Buenos Aires and at the
forefront of pioneering cocktails in the city. While the bar doesn’t focus solely
on the Scottish spirit, its customers’ desire for whisky has seen the team work to
find new approaches to its use in mixed drinks.
878 has been open more than seven years. I started it
with Flor, my wife, and we wanted to recover the speakeasy
spirit, blending classic cocktails and the Argentinean-Italian
tradition of vermouth, food, and wines.
Argentina has a rich blend of drinking cultures and at the
beginning of the 20th century the people who traveled here
came with different traditions. From Spain, Italy, and
France we had the introduction of vermouth, wine, spirits,
bitters, and this set trends for cocktails.
The wine is probably our most important product, and that
encourages tourists but when they arrive they also discover
our cocktails. Meanwhile domestically we love whisky. What
is sometimes challenging for younger drinkers though is the
price of a good one!
When I’m suggesting how people should use whisky in
drinks I always encourage them to only use the highest
quality fresh fruits or liquors. You need to use malts such as
Islays very carefully because of their intensity.
Thames 878, CP 1414, Buenos Aires, Argentina
Here is a selection of whisky drinks created by the bar team at 878.
www.878bar.com.ar
        """.trimIndent(),
        ingredients = listOf(
            Ingredient("MARTINI"),
            Ingredient("1 3/4fl oz/50ml Monkey Shoulder whisky"),
            Ingredient("2 1/2 tsp lime juice"),
            Ingredient("1fl oz/25ml fresh banana and cinnamon puree"),
            Ingredient("2 1/2 tsp vanilla simple syrup"),
            Ingredient("ice cubes"),
            Ingredient("3 BANANA SLICES"),
        )
    ),
    Cocktail(
        id = 3,
        name = "JOHNNY WEISMULLER",
        rating = mutableListOf(4),
        description = """
            Me Tarzan.You Jane.Want drink?
            1.Fill cocktail shaker with ice.
            2.Add gin, rum, lemon juice, grenadine, and pow-
            dered sugar.
            3.Shake.
            4.Strain into a cocktail glass.
        """.trimIndent(),
        ingredients = listOf(
            Ingredient("1 1/2 ounces gin"),
            Ingredient("1 1/2 ounces Bacardi rum"),
            Ingredient("1 1/2 ounces lemon juice"),
            Ingredient("Dash of grenadine"),
            Ingredient("1/2 teaspoon powdered sugar"),
        )
    ),
    Cocktail(
        id = 4,
        name = "Mad Hatter",
        rating = mutableListOf(3),
        description = """
            If Lewis Carroll was drinking this while writing, it
            explains everything.
            1. Fill a cocktail mixer with ice.
            2.Add vodka, peach schnapps, lemonade, and cola.
            3.Shake.
            4.Strain into a shot glass.
        """.trimIndent(),
        ingredients = listOf(
            Ingredient("1 ounce vodka"),
            Ingredient("1 ounce peach schnapps"),
            Ingredient("1 ounce lemonade"),
            Ingredient("1 ounce cola"),
        )
    )
)
