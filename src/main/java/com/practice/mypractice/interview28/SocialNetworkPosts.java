package com.practice.mypractice.interview28;

public class SocialNetworkPosts {
}

/*

PayPal - Role specialization round (round 3 - 10th Dec)

We are designing the public HTTP API for a web service that helps corporate social media managers post to multiple social media networks (FACEBOOK, TWITTER, LINKEDIN, etc)

1. Create a new post on one social networks
2. Create a new post across multiple networks
3. Provide Statistics to show how users interacted with a post
4. Delete an existing post

What should be the methods of our API? Give each method a name, and specify the fields of its request and response messages.

-------------------------------------------------------------


1. POST /vi/posts
    Request Body:
    {
        "content": {
            "text"; "string"
            "media": "Link / base64content"
            "mediaType" : IMAGE/VIDEO/
        }
        "socialNetwork": TWITTER/LINKEDIN/FACEBOOK etc. (enum)
    }

    Response:
    {
        "postID": "id",
        "sourcePostId": "sid"
    }

    Response Status Code:
    1. 201 CREATE
    2. 400 BAD REQUEST
    3. 4xx
    4. 5xx


2. POST /vi/posts  (We wil modify the above endpoint to support multiple social networks)

    Request Body:
    {
        "postId": "will be present only in case of retries"
        "content": {
            "text"; "string"
            "media": "Link / base64content"
            "mediaType" : IMAGE/VIDEO/
        }
        "socialNetwork:" TWITTER/LINKEDIN/FACEBOOK etc. (enum)
    }

    Response:
    {
        "postId": "id",
        "socialNetworks": [{
            "sourcePostId": "sid",
            "socialNetwork": "TWITTER/LINKEDIN/FACEBOOK etc. (enum)",
            "status": "success/failure"
        }]
    }

    Response Status Code:
    1. 201 CREATE
    2. ...PARTIAL SUCCESS...
    2. 400 BAD REQUEST
    3. 4xx
    4. 5xx

3. GET /v1/posts/{id}/statistics

    Response Body:
    {
        "socialNetworkStats": [{}]
    }


//  Couldn't complete the below :

4. DELETE /v1/posts

    Req Body:
    {
        "postId": "id",
        "deleteFrom": [ "TWITTER/LINKEDIN/FACEBOOK etc. (enum)" ]
    }

    1. 204 NO CONTENT
    2. 404 NOT FOUND


 */


