DROP TABLE IF EXISTS "public"."user";
CREATE TABLE "public"."user"
(
    "id"       BIGSERIAL                                   NOT NULL PRIMARY KEY,
    "password" varchar(500) COLLATE "pg_catalog"."default" NOT NULL,
    "role"     varchar(45) COLLATE "pg_catalog"."default"  NOT NULL,
    "email"    varchar(45) COLLATE "pg_catalog"."default"  NOT NULL
);

DROP TABLE IF EXISTS "public"."pizza";
CREATE TABLE "public"."pizza"
(
    "id"          BIGSERIAL                                   NOT NULL PRIMARY KEY,
    "name"        varchar(45) COLLATE "pg_catalog"."default"  NOT NULL,
    "description" varchar(500) COLLATE "pg_catalog"."default" NOT NULL,
    "price"       DECIMAL(10, 2)                              NOT NULL,
    "weight"      decimal                                     NOT NULL
)
;

DROP TABLE IF EXISTS "public"."order";
CREATE TABLE "public"."order"
(
    "id"       BIGSERIAL                                   NOT NULL PRIMARY KEY,
    "user_id"  int4                                        NOT NULL REFERENCES "public"."user" (id) ON DELETE CASCADE,
    "comment"  varchar(200) COLLATE "pg_catalog"."default" NOT NULL,
    "date"     date                                        NOT NULL,
    "isClosed" boolean                                     NOT NULL,
    "amount"   DECIMAL(10, 2)                              NOT NULL
)
;

DROP TABLE IF EXISTS "public"."order_pizza";
CREATE TABLE "public"."order_pizza"
(
    "quantity" int4 NOT NULL,
    "order_id" int4 NOT NULL REFERENCES "public"."order" (id) ON DELETE CASCADE,
    "pizza_id" int4 NOT NULL REFERENCES "public"."pizza" (id) ON DELETE CASCADE
)
;