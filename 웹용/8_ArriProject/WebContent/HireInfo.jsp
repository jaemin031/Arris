<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 고용 정보 입력 페이지</title>
</head>
<body>
	<c:choose>
		<c:when test="${empty login }">
			<jsp:include page="main_img.jsp" />
		</c:when>
		<c:otherwise>
			<div align="center">
				<form action="hireInfo.do">
					<input type="hidden" id="hireid" name="hireid" value="${login.id}" />
					<table border="1" width="83%" align="center">
						<tr>
							<td>
								<table width="100%">
									<tr>
										<th style="color: red; font-size: 20px; font-weight: bold;">기본
											정보 입력</th>
									</tr>
									<tr>
										<td colspan="8">
											<hr>
										</td>
									</tr>
									<tr>
										<td>&nbsp;직종 선택</td>
										<td colspan="4"><select id="choiceJob" name="choiceJob">
												<option value="1">1.요식업</option>
												<option value="2">2.유통/판매</option>
												<option value="3">3.서비스</option>
												<option value="4">4.사무직</option>
												<option value="5">5.교육</option>
												<option value="6">6.건설/생산</option>
												<option value="7">7.IT/디자인</option>
												<option value="8">8.영업</option>
										</select></td>
										<td>&nbsp;보험 가입 여부</td>
										<td><select id="choiceInsu" name="choiceInsu">
												<option value="N">아니오</option>
												<option value="Y">네</option>
										</select></td>
									</tr>
									<tr>
										<td>&nbsp;고용일수</td>
										<td>평일 총</td>
										<td><input type="text" name="dayweek_Text" required /></td>
										<td colspan="2">&nbsp;일</td>
										<td>&nbsp;주말 총</td>
										<td><input type="text" name="weekend_Text" required />
											&nbsp; 일</td>
									</tr>
									<tr>
										<td>&nbsp;고용 시간</td>
										<td>&nbsp;&nbsp;&nbsp;일 주간</td>
										<td><input type="text" name="dayTime_Text" required /></td>
										<td colspan="2">&nbsp;시간</td>
										<td>&nbsp;일 야간</td>
										<td><input type="text" name="nightTime_Text" required />
											&nbsp; 시간</td>
									</tr>
									<tr>
										<td>&nbsp;기본 시급</td>
										<td colspan="4"><input type="text" name="Sal_Text"
											required /> &nbsp; 원</td>
										<td>&nbsp;실수령액</td>
										<td><input type="text" name="Pay_Text" required />
											&nbsp; 원</td>
									</tr>
								</table>
								<hr>
								<table width="100%">
									<tr align="left">
										<th style="color: red; font-size: 20px; font-weight: bold;">
											&nbsp;&nbsp;&nbsp;&nbsp;추가정보 선택</th>
									</tr>
									<tr>
										<td colspan="4"><hr></td>
									</tr>

									<tr>
										<td colspan="2" style="font-size: 17px; font-weight: bold;">(1)여성/임산부
											근로자</td>
										<td rowspan="2" colspan="2">
											<table border="1" width="100%">
												<tr>
													<td>
														<table align="center" width="100%">
															<tr>
																<td>&nbsp;건간진단 허용&nbsp;</td>
																<td><select id="choicePrWomen1"
																	name="choicePrWomen1">
																		<option value="N">아니오</option>
																		<option value="Y">네</option>
																</select></td>
																<td>&nbsp;임무삭감 여부&nbsp;</td>
																<td><select id="choicePrWomen2"
																	name="choicePrWomen2">
																		<option value="N">아니오</option>
																		<option value="Y">네</option>
																</select></td>
															</tr>
															<tr>
																<td>&nbsp;출산휴가 여부&nbsp;</td>
																<td><select id="choicePrWomen3"
																	name="choicePrWomen3">
																		<option value="N">아니오</option>
																		<option value="Y">네</option>
																</select></td>
																<td>&nbsp;직무복귀 여부&nbsp;</td>
																<td><select id="choicePrWomen4"
																	name="choicePrWomen4">
																		<option value="N">아니오</option>
																		<option value="Y">네</option>
																</select></td>
															</tr>
														</table>
													</td>
												</tr>
											</table>

										</td>
									</tr>
									<tr>
										<td>&nbsp; <input type="checkbox" id="check_Women"
											name="check_Women" value="Y" />여성
										</td>
										<td>&nbsp; <input type="checkbox" id="checkPrregnancy"
											name="checkPrregnancy" value="Y" />임산부
										</td>
									</tr>
								</table>
								<hr>
								<table width="100%">
									<tr>
										<td style="font-size: 17px; font-weight: bold;">(2)임금
											지불/보상</td>
									</tr>
									<tr>
										<td>&nbsp;불가피한 상황(출산, 질병, 재해, 혼인, 사망, 귀향 등)에 따른 가불 여부</td>
										<td><select id="choicePrepaid" name="choicePrepaid">
												<option value="N">아니오</option>
												<option value="Y">네</option>
										</select></td>
									</tr>
									<tr>
										<td>&nbsp;사업장이 하청 구조일 경우, 임금 지불 문제 발생 시 최상위 업주의 임금 지불 여부</td>
										<td><select id="choiceTier" name="choiceTier">
												<option value="N">아니오</option>
												<option value="Y">네</option>
										</select></td>
									</tr>
									<tr>
										<td>&nbsp;1년 미만 또는 1년 간 100% 미만 출근한 근로자가 1개월 개근시 유급 휴가 여부</td>
										<td><select id="choiceVac" name="choiceVac">
												<option value="N">아니오</option>
												<option value="Y">네</option>
										</select></td>
									</tr>
									<tr>
										<td>&nbsp;고용주의 책임으로 인한 휴업 여부(5인 이상 사업장)</td>
										<td><select id="choice" name="choice">
												<option value="N">아니오</option>
												<option value="Y">네</option>
										</select></td>
										<td>이에 따른 휴업 일수</td>
										<td><input type="text" name="textField" value="0" /> 일</td>
									</tr>
									<tr>
										<td>&nbsp;신체적, 정신적 폭력 행사 여부</td>
										<td><select id="choiceVio" name="choiceVio">
												<option value="N">아니오</option>
												<option value="Y">네</option>
										</select></td>
									</tr>
									<tr>
										<td>&nbsp;재해보상 요영 여부</td>
										<td><select id="choiceRest" name="choiceRest">
												<option value="N">아니오</option>
												<option value="Y">네</option>
										</select></td>
									</tr>
								</table>
								<hr>
								<table width="100%">
									<tr>
										<td style="font-size: 17px; font-weight: bold;">(3)근로 계약</td>
									<tr>
									<tr>
										<td>&nbsp; <input type="checkbox" id="check_a3"
											name="check_a3" value="Y" /> &nbsp;근로계약시 나의 고용주는 임금, 소정근로시간,
											휴일, 근로조건을 명시하지 않았다.
										</td>
									</tr>
									<tr>
										<td>&nbsp; <input type="checkbox" id="check_a4"
											name="check_a4" value="Y" /> &nbsp;미성년자인 경우, 대리인(친권자 혹은
											미성년후견인)이 근로계약을 대신하였다.
										</td>
									</tr>
									<tr>
										<td>&nbsp; <input type="checkbox" id="check_a5"
											name="check_a5" value="Y" /> &nbsp;18세 미만인 경우, 임금, 근무시간, 휴가
											등 근로조건을 포함한 계약 관련 문서를 받지 않았다.
										</td>
									</tr>
								</table>
								<hr>
								<table width="100%">
									<tr>
										<td style="font-size: 17px; font-weight: bold;">(4)해 고</td>
									</tr>
									<tr>
										<td colspan="3">&nbsp; <input type="checkbox"
											id="check_a6" name="check_a6" value="Y" /> &nbsp;업무상 부상 또는
											질병의 요양으로 인한 휴업 기간 중, 또는 이후 30일 이내 해고당한 경험이 있다.
										</td>
									</tr>
									<tr>
										<td colspan="3">&nbsp; <input type="checkbox"
											id="check_a7" name="check_a7" value="Y" /> &nbsp;노동조합에 소속되어
											있는 경우, 해고 예정일보다 50일 전에 해고 통보를 받지 못하거나 협의가 없었다.
										</td>
									</tr>
									<tr>
										<td colspan="3">&nbsp; <input type="checkbox"
											id="check_a8" name="check_a8" value="Y" /> &nbsp;해고 통보가 최소
											30일 전에 이루어지지 않았다. 또는 30일 전에 해고 통보를 받은 경우, 30일 분 이상의 통상 임금을 받지
											못하였다.
										</td>
									</tr>
									<tr>
										<td colspan="3">&nbsp; <input type="checkbox"
											id="check_a9" name="check_a9" value="Y" /> &nbsp;해고사유와 해고시기를
											서면으로 통지받지 않았다. (5인 이상 사업장)
										</td>
									</tr>
									<tr>
										<td colspan="3">&nbsp; <input type="checkbox"
											id="check_a10" name="check_a10" value="Y" /> &nbsp;부당해고에 대한
											구제신청이 해고날로부터 3개월 이후에 진행되었다.(5인 이상 사업장)
										</td>
									</tr>
									<tr>
										<td colspan="3">&nbsp;&nbsp;14일 이내 퇴직금 수령 여부&nbsp; <select
											id="choicePens" name="choicePens">
												<option value="N">아니오</option>
												<option value="Y">네</option>
										</select>
										</td>
									</tr>
									<tr>
										<td colspan="3">
											<hr>
										</td>
									</tr>

									<tr>
										<td align="center"><input type="button"
											onclick="location.href='prMain.do'" value="메인으로"
											style="width: 200px; height: 50px; font-size: 20px; font-weight: bold;">
										</td>
										<td align="center">
											<button type="reset"
												style="width: 200px; height: 50px; font-size: 20px; font-weight: bold;">초기화</button>
										</td>
										<td align="center"><input type="submit" value="확 인"
											style="width: 200px; height: 50px; font-size: 20px; font-weight: bold;" />
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</c:otherwise>
	</c:choose>
</body>
</html>