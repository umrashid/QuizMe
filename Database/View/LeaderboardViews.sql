/*Leader Category Totals*/
DROP VIEW IF EXISTS leaderboard_category_total;
CREATE VIEW leaderboard_category_total as
select userID, sum(score) as totalpoints, categoryID from scorecategory
group by userID, categoryID
order by categoryID ASC, totalpoints DESC, userID;

/*Leader Category Average*/
DROP VIEW IF EXISTS leaderboard_category_average;
CREATE VIEW leaderboard_category_average as
select userID, ROUND(avg(score)) as averagePoints, categoryID from scorecategory
group by userID, categoryID
order by userID, categoryID ASC;

/*Leader Difficulty Totals*/
DROP VIEW IF EXISTS leaderboard_difficulty_total;
CREATE VIEW leaderboard_difficulty_total as
select userID, sum(score) as totalpoints, difficultyID from scoredifficulty
group by userID, difficultyID
order by difficultyID ASC, totalpoints DESC, userID;

/*Leader Difficulty Average*/
DROP VIEW IF EXISTS leaderboard_difficulty_average;
CREATE VIEW leaderboard_difficulty_average as
select userID, ROUND(avg(score)) as averagePoints, difficultyID from scoredifficulty
group by userID, difficultyID
order by userID, difficultyID ASC;

