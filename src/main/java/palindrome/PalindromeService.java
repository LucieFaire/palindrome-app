package palindrome;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dsh on 10/8/17.
 */
@Service
public class PalindromeService {

    /**
     * search palindrome substrings in the input string
     *
     * @param input input string
     * @return array of longest palindromes
     */
    public List<PalindromeResponse> findPalindromes(String input) {
        final List<PalindromeResponse> resp = new ArrayList<>();
        int index = 0;
        while (true) {
            String s = findPalindrome(input.substring(index));
            if (s == null) {
                return resp;
            }
            int position = input.lastIndexOf(s);
            resp.add(new PalindromeResponse(position, s));
            index = position + s.length();
        }
    }

    private String findPalindrome(String input) {
        if (input == null || input.isEmpty()) {
            return null;
        }
        char[] subString = processString(input.toCharArray());
        int[] position = new int[subString.length];
        int start = 0;
        int finish = 0;
        int x, y = 0;

        for (int i = 0; i < subString.length; i++) {
            if (i > finish) {
                position[i] = 0;
                x = i - 1;
                y = i + 1;
            } else {
                int i_2 = start * 2 - i;
                if (position[i_2] < (finish - i)) {
                    position[i] = position[i_2];
                    x = -1;
                } else {
                    position[i] = finish - i;
                    y = finish + 1;
                    x = i * 2 - y;
                }
            }
            while (x >= 0 && y < subString.length && subString[x] == subString[y]) {
                position[i]++;
                x--;
                y++;
            }
            if (i + position[i] > finish) {
                start = i;
                finish = i + position[i];
            }
        }
        int len = 0;
        start = 0;
        for (int i = 1; i < subString.length; i++) {
            if (len < position[i]) {
                len = position[i];
                start = i;
            }
        }

        if (len < 2) {
            return null;
        }
        char[] ss = Arrays.copyOfRange(subString, start - len, start + len + 1);
        return String.valueOf(formatString(ss));
    }

    private char[] processString(char[] chars) {
        if (chars == null || chars.length == 0) {
            return "||".toCharArray();
        }
        char[] output = new char[chars.length * 2 + 1];
        for (int i = 0; i < output.length - 1; i = i + 2) {
            output[i] = '|';
            output[i + 1] = chars[i / 2];
        }
        output[output.length - 1] = '|';
        return output;
    }

    private char[] formatString(char[] chars) {
        if (chars == null || chars.length < 3) {
            return "".toCharArray();
        }
        char[] output = new char[(chars.length - 1) / 2];
        for (int i = 0; i < output.length; i++) {
            output[i] = chars[i * 2 + 1];
        }
        return output;
    }

}
