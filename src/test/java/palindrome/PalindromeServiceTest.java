package palindrome;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by dsh on 10/9/17.
 */

public class PalindromeServiceTest {

    private PalindromeService palindromeService = new PalindromeService();

    @Test
    public void test() throws Exception {

        List<PalindromeResponse> responses = palindromeService.findPalindromes("арозаупаланалапуазораsabhelloolleh");
        Assert.assertEquals(2, responses.size());

        PalindromeResponse r1 = responses.get(0);
        PalindromeResponse r2 = responses.get(1);

        Assert.assertEquals("арозаупаланалапуазора", r1.getText());
        Assert.assertEquals(0, r1.getPosition());

        Assert.assertEquals("helloolleh", r2.getText());
        Assert.assertEquals(24, r2.getPosition());
    }


}
