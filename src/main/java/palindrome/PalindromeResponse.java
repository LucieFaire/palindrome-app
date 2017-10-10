package palindrome;

/**
 * Created by dsh on 10/8/17.
 */
public class PalindromeResponse {

    private final int position;
    private final String text;

    public PalindromeResponse(int position, String text) {
        this.position = position;
        this.text = text;
    }

    public int getPosition() {
        return position;
    }

    public String getText() {
        return text;
    }
}
