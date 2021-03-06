package de.rhm.gitbrowse.api.model

import com.squareup.moshi.Moshi
import de.rhm.gitbrowse.AppModule
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.koin.standalone.StandAloneContext.startKoin
import org.koin.standalone.inject
import org.koin.test.AutoCloseKoinTest

private const val JSON_RESPONSE = """
{
    "id": 93152223,
    "node_id": "MDEwOlJlcG9zaXRvcnk5MzE1MjIyMw==",
    "name": "SmartRefreshLayout",
    "full_name": "scwang90/SmartRefreshLayout",
    "owner": {
        "login": "scwang90",
        "id": 11567071,
        "node_id": "MDQ6VXNlcjExNTY3MDcx",
        "avatar_url": "https://avatars0.githubusercontent.com/u/11567071?v=4",
        "gravatar_id": "",
        "url": "https://api.github.com/users/scwang90",
        "html_url": "https://github.com/scwang90",
        "followers_url": "https://api.github.com/users/scwang90/followers",
        "following_url": "https://api.github.com/users/scwang90/following{/other_user}",
        "gists_url": "https://api.github.com/users/scwang90/gists{/gist_id}",
        "starred_url": "https://api.github.com/users/scwang90/starred{/owner}{/repo}",
        "subscriptions_url": "https://api.github.com/users/scwang90/subscriptions",
        "organizations_url": "https://api.github.com/users/scwang90/orgs",
        "repos_url": "https://api.github.com/users/scwang90/repos",
        "events_url": "https://api.github.com/users/scwang90/events{/privacy}",
        "received_events_url": "https://api.github.com/users/scwang90/received_events",
        "type": "User",
        "site_admin": false
    },
    "private": false,
    "html_url": "https://github.com/scwang90/SmartRefreshLayout",
    "description": "🔥下拉刷新、上拉加载、二级刷新、淘宝二楼、RefreshLayout、OverScroll，Android智能下拉刷新框架，支持越界回弹、越界拖动，具有极强的扩展性，集成了几十种炫酷的Header和 Footer。",
    "fork": false,
    "url": "https://api.github.com/repos/scwang90/SmartRefreshLayout",
    "forks_url": "https://api.github.com/repos/scwang90/SmartRefreshLayout/forks",
    "keys_url": "https://api.github.com/repos/scwang90/SmartRefreshLayout/keys{/key_id}",
    "collaborators_url": "https://api.github.com/repos/scwang90/SmartRefreshLayout/collaborators{/collaborator}",
    "teams_url": "https://api.github.com/repos/scwang90/SmartRefreshLayout/teams",
    "hooks_url": "https://api.github.com/repos/scwang90/SmartRefreshLayout/hooks",
    "issue_events_url": "https://api.github.com/repos/scwang90/SmartRefreshLayout/issues/events{/number}",
    "events_url": "https://api.github.com/repos/scwang90/SmartRefreshLayout/events",
    "assignees_url": "https://api.github.com/repos/scwang90/SmartRefreshLayout/assignees{/user}",
    "branches_url": "https://api.github.com/repos/scwang90/SmartRefreshLayout/branches{/branch}",
    "tags_url": "https://api.github.com/repos/scwang90/SmartRefreshLayout/tags",
    "blobs_url": "https://api.github.com/repos/scwang90/SmartRefreshLayout/git/blobs{/sha}",
    "git_tags_url": "https://api.github.com/repos/scwang90/SmartRefreshLayout/git/tags{/sha}",
    "git_refs_url": "https://api.github.com/repos/scwang90/SmartRefreshLayout/git/refs{/sha}",
    "trees_url": "https://api.github.com/repos/scwang90/SmartRefreshLayout/git/trees{/sha}",
    "statuses_url": "https://api.github.com/repos/scwang90/SmartRefreshLayout/statuses/{sha}",
    "languages_url": "https://api.github.com/repos/scwang90/SmartRefreshLayout/languages",
    "stargazers_url": "https://api.github.com/repos/scwang90/SmartRefreshLayout/stargazers",
    "contributors_url": "https://api.github.com/repos/scwang90/SmartRefreshLayout/contributors",
    "subscribers_url": "https://api.github.com/repos/scwang90/SmartRefreshLayout/subscribers",
    "subscription_url": "https://api.github.com/repos/scwang90/SmartRefreshLayout/subscription",
    "commits_url": "https://api.github.com/repos/scwang90/SmartRefreshLayout/commits{/sha}",
    "git_commits_url": "https://api.github.com/repos/scwang90/SmartRefreshLayout/git/commits{/sha}",
    "comments_url": "https://api.github.com/repos/scwang90/SmartRefreshLayout/comments{/number}",
    "issue_comment_url": "https://api.github.com/repos/scwang90/SmartRefreshLayout/issues/comments{/number}",
    "contents_url": "https://api.github.com/repos/scwang90/SmartRefreshLayout/contents/{+path}",
    "compare_url": "https://api.github.com/repos/scwang90/SmartRefreshLayout/compare/{base}...{head}",
    "merges_url": "https://api.github.com/repos/scwang90/SmartRefreshLayout/merges",
    "archive_url": "https://api.github.com/repos/scwang90/SmartRefreshLayout/{archive_format}{/ref}",
    "downloads_url": "https://api.github.com/repos/scwang90/SmartRefreshLayout/downloads",
    "issues_url": "https://api.github.com/repos/scwang90/SmartRefreshLayout/issues{/number}",
    "pulls_url": "https://api.github.com/repos/scwang90/SmartRefreshLayout/pulls{/number}",
    "milestones_url": "https://api.github.com/repos/scwang90/SmartRefreshLayout/milestones{/number}",
    "notifications_url": "https://api.github.com/repos/scwang90/SmartRefreshLayout/notifications{?since,all,participating}",
    "labels_url": "https://api.github.com/repos/scwang90/SmartRefreshLayout/labels{/name}",
    "releases_url": "https://api.github.com/repos/scwang90/SmartRefreshLayout/releases{/id}",
    "deployments_url": "https://api.github.com/repos/scwang90/SmartRefreshLayout/deployments",
    "created_at": "2017-06-02T09:52:50Z",
    "updated_at": "2018-06-30T09:07:48Z",
    "pushed_at": "2018-06-28T08:25:14Z",
    "git_url": "git://github.com/scwang90/SmartRefreshLayout.git",
    "ssh_url": "git@github.com:scwang90/SmartRefreshLayout.git",
    "clone_url": "https://github.com/scwang90/SmartRefreshLayout.git",
    "svn_url": "https://github.com/scwang90/SmartRefreshLayout",
    "homepage": "https://segmentfault.com/a/1190000010066071",
    "size": 243986,
    "stargazers_count": 12910,
    "watchers_count": 12910,
    "language": "Java",
    "has_issues": true,
    "has_projects": true,
    "has_downloads": true,
    "has_wiki": true,
    "has_pages": false,
    "forks_count": 2657,
    "mirror_url": null,
    "archived": false,
    "open_issues_count": 15,
    "license": {
        "key": "apache-2.0",
        "name": "Apache License 2.0",
        "spdx_id": "Apache-2.0",
        "url": "https://api.github.com/licenses/apache-2.0",
        "node_id": "MDc6TGljZW5zZTI="
    },
    "forks": 2657,
    "open_issues": 15,
    "watchers": 12910,
    "default_branch": "release",
    "score": 2.4655452
}
"""

class RepositoryTest : AutoCloseKoinTest() {

    val moshi: Moshi by inject()

    @Before
    fun before() {
        startKoin(listOf(AppModule))
    }

    @Test
    fun parse() = moshi.adapter(Repository::class.java).fromJson(JSON_RESPONSE)!!.run {
        assertEquals(93152223, id)
        assertEquals("SmartRefreshLayout", name)
        assertEquals("🔥下拉刷新、上拉加载、二级刷新、淘宝二楼、RefreshLayout、OverScroll，Android智能下拉刷新框架，支持越界回弹、越界拖动，具有极强的扩展性，集成了几十种炫酷的Header和 Footer。", description)
        assertEquals("https://avatars0.githubusercontent.com/u/11567071?v=4", owner.avatarUrl)
        assertEquals(2657, forkCount)
    }

}