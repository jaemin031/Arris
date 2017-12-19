

DROP TABLE jobInfo;

CREATE TABLE jobInfo(
	jobName  	VARCHAR2(10)   	PRIMARY KEY,  -- ������
	jobPart  	VARCHAR2(10)   	NOT NULL, -- ���� �з�
);

DROP TABLE jobs;

CREATE TABLE jobs(
	jobNum		NUMBER(1)   	PRIMARY KEY,    -- ���� id
	jobsPort	VARCHAR2(4)			--���� ä�� ��Ʈ��ȣ
	jobPart		VARCHAR2(10)	REFERENCES jobInfo(jobPart)  -- ���� �з�
);

DROP TABLE hireInfo;

CREATE TABLE hireInfo(
	num		NUMBER(3) 		PRIMARY KEY,	-- �� ��ȣ
	wage		NUMBER(10)		NOT NULL,		-- �ñ�
	insuCheck	VARCHAR2(1)		default 'N',	-- ���谡�� ����
	vioCheck	VARCHAR2(1)		default 'N',	-- ���� ����
	fireCheck	VARCHAR2(1)		default 'N',	-- �δ� �ذ�
	payMoney	NUMBER(15)		default 0,		-- �Ǽ��ɾ�
	d_day		NUMBER(5) 		default 0,		-- ����(�� �ϼ�)
	e_day		NUMBER(5) 		default 0,		-- �ָ�(�� �ϼ�)
	d_time		NUMBER(8) 		default 0,		-- �ְ�(�� �ð�)
	n_time		NUMBER(8) 		default 0,		-- �߰�(�� �ð�)
	jobNum  	NUMBER(1)		REFERENCES jobs(jobNum)  -- ���� id
);

DROP TABLE Users;

CREATE TABLE Users(
		id		VARCHAR2(10)	PRIMARY KEY,			-- ID
		pw		VARCHAR2(10)	NOT NULL				-- PW
		name		VARCHAR2(10) 	NOT NULL,				-- �̸�
		gender 		VARCHAR2(1)		default 'M',			-- ����
		birthDate	DATE			NOT NULL,		-- �������
		num			NUMBER(3)		distinct REFERENCES hireInfo(num)  -- ����ȣ
);

DROP TABLE LawCategory;

CREATE TABLE LawCategory {
			LC_Number NUMBER	PRIMARY KEY,	--���׹�ȣ
			Name	  VARCHAR2(10)	NOT NULL	--�����̸�
};

DROP TABLE LawInfo;

CREATE TABLE LawInfo {
		     Article	VARCHAR2(10)	PRIMARY KEY,			--����
		     Explain	VARCHAR2(300)	NOT NULL,			--����
		     Fine	NUMBER		default 0,			--����
		     Penalty	VARCHAR2(10),					--ó��
		     LC_Numver	NUMBER REFERENCES LawCategory(LC_Number)	--���׹�ȣ
};

DROP TABLE Lawyer;

CREATE TABLE Lawyer{
			phone_number	VARCHAR2(10) PRIMARY KEY	-- ��ȭ��ȣ,
			name 		VARCHAR2(10) NOT NULL,		-- ��ȣ�� �̸�
			phrase		VARCHAR2(10) NOT NULL,		-- �Ѹ���
			workplace	VARCHAR2(10) NOT NULL,		-- �繫��
			LC_Number	NUMBER	REFERENCES LawCategory(LC_Number)	--���׹�ȣ		
};

---------------------------------------------------------
CREATE or replace TRIGGER num_add
BEFORE insert on Users
for each row
begin
			update :new set num = nvl2((select max(num) from Users),max(num)+1,1);  -- ����ȣ ���
end ;
/
------------------------------------------------------------------------------------------------------------

