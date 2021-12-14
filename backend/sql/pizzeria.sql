-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS "public"."role";
CREATE TABLE "public"."role" (
    "id" BIGSERIAL NOT NULL PRIMARY KEY,
    "name" VARCHAR(45) COLLATE "pg_catalog"."default" NOT NULL
);

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO "public"."role" ("name") VALUES ('Admin'), ('Client');


-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS "public"."user";
CREATE TABLE "public"."user" (
    "id" BIGSERIAL NOT NULL PRIMARY KEY,
    "name" varchar(45) COLLATE "pg_catalog"."default" NOT NULL,
    "password" varchar(500) COLLATE "pg_catalog"."default" NOT NULL,
    "role_id" int4 NOT NULL REFERENCES "public"."role"(id) ON DELETE CASCADE,
    "email" varchar(45) COLLATE "pg_catalog"."default" NOT NULL
);

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO "public"."user" ("name", "password", "role_id", "login") VALUES ('Administrator', '12345', 1, 'admin'), ('Ivan Ivanov', '12345', 2, 'Ivan');


-- ----------------------------
-- Table structure for pizza
-- ----------------------------
DROP TABLE IF EXISTS "public"."pizza";
CREATE TABLE "public"."pizza" (
  "id" BIGSERIAL NOT NULL PRIMARY KEY,
  "name" varchar(45) COLLATE "pg_catalog"."default" NOT NULL,
  "description" varchar(500) COLLATE "pg_catalog"."default" NOT NULL,
  "price" DECIMAL(10, 2) NOT NULL,
  "weight" decimal NOT NULL
)
;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS "public"."order";
CREATE TABLE "public"."order" (
  "id" BIGSERIAL NOT NULL PRIMARY KEY,
  "user_id" int4 NOT NULL REFERENCES "public"."user"(id) ON DELETE CASCADE,
  "comment" varchar(200) COLLATE "pg_catalog"."default" NOT NULL,
  "date" date NOT NULL,
  "isClosed" boolean NOT NULL,
  "amount" DECIMAL(10, 2) NOT NULL
)
;

-- ----------------------------
-- Table structure for order_pizza
-- ----------------------------
DROP TABLE IF EXISTS "public"."order_pizza";
CREATE TABLE "public"."order_pizza" (
  "quantity" int4 NOT NULL,
  "order_id" int4 NOT NULL REFERENCES "public"."order"(id) ON DELETE CASCADE,
  "pizza_id" int4 NOT NULL REFERENCES "public"."pizza"(id) ON DELETE CASCADE
)
;

-- ----------------------------
-- Records of order_pizza
-- ----------------------------
INSERT INTO "public"."order_pizza" ("quantity", "pizza_id", "order_id") VALUES (2, '3', '1');
