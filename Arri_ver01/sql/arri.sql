

DROP TABLE jobInfo;

CREATE TABLE jobInfo(
	jobName  	VARCHAR2(10)   	PRIMARY KEY,  -- 직종명
	jobPart  	VARCHAR2(10)   	NOT NULL, -- 직종 분류
);

DROP TABLE jobs;

CREATE TABLE jobs(
	jobNum		NUMBER(1)   	PRIMARY KEY,    -- 직종 id
	jobsPort	VARCHAR2(4)			--업종 채팅 포트번호
	jobPart		VARCHAR2(10)	REFERENCES jobInfo(jobPart)  -- 직종 분류
);

DROP TABLE hireInfo;

CREATE TABLE hireInfo(
	num		NUMBER(3) 		PRIMARY KEY,	-- 고객 번호
	wage		NUMBER(10)		NOT NULL,		-- 시급
	insuCheck	VARCHAR2(1)		default 'N',	-- 보험가입 여부
	vioCheck	VARCHAR2(1)		default 'N',	-- 폭력 행위
	fireCheck	VARCHAR2(1)		default 'N',	-- 부당 해고
	payMoney	NUMBER(15)		default 0,		-- 실수령액
	d_day		NUMBER(5) 		default 0,		-- 평일(총 일수)
	e_day		NUMBER(5) 		default 0,		-- 주말(총 일수)
	d_time		NUMBER(8) 		default 0,		-- 주간(총 시간)
	n_time		NUMBER(8) 		default 0,		-- 야간(총 시간)
	jobNum  	NUMBER(1)		REFERENCES jobs(jobNum)  -- 직종 id
);

DROP TABLE Users;

CREATE TABLE Users(
		id		VARCHAR2(10)	PRIMARY KEY,			-- ID
		pw		VARCHAR2(10)	NOT NULL				-- PW
		name		VARCHAR2(10) 	NOT NULL,				-- 이름
		gender 		VARCHAR2(1)		default 'M',			-- 성별
		birthDate	DATE			NOT NULL,		-- 생년월일
		num			NUMBER(3)		distinct REFERENCES hireInfo(num)  -- 고객번호
);

DROP TABLE LawCategory;

CREATE TABLE LawCategory {
			LC_Number NUMBER	PRIMARY KEY,	--조항번호
			Name	  VARCHAR2(10)	NOT NULL	--조항이름
};

DROP TABLE LawInfo;

CREATE TABLE LawInfo {
		     Article	VARCHAR2(10)	PRIMARY KEY,			--조항
		     Explain	VARCHAR2(300)	NOT NULL,			--설명
		     Fine	NUMBER		default 0,			--벌금
		     Penalty	VARCHAR2(10),					--처벌
		     LC_Numver	NUMBER REFERENCES LawCategory(LC_Number)	--조항번호
};

DROP TABLE Lawyer;

CREATE TABLE Lawyer{
			phone_number	VARCHAR2(10) PRIMARY KEY	-- 전화번호,
			name 		VARCHAR2(10) NOT NULL,		-- 변호사 이름
			phrase		VARCHAR2(10) NOT NULL,		-- 한마디
			workplace	VARCHAR2(10) NOT NULL,		-- 사무소
			LC_Number	NUMBER	REFERENCES LawCategory(LC_Number)	--조항번호		
};

---------------------------------------------------------
CREATE or replace TRIGGER num_add
BEFORE insert on Users
for each row
begin
			update :new set num = nvl2((select max(num) from Users),max(num)+1,1);  -- 고객번호 등록
end ;
/
------------------------------------------------------------------------------------------------------------

