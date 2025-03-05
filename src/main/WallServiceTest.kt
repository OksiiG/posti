import org.junit.Before
import org.junit.jupiter.api.Assertions.assertTrue
import ru.netology.*
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertNotEquals

class WallServiceTest {
    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun updateTrue() {
        // создаём целевой сервис
        val service = ru.netology.WallService
        // заполняем несколькими постами
        service.add(
            Post(
                1,
                2222,
                "text post",
                comments = Comments(0, true, false),
                like = Likes(0),
                repost = Repost(1, true),
                canEdit = true,
                canDelete = true
            )
        )
        service.add(
            Post(
                2,
                2222,
                "text post new",
                comments = Comments(1, true, false),
                like = Likes(1),
                repost = Repost(0, false),
                canEdit = true,
                canDelete = true
            )
        )
        service.add(
            Post(
                3,
                2222,
                "text post №3",
                comments = Comments(3, true, false),
                like = Likes(10),
                repost = Repost(11, true),
                canEdit = true,
                canDelete = true
            )
        )
        // создаём информацию об обновлении
        val update = Post(
            1,
            2222,
            "update text post",
            comments = Comments(0, true, false),
            like = Likes(0),
            repost = Repost(1, true),
            canEdit = true,
            canDelete = true
        )

        // выполняем целевое действие
        val result = service.update(update)

        // проверяем результат (используйте assertTrue или assertFalse)
        assertTrue(result)
    }

    @Test
    fun updateFalse() {
        // создаём целевой сервис
        val service = ru.netology.WallService
        // заполняем несколькими постами
        service.add(
            Post(
                1,
                2222,
                "text post",
                comments = Comments(0, true, false),
                like = Likes(0),
                repost = Repost(1, true),
                canEdit = true,
                canDelete = true
            )
        )
        service.add(
            Post(
                2,
                2222,
                "text post new",
                comments = Comments(1, true, false),
                like = Likes(1),
                repost = Repost(0, false),
                canEdit = true,
                canDelete = true
            )
        )
        service.add(
            Post(
                3,
                2222,
                "text post №3",
                comments = Comments(3, true, false),
                like = Likes(10),
                repost = Repost(11, true),
                canEdit = true,
                canDelete = true
            )
        )
        // создаём информацию об обновлении
        val update = Post(
            11,
            2222,
            "update text post",
            comments = Comments(0, true, false),
            like = Likes(0),
            repost = Repost(1, true),
            canEdit = true,
            canDelete = true
        )

        // выполняем целевое действие
        val result = service.update(update)

        // проверяем результат (используйте assertTrue или assertFalse)
        assertFalse(result)
    }

    @Test
    fun addPost() {
        val service = WallService

        val result = service.add(
            Post(
                1,
                2222,
                "post add",
                comments = Comments(1, true, false),
                like = Likes(1),
                repost = Repost(0, false),
                canEdit = true,
                canDelete = true
            )
        )
        assertNotEquals(0, result.id)
    }


}