package cn.march.guava.test.io.temp_001;


/**
 * String包装类
 */
public class StringValue {

    private String line;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StringValue that = (StringValue) o;

        return !(line != null ? !line.equals(that.line) : that.line != null);

    }


    @Override
    public int hashCode() {

        if (line == null)
            return 0;

        return line.hashCode() & 31;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    @Override
    public String toString() {
        return
                line.split("^import\\s{1}")[1];
    }
}
