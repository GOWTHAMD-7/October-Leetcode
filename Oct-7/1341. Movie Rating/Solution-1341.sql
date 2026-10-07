(
select u.name as results from Users u join MovieRating r on (u.user_id=r.user_id) group by r.user_id order by count(r.user_id) desc,u.name limit 1
)

UNION ALL

(
select m.title as results from Movies m join MovieRating r on (m.movie_id=r.movie_id) where month(created_at)=2 and year(created_at)=2020 group by r.movie_id order by avg(r.rating) desc, m.title asc limit 1
);