INSERT INTO jobInfo VALUES ('일반음식점/패스트푸드점','요식업');
INSERT INTO jobInfo VALUES ('카페/베이커리','요식업');
INSERT INTO jobInfo VALUES ('호프/바','요식업');
INSERT INTO jobInfo VALUES ('기타','요식업');
INSERT INTO jobInfo VALUES ('백화점/마트','유통/판매');
INSERT INTO jobInfo VALUES ('편의점','유통/판매');
INSERT INTO jobInfo VALUES ('의류/뷰티','유통/판매');
INSERT INTO jobInfo VALUES ('기타','유통/판매');
INSERT INTO jobInfo VALUES ('서빙/주방','서비스');
INSERT INTO jobInfo VALUES ('배달/택배','서비스');
INSERT INTO jobInfo VALUES ('문화/여가','서비스');
INSERT INTO jobInfo VALUES ('기타','서비스');
INSERT INTO jobInfo VALUES ('사무보조','사무직');
INSERT INTO jobInfo VALUES ('경리/비서','사무직');
INSERT INTO jobInfo VALUES ('공공기관','사무직');
INSERT INTO jobInfo VALUES ('기타','사무직');
INSERT INTO jobInfo VALUES ('입시/보습학원','교육');
INSERT INTO jobInfo VALUES ('보조강사','교육');
INSERT INTO jobInfo VALUES ('기타','교육');
INSERT INTO jobInfo VALUES ('공사/시공','건설/생산');
INSERT INTO jobInfo VALUES ('제조','건설/생산');
INSERT INTO jobInfo VALUES ('포장/선별','건설/생산');
INSERT INTO jobInfo VALUES ('기타','건설/생산');
INSERT INTO jobInfo VALUES ('쇼핑몰/웹서비스','IT/디자인');
INSERT INTO jobInfo VALUES ('피팅/촬영','IT/디자인');
INSERT INTO jobInfo VALUES ('디자인','IT/디자인');
INSERT INTO jobInfo VALUES ('기타','IT/디자인');
INSERT INTO jobInfo VALUES ('고객상담/인바운드','영업');
INSERT INTO jobInfo VALUES ('텔레마케팅/아웃바운드','영업');
INSERT INTO jobInfo VALUES ('세일즈/전단지','영업');
INSERT INTO jobInfo VALUES ('기타','영업');

INSERT INTO jobs VALUES (1,'9991','요식업');
INSERT INTO jobs VALUES (2,'9992','유통/판매');
INSERT INTO jobs VALUES (3,'9993','서비스');
INSERT INTO jobs VALUES (4,'9994','사무직');
INSERT INTO jobs VALUES (5,'9995','교육');
INSERT INTO jobs VALUES (6,'9996','건설/생산');
INSERT INTO jobs VALUES (7,'9997','IT/디자인');
INSERT INTO jobs VALUES (8,'9998','영업');

INSERT INTO LawCategory VALUES (1,'임금체불');
INSERT INTO LawCategory VALUES (2,'근로계약서 미작성');
INSERT INTO LawCategory VALUES (3,'폭력행위');
INSERT INTO LawCategory VALUES (4,'최저임금 미준수');
INSERT INTO LawCategory VALUES (5,'주휴/초과수당 미지급');
INSERT INTO LawCategory VALUES (6,'부당해고');
INSERT INTO LawCategory VALUES (7,'임금삭감 등 기타');
INSERT INTO LawCategory VALUES (8,'재해수당');

