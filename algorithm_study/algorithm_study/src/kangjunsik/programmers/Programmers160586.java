package kangjunsik.programmers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/160586
 * ���� ���� ����
 */

import java.util.HashMap;
import java.util.Arrays;

public class Programmers160586 {
	public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length]; // ���� ����� ���� ��.
        HashMap<Character, Integer> keymapSetting = new HashMap<>(); // �� targets�� letter�� ������ �ּҰ��� ������ HashMap -> {key, value} ���·� �����; key�� letter(A, B, C, D, ...), value�� �� letter�� ���� �ּҰ�

        for(String key: keymap) { // �ϳ��� ������ - ���⼭�� ABACD, BCEFD �� �ι�
            for(int i = 0; i < key.length(); i++) {
                char keymapLetter = key.charAt(i); // �� keymap�� �ִ� letter

                if(keymapSetting.containsKey(keymapLetter)) { // ���� map�� ch(�� keymap�� �ִ� letter)�� �ִٸ� �ּҰ��� �� ���� �����Ƿ� �� �� �����ؾ���. �� ���� ������ �ּҰ��� �ƴ� ���� �־������ �һ��� ������� �ִ�.
                    if(keymapSetting.get(keymapLetter) > i) { // ���� map�� ����� key(letter)�� value(������ ���� Ƚ��) ��
                        keymapSetting.replace(keymapLetter, i + 1); // j�� 0���� ����, ������ Ŭ���� Ƚ���� ����ϱ� ������ +1 ����� ��Ȯ�� ���� ��(���� Ƚ���� 1���� ����). ���ڿ��� key��, Ŭ���� Ƚ���� j + 1�� value ����.
                    }
                } else { // ���ٸ�? ó�� ���� ���̶� �ϴ� ����
                    keymapSetting.put(keymapLetter, i + 1);
                }
            }
        }

        for(int i = 0; i < targets.length; i++) { // �� letter���� ���� ������ �ּҰ��� ��������, ���� answer�� ���� ����
            int sum = 0; // �ʱⰪ ���� (for-loop�� �� ������ 0���� �ʱ�ȭ�ȴ�) why? �� target������ ���� ������ ���� ���ؾ� �ϱ� ����!
            for(int j = 0; j < targets[i].length(); j++) { // �ϳ��� ������. ���⼭�� ABCD, AABB �� �ι�
                char targetLetter = targets[i].charAt(j); // �� target�� letter �ϳ��� ã�´�

                if(keymapSetting.containsKey(targetLetter)) { // containsKey�� key���� letter�� �ִ��� ���������� �˻�. ���� HashMap�� �ִٸ� �Է��� �����ϴ�.
                    sum += keymapSetting.get(targetLetter); // key�� value�� ������ ó���� �����ص� sum�� ����
                } else { // HashMap�� ���ٸ�? �Է��� �� ���� ����̴�.
                    sum = -1; // sum�� -1�� �ٲٰ� (�Է��� �� ���� ��쿡�� -1�� ����ؾ���)
                    break; // �� ��� for-loop escaping
                }
            }
            answer[i] = sum; // �� ��� ���� ����.
        }

        return answer;
    }
}
