package wmProject;

import java.util.Scanner;

public class WeightManagement {	
	public static void main(String[] args) {
		String name = null; // �̸�
		int sex = 0; // ��������
		String sSex = null; // ����
		int age = 0; // ����
		double height = 0; // Ű
		double weight = 0; //������
		int start; // ���α׷� ����
		int infor; // ���ϴ� ����
		int level; // Ȱ������
		int end; // ���α׷� ������
		double bmi; // �񸸵�
		double bmr = 0; // ���ʴ�緮
		double stweight = 0; // ǥ��ü��
		double tCal = 0; // �Ϸ� ���� Į�θ�

		Scanner sc = new Scanner(System.in);
		BMRI B = new BMRI();
		
		int w1 = 1;
		//���α׷� ���� Loop_1
		while(w1==1) {
			B.PL("<===ü�߰��� ���α׷�===>");
			
			int w2 = 1;
			//�Է����� ���� Loop_2
			while(w2==1) {
				B.PT("\n[�̸��� �Է����ּ���.] : ");
				name = sc.next();
		
				//�������� Loop
				while(true) {
					B.PT("[������ �Է����ּ���. 1. ���� 2. ����] : ");
					sex = sc.nextInt();
				
					if(sex==1) {
						sSex = "����"; break;
					}
					else if(sex==2) {
						sSex = "����"; break;
					}
					else {
						B.PL("\n['1' , '2' �߿��� �Է����ּ���.]"); continue;
					}
				} //�������� Loop��
		
			    B.PT("[(��)���̸� �Է����ּ���] : ");
			    age = sc.nextInt();
			    B.PT("[Ű�� �Է����ּ���] : ");
			    height = sc.nextDouble();
			    B.PT("[ü���� �Է����ּ���] : ");
			    weight = sc.nextDouble();
			    B.PL("\n�̸� : " + name + "\n"
				     + "���� : " + sSex + "\n"
				     + "���� : " + age + "��\n"
				     + "Ű : " + height + "cm" + "\n"
				     + "ü�� : " + weight + "kg");
		
			    //�з�����Ȯ�� Loop
			    while(true) {
			    	B.PT("\n[�Է��� ������ �����Ű���? 1. Yes 2. NO] : ");
			    	start = sc.nextInt();
				
			    	if(start==1) {
			    		w2 = -1; break;
			    	}
			    	else if(start==2) {
			    		B.PL("\n[���� �Է��� �ٽ����ּ���!]"); break;
			    	}
			    	else {
			    		B.PL("\n['1' , '2' �߿��� �Է����ּ���.]"); continue;
			    	}
			    } //�з�����Ȯ�� Loop��
			} //Loop_2 ����
			
			int w3 = 1;
			//���ϴ� ���� Loop_3
			while(w3 == 1) {
				B.PL("\n[���Ͻô� ������ �����Դϱ�?]");
				B.PL(" |<1>BMI(�񸸵�) \n "
						+ "|<2>���ʴ�緮 \n "
						+ "|<3>ǥ�� ü�� \n"
						+ " |<4>�Ϸ� ���� Į�θ� \n "
						+ "|<5>���̾�Ʈ ���� Į�θ� \n "
						+ "|<6>��ũ�� ���� Į�θ�");
				B.PT("[�ʿ��� ����] : ");
				infor = sc.nextInt();
				
				switch(infor) {
					case 1 : bmi = B.MI(height, weight);
							 B.PL("\n"+"'"+name+"'"+"��"+"�� �񸸵��� [ " + String.format("%.2f", bmi) + " ] �Դϴ�.");
					
							 if(bmi<18.5) {
								 B.PL("'"+name+"'"+"��"+"�� ��ü���Դϴ�."); break;
							 }
							 else if((bmi>=18.5)&&(bmi<=22.9)) {
								 B.PL("'"+name+"'"+"��"+"�� ����ü���Դϴ�."); break;
							 }
							 else if((bmi>=23)&&(bmi<=24.9)) {
								 B.PL("'"+name+"'"+"��"+"�� ��ü���Դϴ�."); break;
							 }
							 else if((bmi>=25)&&(bmi<=29.9)) {
								 B.PL("'"+name+"'"+"��"+"�� 1�ܰ� ���Դϴ�."); break;
							 }
							 else if((bmi>=30)&&(bmi<=39.9)) {
								 B.PL("'"+name+"'"+"��"+"�� 2�ܰ� ���Դϴ�."); break;
							 }
							 else if(bmi>=40) {
								 B.PL("'"+name+"'"+"��"+"�� �ɰ��� ���Դϴ�."); break;
							 }
			
					case 2 : if(sex==1) {
								bmr = B.MRM(weight, height, age);
								B.PL("'"+name+"'"+"��"+"�� ���ʴ�緮�� " + String.format("%.2f", bmr) + "kcal �Դϴ�."); break;
					 		 }
					 		 else if(sex==2) {
					 			bmr = B.MRW(weight, height, age);
					 			B.PL("'"+name+"'"+"��"+"�� ���ʴ�緮�� " + String.format("%.2f", bmr) + "kcal �Դϴ�."); break;
					 		 }
			
					case 3 : stweight = Math.pow(height*0.01, 2) * age;
							 B.PL("\n"+"'"+name+"'"+"��"+"�� ǥ��ü���� " + String.format("%.2f", stweight) + "kg �Դϴ�."); break;
					 
					case 4 : 
						//Ȱ������ Loop	
						while(true) {
							B.PL("\n["+"'"+name+"'"+"��"+"�� ��� Ȱ�������� �����Ͽ��ּ���.]");
							B.PT("<1>������(�ɾƼ� ���ϴ� ȸ���, �л� ��)\n"
					 			+ "<2>�߰���(�ֺ�, ���� ���ϴ� ���� ��)\n"
					 			+ "<3>����(�����, ���, �Ǽ��� ��)\n"
					 			+ "<����> : ");
							level = sc.nextInt();
							
							if(sex==1) {
								bmr = B.MRM(weight, height, age);						
							}
							else if(sex==2) {
								bmr = B.MRW(weight, height, age);						
							}
					 
							if(level == 1) {
								tCal = B.X(bmr, 1.2);
								B.PL("\n"+"'"+name+"'"+"��"+"�� �Ϸ� ���� Į�θ��� " + String.format("%.2f", tCal) + "kcal �Դϴ�."); break;
							}
							else if(level == 2) {
								tCal = B.X(bmr, 1.35);
								B.PL("\n"+"'"+name+"'"+"��"+"�� �Ϸ� ���� Į�θ��� " + String.format("%.2f", tCal) + "kcal �Դϴ�."); break;
							}
							else if(level == 3) {
								tCal = B.X(bmr, 1.5);
								B.PL("\n"+"'"+name+"'"+"��"+"�� �Ϸ� ���� Į�θ��� " + String.format("%.2f", tCal) + "kcal �Դϴ�."); break;
							}
							else {
								B.PL("\n['1', '2', '3' �߿��� �Է����ּ���.]");
								continue;
							}
						} break;
			
					case 5 : 
						//Ȱ������ Loop
						while(true) {
							B.PL("\n["+"'"+name+"'"+"��"+"�� ��� Ȱ�������� �����Ͽ��ּ���.]");
							B.PT("<1>������(�ɾƼ� ���ϴ� ȸ���, �л� ��)\n"
				 				+ "<2>�߰���(�ֺ�, ���� ���ϴ� ���� ��)\n"
				 				+ "<3>����(�����, ���, �Ǽ��� ��)\n"
				 				+ "<����> : ");
							level = sc.nextInt();
							
							if(sex==1) {
								bmr = B.MRM(weight, height, age);						
							}
							else if(sex==2) {
								bmr = B.MRW(weight, height, age);						
							}
				 
							if(level == 1) {
								tCal = B.X(bmr, 1.2);
								B.PL("\n"+"'"+name+"'"+"��"+"�� ���̾�Ʈ ���� Į�θ��� " + String.format("%.2f", B.M(tCal, 500)) + "kcal �Դϴ�."); break;
							}
							else if(level == 2) {
								tCal = B.X(bmr, 1.35);
								B.PL("\n"+"'"+name+"'"+"��"+"�� ���̾�Ʈ ���� Į�θ��� " + String.format("%.2f", B.M(tCal, 500)) + "kcal �Դϴ�."); break;
							}
							else if(level == 3) {
								tCal = B.X(bmr, 1.5);
								B.PL("\n"+"'"+name+"'"+"��"+"�� ���̾�Ʈ ���� Į�θ��� " + String.format("%.2f", B.M(tCal, 500)) + "kcal �Դϴ�."); break;
							}
							else {
								B.PL("\n['1', '2', '3' �߿��� �Է����ּ���.]");
								continue;
							}
						}break;
			
					case 6 : 
						//Ȱ������ Loop
						while(true) {
							B.PL("\n["+"'"+name+"'"+"��"+"�� ��� Ȱ�������� �����Ͽ��ּ���.]");
							B.PT("<1>������(�ɾƼ� ���ϴ� ȸ���, �л� ��)\n"
				 				+ "<2>�߰���(�ֺ�, ���� ���ϴ� ���� ��)\n"
				 				+ "<3>����(�����, ���, �Ǽ��� ��)\n"
				 				+ "<����> : ");
							level = sc.nextInt();
							
							if(sex==1) {
								bmr = B.MRM(weight, height, age);					
							}
							else if(sex==2) {
								bmr = B.MRW(weight, height, age);						
							}
				 
							if(level == 1) {
								tCal = B.X(bmr, 1.2);
								B.PL("\n"+"'"+name+"'"+"��"+"�� ��ũ�� ���� Į�θ��� " 
								+ String.format("%.2f", B.P(tCal, 200)) +" ~ "
										+String.format("%.2f", B.P(tCal, 300))+ "kcal �Դϴ�."); break;
							}
							else if(level == 2) {
								tCal = B.X(bmr, 1.35);			 
								B.PL("\n"+"'"+name+"'"+"��"+"�� ��ũ�� ���� Į�θ��� " 
								+ String.format("%.2f", B.P(tCal, 200)) +" ~ "
										+String.format("%.2f", B.P(tCal, 300))+ "kcal �Դϴ�."); break;
							}
							else if(level == 3) {
								tCal = B.X(bmr, 1.5);			
								B.PL("\n"+"'"+name+"'"+"��"+"�� ��ũ�� ���� Į�θ��� " 
								+ String.format("%.2f", B.P(tCal, 200)) +" ~ "
										+String.format("%.2f", B.P(tCal, 300))+ "kcal �Դϴ�."); break;
							}
							else {
								B.PL("\n['1', '2', '3' �߿��� �Է����ּ���.]");
								continue;
							}
						}break;
				} // switch ��
		
				int w4 = 1;
				//������ Loop_3
				while(w4==1) {
					B.PT("\n[������ �Ͻðڽ��ϱ�]\n"
						 + "|<1> �ٸ� ���� Ȯ���ϱ�\n"
						 + "|<2> �ʱ� ȭ������ ���ư���\n"
						 + "|<3> ���α׷� ����\n"
						 + "|<�Է�> : ");
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
						B.PL("\n['1', '2', '3' �߿��� �Է����ּ���.]");
						continue;
					}
				} //Loop_4 ����
			} //Loop_3 ����
		} //Loop_1 ����
		B.PL("\n[ü�߰��� ���α׷��� �����մϴ�.]");
		sc.close();
	}
}
