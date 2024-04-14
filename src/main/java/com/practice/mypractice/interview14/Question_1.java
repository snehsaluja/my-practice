package com.practice.mypractice.interview14;

public class Question_1 {


// Wayfair round 1:

/*
    Question: We are working on a clone of Facebook.
    We want to add a numeric count to every post showing how many friends the post's
    author has at the time of viewing the post,
    like this:

    Marie McWilliams (105 friends)
    I had a great day today, feeling good!

    Our database has two tables:
    USER
        'user_id' (primary key)
        'name'
        'created_date'
    USER_RELATIONSHIP
        'user1_id' (indexed)
        'user2_id' (indexed)
        'start_date'
        'friendship_id' (primary key, unique to each relationship)

    Focusing on the database, how would you implement the friend-count feature? Note we will soon be more popular than Facebook, so the solution
    needs to scale



    Query :
    SELECT COUNT (*) FROM USER_RELATIONSHIP WHERE user_id = uid OR user2_id = :uid ;

    Cons : too many database calls will be made..

    How to improve : introduce a cache layer and keep on updating the friends count in cache.

    */

}
