package wmProject;

public class BMRI extends WeightManagement {
	
	public void PL(String msg) {
		System.out.println(msg);
	}
	
	public void PT(String msg) {
		System.out.print(msg);
	}
	
	public double MI(double height, double weight) {
		double i;
		i = weight/Math.pow(height*0.01, 2);
		return i;
	} //�񸸵� ���� �޼ҵ�
	
	public double MRM(double weight, double height, int age) {
		double i;
		i = 66.47+(13.75*weight)+(5*height)-(6.76*age);
		return i;
	} //���� ���ʴ�緮 ���� �޼ҵ�
	
	public double MRW(double weight, double height, int age) {
		double i;
		i = 655.1+(9.56*weight)+(1.85*height)-(4.68*age);
		return i;
	} //���� ���ʴ�緮 ���� �޼ҵ�
	
	public double P(double i, double j) {
		double k;
		k = i + j;
		return k;
	} //�� �Ǽ� ���� �޼ҵ�
	
	public double M(double i, double j) {
		double k;
		k = i - j;
		return k;
	} //�� �Ǽ� ���� �޼ҵ�
	
	public double X(double i, double j) {
		double k;
		k = i * j;
		return k;
	}//�� �Ǽ� ���� �޼ҵ�
}

