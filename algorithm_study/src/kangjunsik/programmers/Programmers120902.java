package kangjunsik.programmers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120902
 * ���ڿ� ����ϱ�
 */

public class Programmers120902 {
    public static int solution(String my_string) {
        String[] splitString = my_string.split(" "); // �������� ���� ��� ���� �迭ȭ

        int answer = Integer.parseInt(splitString[0]); // ù ���ڴ� �̸� ����

        for(int i = 1; i < splitString.length; i++) { // splitString ��ȸ
            if(i == splitString.length - 1) { // ��ȸ �̹� ����. �� �̻� ������ �� outOfIndex. error exception
                break;
            }
            
            if(i % 2 == 1) { // �迭�� Ȧ����° �ε����� �ִ� ���� �ݵ�� operator
                String op = splitString[i];

                // operator ���� ���� ��� ����. ���� ������ �ڿ� �ִ� ���ڸ� ������ answer ���� �����ְų� ����.
                answer = op.equals("+") ? answer + Integer.parseInt(splitString[i + 1]) : answer - Integer.parseInt(splitString[i + 1]);
            }
        }

        return answer;
    }
}