INSERT INTO Article VALUES ('74조 2항','임금삭감','5인 이상 사업장의 경우, 사용자는 임신한 여성근로자가 임산부 정기건강진단시간을 허용 / 이로인한 임금삭감하면 안된다.','500만원 이하','',7);
INSERT INTO Article VALUES ('74조 6항','부당해고','출산전후휴가 종료 후에는 휴가 전과 동일한 업무 또는 동등한 수준의 임금을 지급하는 직무에 복귀시켜야한다.','500만원 이하','',6);
INSERT INTO Article VALUES ('56조','초과수당','연장근로( 1주 40시간, 1일 8시간) 와 야간근로(10시~오전 6시) 또는 휴일근로에 대하여는 통상임금의 100분의 50 이상을 가산하여 지급하여야 한다','2000만원 이하','3년 이하',5);
INSERT INTO Article VALUES ('79조 1항','재해보상','요양 중 평균 임금의 60% 휴업 보상 지급   * 지급받은 금액이 있을시 받은 금액을 뺀 금액의 60%','평균임금 60%','',1);
INSERT INTO Article VALUES ('81,82조','재해보상','업무상 사망 시 평균임금 90일분의 장의비 지급 & 유족에게 평균임금 1000일 분','평균임금 1090일분','',1);
INSERT INTO Article VALUES ('7조','폭력행위','사용자는 폭행, 협박, 감금, 그 밖에 정신상 또는 신체상의 자유를 부당하게 구속하는 수단으로써 근로자의 자유의사에 어긋나는 근로를 강요하지 못한다.','5천만원 이하','5년 이하',3);
INSERT INTO Article VALUES ('8조','폭력행위','사용자는 사고의 발생이나 그 밖의 어떠한 이유로도 근로자에게 폭행을 하지 못한다.','5천만원 이하','5년 이하',3);
INSERT INTO Article VALUES ('17조','근로계약미작성','사용자는 근로계약 체결시에 임금, 소정근로시간, 휴일, 근로조건을 명시해야 한다.','500만원 이하','',2);
INSERT INTO Article VALUES ('67조 2항','근로계약미작성','친권자나 미성년후견인은 미성년자의 근로계약을 대리할 수 없다. 이에 위반한 자는 처벌을 받는다.','500만원 이하','',2);
INSERT INTO Article VALUES ('67조 3항','근로계약미작성','사용자는 18세 미만인 자와 근로계약을 체결하는 경우에는 임금, 근무시간, 휴가등 명시된 근로조건을 서면으로 교부하여야 한다','500만원 이하','',2);
INSERT INTO Article VALUES ('23조 2항','부당해고','사용자는 근로자가 업무상 부상 또는 질병의 요양을 위하여 휴업한 기간과 그 후 30일 동안은 해고하지 못한다','','',6);
INSERT INTO Article VALUES ('24조 3항','부당해고','사용자는 경영상 이유에 의한 해고를 피하기 위한 노동조합이 있는 경우에는 해고를 하려는 날의 50일 전까지 통보하고 성실하게 협의하여야 한다','해당 월급','',6);
INSERT INTO Article VALUES ('26조','부당해고','사용자는 근로자를 해고하려면 적어도 30일 전에 예고를 하여야 한다 만일, 30일 전에 예고를 하지 아니하였을 때에는 30일분 이상의 통상임금을 지급하여야 한다','해당 월급','',6);
INSERT INTO Article VALUES ('27조','부당해고','5인 이상 사업장의 경우, 사용자는 근로자를 해고하려면 해고사유와 해고시기를 서면으로 통지하여야 한다.','','',6);
INSERT INTO Article VALUES ('28조','부당해고','5인 이상 사업장의 경우, 사용자가 근로자에게 부당해고등을 하면 근로자는 노동위원회에 구제를 신청할 수 있으나 이러한 구제신청은 부당해고등이 있었던 날부터 3개월 이내에 하여야 한다','','',6);
INSERT INTO Article VALUES ('34조','임금체불','1년 이상 계속근로한 자의 경우 사용자(사업규모와 상관없이)로부터 퇴직금을 지급받을 의무가 발생한다.','','',1);
INSERT INTO Article VALUES ('36조','임금체불','사용자는 근로자가 사망 또는 퇴직한 경우에는 그 지급 사유가 발생한 때부터 14일 이내에 임금, 보상금, 그 밖에 일체의 금품을 지급하여야 한다','2000만원 이하','',1);
INSERT INTO Article VALUES ('43조','임금체불',' 사용자가 근로자에게 빌려준 돈이 있다고 해도 사용자는 일단 근로자에게 임금전부를 지급해야한다.','','',1);
INSERT INTO Article VALUES ('44조','임금체불','사용자는 근로자가 출산, 질병, 재해, 혼인, 사망, 귀향등의 비용에 충당하기 위하여 임금 지급을 청구하면 지급기일 전이라도 이미 제공한 근로에 대한 임금을 지급하여야 한다','1000만원 이하','',1);
INSERT INTO Article VALUES ('45조','임금체불','5인 이상 사업장의 경우, 사용자가 책임져야 하는 사유로 휴업하는 경우에 사용자는 휴업기간 동안 그 근로자에게 평균임금의 100분의 70 이상의 수당을 지급하여야 한다.','2000만원 이하','3년 이하',1);
INSERT INTO Article VALUES ('46조 1항','임금체불','사업이 여러 차례의 도급에 따라 행하여지는 경우에 하수급인이 직상수급인의 귀책사유로 근로자에게 임금을 지급하지 못한 경우에는 그 직상 수급인은 그 하수급인과 연대하여 책임을 진다','2000만원 이하','3년 이하',1);
INSERT INTO Article VALUES ('49조','임금체불','이 법에 따른 임금채권은 3년간 행사하지 아니하면 시효로 소멸한다','','',1);
INSERT INTO Article VALUES ('56조','임금체불','사용자는 연장근로( 1주 40시간, 1일 8시간)와 야간근로(10시~6시) 또는 휴일근로에 대하여는 통상임금의 100분의 50 이상을 가산하여 지급하여야 한다','2000만원 이하','3년 이하',1);
INSERT INTO Article VALUES ('60조','임금체불','사용자는 계속하여 근로한 기간이 1년 미만인 근로자 또는 1년간 80퍼센트 미만 출근한 근로자에게 1개월 개근 시 1일의 유급휴가를 주어야 한다.','1000만원 이하','2년 이하',1);
INSERT INTO Article VALUES ('6조 1항','최저임금 미준수','사용자는 최저임금의 적용을 받는 근로자에게 최저임금액 이상의 임금을 지급하여야 한다 (최저임금법)','2000만원 이하','3년 이하',4);

