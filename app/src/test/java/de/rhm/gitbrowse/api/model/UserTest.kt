package de.rhm.gitbrowse.api.model

import com.squareup.moshi.Moshi
import de.rhm.gitbrowse.AppModule
import junit.framework.Assert
import org.junit.Before
import org.junit.Test
import org.koin.standalone.StandAloneContext
import org.koin.standalone.inject
import org.koin.test.AutoCloseKoinTest

private const val JSON_RESPONSE = """
{
        "login": "cdibona",
        "id": 165353,
        "node_id": "MDQ6VXNlcjE2NTM1Mw==",
        "avatar_url": "https://avatars1.githubusercontent.com/u/165353?v=4",
        "gravatar_id": "",
        "url": "https://api.github.com/users/cdibona",
        "html_url": "https://github.com/cdibona",
        "followers_url": "https://api.github.com/users/cdibona/followers",
        "following_url": "https://api.github.com/users/cdibona/following{/other_user}",
        "gists_url": "https://api.github.com/users/cdibona/gists{/gist_id}",
        "starred_url": "https://api.github.com/users/cdibona/starred{/owner}{/repo}",
        "subscriptions_url": "https://api.github.com/users/cdibona/subscriptions",
        "organizations_url": "https://api.github.com/users/cdibona/orgs",
        "repos_url": "https://api.github.com/users/cdibona/repos",
        "events_url": "https://api.github.com/users/cdibona/events{/privacy}",
        "received_events_url": "https://api.github.com/users/cdibona/received_events",
        "type": "User",
        "site_admin": false
}
"""

class UserTest : AutoCloseKoinTest() {

    val moshi: Moshi by inject()

    @Before
    fun before() {
        StandAloneContext.startKoin(listOf(AppModule))
    }

    @Test
    fun parse() = moshi.adapter(User::class.java).fromJson(JSON_RESPONSE)!!.run {
        Assert.assertEquals("cdibona", login)
    }

}