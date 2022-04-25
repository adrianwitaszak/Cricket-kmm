package com.adwi.buddy.service

import com.adwi.buddy.backend.repository.user.UserRepository
import com.adwi.buddy.backend.service.UserService
import com.adwi.buddy.models.User
import com.varabyte.truthish.assertThat
import io.mockk.every
import io.mockk.mockk
import org.junit.Before
import org.junit.Test

class UserServiceTest {

    private val userRepository: UserRepository = mockk()
    private val userService: UserService = UserService(userRepository)

    private val userMock = User(
        id = "1",
        email = "test@test.com",
        hashedPass = "password".toByteArray(),
    )

    @Before
    fun setup() {
        every { userRepository.getUserByEmail(userMock.email) } returns userMock
        every { userRepository.getAll() } returns listOf(userMock)
        every { userRepository.getById(userMock.id) } returns userMock
        every { userRepository.add(userMock) } returns userMock
        every { userRepository.delete(userMock.id) } returns true
        every { userRepository.update(userMock) } returns userMock
    }

    @Test
    fun `getUser gets user returns true`() {
        val user = userService.getUserById(userMock.id)
        assertThat(user.id).isEqualTo("1")
    }

    @Test
    fun `updateFavUserCocktails adds cocktail to users fav list`() {
        var user = userService.getUserById(userMock.id)
//        assertThat(user.favoriteCocktails.size).isEqualTo(0)

        userService.addCocktailToFavorites("c1", userMock.id)

        user = userService.getUserById(userMock.id)
//        assertThat(user.favoriteCocktails.size).isEqualTo(1)
    }
}
