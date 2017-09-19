-- connect to postgres cli with default user
-- psql postgres

-- connect to postgres cli with specified user
-- psql postgres -U pmm

-- disconnect from postgres cli
\q

-- list all users
\du

-- list all databases
\list

-- list all relations
\dt

-- create user
CREATE ROLE spring WITH LOGIN PASSWORD 'cloud';

-- delete user
DROP ROLE spring;

-- add SUPERUSER role for specified user
ALTER ROLE spring SUPERUSER;

-- add CREATEDB role for specified user
ALTER ROLE spring CREATEDB;

-- create database
CREATE DATABASE task_logs;

-- grant privileges to user for database
GRANT ALL PRIVILEGES ON DATABASE task_logs TO spring;

-- delete database
DROP DATABASE task_logs;

-- connect to database
\connect task_logs
