package Week10.searcher;

/**
 * ClassName: Found
 * Description:
 * <p>
 * Datetime: 2025/4/8 21:42
 * Author: @Likun.Fang
 * Version: 1.0
 */
public class Found {
    private volatile boolean  found = false;

    public void setFound() {
        this.found = true;
    }

    public boolean isFound() {
        return found;
    }

    @Override
    public String toString() {
        return
                "found= " + found ;
    }
}
