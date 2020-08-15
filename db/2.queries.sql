
create function get_game(gname text) returns text as
$$
    select * from games where title = gname;
$$ language sql;