INSERT INTO jobInfo VALUES ('�Ϲ�������/�н�ƮǪ����','��ľ�');
INSERT INTO jobInfo VALUES ('ī��/����Ŀ��','��ľ�');
INSERT INTO jobInfo VALUES ('ȣ��/��','��ľ�');
INSERT INTO jobInfo VALUES ('��Ÿ','��ľ�');
INSERT INTO jobInfo VALUES ('��ȭ��/��Ʈ','����/�Ǹ�');
INSERT INTO jobInfo VALUES ('������','����/�Ǹ�');
INSERT INTO jobInfo VALUES ('�Ƿ�/��Ƽ','����/�Ǹ�');
INSERT INTO jobInfo VALUES ('��Ÿ','����/�Ǹ�');
INSERT INTO jobInfo VALUES ('����/�ֹ�','����');
INSERT INTO jobInfo VALUES ('���/�ù�','����');
INSERT INTO jobInfo VALUES ('��ȭ/����','����');
INSERT INTO jobInfo VALUES ('��Ÿ','����');
INSERT INTO jobInfo VALUES ('�繫����','�繫��');
INSERT INTO jobInfo VALUES ('�渮/��','�繫��');
INSERT INTO jobInfo VALUES ('�������','�繫��');
INSERT INTO jobInfo VALUES ('��Ÿ','�繫��');
INSERT INTO jobInfo VALUES ('�Խ�/�����п�','����');
INSERT INTO jobInfo VALUES ('��������','����');
INSERT INTO jobInfo VALUES ('��Ÿ','����');
INSERT INTO jobInfo VALUES ('����/�ð�','�Ǽ�/����');
INSERT INTO jobInfo VALUES ('����','�Ǽ�/����');
INSERT INTO jobInfo VALUES ('����/����','�Ǽ�/����');
INSERT INTO jobInfo VALUES ('��Ÿ','�Ǽ�/����');
INSERT INTO jobInfo VALUES ('���θ�/������','IT/������');
INSERT INTO jobInfo VALUES ('����/�Կ�','IT/������');
INSERT INTO jobInfo VALUES ('������','IT/������');
INSERT INTO jobInfo VALUES ('��Ÿ','IT/������');
INSERT INTO jobInfo VALUES ('�����/�ιٿ��','����');
INSERT INTO jobInfo VALUES ('�ڷ�������/�ƿ��ٿ��','����');
INSERT INTO jobInfo VALUES ('������/������','����');
INSERT INTO jobInfo VALUES ('��Ÿ','����');

INSERT INTO jobs VALUES (1,'9991','��ľ�');
INSERT INTO jobs VALUES (2,'9992','����/�Ǹ�');
INSERT INTO jobs VALUES (3,'9993','����');
INSERT INTO jobs VALUES (4,'9994','�繫��');
INSERT INTO jobs VALUES (5,'9995','����');
INSERT INTO jobs VALUES (6,'9996','�Ǽ�/����');
INSERT INTO jobs VALUES (7,'9997','IT/������');
INSERT INTO jobs VALUES (8,'9998','����');

INSERT INTO LawCategory VALUES (1,'�ӱ�ü��');
INSERT INTO LawCategory VALUES (2,'�ٷΰ�༭ ���ۼ�');
INSERT INTO LawCategory VALUES (3,'��������');
INSERT INTO LawCategory VALUES (4,'�����ӱ� ���ؼ�');
INSERT INTO LawCategory VALUES (5,'����/�ʰ����� ������');
INSERT INTO LawCategory VALUES (6,'�δ��ذ�');
INSERT INTO LawCategory VALUES (7,'�ӱݻ谨 �� ��Ÿ');
INSERT INTO LawCategory VALUES (8,'���ؼ���');

