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
    "total_count": 36598,
    "incomplete_results": false,
    "items": [
        {
            "id": 24953448,
            "node_id": "MDEwOlJlcG9zaXRvcnkyNDk1MzQ0OA==",
            "name": "material-design-icons",
            "full_name": "google/material-design-icons",
            "owner": {
                "login": "google",
                "id": 1342004,
                "node_id": "MDEyOk9yZ2FuaXphdGlvbjEzNDIwMDQ=",
                "avatar_url": "https://avatars1.githubusercontent.com/u/1342004?v=4",
                "gravatar_id": "",
                "url": "https://api.github.com/users/google",
                "html_url": "https://github.com/google",
                "followers_url": "https://api.github.com/users/google/followers",
                "following_url": "https://api.github.com/users/google/following{/other_user}",
                "gists_url": "https://api.github.com/users/google/gists{/gist_id}",
                "starred_url": "https://api.github.com/users/google/starred{/owner}{/repo}",
                "subscriptions_url": "https://api.github.com/users/google/subscriptions",
                "organizations_url": "https://api.github.com/users/google/orgs",
                "repos_url": "https://api.github.com/users/google/repos",
                "events_url": "https://api.github.com/users/google/events{/privacy}",
                "received_events_url": "https://api.github.com/users/google/received_events",
                "type": "Organization",
                "site_admin": false
            },
            "private": false,
            "html_url": "https://github.com/google/material-design-icons",
            "description": "Material Design icons by Google",
            "fork": false,
            "url": "https://api.github.com/repos/google/material-design-icons",
            "forks_url": "https://api.github.com/repos/google/material-design-icons/forks",
            "keys_url": "https://api.github.com/repos/google/material-design-icons/keys{/key_id}",
            "collaborators_url": "https://api.github.com/repos/google/material-design-icons/collaborators{/collaborator}",
            "teams_url": "https://api.github.com/repos/google/material-design-icons/teams",
            "hooks_url": "https://api.github.com/repos/google/material-design-icons/hooks",
            "issue_events_url": "https://api.github.com/repos/google/material-design-icons/issues/events{/number}",
            "events_url": "https://api.github.com/repos/google/material-design-icons/events",
            "assignees_url": "https://api.github.com/repos/google/material-design-icons/assignees{/user}",
            "branches_url": "https://api.github.com/repos/google/material-design-icons/branches{/branch}",
            "tags_url": "https://api.github.com/repos/google/material-design-icons/tags",
            "blobs_url": "https://api.github.com/repos/google/material-design-icons/git/blobs{/sha}",
            "git_tags_url": "https://api.github.com/repos/google/material-design-icons/git/tags{/sha}",
            "git_refs_url": "https://api.github.com/repos/google/material-design-icons/git/refs{/sha}",
            "trees_url": "https://api.github.com/repos/google/material-design-icons/git/trees{/sha}",
            "statuses_url": "https://api.github.com/repos/google/material-design-icons/statuses/{sha}",
            "languages_url": "https://api.github.com/repos/google/material-design-icons/languages",
            "stargazers_url": "https://api.github.com/repos/google/material-design-icons/stargazers",
            "contributors_url": "https://api.github.com/repos/google/material-design-icons/contributors",
            "subscribers_url": "https://api.github.com/repos/google/material-design-icons/subscribers",
            "subscription_url": "https://api.github.com/repos/google/material-design-icons/subscription",
            "commits_url": "https://api.github.com/repos/google/material-design-icons/commits{/sha}",
            "git_commits_url": "https://api.github.com/repos/google/material-design-icons/git/commits{/sha}",
            "comments_url": "https://api.github.com/repos/google/material-design-icons/comments{/number}",
            "issue_comment_url": "https://api.github.com/repos/google/material-design-icons/issues/comments{/number}",
            "contents_url": "https://api.github.com/repos/google/material-design-icons/contents/{+path}",
            "compare_url": "https://api.github.com/repos/google/material-design-icons/compare/{base}...{head}",
            "merges_url": "https://api.github.com/repos/google/material-design-icons/merges",
            "archive_url": "https://api.github.com/repos/google/material-design-icons/{archive_format}{/ref}",
            "downloads_url": "https://api.github.com/repos/google/material-design-icons/downloads",
            "issues_url": "https://api.github.com/repos/google/material-design-icons/issues{/number}",
            "pulls_url": "https://api.github.com/repos/google/material-design-icons/pulls{/number}",
            "milestones_url": "https://api.github.com/repos/google/material-design-icons/milestones{/number}",
            "notifications_url": "https://api.github.com/repos/google/material-design-icons/notifications{?since,all,participating}",
            "labels_url": "https://api.github.com/repos/google/material-design-icons/labels{/name}",
            "releases_url": "https://api.github.com/repos/google/material-design-icons/releases{/id}",
            "deployments_url": "https://api.github.com/repos/google/material-design-icons/deployments",
            "created_at": "2014-10-08T18:01:28Z",
            "updated_at": "2018-07-01T12:42:26Z",
            "pushed_at": "2018-04-24T22:45:47Z",
            "git_url": "git://github.com/google/material-design-icons.git",
            "ssh_url": "git@github.com:google/material-design-icons.git",
            "clone_url": "https://github.com/google/material-design-icons.git",
            "svn_url": "https://github.com/google/material-design-icons",
            "homepage": "http://google.github.io/material-design-icons/",
            "size": 47085,
            "stargazers_count": 35256,
            "watchers_count": 35256,
            "language": "CSS",
            "has_issues": true,
            "has_projects": true,
            "has_downloads": false,
            "has_wiki": true,
            "has_pages": true,
            "forks_count": 7005,
            "mirror_url": null,
            "archived": false,
            "open_issues_count": 463,
            "license": {
                "key": "apache-2.0",
                "name": "Apache License 2.0",
                "spdx_id": "Apache-2.0",
                "url": "https://api.github.com/licenses/apache-2.0",
                "node_id": "MDc6TGljZW5zZTI="
            },
            "forks": 7005,
            "open_issues": 463,
            "watchers": 35256,
            "default_branch": "master",
            "score": 2.4564903
        },
        {
            "id": 14098069,
            "node_id": "MDEwOlJlcG9zaXRvcnkxNDA5ODA2OQ==",
            "name": "free-programming-books-zh_CN",
            "full_name": "justjavac/free-programming-books-zh_CN",
            "owner": {
                "login": "justjavac",
                "id": 359395,
                "node_id": "MDQ6VXNlcjM1OTM5NQ==",
                "avatar_url": "https://avatars1.githubusercontent.com/u/359395?v=4",
                "gravatar_id": "",
                "url": "https://api.github.com/users/justjavac",
                "html_url": "https://github.com/justjavac",
                "followers_url": "https://api.github.com/users/justjavac/followers",
                "following_url": "https://api.github.com/users/justjavac/following{/other_user}",
                "gists_url": "https://api.github.com/users/justjavac/gists{/gist_id}",
                "starred_url": "https://api.github.com/users/justjavac/starred{/owner}{/repo}",
                "subscriptions_url": "https://api.github.com/users/justjavac/subscriptions",
                "organizations_url": "https://api.github.com/users/justjavac/orgs",
                "repos_url": "https://api.github.com/users/justjavac/repos",
                "events_url": "https://api.github.com/users/justjavac/events{/privacy}",
                "received_events_url": "https://api.github.com/users/justjavac/received_events",
                "type": "User",
                "site_admin": false
            },
            "private": false,
            "html_url": "https://github.com/justjavac/free-programming-books-zh_CN",
            "description": ":books: 免费的计算机编程类中文书籍，欢迎投稿",
            "fork": false,
            "url": "https://api.github.com/repos/justjavac/free-programming-books-zh_CN",
            "forks_url": "https://api.github.com/repos/justjavac/free-programming-books-zh_CN/forks",
            "keys_url": "https://api.github.com/repos/justjavac/free-programming-books-zh_CN/keys{/key_id}",
            "collaborators_url": "https://api.github.com/repos/justjavac/free-programming-books-zh_CN/collaborators{/collaborator}",
            "teams_url": "https://api.github.com/repos/justjavac/free-programming-books-zh_CN/teams",
            "hooks_url": "https://api.github.com/repos/justjavac/free-programming-books-zh_CN/hooks",
            "issue_events_url": "https://api.github.com/repos/justjavac/free-programming-books-zh_CN/issues/events{/number}",
            "events_url": "https://api.github.com/repos/justjavac/free-programming-books-zh_CN/events",
            "assignees_url": "https://api.github.com/repos/justjavac/free-programming-books-zh_CN/assignees{/user}",
            "branches_url": "https://api.github.com/repos/justjavac/free-programming-books-zh_CN/branches{/branch}",
            "tags_url": "https://api.github.com/repos/justjavac/free-programming-books-zh_CN/tags",
            "blobs_url": "https://api.github.com/repos/justjavac/free-programming-books-zh_CN/git/blobs{/sha}",
            "git_tags_url": "https://api.github.com/repos/justjavac/free-programming-books-zh_CN/git/tags{/sha}",
            "git_refs_url": "https://api.github.com/repos/justjavac/free-programming-books-zh_CN/git/refs{/sha}",
            "trees_url": "https://api.github.com/repos/justjavac/free-programming-books-zh_CN/git/trees{/sha}",
            "statuses_url": "https://api.github.com/repos/justjavac/free-programming-books-zh_CN/statuses/{sha}",
            "languages_url": "https://api.github.com/repos/justjavac/free-programming-books-zh_CN/languages",
            "stargazers_url": "https://api.github.com/repos/justjavac/free-programming-books-zh_CN/stargazers",
            "contributors_url": "https://api.github.com/repos/justjavac/free-programming-books-zh_CN/contributors",
            "subscribers_url": "https://api.github.com/repos/justjavac/free-programming-books-zh_CN/subscribers",
            "subscription_url": "https://api.github.com/repos/justjavac/free-programming-books-zh_CN/subscription",
            "commits_url": "https://api.github.com/repos/justjavac/free-programming-books-zh_CN/commits{/sha}",
            "git_commits_url": "https://api.github.com/repos/justjavac/free-programming-books-zh_CN/git/commits{/sha}",
            "comments_url": "https://api.github.com/repos/justjavac/free-programming-books-zh_CN/comments{/number}",
            "issue_comment_url": "https://api.github.com/repos/justjavac/free-programming-books-zh_CN/issues/comments{/number}",
            "contents_url": "https://api.github.com/repos/justjavac/free-programming-books-zh_CN/contents/{+path}",
            "compare_url": "https://api.github.com/repos/justjavac/free-programming-books-zh_CN/compare/{base}...{head}",
            "merges_url": "https://api.github.com/repos/justjavac/free-programming-books-zh_CN/merges",
            "archive_url": "https://api.github.com/repos/justjavac/free-programming-books-zh_CN/{archive_format}{/ref}",
            "downloads_url": "https://api.github.com/repos/justjavac/free-programming-books-zh_CN/downloads",
            "issues_url": "https://api.github.com/repos/justjavac/free-programming-books-zh_CN/issues{/number}",
            "pulls_url": "https://api.github.com/repos/justjavac/free-programming-books-zh_CN/pulls{/number}",
            "milestones_url": "https://api.github.com/repos/justjavac/free-programming-books-zh_CN/milestones{/number}",
            "notifications_url": "https://api.github.com/repos/justjavac/free-programming-books-zh_CN/notifications{?since,all,participating}",
            "labels_url": "https://api.github.com/repos/justjavac/free-programming-books-zh_CN/labels{/name}",
            "releases_url": "https://api.github.com/repos/justjavac/free-programming-books-zh_CN/releases{/id}",
            "deployments_url": "https://api.github.com/repos/justjavac/free-programming-books-zh_CN/deployments",
            "created_at": "2013-11-04T01:59:19Z",
            "updated_at": "2018-07-01T12:26:55Z",
            "pushed_at": "2018-06-06T16:52:49Z",
            "git_url": "git://github.com/justjavac/free-programming-books-zh_CN.git",
            "ssh_url": "git@github.com:justjavac/free-programming-books-zh_CN.git",
            "clone_url": "https://github.com/justjavac/free-programming-books-zh_CN.git",
            "svn_url": "https://github.com/justjavac/free-programming-books-zh_CN",
            "homepage": "http://weibo.com/justjavac",
            "size": 825,
            "stargazers_count": 34895,
            "watchers_count": 34895,
            "language": "JavaScript",
            "has_issues": true,
            "has_projects": true,
            "has_downloads": true,
            "has_wiki": false,
            "has_pages": false,
            "forks_count": 12413,
            "mirror_url": null,
            "archived": false,
            "open_issues_count": 143,
            "license": {
                "key": "gpl-3.0",
                "name": "GNU General Public License v3.0",
                "spdx_id": "GPL-3.0",
                "url": "https://api.github.com/licenses/gpl-3.0",
                "node_id": "MDc6TGljZW5zZTk="
            },
            "forks": 12413,
            "open_issues": 143,
            "watchers": 34895,
            "default_branch": "master",
            "score": 8.819808
        },
        {
            "id": 28428729,
            "node_id": "MDEwOlJlcG9zaXRvcnkyODQyODcyOQ==",
            "name": "awesome-android-ui",
            "full_name": "wasabeef/awesome-android-ui",
            "owner": {
                "login": "wasabeef",
                "id": 1833474,
                "node_id": "MDQ6VXNlcjE4MzM0NzQ=",
                "avatar_url": "https://avatars2.githubusercontent.com/u/1833474?v=4",
                "gravatar_id": "",
                "url": "https://api.github.com/users/wasabeef",
                "html_url": "https://github.com/wasabeef",
                "followers_url": "https://api.github.com/users/wasabeef/followers",
                "following_url": "https://api.github.com/users/wasabeef/following{/other_user}",
                "gists_url": "https://api.github.com/users/wasabeef/gists{/gist_id}",
                "starred_url": "https://api.github.com/users/wasabeef/starred{/owner}{/repo}",
                "subscriptions_url": "https://api.github.com/users/wasabeef/subscriptions",
                "organizations_url": "https://api.github.com/users/wasabeef/orgs",
                "repos_url": "https://api.github.com/users/wasabeef/repos",
                "events_url": "https://api.github.com/users/wasabeef/events{/privacy}",
                "received_events_url": "https://api.github.com/users/wasabeef/received_events",
                "type": "User",
                "site_admin": false
            },
            "private": false,
            "html_url": "https://github.com/wasabeef/awesome-android-ui",
            "description": "A curated list of awesome Android UI/UX libraries",
            "fork": false,
            "url": "https://api.github.com/repos/wasabeef/awesome-android-ui",
            "forks_url": "https://api.github.com/repos/wasabeef/awesome-android-ui/forks",
            "keys_url": "https://api.github.com/repos/wasabeef/awesome-android-ui/keys{/key_id}",
            "collaborators_url": "https://api.github.com/repos/wasabeef/awesome-android-ui/collaborators{/collaborator}",
            "teams_url": "https://api.github.com/repos/wasabeef/awesome-android-ui/teams",
            "hooks_url": "https://api.github.com/repos/wasabeef/awesome-android-ui/hooks",
            "issue_events_url": "https://api.github.com/repos/wasabeef/awesome-android-ui/issues/events{/number}",
            "events_url": "https://api.github.com/repos/wasabeef/awesome-android-ui/events",
            "assignees_url": "https://api.github.com/repos/wasabeef/awesome-android-ui/assignees{/user}",
            "branches_url": "https://api.github.com/repos/wasabeef/awesome-android-ui/branches{/branch}",
            "tags_url": "https://api.github.com/repos/wasabeef/awesome-android-ui/tags",
            "blobs_url": "https://api.github.com/repos/wasabeef/awesome-android-ui/git/blobs{/sha}",
            "git_tags_url": "https://api.github.com/repos/wasabeef/awesome-android-ui/git/tags{/sha}",
            "git_refs_url": "https://api.github.com/repos/wasabeef/awesome-android-ui/git/refs{/sha}",
            "trees_url": "https://api.github.com/repos/wasabeef/awesome-android-ui/git/trees{/sha}",
            "statuses_url": "https://api.github.com/repos/wasabeef/awesome-android-ui/statuses/{sha}",
            "languages_url": "https://api.github.com/repos/wasabeef/awesome-android-ui/languages",
            "stargazers_url": "https://api.github.com/repos/wasabeef/awesome-android-ui/stargazers",
            "contributors_url": "https://api.github.com/repos/wasabeef/awesome-android-ui/contributors",
            "subscribers_url": "https://api.github.com/repos/wasabeef/awesome-android-ui/subscribers",
            "subscription_url": "https://api.github.com/repos/wasabeef/awesome-android-ui/subscription",
            "commits_url": "https://api.github.com/repos/wasabeef/awesome-android-ui/commits{/sha}",
            "git_commits_url": "https://api.github.com/repos/wasabeef/awesome-android-ui/git/commits{/sha}",
            "comments_url": "https://api.github.com/repos/wasabeef/awesome-android-ui/comments{/number}",
            "issue_comment_url": "https://api.github.com/repos/wasabeef/awesome-android-ui/issues/comments{/number}",
            "contents_url": "https://api.github.com/repos/wasabeef/awesome-android-ui/contents/{+path}",
            "compare_url": "https://api.github.com/repos/wasabeef/awesome-android-ui/compare/{base}...{head}",
            "merges_url": "https://api.github.com/repos/wasabeef/awesome-android-ui/merges",
            "archive_url": "https://api.github.com/repos/wasabeef/awesome-android-ui/{archive_format}{/ref}",
            "downloads_url": "https://api.github.com/repos/wasabeef/awesome-android-ui/downloads",
            "issues_url": "https://api.github.com/repos/wasabeef/awesome-android-ui/issues{/number}",
            "pulls_url": "https://api.github.com/repos/wasabeef/awesome-android-ui/pulls{/number}",
            "milestones_url": "https://api.github.com/repos/wasabeef/awesome-android-ui/milestones{/number}",
            "notifications_url": "https://api.github.com/repos/wasabeef/awesome-android-ui/notifications{?since,all,participating}",
            "labels_url": "https://api.github.com/repos/wasabeef/awesome-android-ui/labels{/name}",
            "releases_url": "https://api.github.com/repos/wasabeef/awesome-android-ui/releases{/id}",
            "deployments_url": "https://api.github.com/repos/wasabeef/awesome-android-ui/deployments",
            "created_at": "2014-12-24T01:45:03Z",
            "updated_at": "2018-07-01T10:30:23Z",
            "pushed_at": "2018-07-01T01:21:46Z",
            "git_url": "git://github.com/wasabeef/awesome-android-ui.git",
            "ssh_url": "git@github.com:wasabeef/awesome-android-ui.git",
            "clone_url": "https://github.com/wasabeef/awesome-android-ui.git",
            "svn_url": "https://github.com/wasabeef/awesome-android-ui",
            "homepage": "https://twitter.com/wasabeef_jp",
            "size": 775829,
            "stargazers_count": 30814,
            "watchers_count": 30814,
            "language": null,
            "has_issues": false,
            "has_projects": false,
            "has_downloads": true,
            "has_wiki": false,
            "has_pages": false,
            "forks_count": 8254,
            "mirror_url": null,
            "archived": false,
            "open_issues_count": 9,
            "license": null,
            "forks": 8254,
            "open_issues": 9,
            "watchers": 30814,
            "default_branch": "master",
            "score": 2.4561436
        },
        {
            "id": 31792824,
            "node_id": "MDEwOlJlcG9zaXRvcnkzMTc5MjgyNA==",
            "name": "flutter",
            "full_name": "flutter/flutter",
            "owner": {
                "login": "flutter",
                "id": 14101776,
                "node_id": "MDEyOk9yZ2FuaXphdGlvbjE0MTAxNzc2",
                "avatar_url": "https://avatars3.githubusercontent.com/u/14101776?v=4",
                "gravatar_id": "",
                "url": "https://api.github.com/users/flutter",
                "html_url": "https://github.com/flutter",
                "followers_url": "https://api.github.com/users/flutter/followers",
                "following_url": "https://api.github.com/users/flutter/following{/other_user}",
                "gists_url": "https://api.github.com/users/flutter/gists{/gist_id}",
                "starred_url": "https://api.github.com/users/flutter/starred{/owner}{/repo}",
                "subscriptions_url": "https://api.github.com/users/flutter/subscriptions",
                "organizations_url": "https://api.github.com/users/flutter/orgs",
                "repos_url": "https://api.github.com/users/flutter/repos",
                "events_url": "https://api.github.com/users/flutter/events{/privacy}",
                "received_events_url": "https://api.github.com/users/flutter/received_events",
                "type": "Organization",
                "site_admin": false
            },
            "private": false,
            "html_url": "https://github.com/flutter/flutter",
            "description": "Flutter makes it easy and fast to build beautiful mobile apps.",
            "fork": false,
            "url": "https://api.github.com/repos/flutter/flutter",
            "forks_url": "https://api.github.com/repos/flutter/flutter/forks",
            "keys_url": "https://api.github.com/repos/flutter/flutter/keys{/key_id}",
            "collaborators_url": "https://api.github.com/repos/flutter/flutter/collaborators{/collaborator}",
            "teams_url": "https://api.github.com/repos/flutter/flutter/teams",
            "hooks_url": "https://api.github.com/repos/flutter/flutter/hooks",
            "issue_events_url": "https://api.github.com/repos/flutter/flutter/issues/events{/number}",
            "events_url": "https://api.github.com/repos/flutter/flutter/events",
            "assignees_url": "https://api.github.com/repos/flutter/flutter/assignees{/user}",
            "branches_url": "https://api.github.com/repos/flutter/flutter/branches{/branch}",
            "tags_url": "https://api.github.com/repos/flutter/flutter/tags",
            "blobs_url": "https://api.github.com/repos/flutter/flutter/git/blobs{/sha}",
            "git_tags_url": "https://api.github.com/repos/flutter/flutter/git/tags{/sha}",
            "git_refs_url": "https://api.github.com/repos/flutter/flutter/git/refs{/sha}",
            "trees_url": "https://api.github.com/repos/flutter/flutter/git/trees{/sha}",
            "statuses_url": "https://api.github.com/repos/flutter/flutter/statuses/{sha}",
            "languages_url": "https://api.github.com/repos/flutter/flutter/languages",
            "stargazers_url": "https://api.github.com/repos/flutter/flutter/stargazers",
            "contributors_url": "https://api.github.com/repos/flutter/flutter/contributors",
            "subscribers_url": "https://api.github.com/repos/flutter/flutter/subscribers",
            "subscription_url": "https://api.github.com/repos/flutter/flutter/subscription",
            "commits_url": "https://api.github.com/repos/flutter/flutter/commits{/sha}",
            "git_commits_url": "https://api.github.com/repos/flutter/flutter/git/commits{/sha}",
            "comments_url": "https://api.github.com/repos/flutter/flutter/comments{/number}",
            "issue_comment_url": "https://api.github.com/repos/flutter/flutter/issues/comments{/number}",
            "contents_url": "https://api.github.com/repos/flutter/flutter/contents/{+path}",
            "compare_url": "https://api.github.com/repos/flutter/flutter/compare/{base}...{head}",
            "merges_url": "https://api.github.com/repos/flutter/flutter/merges",
            "archive_url": "https://api.github.com/repos/flutter/flutter/{archive_format}{/ref}",
            "downloads_url": "https://api.github.com/repos/flutter/flutter/downloads",
            "issues_url": "https://api.github.com/repos/flutter/flutter/issues{/number}",
            "pulls_url": "https://api.github.com/repos/flutter/flutter/pulls{/number}",
            "milestones_url": "https://api.github.com/repos/flutter/flutter/milestones{/number}",
            "notifications_url": "https://api.github.com/repos/flutter/flutter/notifications{?since,all,participating}",
            "labels_url": "https://api.github.com/repos/flutter/flutter/labels{/name}",
            "releases_url": "https://api.github.com/repos/flutter/flutter/releases{/id}",
            "deployments_url": "https://api.github.com/repos/flutter/flutter/deployments",
            "created_at": "2015-03-06T22:54:58Z",
            "updated_at": "2018-07-01T13:13:46Z",
            "pushed_at": "2018-07-01T00:17:36Z",
            "git_url": "git://github.com/flutter/flutter.git",
            "ssh_url": "git@github.com:flutter/flutter.git",
            "clone_url": "https://github.com/flutter/flutter.git",
            "svn_url": "https://github.com/flutter/flutter",
            "homepage": "https://flutter.io",
            "size": 40720,
            "stargazers_count": 30652,
            "watchers_count": 30652,
            "language": "Dart",
            "has_issues": true,
            "has_projects": true,
            "has_downloads": true,
            "has_wiki": true,
            "has_pages": false,
            "forks_count": 2756,
            "mirror_url": null,
            "archived": false,
            "open_issues_count": 3473,
            "license": {
                "key": "other",
                "name": "Other",
                "spdx_id": null,
                "url": null,
                "node_id": "MDc6TGljZW5zZTA="
            },
            "forks": 2756,
            "open_issues": 3473,
            "watchers": 30652,
            "default_branch": "master",
            "score": 8.529065
        },
        {
            "id": 51148780,
            "node_id": "MDEwOlJlcG9zaXRvcnk1MTE0ODc4MA==",
            "name": "android-architecture",
            "full_name": "googlesamples/android-architecture",
            "owner": {
                "login": "googlesamples",
                "id": 7378196,
                "node_id": "MDEyOk9yZ2FuaXphdGlvbjczNzgxOTY=",
                "avatar_url": "https://avatars3.githubusercontent.com/u/7378196?v=4",
                "gravatar_id": "",
                "url": "https://api.github.com/users/googlesamples",
                "html_url": "https://github.com/googlesamples",
                "followers_url": "https://api.github.com/users/googlesamples/followers",
                "following_url": "https://api.github.com/users/googlesamples/following{/other_user}",
                "gists_url": "https://api.github.com/users/googlesamples/gists{/gist_id}",
                "starred_url": "https://api.github.com/users/googlesamples/starred{/owner}{/repo}",
                "subscriptions_url": "https://api.github.com/users/googlesamples/subscriptions",
                "organizations_url": "https://api.github.com/users/googlesamples/orgs",
                "repos_url": "https://api.github.com/users/googlesamples/repos",
                "events_url": "https://api.github.com/users/googlesamples/events{/privacy}",
                "received_events_url": "https://api.github.com/users/googlesamples/received_events",
                "type": "Organization",
                "site_admin": false
            },
            "private": false,
            "html_url": "https://github.com/googlesamples/android-architecture",
            "description": "A collection of samples to discuss and showcase different architectural tools and patterns for Android apps.",
            "fork": false,
            "url": "https://api.github.com/repos/googlesamples/android-architecture",
            "forks_url": "https://api.github.com/repos/googlesamples/android-architecture/forks",
            "keys_url": "https://api.github.com/repos/googlesamples/android-architecture/keys{/key_id}",
            "collaborators_url": "https://api.github.com/repos/googlesamples/android-architecture/collaborators{/collaborator}",
            "teams_url": "https://api.github.com/repos/googlesamples/android-architecture/teams",
            "hooks_url": "https://api.github.com/repos/googlesamples/android-architecture/hooks",
            "issue_events_url": "https://api.github.com/repos/googlesamples/android-architecture/issues/events{/number}",
            "events_url": "https://api.github.com/repos/googlesamples/android-architecture/events",
            "assignees_url": "https://api.github.com/repos/googlesamples/android-architecture/assignees{/user}",
            "branches_url": "https://api.github.com/repos/googlesamples/android-architecture/branches{/branch}",
            "tags_url": "https://api.github.com/repos/googlesamples/android-architecture/tags",
            "blobs_url": "https://api.github.com/repos/googlesamples/android-architecture/git/blobs{/sha}",
            "git_tags_url": "https://api.github.com/repos/googlesamples/android-architecture/git/tags{/sha}",
            "git_refs_url": "https://api.github.com/repos/googlesamples/android-architecture/git/refs{/sha}",
            "trees_url": "https://api.github.com/repos/googlesamples/android-architecture/git/trees{/sha}",
            "statuses_url": "https://api.github.com/repos/googlesamples/android-architecture/statuses/{sha}",
            "languages_url": "https://api.github.com/repos/googlesamples/android-architecture/languages",
            "stargazers_url": "https://api.github.com/repos/googlesamples/android-architecture/stargazers",
            "contributors_url": "https://api.github.com/repos/googlesamples/android-architecture/contributors",
            "subscribers_url": "https://api.github.com/repos/googlesamples/android-architecture/subscribers",
            "subscription_url": "https://api.github.com/repos/googlesamples/android-architecture/subscription",
            "commits_url": "https://api.github.com/repos/googlesamples/android-architecture/commits{/sha}",
            "git_commits_url": "https://api.github.com/repos/googlesamples/android-architecture/git/commits{/sha}",
            "comments_url": "https://api.github.com/repos/googlesamples/android-architecture/comments{/number}",
            "issue_comment_url": "https://api.github.com/repos/googlesamples/android-architecture/issues/comments{/number}",
            "contents_url": "https://api.github.com/repos/googlesamples/android-architecture/contents/{+path}",
            "compare_url": "https://api.github.com/repos/googlesamples/android-architecture/compare/{base}...{head}",
            "merges_url": "https://api.github.com/repos/googlesamples/android-architecture/merges",
            "archive_url": "https://api.github.com/repos/googlesamples/android-architecture/{archive_format}{/ref}",
            "downloads_url": "https://api.github.com/repos/googlesamples/android-architecture/downloads",
            "issues_url": "https://api.github.com/repos/googlesamples/android-architecture/issues{/number}",
            "pulls_url": "https://api.github.com/repos/googlesamples/android-architecture/pulls{/number}",
            "milestones_url": "https://api.github.com/repos/googlesamples/android-architecture/milestones{/number}",
            "notifications_url": "https://api.github.com/repos/googlesamples/android-architecture/notifications{?since,all,participating}",
            "labels_url": "https://api.github.com/repos/googlesamples/android-architecture/labels{/name}",
            "releases_url": "https://api.github.com/repos/googlesamples/android-architecture/releases{/id}",
            "deployments_url": "https://api.github.com/repos/googlesamples/android-architecture/deployments",
            "created_at": "2016-02-05T13:42:07Z",
            "updated_at": "2018-07-01T10:17:41Z",
            "pushed_at": "2018-06-23T23:34:09Z",
            "git_url": "git://github.com/googlesamples/android-architecture.git",
            "ssh_url": "git@github.com:googlesamples/android-architecture.git",
            "clone_url": "https://github.com/googlesamples/android-architecture.git",
            "svn_url": "https://github.com/googlesamples/android-architecture",
            "homepage": "",
            "size": 8197,
            "stargazers_count": 28063,
            "watchers_count": 28063,
            "language": null,
            "has_issues": true,
            "has_projects": true,
            "has_downloads": true,
            "has_wiki": true,
            "has_pages": false,
            "forks_count": 7852,
            "mirror_url": null,
            "archived": false,
            "open_issues_count": 106,
            "license": {
                "key": "apache-2.0",
                "name": "Apache License 2.0",
                "spdx_id": "Apache-2.0",
                "url": "https://api.github.com/licenses/apache-2.0",
                "node_id": "MDc6TGljZW5zZTI="
            },
            "forks": 7852,
            "open_issues": 106,
            "watchers": 28063,
            "default_branch": "master",
            "score": 8.72604
        }
    ]
}
"""


class SearchRepositoriesResponseTest : AutoCloseKoinTest() {

    val moshi: Moshi by inject()

    @Before
    fun before() {
        startKoin(listOf(AppModule))
    }

    @Test
    fun parse() = moshi.adapter(SearchRepositoriesResponse::class.java).fromJson(JSON_RESPONSE)!!.run {
        assertEquals(5, repositories.size)
    }
}