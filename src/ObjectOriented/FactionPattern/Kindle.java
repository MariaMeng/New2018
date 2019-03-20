package ObjectOriented.FactionPattern;

import java.util.*;

/**
 * Created by apple on 11/1/18.
 */
public class Kindle {
    EBookReaderFactory factory;
    public Kindle() {
        //write your code here
        factory = new EBookReaderFactory();
    }

    public String readBook(Book book) throws Exception {
        //write your code here
        return factory.createReader(book).readBook();
    }

    public void downloadBook(Book b) {
        //write your code here

    }

    public void uploadBook(Book b) {
        //write your code here
    }

    public void deleteBook(Book b) {
        //write your code here
    }
}

enum Format {
    EPUB("epub"), PDF("pdf"), MOBI("mobi");

    private String content;

    Format(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

class Book {
    private Format format;

    public Book(Format format) {
        this.format = format;
    }

    public Format getFormat() {
        return format;
    }
}

abstract class EBookReader {

    protected Book book;

    public EBookReader(Book b){
        this.book = b;
    }

    public abstract String readBook();
    public abstract String displayReaderType();
}

class EBookReaderFactory {

    public EBookReader createReader(Book b) {
        //write your code here
        if (b.getFormat() == Format.EPUB){
            return new EpubReader(b);
        } else if (b.getFormat() == Format.MOBI) {
            return new MobiReader(b);
        } else
            return new PdfReader(b);
    }
}

class EpubReader extends EBookReader{

    public EpubReader(Book b) {
        super(b);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String readBook() {
        //write your code here
        return "book content is: epub";
    }

    @Override
    public String displayReaderType() {
        // TODO Auto-generated method stub
        return "Using EPUB reader";
    }
}

class MobiReader extends EBookReader {

    public MobiReader(Book b) {
        super(b);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String readBook() {
        //write your code here
        return "book content is: mobi";
    }

    @Override
    public String displayReaderType() {
        // TODO Auto-generated method stub
        return "Using MOBI reader";
    }

}
class PdfReader extends EBookReader{

    public PdfReader(Book b) {
        super(b);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String readBook() {
        //write your code here
        return "book content is: pdf";
    }

    @Override
    public String displayReaderType() {
        // TODO Auto-generated method stub
        return "Using PDF reader";
    }
}
