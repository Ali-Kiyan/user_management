CREATE TABLE IF NOT EXISTS topic (
    topic_id UUID NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    description TEXT NOT NULL,
    category VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS user_topic (
    user_id UUID NOT NULL REFERENCES app_user(user_id),
    topic_id UUID NOT NULL REFERENCES topic(topic_id),
    subscription_date DATE NOT NULL,
    rate INTEGER CHECK(rate>=0 AND rate<=100),
    UNIQUE (user_id, topic_id)
);