BEGIN;
DROP TABLE IF EXISTS PRICES;
CREATE TABLE PRICES(ID LONG NOT NULL AUTO_INCREMENT,BRAND_ID NUMBER(2,0),START_DATE TIMESTAMP,END_DATE TIMESTAMP,PRICE_LIST NUMBER(10,2),PRODUCT_ID NUMBER(10,0),PRIORITY NUMBER(2,0),PRICE NUMBER(10,2),CURR VARCHAR(50),PRIMARY KEY (ID));
COMMIT;