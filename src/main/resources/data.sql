--create table customer (customer_id bigint auto_increment, name varchar(255), phone_number varchar(255), primary key (customer_id));
--create table transaction (transaction_id bigint auto_increment, bill_amount double, reward_points bigint, transaction_date date, cust_id bigint, primary key (transaction_id));
--create table reward_point (id integer auto_increment, amount_limit bigint, points integer, primary key (id));

--insert into reward_point values(1,50,1);
--insert into reward_point values(2,100,2);
--insert into customer values (1,'Roy','1111');
--insert into customer values (2,'Ram','2222');
--insert into customer values (3,'Sham','3333');
--
--insert into transaction values (1,120, 90, '2022-08-23',1);
--insert into transaction values (2l,220, 290, '2022-07-27',1l);
--insert into transaction values (3l,50, 0, '2022-07-27',1l);
--insert into transaction values (4l,120, 90, '2022-08-23',2);
--insert into transaction values (5l,220, 290, '2022-04-27',2);
--insert into transaction values (6l,100, 50, '2022-05-27',3);
