package palindrome;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Created by dsh on 10/8/17.
 */
@RestController
public class PalindromeController {

    @Autowired
    PalindromeService palindromeService;

    @RequestMapping(value = "/palindrome", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<PalindromeResponse>> getPalindrome(
            @RequestParam(value = "input") String input) {

        List<PalindromeResponse> response = palindromeService.findPalindromes(input);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
