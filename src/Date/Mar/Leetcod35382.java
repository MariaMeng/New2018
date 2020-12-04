package Date.Mar;

/**
 * @author mengxiang
 * @date 20/4/12
 */
public class Leetcod35382 {
    public String entityParser(String text) {
        if (text == null || text.length() == 0) return text;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if ( c != '&') {
                sb.append(c);
                continue;
            }
            if (text.startsWith("&quot;", i)) {
                sb.append("\"");
                i = i + 6 - 1;
            } else if (text.startsWith("&apos;", i)) {
                sb.append("\'");
                i = i + 6 - 1;
            } else if (text.startsWith("&amp;", i)) {
                sb.append("&");
                i = i + 5 - 1;
            } else if (text.startsWith("&gt;", i)) {
                sb.append(">");
                i = i + 4 - 1;
            } else if (text.startsWith("&lt;", i)) {
                sb.append("<");
                i = i + 4 - 1;
            } else if (text.startsWith("&frasl;", i)) {
                sb.append("/");
                i = i + 7 - 1;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