INSERT INTO Article VALUES ('74�� 2��','�ӱݻ谨','5�� �̻� ������� ���, ����ڴ� �ӽ��� �����ٷ��ڰ� �ӻ�� ����ǰ����ܽð��� ��� / �̷����� �ӱݻ谨�ϸ� �ȵȴ�.','500���� ����','',7);
INSERT INTO Article VALUES ('74�� 6��','�δ��ذ�','��������ް� ���� �Ŀ��� �ް� ���� ������ ���� �Ǵ� ������ ������ �ӱ��� �����ϴ� ������ ���ͽ��Ѿ��Ѵ�.','500���� ����','',6);
INSERT INTO Article VALUES ('56��','�ʰ�����','����ٷ�( 1�� 40�ð�, 1�� 8�ð�) �� �߰��ٷ�(10��~���� 6��) �Ǵ� ���ϱٷο� ���Ͽ��� ����ӱ��� 100���� 50 �̻��� �����Ͽ� �����Ͽ��� �Ѵ�','2000���� ����','3�� ����',5);
INSERT INTO Article VALUES ('79�� 1��','���غ���','��� �� ��� �ӱ��� 60% �޾� ���� ����   * ���޹��� �ݾ��� ������ ���� �ݾ��� �� �ݾ��� 60%','����ӱ� 60%','',1);
INSERT INTO Article VALUES ('81,82��','���غ���','������ ��� �� ����ӱ� 90�Ϻ��� ���Ǻ� ���� & �������� ����ӱ� 1000�� ��','����ӱ� 1090�Ϻ�','',1);
INSERT INTO Article VALUES ('7��','��������','����ڴ� ����, ����, ����, �� �ۿ� ���Ż� �Ǵ� ��ü���� ������ �δ��ϰ� �����ϴ� �������ν� �ٷ����� �����ǻ翡 ��߳��� �ٷθ� �������� ���Ѵ�.','5õ���� ����','5�� ����',3);
INSERT INTO Article VALUES ('8��','��������','����ڴ� ����� �߻��̳� �� ���� ��� �����ε� �ٷ��ڿ��� ������ ���� ���Ѵ�.','5õ���� ����','5�� ����',3);
INSERT INTO Article VALUES ('17��','�ٷΰ����ۼ�','����ڴ� �ٷΰ�� ü��ÿ� �ӱ�, �����ٷνð�, ����, �ٷ������� ����ؾ� �Ѵ�.','500���� ����','',2);
INSERT INTO Article VALUES ('67�� 2��','�ٷΰ����ۼ�','ģ���ڳ� �̼����İ����� �̼������� �ٷΰ���� �븮�� �� ����. �̿� ������ �ڴ� ó���� �޴´�.','500���� ����','',2);
INSERT INTO Article VALUES ('67�� 3��','�ٷΰ����ۼ�','����ڴ� 18�� �̸��� �ڿ� �ٷΰ���� ü���ϴ� ��쿡�� �ӱ�, �ٹ��ð�, �ް��� ��õ� �ٷ������� �������� �����Ͽ��� �Ѵ�','500���� ����','',2);
INSERT INTO Article VALUES ('23�� 2��','�δ��ذ�','����ڴ� �ٷ��ڰ� ������ �λ� �Ǵ� ������ ����� ���Ͽ� �޾��� �Ⱓ�� �� �� 30�� ������ �ذ����� ���Ѵ�','','',6);
INSERT INTO Article VALUES ('24�� 3��','�δ��ذ�','����ڴ� �濵�� ������ ���� �ذ� ���ϱ� ���� �뵿������ �ִ� ��쿡�� �ذ� �Ϸ��� ���� 50�� ������ �뺸�ϰ� �����ϰ� �����Ͽ��� �Ѵ�','�ش� ����','',6);
INSERT INTO Article VALUES ('26��','�δ��ذ�','����ڴ� �ٷ��ڸ� �ذ��Ϸ��� ��� 30�� ���� ���� �Ͽ��� �Ѵ� ����, 30�� ���� ���� ���� �ƴ��Ͽ��� ������ 30�Ϻ� �̻��� ����ӱ��� �����Ͽ��� �Ѵ�','�ش� ����','',6);
INSERT INTO Article VALUES ('27��','�δ��ذ�','5�� �̻� ������� ���, ����ڴ� �ٷ��ڸ� �ذ��Ϸ��� �ذ������ �ذ�ñ⸦ �������� �����Ͽ��� �Ѵ�.','','',6);
INSERT INTO Article VALUES ('28��','�δ��ذ�','5�� �̻� ������� ���, ����ڰ� �ٷ��ڿ��� �δ��ذ���� �ϸ� �ٷ��ڴ� �뵿����ȸ�� ������ ��û�� �� ������ �̷��� ������û�� �δ��ذ���� �־��� ������ 3���� �̳��� �Ͽ��� �Ѵ�','','',6);
INSERT INTO Article VALUES ('34��','�ӱ�ü��','1�� �̻� ��ӱٷ��� ���� ��� �����(����Ը�� �������)�κ��� �������� ���޹��� �ǹ��� �߻��Ѵ�.','','',1);
INSERT INTO Article VALUES ('36��','�ӱ�ü��','����ڴ� �ٷ��ڰ� ��� �Ǵ� ������ ��쿡�� �� ���� ������ �߻��� ������ 14�� �̳��� �ӱ�, �����, �� �ۿ� ��ü�� ��ǰ�� �����Ͽ��� �Ѵ�','2000���� ����','',1);
INSERT INTO Article VALUES ('43��','�ӱ�ü��',' ����ڰ� �ٷ��ڿ��� ������ ���� �ִٰ� �ص� ����ڴ� �ϴ� �ٷ��ڿ��� �ӱ����θ� �����ؾ��Ѵ�.','','',1);
INSERT INTO Article VALUES ('44��','�ӱ�ü��','����ڴ� �ٷ��ڰ� ���, ����, ����, ȥ��, ���, ������� ��뿡 ����ϱ� ���Ͽ� �ӱ� ������ û���ϸ� ���ޱ��� ���̶� �̹� ������ �ٷο� ���� �ӱ��� �����Ͽ��� �Ѵ�','1000���� ����','',1);
INSERT INTO Article VALUES ('45��','�ӱ�ü��','5�� �̻� ������� ���, ����ڰ� å������ �ϴ� ������ �޾��ϴ� ��쿡 ����ڴ� �޾��Ⱓ ���� �� �ٷ��ڿ��� ����ӱ��� 100���� 70 �̻��� ������ �����Ͽ��� �Ѵ�.','2000���� ����','3�� ����',1);
INSERT INTO Article VALUES ('46�� 1��','�ӱ�ü��','����� ���� ������ ���޿� ���� ���Ͽ����� ��쿡 �ϼ������� ����������� ��å������ �ٷ��ڿ��� �ӱ��� �������� ���� ��쿡�� �� ���� �������� �� �ϼ����ΰ� �����Ͽ� å���� ����','2000���� ����','3�� ����',1);
INSERT INTO Article VALUES ('49��','�ӱ�ü��','�� ���� ���� �ӱ�ä���� 3�Ⱓ ������� �ƴ��ϸ� ��ȿ�� �Ҹ��Ѵ�','','',1);
INSERT INTO Article VALUES ('56��','�ӱ�ü��','����ڴ� ����ٷ�( 1�� 40�ð�, 1�� 8�ð�)�� �߰��ٷ�(10��~6��) �Ǵ� ���ϱٷο� ���Ͽ��� ����ӱ��� 100���� 50 �̻��� �����Ͽ� �����Ͽ��� �Ѵ�','2000���� ����','3�� ����',1);
INSERT INTO Article VALUES ('60��','�ӱ�ü��','����ڴ� ����Ͽ� �ٷ��� �Ⱓ�� 1�� �̸��� �ٷ��� �Ǵ� 1�Ⱓ 80�ۼ�Ʈ �̸� ����� �ٷ��ڿ��� 1���� ���� �� 1���� �����ް��� �־�� �Ѵ�.','1000���� ����','2�� ����',1);
INSERT INTO Article VALUES ('6�� 1��','�����ӱ� ���ؼ�','����ڴ� �����ӱ��� ������ �޴� �ٷ��ڿ��� �����ӱݾ� �̻��� �ӱ��� �����Ͽ��� �Ѵ� (�����ӱݹ�)','2000���� ����','3�� ����',4);

