CREATE TYPE gender AS ENUM ('MALE', 'FEMALE');

ALTER TABLE app_user ALTER COLUMN gender TYPE gender USING (gender::gender);