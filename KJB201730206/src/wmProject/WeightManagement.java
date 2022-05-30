package wmProject;

import java.util.Scanner;

public class WeightManagement {	
	public static void main(String[] args) {
		String name = null; // 이름
		int sex = 0; // 성별선택
		String sSex = null; // 성별
		int age = 0; // 나이
		double height = 0; // 키
		double weight = 0; //몸무게
		int start; // 프로그램 시작
		int infor; // 원하는 정보
		int level; // 활동강도
		int end; // 프로그램 마무리
		double bmi; // 비만도
		double bmr = 0; // 기초대사량
		double stweight = 0; // 표준체중
		double tCal = 0; // 하루 권장 칼로리

		Scanner sc = new Scanner(System.in);
		BMRI B = new BMRI();
		
		int w1 = 1;
		//프로그램 시작 Loop_1
		while(w1==1) {
			B.PL("<===체중관리 프로그램===>");
			
			int w2 = 1;
			//입력정보 시작 Loop_2
			while(w2==1) {
				B.PT("\n[이름을 입력해주세요.] : ");
				name = sc.next();
		
				//성별선택 Loop
				while(true) {
					B.PT("[성별을 입력해주세요. 1. 남자 2. 여자] : ");
					sex = sc.nextInt();
				
					if(sex==1) {
						sSex = "남자"; break;
					}
					else if(sex==2) {
						sSex = "여자"; break;
					}
					else {
						B.PL("\n['1' , '2' 중에서 입력해주세요.]"); continue;
					}
				} //성별선택 Loop끝
		
			    B.PT("[(만)나이를 입력해주세요] : ");
			    age = sc.nextInt();
			    B.PT("[키를 입력해주세요] : ");
			    height = sc.nextDouble();
			    B.PT("[체중을 입력해주세요] : ");
			    weight = sc.nextDouble();
			    B.PL("\n이름 : " + name + "\n"
				     + "성별 : " + sSex + "\n"
				     + "나이 : " + age + "세\n"
				     + "키 : " + height + "cm" + "\n"
				     + "체중 : " + weight + "kg");
		
			    //압력정보확인 Loop
			    while(true) {
			    	B.PT("\n[입력한 내용이 맞으신가요? 1. Yes 2. NO] : ");
			    	start = sc.nextInt();
				
			    	if(start==1) {
			    		w2 = -1; break;
			    	}
			    	else if(start==2) {
			    		B.PL("\n[정보 입력을 다시해주세요!]"); break;
			    	}
			    	else {
			    		B.PL("\n['1' , '2' 중에서 입력해주세요.]"); continue;
			    	}
			    } //압력정보확인 Loop끝
			} //Loop_2 종료
			
			int w3 = 1;
			//원하는 정보 Loop_3
			while(w3 == 1) {
				B.PL("\n[원하시는 정보가 무엇입니까?]");
				B.PL(" |<1>BMI(비만도) \n "
						+ "|<2>기초대사량 \n "
						+ "|<3>표준 체중 \n"
						+ " |<4>하루 권장 칼로리 \n "
						+ "|<5>다이어트 권장 칼로리 \n "
						+ "|<6>벌크업 권장 칼로리");
				B.PT("[필요한 정보] : ");
				infor = sc.nextInt();
				
				switch(infor) {
					case 1 : bmi = B.MI(height, weight);
							 B.PL("\n"+"'"+name+"'"+"님"+"의 비만도는 [ " + String.format("%.2f", bmi) + " ] 입니다.");
					
							 if(bmi<18.5) {
								 B.PL("'"+name+"'"+"님"+"은 저체중입니다."); break;
							 }
							 else if((bmi>=18.5)&&(bmi<=22.9)) {
								 B.PL("'"+name+"'"+"님"+"은 정상체중입니다."); break;
							 }
							 else if((bmi>=23)&&(bmi<=24.9)) {
								 B.PL("'"+name+"'"+"님"+"은 과체중입니다."); break;
							 }
							 else if((bmi>=25)&&(bmi<=29.9)) {
								 B.PL("'"+name+"'"+"님"+"은 1단계 비만입니다."); break;
							 }
							 else if((bmi>=30)&&(bmi<=39.9)) {
								 B.PL("'"+name+"'"+"님"+"은 2단계 비만입니다."); break;
							 }
							 else if(bmi>=40) {
								 B.PL("'"+name+"'"+"님"+"은 심각한 비만입니다."); break;
							 }
			
					case 2 : if(sex==1) {
								bmr = B.MRM(weight, height, age);
								B.PL("'"+name+"'"+"님"+"의 기초대사량은 " + String.format("%.2f", bmr) + "kcal 입니다."); break;
					 		 }
					 		 else if(sex==2) {
					 			bmr = B.MRW(weight, height, age);
					 			B.PL("'"+name+"'"+"님"+"의 기초대사량은 " + String.format("%.2f", bmr) + "kcal 입니다."); break;
					 		 }
			
					case 3 : stweight = Math.pow(height*0.01, 2) * age;
							 B.PL("\n"+"'"+name+"'"+"님"+"의 표준체중은 " + String.format("%.2f", stweight) + "kg 입니다."); break;
					 
					case 4 : 
						//활동강도 Loop	
						while(true) {
							B.PL("\n["+"'"+name+"'"+"님"+"의 평소 활동강도를 선택하여주세요.]");
							B.PT("<1>저강도(앉아서 일하는 회사원, 학생 등)\n"
					 			+ "<2>중강도(주부, 서서 일하는 직업 등)\n"
					 			+ "<3>고강도(운동선수, 농사, 건설업 등)\n"
					 			+ "<선택> : ");
							level = sc.nextInt();
							
							if(sex==1) {
								bmr = B.MRM(weight, height, age);						
							}
							else if(sex==2) {
								bmr = B.MRW(weight, height, age);						
							}
					 
							if(level == 1) {
								tCal = B.X(bmr, 1.2);
								B.PL("\n"+"'"+name+"'"+"님"+"의 하루 권장 칼로리는 " + String.format("%.2f", tCal) + "kcal 입니다."); break;
							}
							else if(level == 2) {
								tCal = B.X(bmr, 1.35);
								B.PL("\n"+"'"+name+"'"+"님"+"의 하루 권장 칼로리는 " + String.format("%.2f", tCal) + "kcal 입니다."); break;
							}
							else if(level == 3) {
								tCal = B.X(bmr, 1.5);
								B.PL("\n"+"'"+name+"'"+"님"+"의 하루 권장 칼로리는 " + String.format("%.2f", tCal) + "kcal 입니다."); break;
							}
							else {
								B.PL("\n['1', '2', '3' 중에서 입력해주세요.]");
								continue;
							}
						} break;
			
					case 5 : 
						//활동강도 Loop
						while(true) {
							B.PL("\n["+"'"+name+"'"+"님"+"의 평소 활동강도를 선택하여주세요.]");
							B.PT("<1>저강도(앉아서 일하는 회사원, 학생 등)\n"
				 				+ "<2>중강도(주부, 서서 일하는 직업 등)\n"
				 				+ "<3>고강도(운동선수, 농사, 건설업 등)\n"
				 				+ "<선택> : ");
							level = sc.nextInt();
							
							if(sex==1) {
								bmr = B.MRM(weight, height, age);						
							}
							else if(sex==2) {
								bmr = B.MRW(weight, height, age);						
							}
				 
							if(level == 1) {
								tCal = B.X(bmr, 1.2);
								B.PL("\n"+"'"+name+"'"+"님"+"의 다이어트 권장 칼로리는 " + String.format("%.2f", B.M(tCal, 500)) + "kcal 입니다."); break;
							}
							else if(level == 2) {
								tCal = B.X(bmr, 1.35);
								B.PL("\n"+"'"+name+"'"+"님"+"의 다이어트 권장 칼로리는 " + String.format("%.2f", B.M(tCal, 500)) + "kcal 입니다."); break;
							}
							else if(level == 3) {
								tCal = B.X(bmr, 1.5);
								B.PL("\n"+"'"+name+"'"+"님"+"의 다이어트 권장 칼로리는 " + String.format("%.2f", B.M(tCal, 500)) + "kcal 입니다."); break;
							}
							else {
								B.PL("\n['1', '2', '3' 중에서 입력해주세요.]");
								continue;
							}
						}break;
			
					case 6 : 
						//활동강도 Loop
						while(true) {
							B.PL("\n["+"'"+name+"'"+"님"+"의 평소 활동강도를 선택하여주세요.]");
							B.PT("<1>저강도(앉아서 일하는 회사원, 학생 등)\n"
				 				+ "<2>중강도(주부, 서서 일하는 직업 등)\n"
				 				+ "<3>고강도(운동선수, 농사, 건설업 등)\n"
				 				+ "<선택> : ");
							level = sc.nextInt();
							
							if(sex==1) {
								bmr = B.MRM(weight, height, age);					
							}
							else if(sex==2) {
								bmr = B.MRW(weight, height, age);						
							}
				 
							if(level == 1) {
								tCal = B.X(bmr, 1.2);
								B.PL("\n"+"'"+name+"'"+"님"+"의 벌크업 권장 칼로리는 " 
								+ String.format("%.2f", B.P(tCal, 200)) +" ~ "
										+String.format("%.2f", B.P(tCal, 300))+ "kcal 입니다."); break;
							}
							else if(level == 2) {
								tCal = B.X(bmr, 1.35);			 
								B.PL("\n"+"'"+name+"'"+"님"+"의 벌크업 권장 칼로리는 " 
								+ String.format("%.2f", B.P(tCal, 200)) +" ~ "
										+String.format("%.2f", B.P(tCal, 300))+ "kcal 입니다."); break;
							}
							else if(level == 3) {
								tCal = B.X(bmr, 1.5);			
								B.PL("\n"+"'"+name+"'"+"님"+"의 벌크업 권장 칼로리는 " 
								+ String.format("%.2f", B.P(tCal, 200)) +" ~ "
										+String.format("%.2f", B.P(tCal, 300))+ "kcal 입니다."); break;
							}
							else {
								B.PL("\n['1', '2', '3' 중에서 입력해주세요.]");
								continue;
							}
						}break;
				} // switch 끝
		
				int w4 = 1;
				//마무리 Loop_3
				while(w4==1) {
					B.PT("\n[무엇을 하시겠습니까]\n"
						 + "|<1> 다른 정보 확인하기\n"
						 + "|<2> 초기 화면으로 돌아가기\n"
						 + "|<3> 프로그램 종료\n"
						 + "|<입력> : ");
					end = sc.nextInt();
				
					if(end == 1) {
						w4 = -1;			
					}
					else if(end == 2) {
						w3 = -1;
						w4 = -1;
					}
					else if(end == 3) {
						w1 = -1;
						w3 = -1;
						w4 = -1;
					}
					else {
						B.PL("\n['1', '2', '3' 중에서 입력해주세요.]");
						continue;
					}
				} //Loop_4 종료
			} //Loop_3 종료
		} //Loop_1 종료
		B.PL("\n[체중관리 프로그램을 종료합니다.]");
		sc.close();
	}
}