INSERT INTO Lawyer VALUES ('02-551-2210','������','������б� ��������/ SBS / KBS / ����ڹ�','��������(����) �ѱ�',6);
INSERT INTO Lawyer VALUES ('02-599-0878','�۸�ȣ','�� �������� ��ȭ ��ǥ ��ȣ��','�������� ��ȭ',6);
INSERT INTO Lawyer VALUES ('070-4291-8351','���¿�','������ �ּ��� ���� �Ƿ����� ����� �ذ��ص帮�ڽ��ϴ�.','��ȣ�����¿�����繫��',6);
INSERT INTO Lawyer VALUES ('02-522-5959','����','�������� ȿ�� ��ȣ��','�������� ȿ��',8);
INSERT INTO Lawyer VALUES ('02-842-4777','�彽��','�����繫�� �������� ��ȣ��','��ȣ���彽������繫��',8);
INSERT INTO Lawyer VALUES ('050-7725-0324','���','�����û ������㺯ȣ��',' ��ȣ���������繫��',8);
INSERT INTO Lawyer VALUES ('02-599-0878','�۸�ȣ','��ȭ ���� ���� / ������û �ڹ�','�������� �����մϴ�',7);
INSERT INTO Lawyer VALUES ('050-7725-0386','�̹���','�Ƿ����� �������� ���������� �������񽺸� �����մϴ�.','�����繫�� ����',7);
INSERT INTO Lawyer VALUES ('050-7725-0687','���ּ�','�� ����û �ڹ� ��ȣ��','��ȣ�����ּ������繫��',7);
INSERT INTO Lawyer VALUES ('050-7725-0293','������','�ñ��� ���� �����ϰ� ģ���ϰ� ����� �帳�ϴ�.','���������繫�� ����Ʈ',5);
INSERT INTO Lawyer VALUES ('060-900-0497','�̼���','���ǰ� �ŷڸ� �������� �������� ���������� �ּ��� ���� ���͵帮�ڽ��ϴ�.','��ȣ���̼�������繫��',5);
INSERT INTO Lawyer VALUES ('063-271-8286','������','������ �����繫�� ��ȣ��','��ȣ�繮���������繫��',5);
INSERT INTO Lawyer VALUES ('050-7725-0208','������','����� ����ó�� ����� ���� �Ǿ� �帮�ڽ��ϴ�.','�������� ����������',1);
INSERT INTO Lawyer VALUES ('050-7725-0500','����ȣ','�Ƿ��β��� ���� ���� ������ �Ͻ� �� �ְ� �ص帳�ϴ�.',' ��ȣ�����ȣ�����繫��',1);
INSERT INTO Lawyer VALUES ('050-7725-0321','����ȣ','�ּ��� ���ϴ� �̱�� ��ȣ�簡 �ǰڽ��ϴ�.','��ȣ�����ȣ�����繫��',1);
INSERT INTO Lawyer VALUES ('050-7725-0788','������','�Ƿ����� ������ �ּ����� ����� �����ڰ� �ǰڽ��ϴ�.','��ȣ�������ƹ����繫��',2);
INSERT INTO Lawyer VALUES ('050-7725-0670','�ֿ빮','�Ƿ����� ���忡�� �����ϰ� �ൿ�ϴ� �ֿ빮 ��ȣ���Դϴ�','�����ΰ� �������� ��ȣ',2);
INSERT INTO Lawyer VALUES ('050-7725-0383','�ǿ���','�ȳ��Ͻʴϱ� ����ϴ� ��ȣ�� �ǿ��� ��ȣ���Դϴ�.''�����ΰ� �������� ��ȣ',2);
INSERT INTO Lawyer VALUES ('050-7725-0231','������','���Ѻ��� �ε���, �뵿�� ������ȣ�� �������Դϴ�.','�������� ��ȿ',3);
INSERT INTO Lawyer VALUES ('050-7725-0458','��ġ��','�Ƿ����� ���忡�� �� �ϰ� ���� �ּ��� ���ϰڽ��ϴ�.','��ȣ����ġ�չ����繫��',3);
INSERT INTO Lawyer VALUES ('050-7725-0740','����','������ ���� ���� ���ϴ� ����� �����մϴ�.','�������� �︲',3);
INSERT INTO Lawyer VALUES ('050-7725-0583','�����','��ǿ� ������ ���ؼ� ������ �帮�ڽ��ϴ�.','��ȣ������¹����繫��',4);
INSERT INTO Lawyer VALUES ('050-7725-2017','�̱���','��û�� ���� ���Ǵ� ��û���� ���۵ȴٰ� �Ͻ��ϴ�','��ȣ���̱�ä�����繫��',4);
INSERT INTO Lawyer VALUES ('050-7725-0530','�賲��','�빫�� ��� ��ȣ���Դϴ�.','�����ΰ� �������� ��ȣ',4);