INSERT INTO Lawyer VALUES ('02-551-2210','문정구','서울대학교 법과대학/ SBS / KBS / 방송자문','법무법인(유한) 한길',6);
INSERT INTO Lawyer VALUES ('02-599-0878','송명호','前 법무법인 평화 대표 변호사','법무법인 평화',6);
INSERT INTO Lawyer VALUES ('070-4291-8351','은승우','언제나 최선을 다해 의뢰인의 고민을 해결해드리겠습니다.','변호사은승우법률사무소',6);
INSERT INTO Lawyer VALUES ('02-522-5959','김현','법무법인 효성 변호사','법무법인 효성',8);
INSERT INTO Lawyer VALUES ('02-842-4777','장슬기','법률사무소 보상과배상 변호사','변호사장슬기법률사무소',8);
INSERT INTO Lawyer VALUES ('050-7725-0324','김욱동','광명시청 법률상담변호사',' 변호사김욱동법률사무소',8);
INSERT INTO Lawyer VALUES ('02-599-0878','송명호','한화 손해 보험 / 강남구청 자문','법무법인 감사합니다',7);
INSERT INTO Lawyer VALUES ('050-7725-0386','이민정','의뢰인의 마음까지 따뜻해지는 법률서비스를 제공합니다.','법률사무소 감동',7);
INSERT INTO Lawyer VALUES ('050-7725-0687','정주섭','前 경찰청 자문 변호사','변호사정주섭법률사무소',7);
INSERT INTO Lawyer VALUES ('050-7725-0293','백종하','궁금한 점을 명쾌하고 친절하게 상담해 드립니다.','공동법률사무소 저스트',5);
INSERT INTO Lawyer VALUES ('060-900-0497','이성재','성실과 신뢰를 바탕으로 여러분의 법률문제를 최선을 다해 도와드리겠습니다.','변호사이성재법률사무소',5);
INSERT INTO Lawyer VALUES ('063-271-8286','문승현','문승현 법률사무소 변호사','변호사문승현법률사무소',5);
INSERT INTO Lawyer VALUES ('050-7725-0208','서지원','든든한 가족처럼 당신의 편이 되어 드리겠습니다.','법무법인 자유라이프',1);
INSERT INTO Lawyer VALUES ('050-7725-0500','류한호','의뢰인께서 마음 놓고 생업을 하실 수 있게 해드립니다.',' 변호사류한호법률사무소',1);
INSERT INTO Lawyer VALUES ('050-7725-0321','손준호','최선을 다하는 이기는 변호사가 되겠습니다.','변호사손준호법률사무소',1);
INSERT INTO Lawyer VALUES ('050-7725-0788','현태훈','의뢰인의 이익을 최선으로 여기는 조력자가 되겠습니다.','변호사현태훈법률사무소',2);
INSERT INTO Lawyer VALUES ('050-7725-0670','최용문','의뢰인의 입장에서 생각하고 행동하는 최용문 변호사입니다','공증인가 법무법인 수호',2);
INSERT INTO Lawyer VALUES ('050-7725-0383','권오현','안녕하십니까 노력하는 변호사 권오현 변호사입니다.''공증인가 법무법인 수호',2);
INSERT INTO Lawyer VALUES ('050-7725-0231','오세정','대한변협 부동산, 노동법 전문변호사 오세정입니다.','법무법인 신효',3);
INSERT INTO Lawyer VALUES ('050-7725-0458','정치균','의뢰인의 입장에서 내 일과 같이 최선을 다하겠습니다.','변호사정치균법률사무소',3);
INSERT INTO Lawyer VALUES ('050-7725-0740','김경목','공감을 통해 고객이 원하는 대안을 제시합니다.','법무법인 울림',3);
INSERT INTO Lawyer VALUES ('050-7725-0583','차재승','사건에 성심을 다해서 도움을 드리겠습니다.','변호사차재승법률사무소',4);
INSERT INTO Lawyer VALUES ('050-7725-2017','이규재','경청과 정의 정의는 경청에서 시작된다고 믿습니다','변호사이규채법률사무소',4);
INSERT INTO Lawyer VALUES ('050-7725-0530','김남석','노무사 출신 변호사입니다.','공증인가 법무법인 수호',4);