-- Enable the UUID extension for Postgres
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- 1) user table with UUID PK
CREATE TABLE IF NOT EXISTS public.user (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL,
    registration_date TIMESTAMP NOT NULL DEFAULT NOW()
);

-- 2) activity_type table with UUID PK
CREATE TABLE IF NOT EXISTS public.activity_type (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name VARCHAR(100) NOT NULL,
    description VARCHAR(255),
    average_carbon_emission NUMERIC(10,2)
);

-- 3) activities table with UUID PK + FKs to user_id and activity_type_id
CREATE TABLE IF NOT EXISTS public.activity (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    user_id UUID NOT NULL,
    activity_type_id UUID NOT NULL,
    occurred_at TIMESTAMP NOT NULL DEFAULT NOW(),
    calculated_emission NUMERIC(10,2),
    CONSTRAINT fk_user
    FOREIGN KEY (user_id) REFERENCES public.user(id),
    CONSTRAINT fk_type
    FOREIGN KEY (activity_type_id) REFERENCES public.activity_type(id)
);

-- Insert some sample users with fixed UUIDs
INSERT INTO public.user (id, full_name, email) VALUES
    ('11111111-1111-1111-1111-111111111111','Alice Green','alice@cft.com'),
    ('22222222-2222-2222-2222-222222222222','Bob Brown','bob@cft.com'),
    ('33333333-3333-3333-3333-333333333333','Charlie White','charlie@cft.com');

-- Insert some sample activity types with fixed UUIDs
INSERT INTO public.activity_type (id, name, description, average_carbon_emission) VALUES
    ('44444444-4444-4444-4444-444444444444','Car Commute','Driving a standard car or rideshare',2.50),
    ('55555555-5555-5555-5555-555555555555','Flight','Short domestic flight',30.00),
    ('66666666-6666-6666-6666-666666666666','Online Purchase','Ordering goods online',1.00);