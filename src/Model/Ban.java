
package Model;

import java.io.Serializable;

/**
 *
 * @author luuhuy
 */
public class Ban implements Serializable{
    private String id;
    private String kind;

    public Ban() {
    }

    public Ban(String id, String kind) {
        this.id = id;
        this.kind = kind;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
    
}
