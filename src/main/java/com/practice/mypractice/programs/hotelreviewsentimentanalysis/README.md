# Problem: Sort Hotel List by Sentiment Analysis
Given a set of hotels and their guest reviews, sort the hotels based on the sentiment analysis of their reviews. Positive words add a weighted score, and negative words subtract from the score.

### Input:
The first line contains a space-separated set of positive words used for sentiment analysis.
The second line contains a space-separated set of negative words used for sentiment analysis.
The third line contains one integer `M`, which is the number of reviews.
This is followed by `M+M` lines, alternating between a hotel ID and a review belonging to that hotel.

### Scoring:
- Each positive word increases the score by `+3`.
- Each negative word decreases the score by `-1`.

### Output:
A list of hotel IDs sorted, in descending order, by their sentiment score.

### Notes:
* The scoring words will always be single words, like 'excellent' or 'noisy'. Never double words like 'swimming pool'.
* Hotel ID is a 4-byte integer.
* Word matching should be case-insensitive.
* Dots and commas should be ignored.
* If a word appears in a review multiple times, its contribution to the score should be multiplied accordingly.
* If two hotels have the same sentiment score, they should be sorted in the output by their ID, smallest ID first.
* Ensure the runtime complexity of the algorithm is efficient to handle large inputs.

### Example Input:
```
excellent wonderful amazing fantastic outstanding perfect beautiful great friendly comfortable
terrible horrible awful disgusting dirty unfriendly noisy uncomfortable rude poor
5
1
This hotel has a nice view of the citycenter. The location is perfect and the staff is friendly.
2
The breakfast is okay. However, the location is quite far from the citycenter and the room was dirty.
1
Location is excellent, 5 minutes from the citycenter. The staff was great but the metro station was noisy.
3
Terrible experience. The room was disgusting and the staff was rude.
2
Very friendly staff and good cost-benefit ratio. However, the location is far from the citycenter.
```

### Example Output:
```
1 2 3
```

### Explanation:
Hotel *1* has a total sentiment score of `+15` (positive words: `perfect, friendly, excellent, great` contributing `+3` each, and negative words: `noisy` contributing `-1`).
Hotel *2* has a total sentiment score of `+11` (positive words: `friendly` contributing `+3`, and negative words: `dirty` contributing `-1`).
Hotel *3* has a total sentiment score of `-5` (negative words: `terrible, disgusting, rude` contributing `-1` each).

Hotels are sorted by their scores in descending order, with ties resolved by the smallest hotel ID.

# Solution
Refer
```
HotelSortBySentiment.java file
```
