INSERT INTO app_user ("user_id", "first_name", "last_name", "email", "gender")
VALUES ('e926f3e2-f5b2-4d84-a858-951fbeea54d2', 'Ali', 'Kiyan', 'Alikiyand@gmail.com', 'MALE'),
('3f7475b2-117f-42ad-93a3-308ecf7bf607', 'Lucy', 'James', 'Lucyjames@gmail.com', 'FEMALE');

INSERT INTO user_topic ( "user_id", "topic_id", "subscription_date", "rate" )
VALUES
	( 'e926f3e2-f5b2-4d84-a858-951fbeea54d2', '96df7245-fcb1-4f76-9f28-8932affb66a3', NOW( ) :: DATE, 80 ),
	( '3f7475b2-117f-42ad-93a3-308ecf7bf607', '116ff631-5f7a-4497-8dd8-8d5b62b04be7', (NOW( ) - INTERVAL '1 YEAR')::DATE, 75);