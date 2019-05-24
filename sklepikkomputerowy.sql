--------------------------------------------------------
--  File created - czwartek-maja-23-2019   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence SEQ_CAT
--------------------------------------------------------

   CREATE SEQUENCE  "SYS"."SEQ_CAT"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Table PODKATEGORIE
--------------------------------------------------------

  CREATE TABLE "SYS"."PODKATEGORIE" 
   (	"ID_PODKATEGORII" NUMBER(10,0), 
	"NAZWA_PODKATEGORII" VARCHAR2(255 CHAR), 
	"KATEGORIE_ID_KATEGORII" NUMBER(10,0)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table KATEGORIE
--------------------------------------------------------

  CREATE TABLE "SYS"."KATEGORIE" 
   (	"ID_KATEGORII" NUMBER(10,0), 
	"NAZWA_KATEGORII" VARCHAR2(255 CHAR)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table PRACOWNICY
--------------------------------------------------------

  CREATE TABLE "SYS"."PRACOWNICY" 
   (	"ID_PRACOWNIKA" NUMBER(10,0), 
	"HASLO" VARCHAR2(255 CHAR), 
	"LOGIN" VARCHAR2(255 CHAR)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table PRODUCENT
--------------------------------------------------------

  CREATE TABLE "SYS"."PRODUCENT" 
   (	"ID_PRODUCENTA" NUMBER(10,0), 
	"NAZWA_PRODUCENTA" VARCHAR2(255 CHAR)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table PRODUKTY
--------------------------------------------------------

  CREATE TABLE "SYS"."PRODUKTY" 
   (	"ID_PRODUKTU" NUMBER(10,0), 
	"CENA_PRODUKTU" FLOAT(126), 
	"NAZWA_PRODUKTU" VARCHAR2(255 CHAR), 
	"OPIS_PRODUKTU" VARCHAR2(255 CHAR), 
	"PARAMETRY_PRODUKTU" VARCHAR2(255 CHAR), 
	"ZDJECIE_PRODUKTU" BLOB, 
	"PODKATEGORIE_ID_PODKATEGORII" NUMBER(10,0), 
	"PRODUCENT_ID_PRODUCENTA" NUMBER(10,0)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" 
 LOB ("ZDJECIE_PRODUKTU") STORE AS BASICFILE (
  TABLESPACE "SYSTEM" ENABLE STORAGE IN ROW CHUNK 8192 RETENTION 
  NOCACHE LOGGING 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)) ;
--------------------------------------------------------
--  DDL for Table UZYTKOWNICY
--------------------------------------------------------

  CREATE TABLE "SYS"."UZYTKOWNICY" 
   (	"ID_UZYTKOWNIKA" NUMBER(10,0), 
	"HASLO" VARCHAR2(255 CHAR), 
	"IMIE" VARCHAR2(255 CHAR), 
	"LOGIN" VARCHAR2(255 CHAR), 
	"NAZWISKO" VARCHAR2(255 CHAR)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table ZAMOWIENIA
--------------------------------------------------------

  CREATE TABLE "SYS"."ZAMOWIENIA" 
   (	"ID_ZAMOWIENIA" NUMBER(10,0), 
	"STATUS_ZAMOWIENIA" VARCHAR2(255 CHAR), 
	"PRODUKT_ID_PRODUKTU" NUMBER(10,0), 
	"UZYTKOWNIK_ID_UZYTKOWNIKA" NUMBER(10,0)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into SYS.PODKATEGORIE
SET DEFINE OFF;
Insert into SYS.PODKATEGORIE (ID_PODKATEGORII,NAZWA_PODKATEGORII,KATEGORIE_ID_KATEGORII) values ('3','Telewizory','1');
Insert into SYS.PODKATEGORIE (ID_PODKATEGORII,NAZWA_PODKATEGORII,KATEGORIE_ID_KATEGORII) values ('1','Procesory','2');
Insert into SYS.PODKATEGORIE (ID_PODKATEGORII,NAZWA_PODKATEGORII,KATEGORIE_ID_KATEGORII) values ('2','P³yty g³ówne','2');
REM INSERTING into SYS.KATEGORIE
SET DEFINE OFF;
Insert into SYS.KATEGORIE (ID_KATEGORII,NAZWA_KATEGORII) values ('2','Podzespo³y Komputerowe');
Insert into SYS.KATEGORIE (ID_KATEGORII,NAZWA_KATEGORII) values ('4','Gry komputerowe');
Insert into SYS.KATEGORIE (ID_KATEGORII,NAZWA_KATEGORII) values ('1','RTV');
Insert into SYS.KATEGORIE (ID_KATEGORII,NAZWA_KATEGORII) values ('3','G³oœniki');
REM INSERTING into SYS.PRACOWNICY
SET DEFINE OFF;
Insert into SYS.PRACOWNICY (ID_PRACOWNIKA,HASLO,LOGIN) values ('1','supcioadmin123.','superadmin');
REM INSERTING into SYS.PRODUCENT
SET DEFINE OFF;
Insert into SYS.PRODUCENT (ID_PRODUCENTA,NAZWA_PRODUCENTA) values ('3','Samsung');
Insert into SYS.PRODUCENT (ID_PRODUCENTA,NAZWA_PRODUCENTA) values ('4','ASrock');
Insert into SYS.PRODUCENT (ID_PRODUCENTA,NAZWA_PRODUCENTA) values ('1','AMD');
Insert into SYS.PRODUCENT (ID_PRODUCENTA,NAZWA_PRODUCENTA) values ('2','Intel');
REM INSERTING into SYS.PRODUKTY
SET DEFINE OFF;
Insert into SYS.PRODUKTY (ID_PRODUKTU,CENA_PRODUKTU,NAZWA_PRODUKTU,OPIS_PRODUKTU,PARAMETRY_PRODUKTU,PODKATEGORIE_ID_PODKATEGORII,PRODUCENT_ID_PRODUCENTA) values ('3','349','X370 Pro4','Stabilna p³yta g³ówna pod AM4','X370, PCI 3.0','2','4');
Insert into SYS.PRODUKTY (ID_PRODUKTU,CENA_PRODUKTU,NAZWA_PRODUKTU,OPIS_PRODUKTU,PARAMETRY_PRODUKTU,PODKATEGORIE_ID_PODKATEGORII,PRODUCENT_ID_PRODUCENTA) values ('1','629,99','Ryzen 2600X','Super szybki wydajny procesor!','6C/12T, 3,6@GHZ','1','1');
Insert into SYS.PRODUKTY (ID_PRODUKTU,CENA_PRODUKTU,NAZWA_PRODUKTU,OPIS_PRODUKTU,PARAMETRY_PRODUKTU,PODKATEGORIE_ID_PODKATEGORII,PRODUCENT_ID_PRODUCENTA) values ('2','2999','NU8002','Doznania w 4K HDR pe³n¹ par¹','4K, HDR, 55Cali','3','3');
REM INSERTING into SYS.UZYTKOWNICY
SET DEFINE OFF;
Insert into SYS.UZYTKOWNICY (ID_UZYTKOWNIKA,HASLO,IMIE,LOGIN,NAZWISKO) values ('1','lolek','Janusz','kupiec1','Nosacz');
Insert into SYS.UZYTKOWNICY (ID_UZYTKOWNIKA,HASLO,IMIE,LOGIN,NAZWISKO) values ('2','1234ktos','Antoni','kupiec2','Siebroni');
REM INSERTING into SYS.ZAMOWIENIA
SET DEFINE OFF;
Insert into SYS.ZAMOWIENIA (ID_ZAMOWIENIA,STATUS_ZAMOWIENIA,PRODUKT_ID_PRODUKTU,UZYTKOWNIK_ID_UZYTKOWNIKA) values ('3','Nowy','2','2');
Insert into SYS.ZAMOWIENIA (ID_ZAMOWIENIA,STATUS_ZAMOWIENIA,PRODUKT_ID_PRODUKTU,UZYTKOWNIK_ID_UZYTKOWNIKA) values ('1','Nowy','1','1');
Insert into SYS.ZAMOWIENIA (ID_ZAMOWIENIA,STATUS_ZAMOWIENIA,PRODUKT_ID_PRODUKTU,UZYTKOWNIK_ID_UZYTKOWNIKA) values ('2','Wyslany','3','1');
--------------------------------------------------------
--  DDL for Index SYS_C007601
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS"."SYS_C007601" ON "SYS"."PODKATEGORIE" ("ID_PODKATEGORII") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index SYS_C007599
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS"."SYS_C007599" ON "SYS"."KATEGORIE" ("ID_KATEGORII") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index SYS_C007603
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS"."SYS_C007603" ON "SYS"."PRACOWNICY" ("ID_PRACOWNIKA") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index SYS_C007605
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS"."SYS_C007605" ON "SYS"."PRODUCENT" ("ID_PRODUCENTA") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index SYS_C007607
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS"."SYS_C007607" ON "SYS"."PRODUKTY" ("ID_PRODUKTU") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index SYS_C007609
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS"."SYS_C007609" ON "SYS"."UZYTKOWNICY" ("ID_UZYTKOWNIKA") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index SYS_C007611
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS"."SYS_C007611" ON "SYS"."ZAMOWIENIA" ("ID_ZAMOWIENIA") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Procedure AUTHADMIN
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "SYS"."AUTHADMIN" (
rekordy OUT SYS_REFCURSOR,
logg IN pracownicy.login%TYPE,
pa  IN pracownicy.haslo%TYPE
)AS
BEGIN 
  OPEN rekordy FOR
  SELECT id_pracownika from Pracownicy where login = logg and haslo = pa;
END AUTHADMIN;

/
--------------------------------------------------------
--  DDL for Procedure AUTHUSER
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "SYS"."AUTHUSER" (
rekordy OUT SYS_REFCURSOR,
logg IN uzytkownicy.login%TYPE,
pa  IN uzytkownicy.haslo%TYPE
)AS
BEGIN 
  OPEN rekordy FOR
  SELECT id_uzytkownika from UZYTKOWNICY where login = logg and haslo = pa;
END AUTHUSER;

/
--------------------------------------------------------
--  DDL for Procedure BUYPRODUCT
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "SYS"."BUYPRODUCT" 
(
id_produktu IN zamowienia.produkt_id_produktu%TYPE,
id_uzytkownika IN zamowienia.uzytkownik_id_uzytkownika%TYPE)
AS 
BEGIN
    INSERT INTO Zamowienia 
    (id_zamowienia,status_zamowienia, produkt_id_produktu, uzytkownik_id_uzytkownika) 
    VALUES
    ((select NVL(MAX(id_zamowienia),0)+1 from Zamowienia),'Nowy', id_produktu, id_uzytkownika);

END BUYPRODUCT;

/
--------------------------------------------------------
--  DDL for Procedure CHANGEORDERSTATUS
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "SYS"."CHANGEORDERSTATUS" 
(ajdi IN zamowienia.id_zamowienia%TYPE,
status IN zamowienia.status_zamowienia%TYPE)
AS 
BEGIN

  UPDATE Zamowienia SET status_zamowienia = status where id_zamowienia = ajdi;
  COMMIT;
  
END CHANGEORDERSTATUS;

/
--------------------------------------------------------
--  DDL for Procedure DELETECAT
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "SYS"."DELETECAT" (nazwa IN kategorie.id_kategorii%TYPE) AS 
BEGIN
  DELETE Kategorie WHERE nazwa = id_kategorii;
  COMMIT;
END DELETECAT;

/
--------------------------------------------------------
--  DDL for Procedure DELETEPROD
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "SYS"."DELETEPROD" (nazwa IN producent.id_producenta%TYPE) AS 
BEGIN
  DELETE Producent WHERE nazwa = id_producenta;
  COMMIT;
END DELETEPROD;

/
--------------------------------------------------------
--  DDL for Procedure DELETEPRODUCT
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "SYS"."DELETEPRODUCT" (nazwa IN produkty.id_produktu%TYPE) AS 
BEGIN
  DELETE Produkty WHERE nazwa = id_produktu;
  COMMIT;
END DELETEPRODUCT;

/
--------------------------------------------------------
--  DDL for Procedure DELETEUNDERCAT
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "SYS"."DELETEUNDERCAT" (nazwa IN podkategorie.id_podkategorii%TYPE) AS 
BEGIN
  DELETE Podkategorie WHERE nazwa = id_podkategorii;
  COMMIT;
END DELETEUNDERCAT;

/
--------------------------------------------------------
--  DDL for Procedure GETCAT
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "SYS"."GETCAT" 
(rekordy OUT SYS_REFCURSOR)
AS 
BEGIN
OPEN rekordy FOR
SELECT id_kategorii, nazwa_kategorii FROM Kategorie;
END GETCAT;

/
--------------------------------------------------------
--  DDL for Procedure GETORDERADMIN
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "SYS"."GETORDERADMIN" 
(rekordy OUT SYS_REFCURSOR)

AS 
BEGIN
    OPEN rekordy FOR
        SELECT p.nazwa_produktu, u.imie, u.nazwisko, z.status_zamowienia, z.id_zamowienia
        FROM ZAMOWIENIA z, Produkty p, Uzytkownicy u 
        WHERE z.produkt_id_produktu = p.id_produktu AND z.uzytkownik_id_uzytkownika = u.id_uzytkownika;
END GETORDERADMIN;

/
--------------------------------------------------------
--  DDL for Procedure GETORDERUSER
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "SYS"."GETORDERUSER" 
(rekordy OUT SYS_REFCURSOR, liczba IN INTEGER)
AS 
BEGIN
    
    OPEN rekordy FOR

        SELECT p.nazwa_produktu, p.cena_produktu, z.status_zamowienia
        FROM Produkty p, Zamowienia z
        WHERE z.produkt_id_produktu = p.id_produktu AND z.uzytkownik_id_uzytkownika = liczba;

END GETORDERUSER;

/
--------------------------------------------------------
--  DDL for Procedure GETPRODUCENT
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "SYS"."GETPRODUCENT" 
(rekordy OUT SYS_REFCURSOR)
AS 
BEGIN
    OPEN rekordy FOR
        SELECT id_producenta, nazwa_producenta FROM Producent;
END GETPRODUCENT;

/
--------------------------------------------------------
--  DDL for Procedure GETPRODUCT
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "SYS"."GETPRODUCT" 
(rekordy OUT SYS_REFCURSOR)
AS 
BEGIN
    OPEN rekordy FOR
        SELECT pr.id_produktu, pr.nazwa_produktu, pr.opis_produktu, pr.parametry_produktu, pr.zdjecie_produktu, pr.cena_produktu, p.kategorie_id_kategorii, k.nazwa_kategorii, p.id_podkategorii, p.nazwa_podkategorii, pro.id_producenta, pro.nazwa_producenta
        FROM Podkategorie p, Produkty pr, Producent pro, Kategorie k
        WHERE pr.podkategorie_id_podkategorii = p.id_podkategorii AND pr.producent_id_producenta = pro.id_producenta AND p.kategorie_id_kategorii = k.id_kategorii;
END GETPRODUCT;

/
--------------------------------------------------------
--  DDL for Procedure GETUNDERCAT
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "SYS"."GETUNDERCAT" 
(rekordy OUT SYS_REFCURSOR)
AS 
BEGIN
    OPEN rekordy FOR
        SELECT * 
        FROM Podkategorie p, Kategorie k
        WHERE p.kategorie_id_kategorii = k.id_kategorii;
END GETUNDERCAT;

/
--------------------------------------------------------
--  DDL for Procedure INSERTCAT
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "SYS"."INSERTCAT" (nazwa IN kategorie.nazwa_kategorii%TYPE) AS 
BEGIN
  INSERT INTO
  Kategorie (nazwa_kategorii)
  VALUES(nazwa);
  COMMIT;
END INSERTCAT;

/
--------------------------------------------------------
--  DDL for Procedure INSERTPROD
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "SYS"."INSERTPROD" (nazwa IN producent.nazwa_producenta%TYPE) AS 
BEGIN
  INSERT INTO Producent (id_producenta,nazwa_producenta) VALUES((select NVL(MAX(id_producenta), 0)+1 from producent),nazwa);
  COMMIT;
END INSERTPROD;

/
--------------------------------------------------------
--  DDL for Procedure INSERTPRODUCT
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "SYS"."INSERTPRODUCT" (
cena IN produkty.cena_produktu%TYPE,
nazwa IN produkty.nazwa_produktu%TYPE,
opis IN produkty.opis_produktu%TYPE,
para IN produkty.parametry_produktu%TYPE,
zdj  IN produkty.zdjecie_produktu%TYPE,
underc IN produkty.podkategorie_id_podkategorii%TYPE,
prod IN produkty.producent_id_producenta%TYPE)AS 

BEGIN

    INSERT INTO Produkty(
    id_produktu,
    cena_produktu,
    nazwa_produktu,
    opis_produktu,
    parametry_produktu,
    zdjecie_produktu,
    podkategorie_id_podkategorii,
    producent_id_producenta)
    
    VALUES(
    (select NVL(MAX(id_produktu),0)+1 from produkty),
    cena,
    nazwa,
    opis,
    para,
    zdj,
    underc,
    prod);
    
    COMMIT;
END INSERTPRODUCT;

/
--------------------------------------------------------
--  DDL for Procedure INSERTUNDERCAT
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "SYS"."INSERTUNDERCAT" (nazwa in podkategorie.nazwa_podkategorii%TYPE,nazwa2 in podkategorie.kategorie_id_kategorii%TYPE) AS 
BEGIN
    INSERT INTO Podkategorie (id_podkategorii,nazwa_podkategorii,kategorie_id_kategorii) VALUES((select NVL(MAX(id_podkategorii),0)+1 from podkategorie),nazwa,nazwa2);
    COMMIT;
END INSERTUNDERCAT;

/
--------------------------------------------------------
--  DDL for Procedure SEARCHINGORDERADMIN
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "SYS"."SEARCHINGORDERADMIN" 
(rekordy OUT SYS_REFCURSOR,
searching IN zamowienia.status_zamowienia%TYPE)
AS 
BEGIN
  OPEN rekordy FOR
    SELECT p.nazwa_produktu, u.imie, u.nazwisko, z.status_zamowienia, z.id_zamowienia
    FROM ZAMOWIENIA z, Produkty p, Uzytkownicy u 
    WHERE
    (z.produkt_id_produktu = p.id_produktu AND z.uzytkownik_id_uzytkownika = u.id_uzytkownika)
    AND
    (INSTR(UPPER(z.status_zamowienia), UPPER(searching), 1) > 0 OR
    INSTR(UPPER(u.imie), UPPER(searching), 1) > 0 OR
    INSTR(UPPER(u.nazwisko), UPPER(searching), 1) > 0  OR
    INSTR(UPPER(p.nazwa_produktu), UPPER(searching), 1) > 0);
    
END SEARCHINGORDERADMIN;

/
--------------------------------------------------------
--  DDL for Procedure SEARCHINGORDERUSER
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "SYS"."SEARCHINGORDERUSER" 
(rekordy OUT SYS_REFCURSOR,
liczba IN INTEGER,
searching IN zamowienia.status_zamowienia%TYPE)
AS 
BEGIN
  OPEN rekordy FOR
    SELECT p.nazwa_produktu, p.cena_produktu, z.status_zamowienia
    FROM Produkty p, Zamowienia z
    WHERE
    (z.produkt_id_produktu = p.id_produktu AND z.uzytkownik_id_uzytkownika = liczba)
    AND
    (INSTR(UPPER(p.nazwa_produktu), UPPER(searching), 1) > 0 OR
    (INSTR(UPPER(z.status_zamowienia), UPPER(searching), 1) > 0));
END SEARCHINGORDERUSER;

/
--------------------------------------------------------
--  DDL for Procedure SEARCHINGPRODUCT
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "SYS"."SEARCHINGPRODUCT" 
(rekordy OUT SYS_REFCURSOR,
searching IN produkty.nazwa_produktu%TYPE)
AS
BEGIN
  OPEN rekordy FOR
    SELECT  pr.id_produktu, pr.nazwa_produktu, pr.opis_produktu, pr.parametry_produktu, pr.zdjecie_produktu, pr.cena_produktu, p.kategorie_id_kategorii, k.nazwa_kategorii, p.id_podkategorii, p.nazwa_podkategorii, pro.id_producenta, pro.nazwa_producenta    
    FROM Podkategorie p, Produkty pr, Producent pro, Kategorie k
    WHERE
    (pr.podkategorie_id_podkategorii = p.id_podkategorii AND pr.producent_id_producenta = pro.id_producenta AND p.kategorie_id_kategorii = k.id_kategorii) AND (
    INSTR(UPPER(pr.nazwa_produktu), UPPER(searching), 1) > 0 OR 
    INSTR(UPPER(k.nazwa_kategorii), UPPER(searching), 1) > 0 OR
    INSTR(UPPER(pro.nazwa_producenta), UPPER(searching), 1) > 0 OR
    INSTR(UPPER(p.nazwa_podkategorii), UPPER(searching), 1) > 0);
END SEARCHINGPRODUCT;

/
--------------------------------------------------------
--  DDL for Procedure UPDATECAT
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "SYS"."UPDATECAT" (
ajdi IN kategorie.id_kategorii%TYPE,
nazwa IN kategorie.nazwa_kategorii%TYPE
) AS 
BEGIN

  UPDATE Kategorie SET nazwa_kategorii = nazwa where id_kategorii = ajdi;
  COMMIT;
  
END UPDATECAT;

/
--------------------------------------------------------
--  DDL for Procedure UPDATEPROD
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "SYS"."UPDATEPROD" (
ajdi IN producent.id_producenta%TYPE,
nazwa IN producent.nazwa_producenta%TYPE
) AS 
BEGIN

  UPDATE Producent SET nazwa_producenta = nazwa where id_producenta = ajdi;
  COMMIT;
  
END UPDATEPROD;

/
--------------------------------------------------------
--  DDL for Procedure UPDATEPRODUCT
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "SYS"."UPDATEPRODUCT" (
ajdi IN produkty.id_produktu%TYPE,
cena IN produkty.cena_produktu%TYPE,
nazwa IN produkty.nazwa_produktu%TYPE,
opis IN produkty.opis_produktu%TYPE,
para IN produkty.parametry_produktu%TYPE,
zdj  IN produkty.zdjecie_produktu%TYPE,
underc IN produkty.podkategorie_id_podkategorii%TYPE,
prod IN produkty.producent_id_producenta%TYPE)AS 

BEGIN

    UPDATE Produkty SET
    cena_produktu = cena,
    nazwa_produktu = nazwa,
    opis_produktu = opis,
    parametry_produktu = para, 
    zdjecie_produktu = zdj,
    podkategorie_id_podkategorii = underc,
    producent_id_producenta = prod
    
    WHERE
    id_produktu = ajdi;
    
    COMMIT;
END UPDATEPRODUCT;

/
--------------------------------------------------------
--  DDL for Procedure UPDATEUNDERCAT
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "SYS"."UPDATEUNDERCAT" (
ajdi IN podkategorie.id_podkategorii%TYPE,
nazwa IN podkategorie.nazwa_podkategorii%TYPE,
kat IN podkategorie.kategorie_id_kategorii%TYPE
)AS 
BEGIN

  UPDATE Podkategorie SET
  nazwa_podkategorii = nazwa,
  kategorie_id_kategorii = kat 
  where id_podkategorii = ajdi;
  COMMIT;
  
END UPDATEUNDERCAT;

/
--------------------------------------------------------
--  DDL for Procedure VALUEORDERS
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "SYS"."VALUEORDERS" 
(rekordy OUT SYS_REFCURSOR,
id_uzytkownika IN zamowienia.uzytkownik_id_uzytkownika%TYPE)
AS 
BEGIN
  OPEN rekordy FOR
  SELECT SUM(p.cena_produktu) AS "wartosc"
  FROM Zamowienia z, Produkty p
  WHERE z.produkt_id_produktu = p.id_produktu AND z.status_zamowienia LIKE 'Wyslany' AND z.uzytkownik_id_uzytkownika = id_uzytkownika;
END VALUEORDERS;

/
--------------------------------------------------------
--  Constraints for Table PODKATEGORIE
--------------------------------------------------------

  ALTER TABLE "SYS"."PODKATEGORIE" MODIFY ("ID_PODKATEGORII" NOT NULL ENABLE);
  ALTER TABLE "SYS"."PODKATEGORIE" ADD PRIMARY KEY ("ID_PODKATEGORII")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Constraints for Table KATEGORIE
--------------------------------------------------------

  ALTER TABLE "SYS"."KATEGORIE" MODIFY ("ID_KATEGORII" NOT NULL ENABLE);
  ALTER TABLE "SYS"."KATEGORIE" ADD PRIMARY KEY ("ID_KATEGORII")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Constraints for Table PRACOWNICY
--------------------------------------------------------

  ALTER TABLE "SYS"."PRACOWNICY" MODIFY ("ID_PRACOWNIKA" NOT NULL ENABLE);
  ALTER TABLE "SYS"."PRACOWNICY" ADD PRIMARY KEY ("ID_PRACOWNIKA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Constraints for Table PRODUCENT
--------------------------------------------------------

  ALTER TABLE "SYS"."PRODUCENT" MODIFY ("ID_PRODUCENTA" NOT NULL ENABLE);
  ALTER TABLE "SYS"."PRODUCENT" ADD PRIMARY KEY ("ID_PRODUCENTA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Constraints for Table PRODUKTY
--------------------------------------------------------

  ALTER TABLE "SYS"."PRODUKTY" MODIFY ("ID_PRODUKTU" NOT NULL ENABLE);
  ALTER TABLE "SYS"."PRODUKTY" ADD PRIMARY KEY ("ID_PRODUKTU")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Constraints for Table UZYTKOWNICY
--------------------------------------------------------

  ALTER TABLE "SYS"."UZYTKOWNICY" MODIFY ("ID_UZYTKOWNIKA" NOT NULL ENABLE);
  ALTER TABLE "SYS"."UZYTKOWNICY" ADD PRIMARY KEY ("ID_UZYTKOWNIKA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Constraints for Table ZAMOWIENIA
--------------------------------------------------------

  ALTER TABLE "SYS"."ZAMOWIENIA" MODIFY ("ID_ZAMOWIENIA" NOT NULL ENABLE);
  ALTER TABLE "SYS"."ZAMOWIENIA" ADD PRIMARY KEY ("ID_ZAMOWIENIA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table PODKATEGORIE
--------------------------------------------------------

  ALTER TABLE "SYS"."PODKATEGORIE" ADD CONSTRAINT "FKFOCN6VUKX1532BHQSDCP932XW" FOREIGN KEY ("KATEGORIE_ID_KATEGORII")
	  REFERENCES "SYS"."KATEGORIE" ("ID_KATEGORII") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table PRODUKTY
--------------------------------------------------------

  ALTER TABLE "SYS"."PRODUKTY" ADD CONSTRAINT "FKEU9T9A1ELJDO2130UMKW90348" FOREIGN KEY ("PODKATEGORIE_ID_PODKATEGORII")
	  REFERENCES "SYS"."PODKATEGORIE" ("ID_PODKATEGORII") ENABLE;
  ALTER TABLE "SYS"."PRODUKTY" ADD CONSTRAINT "FKAUAYVRRDBN91GUW24I902NEGL" FOREIGN KEY ("PRODUCENT_ID_PRODUCENTA")
	  REFERENCES "SYS"."PRODUCENT" ("ID_PRODUCENTA") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table ZAMOWIENIA
--------------------------------------------------------

  ALTER TABLE "SYS"."ZAMOWIENIA" ADD CONSTRAINT "FK3HIL9V9ILA3HL7VU62AJJDNAN" FOREIGN KEY ("PRODUKT_ID_PRODUKTU")
	  REFERENCES "SYS"."PRODUKTY" ("ID_PRODUKTU") ENABLE;
  ALTER TABLE "SYS"."ZAMOWIENIA" ADD CONSTRAINT "FKBFXUE9AD3CHPEPRAA594O2LBE" FOREIGN KEY ("UZYTKOWNIK_ID_UZYTKOWNIKA")
	  REFERENCES "SYS"."UZYTKOWNICY" ("ID_UZYTKOWNIKA") ENABLE;
