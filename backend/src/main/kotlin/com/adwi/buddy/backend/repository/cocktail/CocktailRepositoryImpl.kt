package com.adwi.buddy.backend.repository.cocktail

import com.adwi.buddy.backend.repository.user.DATABASE_NAME
import com.adwi.buddy.models.Cocktail
import com.adwi.buddy.models.CocktailsPage
import com.adwi.buddy.models.PagingInfo
import com.adwi.buddy.models.User
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoCollection
import org.litote.kmongo.getCollection
import java.util.*

class CocktailRepositoryImpl(client: MongoClient) : CocktailRepository {

    override lateinit var col: MongoCollection<Cocktail>

    init {
        val database = client.getDatabase(DATABASE_NAME)
        col = database.getCollection()
    }

    override fun getAllPaged(page: Int, size: Int): CocktailsPage {
        try {
            val skips = page * size
            val cocktails = col.find().skip(skips).limit(size)
            val results = cocktails.asIterable().map { it }
            val totalCocktails = col.countDocuments()
            val totalPages = (totalCocktails / size) + 1
            val next = if (results.isNotEmpty()) page + 1 else null
            val prev = if (page > 0) page - 1 else null
            val info = PagingInfo(totalCocktails.toInt(), totalPages.toInt(), next, prev)
            return CocktailsPage(results, info)
        } catch (t: Throwable) {
            throw Exception("Cannot get cocktails paged")
        }
    }

    override fun getUserCocktails(user: User): List<Cocktail> {
        return try {
            val cocktailIds = user.favoriteCocktails
            cocktailIds.map { id ->
                getById(id)
            }
        } catch (e: Exception) {
            throw Exception("Cannot get cocktails")
        }
    }
}

val cocktails = listOf(
    Cocktail(
        id = UUID.randomUUID().toString(),
        name = "Frozen Bananadaiquiri",
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
            "11/2ounces light rum",
            "1/2 ounce lime juice",
            "1 ounce banana liqueur",
            "1/4 sliced banana",
            "1 teaspoon sugar",
            "1/2 ounce cream",
            "1/2 cup crushed ice",
        )
    ),
    Cocktail(
        id = UUID.randomUUID().toString(),
        name = "Hulla Balloo",
        rating = mutableListOf(5),
        description = """
            Created by the other founding father of Bramble, Jas Scott. Combining banana
with a spirit called Monkey Shoulder is more than just a clever association
(monkeys like bananas, in case you didn???t pick that up)???the fruit, spiced with
cinnamon, also delivers a happy harmony with the smooth and sweet blended
whisky.
Shake all the ingredients hard with ice. Double strain into a glass and garnish
with 3 banana slices.
Banana and cinnamon pur??e
Blend 1 ripe banana with 2 pinches of cinnamon (or thereabouts, to taste) and
1fl oz/25ml of water. Don???t over-blend, as this will make a gluey consistency.
Store in the refrigerator for up to 1 week.
Today whisky is a truly global spirit enjoyed by imbibers across the world, not
least those in South America, and in many countries it is now the number one
spirit import. Juli??n D??az is owner of the 878 bar in Buenos Aires and at the
forefront of pioneering cocktails in the city. While the bar doesn???t focus solely
on the Scottish spirit, its customers??? desire for whisky has seen the team work to
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
When I???m suggesting how people should use whisky in
drinks I always encourage them to only use the highest
quality fresh fruits or liquors. You need to use malts such as
Islays very carefully because of their intensity.
Thames 878, CP 1414, Buenos Aires, Argentina
Here is a selection of whisky drinks created by the bar team at 878.
www.878bar.com.ar
        """.trimIndent(),
        ingredients = listOf(
            "Martini",
            "1 3/4fl oz/50ml Monkey Shoulder whisky",
            "2 1/2 tsp lime juice",
            "1fl oz/25ml fresh banana and cinnamon puree",
            "2 1/2 tsp vanilla simple syrup",
            "ice cubes",
            "3 BANANA SLICES",
        )
    ),
    Cocktail(
        id = UUID.randomUUID().toString(),
        name = "Johny Weismuller",
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
            "1 1/2 ounces gin",
            "1 1/2 ounces Bacardi rum",
            "1 1/2 ounces lemon juice",
            "Dash of grenadine",
            "1/2 teaspoon powdered sugar",
        )
    ),
    Cocktail(
        id = UUID.randomUUID().toString(),
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
            "1 ounce vodka",
            "1 ounce peach schnapps",
            "1 ounce lemonade",
            "1 ounce cola",
        )
    )
)
